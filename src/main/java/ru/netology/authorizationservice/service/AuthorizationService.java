package ru.netology.authorizationservice.service;

import org.springframework.stereotype.Service;
import ru.netology.authorizationservice.exeption.InvalidCredentials;
import ru.netology.authorizationservice.exeption.UnauthorizedUser;
import ru.netology.authorizationservice.repository.Authorities;
import ru.netology.authorizationservice.repository.AuthorizationRepository;

import java.util.List;

@Service
public class AuthorizationService {

    private final AuthorizationRepository repository;

    public AuthorizationService(AuthorizationRepository repository) {
        this.repository = repository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        final var userAuthorities = repository.getUserAuthorities(user, password);
        if (userAuthorities == null || isEmpty(userAuthorities)) throw new UnauthorizedUser("Unknown user: " + user);
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
