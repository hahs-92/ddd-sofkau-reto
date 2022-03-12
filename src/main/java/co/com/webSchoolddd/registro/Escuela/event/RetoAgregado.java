package co.com.webSchoolddd.registro.Escuela.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Escuela.valor.Author;
import co.com.webSchoolddd.registro.Escuela.valor.Contenido;
import co.com.webSchoolddd.registro.Escuela.valor.Descripcion;
import co.com.webSchoolddd.registro.Escuela.valor.RetoId;

public class RetoAgregado extends DomainEvent {
    private final RetoId retoId;
    private final Author author;
    private final Contenido contenido;
    private final Descripcion descripcion;


    public RetoAgregado( RetoId retoId, Author author, Contenido contenido, Descripcion descripcion) {
        super("webSchoolddd.registro.escuela.retoAgregado");
        this.retoId = retoId;
        this.author = author;
        this.contenido = contenido;
        this.descripcion = descripcion;
    }

    public RetoId getRetoId() {
        return retoId;
    }

    public Author getAuthor() {
        return author;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
