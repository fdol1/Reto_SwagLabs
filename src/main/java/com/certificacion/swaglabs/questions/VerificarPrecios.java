package com.certificacion.swaglabs.questions;

import com.certificacion.swaglabs.util.AccionesObjetos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static com.certificacion.swaglabs.userinterface.UiDetalleCompra.LBL_PRECIO_SUB_TOTAL;
import static com.certificacion.swaglabs.userinterface.UiDetalleCompra.LBL_PRECIO_TOTAL;
import static com.certificacion.swaglabs.util.Constantes.*;

public class VerificarPrecios implements Question<Boolean> {

    public VerificarPrecios() {

    }
    public static VerificarPrecios paraFinalizarCompra(){
        return new VerificarPrecios();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        double totalWeb = AccionesObjetos.convertirNumero(Text.of(LBL_PRECIO_TOTAL).viewedBy(actor).asString());
        double subTotalWb = AccionesObjetos.convertirNumero(Text.of(LBL_PRECIO_SUB_TOTAL).viewedBy(actor).asString());
        List<Double> listaPrecios = actor.recall(LLAVE_PRECIOS_COMPRA);

        return (totalWeb == listaPrecios.get(0) && subTotalWb == listaPrecios.get(1));
    }
}