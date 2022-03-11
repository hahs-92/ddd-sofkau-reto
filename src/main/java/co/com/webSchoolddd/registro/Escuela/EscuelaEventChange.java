package co.com.webSchoolddd.registro.Escuela;

import co.com.sofka.domain.generic.EventChange;
import co.com.webSchoolddd.registro.Escuela.event.EscuelaCreada;

import java.util.ArrayList;


public class EscuelaEventChange  extends EventChange {
    public EscuelaEventChange(Escuela escuela) {

        apply((EscuelaCreada event) -> {
            escuela.nombre = event.getNombre();
            escuela.directorId = event.getDirectorId();
            escuela.blog = event.getBlog();
            escuela.examen = event.getExamen();
            escuela.retos = new ArrayList<>();
            escuela.cursos = new ArrayList<>();
        });
    }
}
