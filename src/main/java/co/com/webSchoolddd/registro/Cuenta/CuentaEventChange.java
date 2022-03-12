package co.com.webSchoolddd.registro.Cuenta;

import co.com.sofka.domain.generic.EventChange;
import co.com.webSchoolddd.registro.Cuenta.event.CuentaCreada;
import co.com.webSchoolddd.registro.Cuenta.event.SuscripcionCambiada;


public class CuentaEventChange extends EventChange {
    public CuentaEventChange(Cuenta cuenta) {

        apply((CuentaCreada event) -> {
            cuenta.suscripcion = event.getSuscripcion();
        });

        apply((SuscripcionCambiada event) -> {
            cuenta.suscripcion = event.getSuscripcion();
        });
    }
}
