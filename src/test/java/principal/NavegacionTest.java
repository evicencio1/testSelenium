package principal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import utilities.BaseTest;
import utilities.FileManager;
import utilities.Logs;

public class NavegacionTest extends BaseTest{

    
    @Test(groups = {regression})
    public void inicioSesionAgriTest(){
        var url = "https://dev-test-agri.herokuapp.com/";

        FileManager.logMessage("Prueba Inicio de Sesion");

        Logs.info("Test");
        driver.get(url);
        Logs.info("url: %s",url);
        
        sleep(3000);

        driver.findElement(By.id("user_email")).sendKeys("asistencia@agri.so");
        Logs.info("Se ingresa el usuario");

        driver.findElement(By.id("user_password")).sendKeys("788e48783#T");
        Logs.info("Se ingresa la contraseña");

        //driver.findElement(By.className("btn btn-primary mb-2")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary.login-button")).click();

        sleep(5000);


    }

    
    @Test(groups = {regression})
    public void abrirMenuTest() throws InterruptedException{

        var url = "https://dev-test-agri.herokuapp.com/";

        FileManager.logMessage("Prueba Inicio de Sesion");

        Logs.info("Test");
        driver.get(url);
        Logs.info("url: %s",url);
        
        sleep(3000);

        driver.findElement(By.id("user_email")).sendKeys("asistencia@agri.so");
        Logs.info("Se ingresa el usuario");

        driver.findElement(By.id("user_password")).sendKeys("d644cb1c7#T");
        Logs.info("Se ingresa la contraseña");

        //driver.findElement(By.className("btn btn-primary mb-2")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary.login-button")).click();

        sleep(5000);

        var btnAccion = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div/div/div[3]/div[2]/div/button"));

        btnAccion.click();

        sleep(3000);

    }

    
    @Test(groups = {regression})
    public void facturaElectronicaSiiAgriTest() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        var url = "https://dev-test-agri.herokuapp.com/";

        FileManager.logMessage("Prueba SII");
        FileManager.logMessage("Buscar documentos Factura Electronica");

        Logs.info("Test");
        driver.get(url);
        Logs.info("url: %s",url);
        
        sleep(3000);

        driver.findElement(By.id("user_email")).sendKeys("asistencia@agri.so");
        Logs.info("Se ingresa el usuario");

        driver.findElement(By.id("user_password")).sendKeys("d644cb1c7#T");
        Logs.info("Se ingresa la contraseña");

        //driver.findElement(By.className("btn btn-primary mb-2")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary.login-button")).click();

        sleep(5000);

        //Realiza click en boton "ACCION"
        var btnAccion = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div/div/div[3]/div[2]/div/button"));

        btnAccion.click();

        sleep(3000);

        //esto sire para el boton buscar
        //driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-fullWidth")).click();

        //Busca y selecciona la opcion "Integracion SII"
        var menuSii = driver.findElement(By.xpath("//*[@id=\"menu-list-grow\"]/li[13]"));

        menuSii.click();

        sleep(3000);

        //WebElement taxType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxableTypeId")));
        //taxType.

        //WebElement div = driver.findElement(By.className(".MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3"));

