package com.certificacion.swaglabs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.certificacion.swaglabs.userinterface.UiIniciarSesion.BTN_CARRITO_COMPRAS;


public class IrAlCarrito implements Task {

    public IrAlCarrito() {
    }

    public static IrAlCarrito paraVerProductos() {
        return Tasks.instrumented(IrAlCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_CARRITO_COMPRAS, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CARRITO_COMPRAS)
        );
    }
}