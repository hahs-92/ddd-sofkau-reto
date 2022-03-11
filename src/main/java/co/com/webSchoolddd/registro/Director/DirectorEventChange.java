package co.com.webSchoolddd.registro.Director;

import co.com.sofka.domain.generic.EventChange;
import co.com.webSchoolddd.registro.Director.entity.Funcion;
import co.com.webSchoolddd.registro.Director.event.DirectorCreado;
import co.com.webSchoolddd.registro.Director.event.FuncionAgregada;
import co.com.webSchoolddd.registro.Director.event.FuncionRemovida;


import java.util.ArrayList;
import java.util.function.Consumer;

public class DirectorEventChange extends EventChange {
    public DirectorEventChange(Director director) {

        apply((DirectorCreado event) -> {
            director.nombre = event.getNombre();
            director.apellido = event.getApellido();
            director.email = event.getEmail();
            director.genero = event.getGenero();
            director.funciones = new ArrayList<>();
        } );

        apply(getFuncionAgregada(director));
        apply(getFuncionRemovida(director));
    }

    private Consumer<FuncionAgregada> getFuncionAgregada(Director director) {
        return (FuncionAgregada event) -> {
            var funcion = new Funcion(
                    event.getFuncionId(),
                    event.getPrioridad(),
                    event.getCaracteristica()
            );
            director.funciones.add(funcion);
        };
    }

    private Consumer<FuncionRemovida> getFuncionRemovida(Director director) {
        return (FuncionRemovida event ) -> director.funciones
                .removeIf(f -> f.identity().equals(event.getFuncionId()));
    }
}
