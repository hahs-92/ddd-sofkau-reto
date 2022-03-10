package co.com.webSchoolddd.registro.Director.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Prioridad implements ValueObject<Prioridad.NivelPrioridad> {
    private final NivelPrioridad prioridad;

    public Prioridad(NivelPrioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Prioridad actualizarPrioridad(NivelPrioridad prioridad) {
        return new Prioridad(prioridad);
    }

    @Override
    public NivelPrioridad value() {
        return prioridad;
    }

    public enum NivelPrioridad {
        ALTO, MEDIO, BAJO
    }

}
