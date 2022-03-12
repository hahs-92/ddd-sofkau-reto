package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Escuela.Escuela;
import co.com.webSchoolddd.registro.Escuela.command.CrearEscuela;

public class CrearEscuelaUseCase extends UseCase<RequestCommand<CrearEscuela>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearEscuela> input) {
        var command = input.getCommand();
        var escuela = new Escuela(
                command.getEscuelaId(),
                command.getDirectorId(),
                command.getNombre()
        );
        emit().onResponse(new ResponseEvents(escuela.getUncommittedChanges()));
    }
}
