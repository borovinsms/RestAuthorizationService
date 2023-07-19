package ru.netology.authorizationservice.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.model.User;
import ru.netology.authorizationservice.repository.Authorities;
import ru.netology.authorizationservice.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/authorize")
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user.user(), user.password());
    }
}
