package co.com.webSchoolddd.registro.Escuela;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Escuela.entity.Blog;
import co.com.webSchoolddd.registro.Escuela.entity.Curso;
import co.com.webSchoolddd.registro.Escuela.entity.Examen;
import co.com.webSchoolddd.registro.Escuela.entity.Reto;
import co.com.webSchoolddd.registro.Escuela.event.*;
import co.com.webSchoolddd.registro.Escuela.valor.*;

import java.util.List;
import java.util.Objects;

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
            Nombre nombre
    ) {
        super(entityId);
        appendChange(new EscuelaCreada(
                nombre,
                directorId
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

    public void asignarExamen(ExamenId examenId, Author author, Contenido contenido) {
        appendChange(new ExamenAsignado(examenId, author, contenido)).apply();
    }

    public void asignarBlog(BlogId blogId, Contenido contenido, Author author) {
        appendChange(new BlogAsignado(blogId, contenido, author)).apply();
    }

    public void agregarReto(RetoId retoId, Author author, Contenido contenido, Descripcion descripcion) {
        appendChange(new RetoAgregado(retoId, author,contenido,descripcion ));
    }

    public void agregarCurso(
            CursoId cursoId,
            Nombre nombre,
            Descripcion descripcion,
            Video video,
            Author author
    ) {
        appendChange(new CursoAgregado(cursoId, nombre, descripcion, video, author)).apply();
    }

    public void removerCurso(CursoId  cursoId) {
        Objects.requireNonNull(cursoId, "CursoId no puede ser nullo");
        Objects.requireNonNull(getCursoById(cursoId));

        appendChange(new CursoRemovido(cursoId)).apply();
    }

    public void removerReto(RetoId retoId) {
        Objects.requireNonNull(retoId, "RetoId no puede ser Nullo");
        Objects.requireNonNull(getRetoById(retoId));

        appendChange(new RetoRemovido(retoId));
    }

    public Curso getCursoById(CursoId cursoId) {
        return cursos.stream()
                .filter(c -> c.identity().equals(cursoId))
                .findFirst().orElseThrow();
    }

    public Reto getRetoById(RetoId retoId) {
        return retos.stream()
                .filter(r-> r.identity().equals(retoId))
                .findFirst().orElseThrow();
    }

    //accesos

    public DirectorId directorId() {
        return directorId;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Blog blog() {
        return blog;
    }

    public Examen examen() {
        return examen;
    }

    public List<Reto> retos() {
        return retos;
    }

    public List<Curso> cursos() {
        return cursos;
    }
}
