package principal;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

/**
 * Esta clase es el punto de entrada para ejecutar las pruebas de Cucumber con JUnit 5.
 * NO necesita contener ningún método. Las anotaciones hacen todo el trabajo.
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Le dice a Cucumber que busque los .feature en "src/test/resources/features"
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps") // Le dice a Cucumber que busque los Step Definitions en el paquete "steps"
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm") // Activa los reportes de Allure y una salida legible en consola
public class RunCucumberTest {
    // Esta clase debe permanecer vacía.
}