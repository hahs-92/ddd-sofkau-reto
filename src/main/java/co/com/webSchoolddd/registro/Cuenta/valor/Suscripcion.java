package co.com.webSchoolddd.registro.Cuenta.valor;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Suscripcion implements ValueObject<Suscripcion.SuscripcionType> {
    private final SuscripcionType suscripcion;

    public Suscripcion(SuscripcionType suscripcion) {
        this.suscripcion = Objects.requireNonNull(suscripcion);
    }

    public Suscripcion actualizarSuscripcion(SuscripcionType suscripcion) {
        return new Suscripcion(suscripcion);
    }

    @Override
    public SuscripcionType value() {
        return suscripcion;
    }

    public enum SuscripcionType {
        BASIC, PREMIUM, EXPERT
    }
}
