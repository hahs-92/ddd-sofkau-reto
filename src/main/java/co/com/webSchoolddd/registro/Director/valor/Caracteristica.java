package co.com.webSchoolddd.registro.Director.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Caracteristica implements ValueObject<String> {
    private final String caracteristica;

    public Caracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Caracteristica actualizarCaracteristica(String caracteristica) {
        return new Caracteristica(caracteristica);
    }

    @Override
    public String value() {
        return caracteristica;
    }
}
