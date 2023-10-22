package com.certificacion.swaglabs.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.certificacion.swaglabs.util.Constantes.LLAVE_PRECIO_PRODUCTO;
import static com.certificacion.swaglabs.util.Constantes.LLAVE_TITULO_PRODUCTO;

public class ObtenerProductoPrecio implements Task {

    private  final WebElementFacade titulo;
    private final WebElementFacade precio;

    public ObtenerProductoPrecio(WebElementFacade titulo, WebElementFacade precio) {
        this.titulo = titulo;
        this.precio = precio;
    }

    public static ObtenerProductoPrecio delPrimerElemento(WebElementFacade titulo, WebElementFacade precio) {
        return Tasks.instrumented(ObtenerProductoPrecio.class, titulo, precio);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember(LLAVE_TITULO_PRODUCTO, titulo.getText());
        actor.remember(LLAVE_PRECIO_PRODUCTO, precio.getText());

    }
}
