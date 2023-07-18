package ru.netology.authorizationservice.exeption;

public class UnauthorizedUser extends RuntimeException {

    public UnauthorizedUser(String message) {
        super(message);
    }
}
