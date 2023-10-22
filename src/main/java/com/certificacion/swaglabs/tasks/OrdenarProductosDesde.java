package com.certificacion.swaglabs.tasks;

import com.certificacion.swaglabs.interactions.SeleccionarLista;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.certificacion.swaglabs.userinterface.UiProductos.FILTAR_POR;
import static com.certificacion.swaglabs.userinterface.UiProductos.OPCION_FILTRADO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OrdenarProductosDesde implements Task {

    private final String opcion;
    public OrdenarProductosDesde(String opcion) {
        this.opcion = opcion;
    }
    public static OrdenarProductosDesde OpcionesDesplegables(String opcion) {
        return Tasks.instrumented(OrdenarProductosDesde.class, opcion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(FILTAR_POR,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(FILTAR_POR),
                SeleccionarLista.porOpcion(OPCION_FILTRADO,opcion)
        );
    }
}