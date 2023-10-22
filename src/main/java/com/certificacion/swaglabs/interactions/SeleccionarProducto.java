package com.certificacion.swaglabs.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.List;

import static com.certificacion.swaglabs.userinterface.UiProductos.BTN_AGREGAR_AL_CARRITO;
import static com.certificacion.swaglabs.userinterface.UiProductos.LBL_TITULO_PRODUCTO;

public class SeleccionarProducto implements Interaction {

    private String opcion;

    public SeleccionarProducto(String opcion) {
        this.opcion = opcion;
    }

    public static SeleccionarProducto porTitulo(String opcion) {
        return new SeleccionarProducto(opcion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listaTituloProducto = LBL_TITULO_PRODUCTO.resolveAllFor(actor);
        List<WebElementFacade> listaBotonAgregar = BTN_AGREGAR_AL_CARRITO.resolveAllFor(actor);

        for (int i = 0; i < listaTituloProducto.size(); i++) {
            if (listaTituloProducto.get(i).getText().trim().equals(opcion)) {
                listaBotonAgregar.get(i).click();
                break;
            }
        }
    }
}