package co.com.webSchoolddd.registro.Escuela.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Escuela.valor.Author;
import co.com.webSchoolddd.registro.Escuela.valor.BlogId;
import co.com.webSchoolddd.registro.Escuela.valor.Contenido;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;

import java.util.Objects;

public class AsignarBlog extends Command {
    private EscuelaId escuelaId;
    private BlogId blogId;
    private Contenido contenido;
    private Author author;

    public AsignarBlog(EscuelaId escuelaId, BlogId blogId, Contenido contenido, Author author) {
        this.escuelaId = Objects.requireNonNull(escuelaId);
        this.blogId = Objects.requireNonNull(blogId);
        this.contenido = Objects.requireNonNull(contenido);
        this.author = Objects.requireNonNull(author);
    }

    public EscuelaId getEscuelaId() {
        return escuelaId;
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
