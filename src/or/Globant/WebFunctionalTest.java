package or.Globant;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebFunctionalTest {

    static WebDriver driver;

    public  static void main(String [] args){

        try {
            //Instance the object from WebDriver
            String baseURL = "http://live.demoguru99.com/index.php/checkout/cart/";
            String actualResult = "";
            String expectResult = "$500.00";
            String chromePath = System.getProperty("user.dir")+"\\driver\\chromedriver.exe";

            //Open the Browser
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.get(baseURL);
            driver.manage().window().maximize();


            WebElement lnkMobile = driver.findElement(By.linkText("MOBILE"));

            lnkMobile.click();

            WebElement btnAddtocart = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button/span/span"));
            btnAddtocart.click();

            WebElement lblSubtotal = driver.findElement(By.cssSelector("#shopping-cart-table>tbody>tr>td.product-cart-total>span>span"));
            actualResult = lblSubtotal.getText();

            //Validate
            if (actualResult.contentEquals(expectResult)) {
                System.out.println("Test OK! The result is: " + actualResult + " is equals " + expectResult);
            } else {
                System.out.println("Test Faild! the result is: " + actualResult + " not is equals " + expectResult);
            };
        }catch (NoSuchElementException ne) {
            System.err.println("No se encontró el WebElement" + ne.getMessage());
        }catch (WebDriverException we) {
            System.err.println("Web Driver Fallo: " + we.getMessage());
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
        }//catch (NullPointerException e){
           // System.err.println(e.getMessage());
        finally {
            driver.close();
         }


    }

}


