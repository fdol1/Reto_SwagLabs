package com.certificacion.swaglabs.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiDetalleCompra {

    public static final Target LBL_PRECIOS_COMPRAS = Target.the("Listado de precios de la compra").located(By.xpath("//div[@class = 'inventory_item_price']"));
    public static final Target LBL_PRECIO_SUB_TOTAL = Target.the("Elemento que contiene la suma de los productos").located(By.xpath("//div[@class = 'summary_subtotal_label']"));
    public static final Target LBL_IMPUESTO_TAX = Target.the("Elemento con el impuesto Tax").located(By.xpath("//div[@class = 'summary_tax_label']"));
    public static final Target LBL_PRECIO_TOTAL = Target.the("Campo con el valor total de la compra").located(By.xpath("//div[@class = 'summary_info_label summary_total_label']"));
    public static final Target BTN_FINALIZAR_COMPRA = Target.the("Boton para finalizar la compra").located(By.xpath("//button[@id='finish']"));

}

