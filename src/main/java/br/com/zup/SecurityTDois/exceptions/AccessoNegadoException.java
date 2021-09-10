package br.com.zup.SecurityTDois.exceptions;

public class AccessoNegadoException extends RuntimeException{
    private int statusCode = 403;

    public AccessoNegadoException() {
        super("Acesso negado");
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
