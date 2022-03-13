package co.com.webSchoolddd.registro.Cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.webSchoolddd.registro.Cuenta.valor.CuentaId;
import co.com.webSchoolddd.registro.Cuenta.valor.Suscripcion;

public class CambiarSuscripcion extends Command {
    private final CuentaId cuentaId;
    private final Suscripcion suscripcion;

    public CambiarSuscripcion(CuentaId cuentaId, Suscripcion suscripcion) {
        this.cuentaId = cuentaId;
        this.suscripcion = suscripcion;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }
}
