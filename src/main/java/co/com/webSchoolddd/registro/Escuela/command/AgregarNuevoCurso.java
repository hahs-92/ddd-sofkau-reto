package co.com.webSchoolddd.registro.Escuela.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Escuela.valor.*;

public class AgregarNuevoCurso extends Command {
    private final EscuelaId escuelaId;
    private final CursoId cursoId;
    private final Nombre nombre;
    private final Descripcion descripcion;
    private final Video video;
    private final Author author;

    public AgregarNuevoCurso(
            EscuelaId escuelaId,
            CursoId cursoId,
            Nombre nombre,
            Descripcion descripcion,
            Video video,
            Author author
    ) {
        this.escuelaId = escuelaId;
        this.cursoId = cursoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.video = video;
        this.author = author;
    }

    public EscuelaId getEscuelaId() {
        return escuelaId;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Video getVideo() {
        return video;
    }

    public Author getAuthor() {
        return author;
    }
}
