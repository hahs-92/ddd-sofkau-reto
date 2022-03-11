package co.com.webSchoolddd.registro.Director.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.Caracteristica;
import co.com.webSchoolddd.registro.Director.value.FuncionId;
import co.com.webSchoolddd.registro.Director.value.Prioridad;



public class FuncionAgregada extends DomainEvent {
    private final FuncionId funcionId;
    private final Prioridad prioridad;
    private final Caracteristica caracteristica;

    public FuncionAgregada(FuncionId funcionId, Prioridad prioridad, Caracteristica caracteristica) {
        super("webSchoolddd.registro.director.funcionAgregada");
        this.funcionId = funcionId;
        this.prioridad = prioridad;
        this.caracteristica = caracteristica;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }
}
