package co.com.webSchoolddd.registro.Escuela.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.webSchoolddd.registro.Escuela.valor.Author;
import co.com.webSchoolddd.registro.Escuela.valor.Contenido;
import co.com.webSchoolddd.registro.Escuela.valor.Descripcion;
import co.com.webSchoolddd.registro.Escuela.valor.RetoId;

import java.util.Objects;

public class Reto extends Entity<RetoId> {
    private Author author;
    private Contenido contenido;
    private Descripcion descripcion;

    public Reto(
            RetoId entityId,
            Author author,
            Contenido contenido,
            Descripcion descripcion
    ) {
        super(entityId);
        this.author = Objects.requireNonNull(author);
        this.contenido = Objects.requireNonNull(contenido);
        this.descripcion = Objects.requireNonNull(descripcion);
    }


    public void modificarAuthor(Author author) {
        this.author = author;
    }

    public void modificarContenido(Contenido contenido) {
        this.contenido = contenido;
    }


    public Contenido contenido() {
        return contenido;
    }

    public Author author() {
        return author;
    }

    public Descripcion descripcion() { return descripcion; }
}

