package co.com.webSchoolddd.registro.Director.valor;

import co.com.sofka.domain.generic.Identity;

public class FuncionId extends Identity {
    private FuncionId(String id) {
        super(id);
    }

    public FuncionId() {}

    public static FuncionId of(String id) {
        return  new FuncionId(id);
    }
}
