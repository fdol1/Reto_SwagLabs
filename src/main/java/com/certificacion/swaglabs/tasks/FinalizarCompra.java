package com.certificacion.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.certificacion.swaglabs.userinterface.UiDetalleCompra.BTN_FINALIZAR_COMPRA;

public class FinalizarCompra implements Task {

    public FinalizarCompra() {
    }

    public static FinalizarCompra deProductos() {
        return Tasks.instrumented(FinalizarCompra.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_FINALIZAR_COMPRA));
    }
}
