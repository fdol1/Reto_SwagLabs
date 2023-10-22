package com.certificacion.swaglabs.userinterface;

import com.certificacion.swaglabs.util.Constantes;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl(Constantes.URL_PORTAL)
public class UiIniciarSesion extends PageObject {
    public static final Target TXT_USUARIO = Target.the("Campo para ingresar el usuario").located(By.xpath("//input[@id='user-name']"));
    public static final Target TXT_CLAVE = Target.the("Campo para ingresar la clave").located(By.xpath("//input[@id='password']"));
    public static final Target BTN_INICIAR_SESION = Target.the("boton para ingresar al perfil").located(By.xpath("//input[@id='login-button']"));
    public static final Target LBL_MENSAJE_ERROR = Target.the("Mensaje de error al ingresar datos errados").located(By.xpath("//h3[@data-test = 'error']"));
    public static final Target BTN_CARRITO_COMPRAS = Target.the("Boton para ingresar al carrito de compras").located(By.xpath("//div[@class= 'shopping_cart_container']"));

}


