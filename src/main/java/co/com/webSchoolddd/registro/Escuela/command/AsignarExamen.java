package co.com.webSchoolddd.registro.Escuela.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Escuela.valor.Author;
import co.com.webSchoolddd.registro.Escuela.valor.Contenido;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;

import java.util.Objects;

public class AsignarExamen  extends Command {
    private EscuelaId escuelaId;
    private Author author;
    private Contenido contenido;


    public AsignarExamen(EscuelaId escuelaId,Author author, Contenido contenido) {
        this.escuelaId = Objects.requireNonNull(escuelaId);
        this.author = Objects.requireNonNull(author);
        this.contenido = Objects.requireNonNull(contenido);
    }

    public AsignarExamen() {
    }

    public EscuelaId getEscuelaId() {
        return escuelaId;
    }

    public Author getAuthor() {
        return author;
    }

    public Contenido getContenido() {
        return contenido;
    }
}
