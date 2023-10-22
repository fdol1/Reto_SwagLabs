package com.certificacion.swaglabs.interactions.bylogic;

import com.certificacion.swaglabs.interactions.GuardarProductosOrdenados;
import com.certificacion.swaglabs.util.AccionesObjetos;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

import static com.certificacion.swaglabs.util.Constantes.*;

public class OrdenarLista implements Interaction {

    private final Target listaTitulo;
    private final Target listaPrecio;
    private final boolean tituloAccion;

    public OrdenarLista(Target lista, Target listaPrecio, boolean tituloAccion) {
        this.listaTitulo = lista;
        this.listaPrecio = listaPrecio;
        this.tituloAccion = tituloAccion;
    }

    public static OrdenarLista deProductosListados(Target lista, Target listaPrecio, boolean tituloAccion) {
        return new OrdenarLista(lista, listaPrecio, tituloAccion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listTitulo = listaTitulo.resolveAllFor(actor);
        List<WebElementFacade> listPrecio = listaPrecio.resolveAllFor(actor);
        List<Double> listaPrecio = new ArrayList<>();
        List<String> listaTitulos = new ArrayList<>();

        for (int i = 0; i < listTitulo.size(); i++) {
            listaPrecio.add(AccionesObjetos.convertirNumero(listPrecio.get(i).getText().trim()));
            listaTitulos.add(listTitulo.get(i).getText().trim());
        }

        Object[] objects = AccionesObjetos.ordenarLista(listaPrecio,listaTitulos, tituloAccion);
        List<Double> precioSeleccionado = (List<Double>) objects[0];
        List<String> tituloSeleccionado = (List<String>) objects[1];
        actor.remember(LLAVE_TITULO_PRODUCTO, tituloSeleccionado.get(0));
        actor.remember(LLAVE_PRECIO_PRODUCTO, OPCION_SIMBOLO_DOLAR+precioSeleccionado.get(0));
        actor.attemptsTo(GuardarProductosOrdenados.deSwagLabs((List<Double>) objects[0], (List<String>) objects[1], tituloAccion));
    }
}