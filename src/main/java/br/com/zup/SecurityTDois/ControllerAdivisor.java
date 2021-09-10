package br.com.zup.SecurityTDois;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ControllerAdivisor {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> runtimeHandler(RuntimeException exception){
        HashMap<String, String> mensagem = new HashMap<>();
        mensagem.put("mensagemErro", exception.getMessage());

        return mensagem;
    }
}
