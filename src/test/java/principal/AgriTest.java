package principal;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import utilities.BaseTest;
import utilities.FileManager;
import utilities.Logs;

public class AgriTest extends BaseTest{

    @Ignore
    @Test(groups = {regression})
    public void inicioSesionAgriTest(){
        var url = "https://demo.agri.cl/";

        FileManager.logMessage("Prueba Inicio de Sesion");

        Logs.info("Test");
        driver.get(url);
        Logs.info("url: %s",url);
        
        sleep(3000);

        driver.findElement(By.id("user_email")).sendKeys("demo@agri.cl");
        Logs.info("Se ingresa el usuario");

        driver.findElement(By.id("user_password")).sendKeys("3aabf64ad#T");
        Logs.info("Se ingresa la contraseña");

        //driver.findElement(By.className("btn btn-primary mb-2")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary.login-button")).click();

        sleep(5000);


    }

    @Ignore("Test se obviara por el momento")
    @Test(groups = {regression})
    public void resumenTest(){
        //declarar url a ingresar
        var url = "https:\\demo.agri.cl";

        FileManager.logMessage("Validacion creacion resumen por fecha");

        //Ingresa a la pagina

        driver.get(url);

        //Ingreso de usuario y contraseña

        driver.findElement(By.id("user_email")).sendKeys("demo@agri.cl");
        Logs.info("Se ingresa el usuario");

        driver.findElement(By.id("user_password")).sendKeys("788e48783#T");
        Logs.info("Se ingresa la contraseña");

        var text = driver.findElement(By.id("user_email"));
        Logs.info(text.getText());
        softAssert.assertFalse(text.isEnabled(),"");
        softAssert.assertAll();
        //driver.findElement(By.className("btn btn-primary mb-2")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary.login-button")).click();

        sleep(5000);

        url = "https://demo.agri.cl/budget_report";

        final var currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url);

        //Comando para cerrar ventana emergente
        driver.findElement(By.cssSelector(".MuiSvgIcon-root.closeIcon.MuiSvgIcon-fontSizeLarge")).click();

        sleep(3000);

        //click al menu contextual
        driver.findElement(By.cssSelector(".MuiSvgIcon-root")).click();

        sleep(3000);

        //seleccion de opcion en menu contextual
        var link1 = driver.findElement(By.xpath("//span[text()='Compras y tesorería']"));

        link1.click();

        sleep(3000);

        //Seleccion de subopcion en menu contextual
        var link2 = driver.findElement(By.xpath("//span[text()='Egresos y recepciones']"));

        link2.click();

        //driver.findElement(By.cssSelector(".MuiTypography-root-3036.MuiListItemText-primary-3034.MuiTypography-body1-3038.MuiTypography-displayBlock-3065")).click();

        sleep(3000);

        //ingreso de fecha en filtro
        var dateInput = driver.findElement(By.id("startDateSearch"));
        dateInput.click();

        sleep(3000);

        dateInput.sendKeys("01-04-2025");

        sleep(3000);

        //click en boton buscar
        driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-fullWidth")).click();

        sleep(5000);

        //var accion1 = driver.findElement(By.xpath("//*[@id=\"menu-list-grow\"]/li[2]///div[normalize-space()='Planilla Excel']"));

        //accion1.click();

        //seleccion filtro "Estado"
        driver.findElement(By.id("mui-component-select-accounted")).click();

        sleep(3000);

        //seleccion del estado para filtro
        driver.findElement(By.xpath("//*[@id=\"menu-accounted\"]/div[3]/ul/li[2]")).click();

        sleep(3000);

        //selecciom de fitlro "Sistema"
        driver.findElement(By.id("mui-component-select-system")).click();

        //seleccion del dato del filtro
        driver.findElement(By.xpath("//*[@id=\"menu-system\"]/div[3]/ul/li[2]")).click();

        sleep(5000);

        driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-root.MuiButton-contained.primary-button.MuiButton-containedPrimary.MuiButton-fullWidth")).click();
    }
}