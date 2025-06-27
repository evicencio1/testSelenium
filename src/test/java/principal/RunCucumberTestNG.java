package principal;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features", // Ruta a tus archivos .feature
    glue = "steps",                           // Paquete donde están tus Step Definitions
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Plugin para los reportes de Allure
    }
)
public class RunCucumberTestNG extends AbstractTestNGCucumberTests {
    // Esta clase extiende las funcionalidades de TestNG para Cucumber.
    // Debe permanecer vacía.
}