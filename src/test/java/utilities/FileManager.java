package utilities;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final static String screenshotPath = "src/test/resources/screenshots";
    private static final String pageSourcePath = "src/test/resources/pageStructure";

    public static void getScreenshot(String screenshotName){
        Logs.debug("Tomando Screenshot");

        final var screenshotFile = ((TakesScreenshot) new WebDriverProvider().get()).getScreenshotAs(OutputType.FILE);

        final var path = String.format("%s/%s.png", screenshotPath,screenshotName);

        try{
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (IOException ioException){
            Logs.error("Error al tomar el screenshot: %s", ioException.getLocalizedMessage());
        }
    }

    public static void getPageSource(String fileName){
        Logs.debug("Tomando page source");

        final var path = String.format("%s/%s.html", pageSourcePath, fileName);

        try {
            final var file = new File(path);

            Logs.debug("Creando directorios padres si es que no existen");
            if (file.getParentFile().mkdirs()) {
                final var fileWriter = new FileWriter(file);
                final var pageSource = new WebDriverProvider().get().getPageSource();
                fileWriter.write(Jsoup.parse(pageSource).toString());
                fileWriter.close();
            }
        } catch (IOException ioException) {
            Logs.error("Error al tomar page source: %s", ioException.getLocalizedMessage());
        }
    }

    public static void deletePreviousEvidence(){
        try{
            Logs.debug("Borrando la evidencia anterior");
            FileUtils.deleteDirectory(new File(screenshotPath));
            FileUtils.deleteDirectory(new File(pageSourcePath));
        } catch (IOException ioException){
            Logs.error("Error al borrar la evidencia anterior: %s", ioException.getLocalizedMessage());
        }
    }

    @Attachment(value = "failureScreenshot", type = "image/png")
    public static byte[] getScreenshot(){
        return ((TakesScreenshot)new WebDriverProvider().get()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "pageSource", type = "text/html", fileExtension = "txt")
    public static String getPageSource(){
        return Jsoup.parse(new WebDriverProvider().get().getPageSource()).toString();
    }
    
    @Attachment(value = "passScreenshot", type = "image/png")
    public static byte[] getScreenshot2(){
        return ((TakesScreenshot)new WebDriverProvider().get()).getScreenshotAs(OutputType.BYTES);
    }
    
    @Step("Log Message {0}")
    public static void logMessage(String message){
        System.out.println(message);
    }

    @Step("Iniciando Prueba: {0}")
    public static void iniciarPrueba(String nombrePrueba){
        System.out.println("Iniciando la prueba: " + nombrePrueba);
    }

    
    @Step("Finalizando la prueba: {0}")
    public static void finalizarPrueba(String nombrePrueba) {
        System.out.println("Finalizando la prueba: " + nombrePrueba);
    }
    
    @Step("Navegando a la URL: {0}")
    public static void navegarAUrl(String url) {
        new WebDriverProvider().get().get(url);
        System.out.println("Navegando a la URL: " + url);
    }
    
}
