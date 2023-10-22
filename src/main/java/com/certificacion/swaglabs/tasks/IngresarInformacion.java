package com.certificacion.swaglabs.tasks;

import com.certificacion.swaglabs.interactions.ObtenerPrecioTotal;
import com.certificacion.swaglabs.model.ModelInfoPersonal;
import com.certificacion.swaglabs.questions.VerificarPrecios;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.certificacion.swaglabs.userinterface.UiDetalleCompra.BTN_FINALIZAR_COMPRA;
import static com.certificacion.swaglabs.userinterface.UiProductos.BTN_CHECKOUT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarInformacion implements Task {

    private final ModelInfoPersonal infoPersonal;

    public IngresarInformacion(ModelInfoPersonal infoPersonal) {
        this.infoPersonal = infoPersonal;
    }

    public static IngresarInformacion paraLaCompra(ModelInfoPersonal infoPersonal) {
        return Tasks.instrumented(IngresarInformacion.class, infoPersonal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_CHECKOUT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CHECKOUT),
                com.certificacion.swaglabs.interactions.IngresarInformacion.paraCompra(infoPersonal),
                ObtenerPrecioTotal.deLaCompra()
        );
    }
}