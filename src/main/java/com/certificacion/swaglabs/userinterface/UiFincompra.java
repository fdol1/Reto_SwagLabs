package com.certificacion.swaglabs.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiFincompra {

    public static final Target LBL_MENSAJE_EXITOSO_DE_COMPRA = Target.the("Elemento que contiene el mensaje exitoso de fin de compra").located(By.xpath("//h2[@class = 'complete-header']"));

}
