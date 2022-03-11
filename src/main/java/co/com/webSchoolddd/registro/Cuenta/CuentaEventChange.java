package co.com.webSchoolddd.registro.Cuenta;

import co.com.sofka.domain.generic.EventChange;
import co.com.webSchoolddd.registro.Cuenta.event.CuentaCreada;


public class CuentaEventChange extends EventChange {
    public CuentaEventChange(Cuenta cuenta) {

        apply((CuentaCreada event) -> {
            cuenta.suscripcion = event.getSuscripcion();
        });
    }
}
