package co.com.webSchoolddd.registro.Escuela.entity;


import co.com.sofka.domain.generic.Entity;
import co.com.webSchoolddd.registro.Escuela.valor.*;

public class Curso  extends Entity<CursoId> {
    private Nombre nombre;
    private Descripcion descripcion;
    private Video video;
    private Author author;

    public Curso(
            CursoId entityId,
            Nombre nombre,
            Descripcion descripcion,
            Video video,
            Author author
    ) {
        super(entityId);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.video = video;
        this.author = author;
    }

    //comportamientos

    public void cambiarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public void modificarDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public void cambiarVideo(Video video) {
        this.video = video;
    }

    public void modificarAuthor(Author author) {
        this.author = author;
    }


    //accesos

    public Nombre nombre() {
        return nombre;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Video video() {
        return video;
    }

    public Author author() {
        return author;
    }
}
