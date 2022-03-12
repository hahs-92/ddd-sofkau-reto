package co.com.webSchoolddd.registro.Escuela;

import co.com.sofka.domain.generic.EventChange;
import co.com.webSchoolddd.registro.Escuela.entity.Examen;
import co.com.webSchoolddd.registro.Escuela.event.EscuelaCreada;
import co.com.webSchoolddd.registro.Escuela.event.ExamenAsignado;


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
    }
}
