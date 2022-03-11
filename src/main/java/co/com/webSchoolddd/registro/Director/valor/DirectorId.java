package co.com.webSchoolddd.registro.Director.valor;

import co.com.sofka.domain.generic.Identity;

public class DirectorId extends Identity {

    private DirectorId(String id) {
        super(id);
    }

    public DirectorId() {}

    public static DirectorId of(String id) {
        return  new DirectorId(id);
    }
}
