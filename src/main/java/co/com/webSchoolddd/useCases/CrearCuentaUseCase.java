package co.com.webSchoolddd.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.webSchoolddd.registro.Cuenta.Cuenta;
import co.com.webSchoolddd.registro.Cuenta.command.CrearCuenta;

public class CrearCuentaUseCase  extends UseCase<RequestCommand<CrearCuenta>, ResponseEvents>{

    @Override
    public void executeUseCase(RequestCommand<CrearCuenta> input) {
        var command = input.getCommand();
        var cuenta = new Cuenta(command.getCuentaId(), command.getSuscripcion());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
