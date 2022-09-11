package edu.escuelaing.ieti.app.exception;

import edu.escuelaing.ieti.app.enums.ErrorCodeEnum;
import edu.escuelaing.ieti.app.persistence.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

import javax.ws.rs.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException
{
   private ServerErrorResponseDto serverErrorResponseDto;

    /**
     * Funcion generada para avisar al usuario el hecho que no se encuentra
     * un usuario con esas credenciales
     */
    public InvalidCredentialsException() {
        //super(String.valueOf(HttpStatus.NOT_FOUND));
        //this.serverErrorResponseDto = new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        super(String.valueOf(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND)));
    }
}
