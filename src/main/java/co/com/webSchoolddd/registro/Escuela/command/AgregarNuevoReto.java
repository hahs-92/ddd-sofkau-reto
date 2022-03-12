package co.com.webSchoolddd.registro.Escuela.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Escuela.valor.*;

public class AgregarNuevoReto extends Command {
    private final EscuelaId escuelaId;
    private final RetoId retoId;
    private final Author author;
    private final Contenido contenido;
    private final Descripcion descripcion;

    public AgregarNuevoReto(
            EscuelaId escuelaId,
            RetoId retoId,
            Author author,
            Contenido contenido,
            Descripcion descripcion
    ) {
        this.escuelaId = escuelaId;
        this.retoId = retoId;
        this.author = author;
        this.contenido = contenido;
        this.descripcion = descripcion;
    }

    public EscuelaId getEscuelaId() {
        return escuelaId;
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
