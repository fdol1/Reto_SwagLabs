package com.certificacion.swaglabs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.certificacion.swaglabs.userinterface.UiCarritoCompras.LBL_PRECIO_PRODUCTO_AGREGADO;
import static com.certificacion.swaglabs.userinterface.UiCarritoCompras.LBL_TITULO_PRODUCTO_AGREGADO;
import static com.certificacion.swaglabs.util.Constantes.LLAVE_PRECIO_PRODUCTO;
import static com.certificacion.swaglabs.util.Constantes.LLAVE_TITULO_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarArticuloEn implements Question<Boolean> {

    public VerificarArticuloEn() {

    }
    public static VerificarArticuloEn elCarritoDeCompras(){
        return new VerificarArticuloEn();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_TITULO_PRODUCTO_AGREGADO,isVisible()).forNoMoreThan(10).seconds()
        );
        return ((actor.recall(LLAVE_TITULO_PRODUCTO).equals(Text.of(LBL_TITULO_PRODUCTO_AGREGADO).viewedBy(actor).asString()) &&
                (actor.recall(LLAVE_PRECIO_PRODUCTO).equals(Text.of(LBL_PRECIO_PRODUCTO_AGREGADO).viewedBy(actor).asString()))));
    }
}