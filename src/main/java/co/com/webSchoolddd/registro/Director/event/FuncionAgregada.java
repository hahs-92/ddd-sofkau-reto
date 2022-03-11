package co.com.webSchoolddd.registro.Director.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.entity.Funcion;

public class FuncionAgregada extends DomainEvent {
    private final Funcion funcion;

    public FuncionAgregada(Funcion funcion) {
        super("webSchoolddd.registro.director.directorCreado");
        this.funcion = funcion;
    }

    public Funcion getFuncion() {
        return funcion;
    }
}
