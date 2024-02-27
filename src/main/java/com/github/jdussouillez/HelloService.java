package com.github.jdussouillez;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class HelloService {

    private static final Map<String, String> HELLOS = new HashMap<>(Map.of(
        "fr", "Bonjour !",
        "en", "Hello!"
    ));

    public Uni<String> hello(final String locale) {
        return Uni.createFrom().item(() -> HELLOS.getOrDefault(locale, "?"));
    }

    public Uni<Void> add(final String locale, final String hello) {
        return Uni.createFrom().voidItem()
            .invoke(() -> HELLOS.put(locale, hello));
    }
}
