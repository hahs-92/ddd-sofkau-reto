package co.com.webSchoolddd.registro.Escuela.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.webSchoolddd.registro.Escuela.valor.Author;
import co.com.webSchoolddd.registro.Escuela.valor.BlogId;
import co.com.webSchoolddd.registro.Escuela.valor.Contenido;

import java.util.Objects;

public class Blog extends Entity<BlogId> {
    private Contenido contenido;
    private Author author;

    public Blog(BlogId entityId, Contenido contenido, Author author) {
        super(entityId);
        this.contenido = Objects.requireNonNull(contenido);
        this.author = Objects.requireNonNull(author);
    }

    //comportamientos

    public Contenido modificarContenido() {
        return contenido;
    }

    public void modificarAuthor(Author author) {
        this.author = author;
    }

    //accesos

    public void contenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Author author() {
        return author;
    }

}
