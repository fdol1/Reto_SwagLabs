package com.certificacion.swaglabs.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/iniciarSesion.feature",
        tags = "@RutaCritica",
        glue = {"com.certificacion.swaglabs"},
        snippets = SnippetType.CAMELCASE
)

public class RunnerIniciarSesion {
}