        //Busca el input "Razon Social"
        WebElement razonSocial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("organizationList")));

        razonSocial.sendKeys("Sutil");
        sleep(3000);
        razonSocial.sendKeys(Keys.ENTER);

        sleep(3000);

        //Selecciona las fechas
        var dataPicker = driver.findElement(By.id("datepicker-simple"));

        dataPicker.click();

        dataPicker.sendKeys("04");
        dataPicker.sendKeys(Keys.TAB);
        dataPicker.sendKeys("2025");
        
        //Se mueve hasta el siguiente input "Tipo Documento"
        Actions accion = new Actions(driver);
        accion.sendKeys(Keys.TAB).perform();
        sleep(3000);
        accion.sendKeys(Keys.TAB).perform();
        sleep(3000);

        //En el input tipo documento ingresa un valor
        accion.sendKeys("Factura Electrónica").perform();
        sleep(3000);
        accion.sendKeys(Keys.ENTER).perform();
        accion.sendKeys(Keys.TAB).perform();
        
        sleep(5000); 
       
        //Busca el boton y valida si este esta activo, de estarlo presiona enter
        var btnBuscar = driver.findElement(By.cssSelector(
            ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-fullWidth"));

        if(btnBuscar.isEnabled()){
            accion.sendKeys(Keys.ENTER).perform();            
        } else {
            Logs.error("estado del boton: " + btnBuscar.isEnabled());

        }

        sleep(10000);

        FileManager.logMessage("Error: " + btnBuscar.isEnabled());

        softAssert.assertNotEquals(razonSocial, "");
        softAssert.assertTrue(razonSocial.isSelected());
        softAssert.assertTrue(btnBuscar.isEnabled());
        softAssert.assertAll();

        sleep(3000);

    }

    
    @Test(groups = {regression})
    public void notaCreditoSiiAgriTest() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        var url = "https://dev-test-agri.herokuapp.com/";

        FileManager.logMessage("Prueba SII");
        FileManager.logMessage("Buscar documentos Factura Electronica");

        Logs.info("Test");
        driver.get(url);
        Logs.info("url: %s",url);
        
        sleep(3000);

        driver.findElement(By.id("user_email")).sendKeys("asistencia@agri.so");
        Logs.info("Se ingresa el usuario");

        driver.findElement(By.id("user_password")).sendKeys("d644cb1c7#T");
        Logs.info("Se ingresa la contraseña");

        //driver.findElement(By.className("btn btn-primary mb-2")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary.login-button")).click();

        sleep(5000);

        //Realiza click en boton "ACCION"
        var btnAccion = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div/div/div[3]/div[2]/div/button"));

        btnAccion.click();

        sleep(3000);

        //esto sire para el boton buscar
        //driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-fullWidth")).click();

        //Busca y selecciona la opcion "Integracion SII"
        var menuSii = driver.findElement(By.xpath("//*[@id=\"menu-list-grow\"]/li[13]"));

        menuSii.click();

        sleep(3000);

        //WebElement taxType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxableTypeId")));
        //taxType.

        //WebElement div = driver.findElement(By.className(".MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3"));

        //Busca el input "Razon Social"
        WebElement razonSocial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("organizationList")));

        razonSocial.sendKeys("Sutil");
        sleep(3000);
        razonSocial.sendKeys(Keys.ENTER);

        sleep(3000);

        //Selecciona las fechas
        var dataPicker = driver.findElement(By.id("datepicker-simple"));

        dataPicker.click();

        dataPicker.sendKeys("04");
        dataPicker.sendKeys(Keys.TAB);
        dataPicker.sendKeys("2025");
        
        //Se mueve hasta el siguiente input "Tipo Documento"
        Actions accion = new Actions(driver);
        accion.sendKeys(Keys.TAB).perform();
        sleep(3000);
        accion.sendKeys(Keys.TAB).perform();
        sleep(3000);

        //En el input tipo documento ingresa un valor
        accion.sendKeys("Nota de crédito").perform();
        sleep(3000);
        accion.sendKeys(Keys.ENTER).perform();
        accion.sendKeys(Keys.TAB).perform();
        
        sleep(5000); 
       
        //Busca el boton y valida si este esta activo, de estarlo presiona enter
        var btnBuscar = driver.findElement(By.cssSelector(
            ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-fullWidth"));

        if(btnBuscar.isEnabled()){
            accion.sendKeys(Keys.ENTER).perform();            
        } else {
            Logs.error("estado del boton: " + btnBuscar.isEnabled());

        }

        sleep(10000);

        FileManager.logMessage("Error: " + btnBuscar.isEnabled());

        softAssert.assertNotEquals(razonSocial, "");
        softAssert.assertTrue(razonSocial.isSelected());
        softAssert.assertTrue(btnBuscar.isEnabled());
        softAssert.assertAll();

        sleep(3000);

    }

    
    @Test(groups = {regression})
    public void notaDebitoSiiAgriTest() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        var url = "https://dev-test-agri.herokuapp.com/";

        FileManager.logMessage("Prueba SII");
        FileManager.logMessage("Buscar documentos Factura Electronica");

        Logs.info("Test");
        driver.get(url);
        Logs.info("url: %s",url);
        
        sleep(3000);

        driver.findElement(By.id("user_email")).sendKeys("asistencia@agri.so");
        Logs.info("Se ingresa el usuario");

        driver.findElement(By.id("user_password")).sendKeys("d644cb1c7#T");
        Logs.info("Se ingresa la contraseña");

        //driver.findElement(By.className("btn btn-primary mb-2")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary.login-button")).click();

        sleep(5000);

        //Realiza click en boton "ACCION"
        var btnAccion = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div/div/div[3]/div[2]/div/button"));

        btnAccion.click();

        sleep(3000);

        //esto sire para el boton buscar
        //driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-fullWidth")).click();

        //Busca y selecciona la opcion "Integracion SII"
        var menuSii = driver.findElement(By.xpath("//*[@id=\"menu-list-grow\"]/li[13]"));

        menuSii.click();

        sleep(3000);

        //WebElement taxType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxableTypeId")));
        //taxType.

        //WebElement div = driver.findElement(By.className(".MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3"));

        //Busca el input "Razon Social"
        WebElement razonSocial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("organizationList")));

        razonSocial.sendKeys("Sutil");
        sleep(3000);
        razonSocial.sendKeys(Keys.ENTER);

        sleep(3000);

        //Selecciona las fechas
        var dataPicker = driver.findElement(By.id("datepicker-simple"));

        dataPicker.click();

        dataPicker.sendKeys("04");
        dataPicker.sendKeys(Keys.TAB);
        dataPicker.sendKeys("2025");
        
        //Se mueve hasta el siguiente input "Tipo Documento"
        Actions accion = new Actions(driver);
        accion.sendKeys(Keys.TAB).perform();
        sleep(3000);
        accion.sendKeys(Keys.TAB).perform();
        sleep(3000);

        //En el input tipo documento ingresa un valor
        accion.sendKeys("Nota de dédito").perform();
        sleep(3000);
        accion.sendKeys(Keys.ENTER).perform();
        accion.sendKeys(Keys.TAB).perform();
        
        sleep(5000); 
       
        //Busca el boton y valida si este esta activo, de estarlo presiona enter
        var btnBuscar = driver.findElement(By.cssSelector(
            ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-fullWidth"));

        if(btnBuscar.isEnabled()){
            accion.sendKeys(Keys.ENTER).perform();            
        } else {
            Logs.error("estado del boton: " + btnBuscar.isEnabled());

        }

        sleep(10000);

        FileManager.logMessage("Error: " + btnBuscar.isEnabled());

        softAssert.assertNotEquals(razonSocial, "");
        softAssert.assertTrue(razonSocial.isSelected());
        softAssert.assertTrue(btnBuscar.isEnabled());
        softAssert.assertAll();

        sleep(3000);

    }

    
    @Test(groups = {regression})
    public void remuneracionSiiAgriTest() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        var url = "https://dev-test-agri.herokuapp.com/";

        FileManager.logMessage("Prueba SII");
        FileManager.logMessage("Buscar documentos Factura Electronica");

        Logs.info("Test");
        driver.get(url);
        Logs.info("url: %s",url);
        
        sleep(3000);

        driver.findElement(By.id("user_email")).sendKeys("asistencia@agri.so");
        Logs.info("Se ingresa el usuario");

        driver.findElement(By.id("user_password")).sendKeys("d644cb1c7#T");
        Logs.info("Se ingresa la contraseña");

        //driver.findElement(By.className("btn btn-primary mb-2")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary.login-button")).click();

        sleep(5000);

        //Realiza click en boton "ACCION"
        var btnAccion = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div/div/div[3]/div[2]/div/button"));

        btnAccion.click();

        sleep(3000);

        //esto sire para el boton buscar
        //driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-fullWidth")).click();

        //Busca y selecciona la opcion "Integracion SII"
        var menuSii = driver.findElement(By.xpath("//*[@id=\"menu-list-grow\"]/li[13]"));

        menuSii.click();

        sleep(3000);

        //WebElement taxType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxableTypeId")));
        //taxType.

        //WebElement div = driver.findElement(By.className(".MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3"));

        //Busca el input "Razon Social"
        WebElement razonSocial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("organizationList")));

        razonSocial.sendKeys("Sutil");
        sleep(3000);
        razonSocial.sendKeys(Keys.ENTER);

        sleep(3000);

        //Selecciona las fechas
        var dataPicker = driver.findElement(By.id("datepicker-simple"));

        dataPicker.click();

        dataPicker.sendKeys("04");
        dataPicker.sendKeys(Keys.TAB);
        dataPicker.sendKeys("2025");
        
        //Se mueve hasta el siguiente input "Tipo Documento"
        Actions accion = new Actions(driver);
        accion.sendKeys(Keys.TAB).perform();
        sleep(3000);
        accion.sendKeys(Keys.TAB).perform();
        sleep(3000);

        //En el input tipo documento ingresa un valor
        accion.sendKeys("Remuneraciones").perform();
        sleep(3000);
        accion.sendKeys(Keys.ENTER).perform();
        accion.sendKeys(Keys.TAB).perform();
        
        sleep(5000); 
       
        //Busca el boton y valida si este esta activo, de estarlo presiona enter
        var btnBuscar = driver.findElement(By.cssSelector(
            ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-fullWidth"));

        if(btnBuscar.isEnabled()){
            accion.sendKeys(Keys.ENTER).perform();
            Assert.assertTrue(btnBuscar.isEnabled());
            Assert.assertEquals(razonSocial.getText(), "Sutil");
            Assert.assertEquals(dataPicker.getText(), "2025-04");        
        } else {
            Logs.error("estado del boton: " + btnBuscar.isEnabled());

        }

        sleep(10000);

        FileManager.logMessage("Error: " + btnBuscar.isEnabled());

        softAssert.assertNotEquals(razonSocial.getText(), "");
        //softAssert.assertTrue(razonSocial.isSelected());
        softAssert.assertTrue(btnBuscar.isEnabled());
        softAssert.assertAll();

        sleep(3000);
    }

}