package ru.netology.authorizationservice.advice;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorizationservice.exeption.InvalidCredentials;
import ru.netology.authorizationservice.exeption.UnauthorizedUser;

@RestControllerAdvice()
public class ExeptionHahdlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        final var msg = e.getMessage();
        System.out.println(msg);
        return new ResponseEntity<>(msg, HttpStatusCode.valueOf(401));
    }
}
