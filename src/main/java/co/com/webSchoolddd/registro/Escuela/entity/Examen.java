package co.com.webSchoolddd.registro.Escuela.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.webSchoolddd.registro.Escuela.valor.Author;
import co.com.webSchoolddd.registro.Escuela.valor.Contenido;
import co.com.webSchoolddd.registro.Escuela.valor.ExamenId;

public class Examen extends Entity<ExamenId> {

    private Author author;
    private Contenido contenido;

    public Examen(ExamenId entityId, Author author, Contenido contenido) {
        super(entityId);
        this.author = author;
        this.contenido = contenido;
    }

    //comportamientos
    public void modificarAutor(Author author) {
        this.author = author;
    }

    public void modificarContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    //accesos

    public Author author() {
        return author;
    }

    public Contenido contenido() {
        return contenido;
    }

}
