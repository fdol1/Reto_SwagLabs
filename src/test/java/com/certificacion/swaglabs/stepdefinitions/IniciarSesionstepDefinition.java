package com.certificacion.swaglabs.stepdefinitions;

import com.certificacion.swaglabs.model.InicioDeSesionModel;
import com.certificacion.swaglabs.questions.VerificarInicioDeSesion;
import com.certificacion.swaglabs.questions.VerificarInicioDeSesionErrado;
import com.certificacion.swaglabs.tasks.AbrirNavegador;
import com.certificacion.swaglabs.tasks.IniciarSesion;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IniciarSesionstepDefinition {

    @Before
    public void configuracionInicial(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que (.*) ingresa a la pagina de Swaglabas$")
    public void queFerIngresaALaPaginaDeSwaglabas(String actor) {
        theActorCalled(actor).wasAbleTo(AbrirNavegador.enSwagLabs());
    }


    @Dado("^que fer ingresa sus credenciales$")
    public void queFerIngresaSusCredenciales(List<InicioDeSesionModel> inicioDeSesionModelList) {
        theActorInTheSpotlight().attemptsTo(IniciarSesion.enSwagLabs(inicioDeSesionModelList.get(0)));
    }

    @Entonces("^Entonces verifica el titulo (.*)$")
    public void entoncesVerificaElTituloSwagLabs(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarInicioDeSesion.alIngresarLasCredenciales(mensaje)));
    }

    @Entonces("^Entonces verifica mensaje error (.*)$")
    public void entoncesVerificaElMensajeDeError(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarInicioDeSesionErrado.alIngresarLasCredenciales(mensaje)));
    }
}