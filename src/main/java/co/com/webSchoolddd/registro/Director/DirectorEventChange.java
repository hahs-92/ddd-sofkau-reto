package co.com.webSchoolddd.registro.Director;

import co.com.sofka.domain.generic.EventChange;
import co.com.webSchoolddd.registro.Director.event.DirectorCreado;

import java.util.ArrayList;

public class DirectorEventChange extends EventChange {
    public DirectorEventChange(Director director) {

        apply((DirectorCreado event) -> {
            director.nombre = event.getNombre();
            director.apellido = event.getApellido();
            director.email = event.getEmail();
            director.genero = event.getGenero();
            director.funciones = new ArrayList<>();
        } );
    }
}
