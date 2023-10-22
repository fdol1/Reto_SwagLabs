package com.certificacion.swaglabs.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/realizarCompra.feature",
        tags = "@RealizarCompra",
        glue = {"com.certificacion.swaglabs"},
        snippets = SnippetType.CAMELCASE
)

public class RunnerRealizarCompra {
}