package com.certificacion.swaglabs.stepdefinitions;

import com.certificacion.swaglabs.model.DatosProductoModel;
import com.certificacion.swaglabs.questions.VerificarArticuloEn;
import com.certificacion.swaglabs.tasks.AgregarAlCarrito;
import com.certificacion.swaglabs.tasks.AgregarPrimerEnLista;
import com.certificacion.swaglabs.tasks.IrAlCarrito;
import com.certificacion.swaglabs.tasks.OrdenarProductosDesde;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarAlCarritoStepDefinition {

    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que fer selecciona el producto a comprar$")
    public void queFerSeleccionaElProductoAComprar(List<DatosProductoModel> datosProductoModels) {
        theActorInTheSpotlight().attemptsTo(AgregarAlCarrito.elProducto(datosProductoModels.get(0))  );
    }

    @Cuando("^se dirige al carrito y comprueba su producto$")
    public void seDirigeAlCarritoYCompruebaSuProducto() {
        theActorInTheSpotlight().attemptsTo(IrAlCarrito.paraVerProductos());
    }

    @Entonces("^verifica el titulo y precio del producto agregado al carrito$")
    public void verificaElTituloYPrecioDelProductoAgregadoAlCarrito() {
        theActorInTheSpotlight().should(seeThat(VerificarArticuloEn.elCarritoDeCompras()));
    }

    ///******************************************************************

    @Dado("^que fer ordena la lista$")
    public void queFerOrdenaLaLista(List<String> opcion) {
        theActorInTheSpotlight().attemptsTo(OrdenarProductosDesde.OpcionesDesplegables(opcion.get(1)));
    }


    @Cuando("^agrega agrega al carrito el producto$")
    public void agregaAgregaAlCarritoElProducto() {
        theActorInTheSpotlight().attemptsTo(AgregarPrimerEnLista.despuesDeFiltrar());
    }


}