package co.com.webSchoolddd.registro.Escuela.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Escuela.valor.Author;
import co.com.webSchoolddd.registro.Escuela.valor.Contenido;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.registro.Escuela.valor.ExamenId;

import java.util.Objects;

public class AsignarExamen  extends Command {
    private EscuelaId escuelaId;
    private ExamenId examenId;
    private Author author;
    private Contenido contenido;


    public AsignarExamen(EscuelaId escuelaId, ExamenId examenId,Author author, Contenido contenido) {
        this.escuelaId = Objects.requireNonNull(escuelaId);
        this.examenId = Objects.requireNonNull(examenId);
        this.author = Objects.requireNonNull(author);
        this.contenido = Objects.requireNonNull(contenido);
    }

    public AsignarExamen() {
    }

    public ExamenId getExamenId() { return examenId; }

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
