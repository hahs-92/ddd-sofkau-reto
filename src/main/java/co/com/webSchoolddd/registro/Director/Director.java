package co.com.webSchoolddd.registro.Director;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.webSchoolddd.registro.Director.entity.Funcion;
import co.com.webSchoolddd.registro.Director.valor.*;

import java.util.List;

public class Director extends AggregateEvent<DirectorId> {
    protected Nombre nombre;
    protected Apellido apellido;
    protected Email email;
    protected Genero genero;
    protected List<Funcion> funciones;

    public Director(
            DirectorId entityId,
            Nombre nombre,
            Apellido apellido,
            Email email,
            Genero genero,
            List<Funcion> funciones
    ) {
        super(entityId);
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.funciones = funciones;
    }

    private Director(DirectorId directorId) {
        super(directorId);
    }


}
