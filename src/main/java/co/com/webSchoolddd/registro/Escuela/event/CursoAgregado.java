package co.com.webSchoolddd.registro.Escuela.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Escuela.valor.*;

public class CursoAgregado extends DomainEvent {
    private final CursoId cursoId;
    private final Nombre nombre;
    private final Descripcion descripcion;
    private final Video video;
    private final Author author;

    public CursoAgregado(CursoId cursoId, Nombre nombre, Descripcion descripcion, Video video, Author author) {
        super("webSchoolddd.registro.escuela.cursoAgregado");
        this.cursoId = cursoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.video = video;
        this.author = author;
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
