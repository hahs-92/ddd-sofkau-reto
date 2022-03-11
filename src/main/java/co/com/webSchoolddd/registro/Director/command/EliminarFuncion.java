package co.com.webSchoolddd.registro.Director.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Director.value.DirectorId;
import co.com.webSchoolddd.registro.Director.value.FuncionId;

public class EliminarFuncion extends Command {
    private final FuncionId funcionId;
    private final DirectorId directorId;

    public EliminarFuncion(FuncionId funcionId, DirectorId directorId) {
        this.funcionId = funcionId;
        this.directorId = directorId;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public DirectorId getDirectorId() {
        return directorId;
    }
}
