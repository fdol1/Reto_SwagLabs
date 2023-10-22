package com.certificacion.swaglabs.interactions;

import com.certificacion.swaglabs.util.AccionesObjetos;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static com.certificacion.swaglabs.userinterface.UiDetalleCompra.*;
import static com.certificacion.swaglabs.util.Constantes.LLAVE_PRECIOS_COMPRA;

public class ObtenerPrecioTotal implements Interaction {


    public ObtenerPrecioTotal() {
    }

    public static ObtenerPrecioTotal deLaCompra() {
        return Tasks.instrumented(ObtenerPrecioTotal.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listaPreciosCompra = LBL_PRECIOS_COMPRAS.resolveAllFor(actor);
        double tax = AccionesObjetos.convertirNumero(Text.of(LBL_IMPUESTO_TAX).viewedBy(actor).asString());
        double subTotal = 0;

        for (WebElementFacade webElementFacade : listaPreciosCompra) {
            subTotal = subTotal + AccionesObjetos.convertirNumero(webElementFacade.getText());
        }
        BigDecimal total = new BigDecimal(subTotal + tax);
        total = total.setScale(2, RoundingMode.HALF_UP);
        List<Double> preciosCompra = new ArrayList<>();
        preciosCompra.add(0,Double.parseDouble(String.valueOf(total)));
        preciosCompra.add(1,subTotal);

        actor.remember(LLAVE_PRECIOS_COMPRA, preciosCompra);
    }
}