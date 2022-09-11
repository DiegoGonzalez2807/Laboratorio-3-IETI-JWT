package edu.escuelaing.ieti.app.entities;
/**
 * @author Diego Gonzalez
 */

import java.time.LocalDate;
import java.util.List;

import edu.escuelaing.ieti.app.enums.RoleEnum;
import edu.escuelaing.ieti.app.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Document
  public class User
  {
     @Id
     String id;
  
     String name;
  
     @Indexed( unique = true )
     String email;
  
     String lastName;
     String createdAt;

      private String passwordHash;
      private List<RoleEnum> roles;

      /**
       * Constructor de Usuario donde no se le da ningun valor adicional
       * Crea el identificador y la fecha de creacion
       */
      public User()
     {
         this.id = String.valueOf(Math.floor(Math.random()*10+1));
         this.createdAt = LocalDate.now().toString();
     }
  

    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastName = userDto.getLastName();
        this.createdAt = userDto.getCreatedAt();
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
    }

      /**
       * Funcion generada para actualizar los datos de un usuario, poniendo
       * un userDTO que tenga los nuevos datos
       * Si se quiere actualizar, entonces el password será cambiado
       * @param user
       */
      public void toEntity(UserDto user) {
          this.name = user.getName();
          this.email = user.getEmail();
          this.lastName = user.getLastName();
          if (user.getPassword() != null) {
              this.passwordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
          }
      }


      public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

      public String getPasswordHash() {
          return passwordHash;
      }

      public void setPasswordHash(String passwordHash) {
          this.passwordHash = passwordHash;
      }

      public List<RoleEnum> getRoles() {
          return roles;
      }

      public void setRoles(List<RoleEnum> roles) {
          this.roles = roles;
      }
  }
