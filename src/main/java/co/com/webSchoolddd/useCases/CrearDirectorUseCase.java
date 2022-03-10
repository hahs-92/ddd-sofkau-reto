package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Director.Director;
import co.com.webSchoolddd.registro.Director.command.CrearDirector;


public class CrearDirectorUseCase extends UseCase<RequestCommand<CrearDirector>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearDirector> input) {
        var command = input.getCommand();
        var director = new Director(
                command.getDirectorId(),
                command.getNombre(),
                command.getApellido(),
                command.getEmail(),
                command.getGenero()
        );
        emit().onResponse(new ResponseEvents(director.getUncommittedChanges()));
    }
}
