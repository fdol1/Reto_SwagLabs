package com.certificacion.swaglabs.tasks;

import com.certificacion.swaglabs.userinterface.UiIniciarSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirNavegador implements Task {

    private UiIniciarSesion uiIniciarSesion;

    public static AbrirNavegador enSwagLabs() {
        return Tasks.instrumented(AbrirNavegador.class);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(uiIniciarSesion));
        BrowseTheWeb.as(actor).getDriver().manage().window().maximize();
    }
}
