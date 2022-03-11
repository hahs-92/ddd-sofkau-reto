package co.com.webSchoolddd.registro.Escuela;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.valor.DirectorId;
import co.com.webSchoolddd.registro.Escuela.entity.Blog;
import co.com.webSchoolddd.registro.Escuela.entity.Curso;
import co.com.webSchoolddd.registro.Escuela.entity.Examen;
import co.com.webSchoolddd.registro.Escuela.entity.Reto;
import co.com.webSchoolddd.registro.Escuela.event.EscuelaCreada;
import co.com.webSchoolddd.registro.Escuela.valor.EscuelaId;
import co.com.webSchoolddd.registro.Escuela.valor.Nombre;

import java.util.List;

public class Escuela extends AggregateEvent<EscuelaId> {
    protected DirectorId directorId;
    protected Nombre nombre;
    protected Blog blog;
    protected Examen examen;
    protected List<Reto> retos;
    protected List<Curso> cursos;

    public Escuela(
            EscuelaId entityId,
            DirectorId directorId,
            Nombre nombre,
            Blog blog,
            Examen examen,
            List<Reto> retos,
            List<Curso> cursos
    ) {
        super(entityId);
        appendChange(new EscuelaCreada(
                nombre,
                directorId,
                examen,
                blog
        )).apply();
        subscribe(new EscuelaEventChange(this));
    }

    private Escuela(EscuelaId escuelaId) {
        super(escuelaId);
        subscribe(new EscuelaEventChange(this));
    }

    public static Escuela from(EscuelaId escuelaId, List<DomainEvent> events) {
        var escuela = new Escuela(escuelaId);
        events.forEach(escuela::applyEvent);
        return escuela;
    }

    //comportamientos
}
