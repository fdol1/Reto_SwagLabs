package com.certificacion.swaglabs.stepdefinitions;

import com.certificacion.swaglabs.tasks.byLogic.Ordenar;
import com.certificacion.swaglabs.tasks.byLogic.Seleccionar;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OrdenarProductosStepDefinitions {

    @Before
    public void configuracionInicial(){
        OnStage.setTheStage(new OnlineCast());
    }



    @Dado("^que (.*) ordena los productos de menor a mayor$")
    public void queFerOrdenaLosProductosDeMenorAMayor(String actor, List<String> opcionOrden) {
        theActorCalled(actor).wasAbleTo(Ordenar.productos(opcionOrden.get(1)));


    }

    @Cuando("^selecciona el producto indicado por el precio$")
    public void seleccionaElProductoIndicadoPorElPrecio() {
        theActorInTheSpotlight().attemptsTo(Seleccionar.ProductoOrdenado());
    }

}
