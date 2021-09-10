package br.com.zup.SecurityTDois.exceptions;

import br.com.zup.SecurityTDois.exceptions.AccessoNegadoException;
import br.com.zup.SecurityTDois.exceptions.TokenNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ControllerAdivisor {

    @ExceptionHandler(AccessoNegadoException.class)
    public ResponseEntity<?> runtimeHandler(AccessoNegadoException exception){
        HashMap<String, String> mensagem = new HashMap<>();
        mensagem.put("mensagemErro", exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(mensagem);
    }

    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<?> runtimeHandler(TokenNotValidException exception){
        HashMap<String, String> mensagem = new HashMap<>();
        mensagem.put("mensagemErro", exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(mensagem);
    }
}
