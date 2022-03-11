package co.com.webSchoolddd.registro.Director.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.webSchoolddd.registro.Director.value.FuncionId;


public class FuncionRemovida extends DomainEvent {
    private final FuncionId funcionId;

    public FuncionRemovida(FuncionId funcionId) {
        super("webSchoolddd.registro.director.funcionRemovida");
        this.funcionId = funcionId;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }
}
