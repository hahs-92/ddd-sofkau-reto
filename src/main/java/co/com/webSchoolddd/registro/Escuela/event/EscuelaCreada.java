package co.com.webSchoolddd.registro.Escuela.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.valor.DirectorId;
import co.com.webSchoolddd.registro.Escuela.entity.Blog;
import co.com.webSchoolddd.registro.Escuela.entity.Examen;
import co.com.webSchoolddd.registro.Escuela.valor.Nombre;



public class EscuelaCreada extends DomainEvent {
    private final Nombre nombre;
    private final DirectorId directorId;
    private final Examen examen;
    private final Blog blog;


    public EscuelaCreada(Nombre nombre, DirectorId directorId, Examen examen, Blog blog) {
        super("webSchoolddd.registro.escuela.escuelaCreada");
        this.nombre = nombre;
        this.directorId = directorId;
        this.examen = examen;
        this.blog = blog;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public DirectorId getDirectorId() {
        return directorId;
    }

    public Examen getExamen() {
        return examen;
    }

    public Blog getBlog() {
        return blog;
    }

}
