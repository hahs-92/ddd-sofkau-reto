package co.com.webSchoolddd.registro.Escuela.valor;

import co.com.sofka.domain.generic.Identity;

public class BlogId extends Identity {
    private BlogId(String id) {
        super(id);
    }

    public BlogId() {}

    private static BlogId of(String id) {
        return new BlogId(id);
    }
}
