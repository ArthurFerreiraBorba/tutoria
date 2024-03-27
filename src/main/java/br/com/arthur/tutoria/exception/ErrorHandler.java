package br.com.arthur.tutoria.exception;

import br.com.arthur.tutoria.exception.Error.NotFoundExceptionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handler(RuntimeException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }
    @ExceptionHandler(NotFoundExceptionEntity.class)
    public ResponseEntity<String> handler(NotFoundExceptionEntity e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
