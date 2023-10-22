package com.certificacion.swaglabs.tasks;

import com.certificacion.swaglabs.interactions.ObtenerProductoPrecio;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.certificacion.swaglabs.userinterface.UiIniciarSesion.BTN_CARRITO_COMPRAS;
import static com.certificacion.swaglabs.userinterface.UiProductos.*;

public class AgregarPrimerEnLista implements Task {

    public AgregarPrimerEnLista() {
    }

    public static AgregarPrimerEnLista despuesDeFiltrar() {
        return Tasks.instrumented(AgregarPrimerEnLista.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listaBotonAgregar = BTN_AGREGAR_AL_CARRITO.resolveAllFor(actor);
        List<WebElementFacade> listaTitulo = LBL_TITULO_PRODUCTO.resolveAllFor(actor);
        List<WebElementFacade> listaPrecio = LBL_PRECIO_PRODUCTO.resolveAllFor(actor);

        actor.attemptsTo(
                ObtenerProductoPrecio.delPrimerElemento(listaTitulo.get(0),listaPrecio.get(0)),
                Click.on(listaBotonAgregar.get(0)),
                Click.on(BTN_CARRITO_COMPRAS)
        );
    }
}