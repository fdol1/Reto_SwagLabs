package com.certificacion.swaglabs.interactions;

import com.certificacion.swaglabs.model.ModelInfoPersonal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.certificacion.swaglabs.userinterface.UiInformacionPersonal.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarInformacion implements Task {

    private final ModelInfoPersonal infoPersonal;

    public IngresarInformacion(ModelInfoPersonal infoPersonal) {
        this.infoPersonal = infoPersonal;
    }

    public static IngresarInformacion paraCompra(ModelInfoPersonal infoPersonal) {
        return Tasks.instrumented(IngresarInformacion.class, infoPersonal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_PRIMER_NOMBRE,isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(infoPersonal.getNombre1()).into(TXT_PRIMER_NOMBRE),
                Enter.theValue(infoPersonal.getNombre2()).into(TXT_SEGUNDO_NOMBRE),
                Enter.theValue(infoPersonal.getCodigoPostal()).into(TXT_CODIGO_POSTAL),
                Click.on(BTN_CONTINUAR)
        );
    }
}
