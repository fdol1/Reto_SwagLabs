package com.certificacion.swaglabs.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiInformacionPersonal {

    public static final Target TXT_PRIMER_NOMBRE = Target.the("Campo para ingresar el primer nombre").located(By.xpath("//input[@id='first-name']"));
    public static final Target TXT_SEGUNDO_NOMBRE = Target.the("Campo para ingresar el segundo nombre").located(By.xpath("//input[@id='last-name']"));
    public static final Target TXT_CODIGO_POSTAL = Target.the("Campo para ingresar el codigo postal").located(By.xpath("//input[@id='postal-code']"));
    public static final Target BTN_CONTINUAR = Target.the("Boton para continuar el proceso de compra").located(By.xpath("//input[@id='continue']"));

}
