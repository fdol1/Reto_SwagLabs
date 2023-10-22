package com.certificacion.swaglabs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.certificacion.swaglabs.userinterface.UiFincompra.LBL_MENSAJE_EXITOSO_DE_COMPRA;
import static com.certificacion.swaglabs.userinterface.UiProductos.LBL_TITULO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarCompraExitosa implements Question<Boolean> {

    private final String mensaje;
    public VerificarCompraExitosa(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarCompraExitosa enElPortalSwagLabs(String mensaje){
        return new VerificarCompraExitosa(mensaje);
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_MENSAJE_EXITOSO_DE_COMPRA,isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(Text.of(LBL_MENSAJE_EXITOSO_DE_COMPRA).viewedBy(actor).asString());
    }
}