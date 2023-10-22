package com.certificacion.swaglabs.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiCarritoCompras {

    public static final Target LBL_TITULO_PRODUCTO_AGREGADO = Target.the("Titulo del producto en el carrito").located(By.xpath("//div[@class= 'inventory_item_name']"));
    public static final Target LBL_PRECIO_PRODUCTO_AGREGADO = Target.the("Precio del producto en el carrito").located(By.xpath("//div[@class= 'inventory_item_price']"));

}
