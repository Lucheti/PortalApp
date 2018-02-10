import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by lucasgarcia on 9/2/18.
 */
public class AutomatedPortal {

    WebDriver driver;

    void invokeBrowser() {
        //abre chrome y carga el portal de la austral
        try {
            //el comando webdriver.chrome.driver siempre es el mismo (si estas abriendo chrome) pero la direccion es donde tengas
            //guardado el Chromedriver que te lo bajas de la pagina de Seleniumhq.org
            System.setProperty("webdriver.chrome.driver", "/Users/lucasgarcia/Desktop/Chromedriver");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.get("http://www.austral.edu.ar/PORTAL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void iniciarSesion(String usuarioStr, String contraseñaStr) {
        //Ingresa usuario y contraseña en el formulario del portal y loguea

        driver.findElement(By.name("NroDoc")).sendKeys(usuarioStr);

        driver.findElement(By.name("Clave")).sendKeys(contraseñaStr);

        driver.findElement(By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/form/div[5]/button")).submit();

    }

    public void verNotas(){
        //hardcodeado pero abre el ver notas el Algebra 1
        driver.findElement(By.xpath("//*[@id=\"MateriaActions\"]/a")).click();

    }
    boolean isDisplayed(String id){
        // puse este metodo pq no podes llamar al driver desde el main porque le da un golpe de estatica
        return driver.findElement(By.id(id)).isDisplayed();
    }

    public static void main(String[] args) throws InterruptedException {
        //Dale play monoooooooooooaskFJGAKSDLGFLKASDGFKASGJDF
        AutomatedPortal portal = new AutomatedPortal();
        portal.invokeBrowser();
        portal.iniciarSesion("41710483", "6541Neuq");
        portal.verNotas();
        Thread.sleep(5000);
        System.out.println(portal.isDisplayed("commonConfirmationModalBody"));
    }
}


