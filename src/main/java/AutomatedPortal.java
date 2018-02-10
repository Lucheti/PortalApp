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
        try {
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

        driver.findElement(By.name("NroDoc")).sendKeys(usuarioStr);

        driver.findElement(By.name("Clave")).sendKeys(contraseñaStr);

        driver.findElement(By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/form/div[5]/button")).submit();

    }

    public void verNotas(){
        driver.findElement(By.xpath("//*[@id=\"MateriaActions\"]/a")).click();

    }
    boolean isDisplayed(String id){
        return driver.findElement(By.id(id)).isDisplayed();
    }

    public static void main(String[] args) throws InterruptedException {
        AutomatedPortal portal = new AutomatedPortal();
        portal.invokeBrowser();
        portal.iniciarSesion("41710483", "6541Neuq");
        portal.verNotas();
        Thread.sleep(5000);
        System.out.println(portal.isDisplayed("commonConfirmationModalBody"));
    }
}


//*[@id="MateriaActions"]/a[3]