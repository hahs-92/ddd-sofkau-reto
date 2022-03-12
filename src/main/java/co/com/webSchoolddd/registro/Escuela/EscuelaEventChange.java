package co.com.webSchoolddd.registro.Escuela;

import co.com.sofka.domain.generic.EventChange;
import co.com.webSchoolddd.registro.Escuela.entity.Blog;
import co.com.webSchoolddd.registro.Escuela.entity.Curso;
import co.com.webSchoolddd.registro.Escuela.entity.Examen;
import co.com.webSchoolddd.registro.Escuela.event.*;


import java.util.ArrayList;


public class EscuelaEventChange  extends EventChange {
    public EscuelaEventChange(Escuela escuela) {

        apply((EscuelaCreada event) -> {
            escuela.nombre = event.getNombre();
            escuela.directorId = event.getDirectorId();
            escuela.retos = new ArrayList<>();
            escuela.cursos = new ArrayList<>();
        });

        apply((ExamenAsignado event) -> {
            escuela.examen = new Examen(  event.getExamenId(), event.getAuthor(), event.getContenido());
        });

        apply((BlogAsignado event) -> {
            escuela.blog = new Blog(event.getBlogId(), event.getContenido(), event.getAuthor());
        });

        apply((CursoAgregado event ) -> {
            var curso = new Curso(
                    event.getCursoId(),
                    event.getNombre(),
                    event.getDescripcion(),
                    event.getVideo(),
                    event.getAuthor()
            );
            escuela.cursos.add(curso);
        });

        apply((CursoRemovido event) -> escuela.cursos
                .removeIf(c -> c.identity().equals(event.getCursoId())));
    }
}
