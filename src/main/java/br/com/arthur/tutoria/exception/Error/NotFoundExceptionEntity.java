package br.com.arthur.tutoria.exception.Error;

public class NotFoundExceptionEntity extends RuntimeException{

    public NotFoundExceptionEntity() {
    }

    public NotFoundExceptionEntity(String message) {
        super(message);
    }
}
