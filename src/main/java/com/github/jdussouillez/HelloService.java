package com.github.jdussouillez;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public Uni<String> hello(final String locale) {
        return Uni.createFrom().item(
            () -> switch (locale) {
                case "fr" -> "Bonjour !";
                case "es" -> "¡Hola!";
                default -> "Hello!";
            }
        );
    }
}
