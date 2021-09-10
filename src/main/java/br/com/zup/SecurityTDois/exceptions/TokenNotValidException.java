package br.com.zup.SecurityTDois.exceptions;

public class TokenNotValidException extends RuntimeException{
    private int statusCode = 401;

    public TokenNotValidException() {
        super("Token invalido");
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
