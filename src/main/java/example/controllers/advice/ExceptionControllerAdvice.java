package example.controllers.advice;

import example.NotEnoughMoneyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<?> exceptionNotEnoughMoneyHandler() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not enough money you are broken bitch");
    }
}
