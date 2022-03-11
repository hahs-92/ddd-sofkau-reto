package co.com.webSchoolddd.registro.Director.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Director.valor.Caracteristica;
import co.com.webSchoolddd.registro.Director.valor.DirectorId;
import co.com.webSchoolddd.registro.Director.valor.FuncionId;
import co.com.webSchoolddd.registro.Director.valor.Prioridad;

public class AgregarNuevaFuncion extends Command {
    private final DirectorId directorId;
    private final FuncionId funcionId;
    private final Prioridad prioridad;
    private final Caracteristica caracteristica;

    public AgregarNuevaFuncion(DirectorId directorId,FuncionId funcionId, Prioridad prioridad, Caracteristica caracteristica) {
        this.directorId = directorId;
        this.funcionId = funcionId;
        this.prioridad = prioridad;
        this.caracteristica = caracteristica;
    }

    public DirectorId getDirectorId() {
        return directorId;
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
