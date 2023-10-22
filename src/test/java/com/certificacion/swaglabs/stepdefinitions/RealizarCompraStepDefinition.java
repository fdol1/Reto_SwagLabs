package com.certificacion.swaglabs.stepdefinitions;

import com.certificacion.swaglabs.model.ModelInfoPersonal;
import com.certificacion.swaglabs.questions.VerificarCompraExitosa;
import com.certificacion.swaglabs.questions.VerificarPrecios;
import com.certificacion.swaglabs.tasks.FinalizarCompra;
import com.certificacion.swaglabs.tasks.IngresarInformacion;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.E;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RealizarCompraStepDefinition {

    @Before
    public void configuracionInicial(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("^ingresa los datos para la compra$")
    public void ingresaLosDatosParaLaCompra(List<ModelInfoPersonal> infoPersonalList) {
        theActorInTheSpotlight().attemptsTo(IngresarInformacion.paraLaCompra(infoPersonalList.get(0)));
    }

    @Entonces("^verifica los precios y finaliza la compra$")
    public void verificaLosPreciosYFinalizaLaCompra() {
        theActorInTheSpotlight().should(seeThat(VerificarPrecios.paraFinalizarCompra()));
        theActorInTheSpotlight().attemptsTo(FinalizarCompra.deProductos());
    }

    @Entonces("^verifica el mensaje de compra exitosa: (.*)$")
    public void verificaElMensajeDeCompraExitosaThankYouForYourOrder(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarCompraExitosa.enElPortalSwagLabs(mensaje)));
    }
}
