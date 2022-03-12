package co.com.webSchoolddd.registro.Escuela.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Escuela.valor.Author;
import co.com.webSchoolddd.registro.Escuela.valor.BlogId;
import co.com.webSchoolddd.registro.Escuela.valor.Contenido;

public class BlogAsignado extends DomainEvent {
    private final BlogId blogId;
    private final Contenido contenido;
    private final Author author;

    public BlogAsignado(BlogId blogId, Contenido contenido, Author author) {
        super("webSchoolddd.registro.escuela.examenAsignado");
        this.blogId = blogId;
        this.contenido = contenido;
        this.author = author;
    }

    public BlogId getBlogId() {
        return blogId;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public Author getAuthor() {
        return author;
    }
}
