package co.com.webSchoolddd.registro.Escuela.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Escuela.valor.Author;
import co.com.webSchoolddd.registro.Escuela.valor.Contenido;
import co.com.webSchoolddd.registro.Escuela.valor.ExamenId;

public class ExamenAsignado extends DomainEvent {
    private ExamenId examenId;
    private final Author author;
    private final Contenido contenido;

    public ExamenAsignado(ExamenId examenId,Author author, Contenido contenido) {
        super("webSchoolddd.registro.escuela.examenAsignado");
        this.examenId = examenId;
        this.author = author;
        this.contenido = contenido;
    }

    public ExamenId getExamenId() {
        return examenId;
    }

    public Author getAuthor() {
        return author;
    }

    public Contenido getContenido() {
        return contenido;
    }
}
