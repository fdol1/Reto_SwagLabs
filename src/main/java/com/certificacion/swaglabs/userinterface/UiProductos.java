package com.certificacion.swaglabs.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiProductos {

    public static final Target LBL_TITULO = Target.the("Titulo de la pagina al iniciar sesion").located(By.xpath("//div[@class = 'app_logo']"));
    public static final Target LBL_TITULO_PRODUCTO= Target.the("Lista con toda la cantidad de elementos").located(By.xpath("//div[@class= 'inventory_item_label']//a"));
    public static final Target LBL_PRECIO_PRODUCTO = Target.the("Lista con toda la cantidad de elementos").located(By.xpath("//div[@class= 'inventory_item']//div[2]//div[2]//div"));
    public static final Target BTN_AGREGAR_AL_CARRITO = Target.the("Boton para agregar productos al carrito").located(By.xpath("//div[@class= 'inventory_item']//div[2]//div[2]//button"));
    public static final Target FILTAR_POR = Target.the("Elemento que contiene las opcines de orden").located(By.xpath("//select[@class= 'product_sort_container']"));
    public static final Target OPCION_FILTRADO = Target.the("Elemento con las opciones de filtrado").located(By.xpath("//select[@class= 'product_sort_container']//option"));
    public static final Target BTN_REMOVER = Target.the("Boton para remover producto del carrito").located(By.xpath("//button[@class = 'btn btn_secondary btn_small cart_button']"));
    public static final Target BTN_CHECKOUT = Target.the("Boton para ingresar informacion personal").located(By.xpath("//button[@id='checkout']"));

}


