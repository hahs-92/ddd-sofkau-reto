package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Director.Director;
import co.com.webSchoolddd.registro.Director.command.AgregarNuevaFuncion;

public class AgregarNuevaFuncionUseCase extends UseCase<RequestCommand<AgregarNuevaFuncion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaFuncion> input) {
        var command = input.getCommand();
        var director = Director.from(command.getDirectorId(), retrieveEvents());

        director.agregarFuncion(
                command.getFuncionId(),
                command.getPrioridad(),
                command.getCaracteristica()
        );
        emit().onResponse(new ResponseEvents(director.getUncommittedChanges()));
    }
}
