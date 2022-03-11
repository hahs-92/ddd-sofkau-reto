package co.com.webSchoolddd.registro.Director.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.webSchoolddd.registro.Director.value.Caracteristica;
import co.com.webSchoolddd.registro.Director.value.FuncionId;
import co.com.webSchoolddd.registro.Director.value.Prioridad;

public class Funcion extends Entity<FuncionId> {

    private Prioridad prioridad;
    private Caracteristica caracteristica;

    public Funcion(FuncionId entityId, Prioridad prioridad, Caracteristica caracteristica) {
        super(entityId);
        this.prioridad = prioridad;
        this.caracteristica = caracteristica;
    }

    //comportamientos
    public void cambiarPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public void modificarCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Prioridad Prioridad() {
        return prioridad;
    }

    public Caracteristica Caracteristica() {
        return caracteristica;
    }
}
