package ru.netology.authorizationservice.repository;

import java.util.List;

public interface AuthorizationRepository {

    List<Authorities> getUserAuthorities(String name, String password);
}
