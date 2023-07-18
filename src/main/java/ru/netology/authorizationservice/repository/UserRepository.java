package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements AuthorizationRepository {

    final static Map<String, String> VALID_VALUE = Map.of("user", "pass");

    @Override
    public List<Authorities> getUserAuthorities(String name, String password) {
        return
                VALID_VALUE.containsKey(name) && VALID_VALUE.get(name).equals(password)
                        ? Arrays.stream(Authorities.values()).toList() : new ArrayList<>(0);
    }
}
