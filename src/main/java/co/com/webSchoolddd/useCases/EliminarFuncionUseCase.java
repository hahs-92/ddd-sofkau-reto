package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Director.Director;
import co.com.webSchoolddd.registro.Director.command.EliminarFuncion;

public class EliminarFuncionUseCase extends UseCase<RequestCommand<EliminarFuncion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarFuncion> input) {
        var command = input.getCommand();
        var director = Director.from(command.getDirectorId(),retrieveEvents());

        director.removerFuncion(
                command.getFuncionId()
        );
        emit().onResponse(new ResponseEvents(director.getUncommittedChanges()));
    }
}
