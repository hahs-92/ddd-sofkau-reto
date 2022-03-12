package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Usuario.Usuario;
import co.com.webSchoolddd.registro.Usuario.command.CrearUsuario;

public class CrearUsuarioUseCase  extends UseCase<RequestCommand<CrearUsuario>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearUsuario> input) {
        var command = input.getCommand();
        var usaurio = new Usuario(
                command.getUsuarioId(),
                command.getEscuelaId(),
                command.getCuentaId(),
                command.getNombre(),
                command.getApellido(),
                command.getEmail(),
                command.getGenero()
        );
        emit().onResponse(new ResponseEvents(usaurio.getUncommittedChanges()));
    }
}
