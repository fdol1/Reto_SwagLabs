package com.certificacion.swaglabs.stepdefinitions;

import com.certificacion.swaglabs.tasks.Remover;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RemoverDelCarritoStepDefinition {

    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Cuando("^se dirige al carrito a remover su producto$")
    public void seDirigeAlCarritoARemoverSuProducto() {
        theActorInTheSpotlight().attemptsTo(Remover.delCarrito());
    }

}
