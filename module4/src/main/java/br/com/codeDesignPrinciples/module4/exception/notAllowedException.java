package br.com.codeDesignPrinciples.module4.exception;

public class notAllowedException extends RuntimeException{
    public notAllowedException() {
        super("Not allowed to register with same info =/");
    }
}

