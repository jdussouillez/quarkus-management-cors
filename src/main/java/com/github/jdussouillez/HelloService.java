package com.github.jdussouillez;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class HelloService {

    private static final String DEFAULT_LOCALE = "en";

    private static final Map<String, String> HELLOS = new HashMap<>(Map.of(
        "fr", "Bonjour !",
        "es", "¡Hola!",
        DEFAULT_LOCALE, "Hello!"
    ));

    public Uni<String> hello(final String locale) {
        return Uni.createFrom().item(() -> HELLOS.getOrDefault(locale, HELLOS.get(DEFAULT_LOCALE)));
    }

    public Uni<Void> add(final String locale, final String hello) {
        return Uni.createFrom().voidItem()
            .invoke(() -> HELLOS.put(locale, hello));
    }

    public Uni<Void> delete(final String locale) {
        return Uni.createFrom().voidItem()
            .invoke(() -> HELLOS.remove(locale));
    }
}
