import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.htmlunit.HtmlUnitWebElement;
import org.openqa.selenium.remote.RemoteWebElement;


public class LoginService  {
    static WebDriver driver = new HtmlUnitDriver();
    public static void main(String[] args) {

       iniciarSesion("41710483", "6541Neuq");
       getPromedio();
       getNotas();
       driver.quit();
    }


    private static void getPromedio() {
        WebElement promedio = driver.findElement(By.id("lblPromedio"));
        System.out.println("Promedio: " + promedio.getText());
    }

    public static void iniciarSesion(String usuarioStr, String contraseñaStr) {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.


        // And now use this to visit Google
        driver.get("http://www.austral.edu.ar/PORTAL");

        // Find the text input element by its name
        WebElement usuario = driver.findElement(By.name("NroDoc"));

        // Enter something to search for
        usuario.sendKeys(usuarioStr);

        WebElement contraseña = driver.findElement(By.name("Clave"));

        contraseña.sendKeys(contraseñaStr);

        // Now submit the form. WebDriver will find the form for us from the element
        usuario.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());


    }

    public static void getNotas() {


        //*[@id="commonConfirmationModalBody"]/table[5]/tbody/tr[2]/td



        RemoteWebElement row = (RemoteWebElement) driver.findElement(By.xpath("//*[@id=\"tbMaterias1\"]/tr[1]"));
        System.out.println(row.getLocation());
        RemoteWebElement row2 = (RemoteWebElement) driver.findElement(By.xpath("//*[@id=\"tbMaterias1\"]/tr[2]"));
        System.out.println(row2.getLocation());
//        WebElement materiaActions = row.findElement(By.id("MateriaActions"));
//        WebElement verNotas = materiaActions.findElement(By.linkText("Ver notas"));
//        System.out.println(verNotas.getLocation());
//        WebElement verNotas2 = driver.findElement(By.xpath("//*[@id=\"MateriaActions\"]/a[3]"));
//        System.out.println(verNotas.getLocation());





//        WebElement notaFinal = driver.findElement(By.xpath("//*[@id=\"commonConfirmationModalBody\"]/table[5]/tbody/tr[2]/td"));
//        System.out.println(notaFinal.toString());

    }

}

