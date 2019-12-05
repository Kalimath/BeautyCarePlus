import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestFormClient {

    private WebDriver driver;
    String url = "http://localhost:8080/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\Informatica\\Fase 1\\Webontwikkeling2\\chromedriver_chrome_77\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void form_shows_all_errors_when_form_is_submitted_empty(){
        driver.get(url+"clientForm.jsp");

        //clear text in contact elements
        WebElement nameForm = driver.findElement(By.id("name"));
        WebElement emailForm = driver.findElement(By.id("email"));
        WebElement phoneForm = driver.findElement(By.id("phone"));
        nameForm.clear();
        emailForm.clear();
        phoneForm.clear();

        //clear text in birthday elements
        WebElement birthdayForm = driver.findElement(By.id("birthday"));
        birthdayForm.clear();

        //clear text in address elements
        WebElement placeForm = driver.findElement(By.id("place"));
        WebElement zipForm = driver.findElement(By.id("zip"));
        WebElement streetForm = driver.findElement(By.id("street"));
        WebElement numberForm = driver.findElement(By.id("number"));
        placeForm.clear();
        zipForm.clear();
        streetForm.clear();
        numberForm.clear();

        //clear text in comment element
        WebElement commentForm = driver.findElement(By.id("comment"));
        commentForm.clear();


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorUl = driver.findElement(By.id("errorList"));
        List<WebElement> errorLis = errorUl.findElements(By.id("error"));
        assertEquals(errorLis.size(),8);
        System.out.println(errorLis.size());
    }

    @Test
    public void client_is_added_after_submitting_client_form(){
        driver.get(url+"clientForm.jsp");

        //make variables of all contact elements
        WebElement nameForm = driver.findElement(By.id("name"));
        WebElement emailForm = driver.findElement(By.id("email"));
        WebElement phoneForm = driver.findElement(By.id("phone"));
        //clear text in contact elements
        nameForm.clear();
        emailForm.clear();
        phoneForm.clear();
        //fill in dummy contact form
        nameForm.sendKeys("Jan Janssens");
        emailForm.sendKeys("Jan.Janssens@gmail.com");
        phoneForm.sendKeys("0123456789");

        //clear text in birthday element
        WebElement birthdayForm = driver.findElement(By.id("birthday"));
        birthdayForm.clear();

        //fill in dummy birthdate
        birthdayForm.sendKeys("15-02-1959");

        //make variables of all address elements
        WebElement placeForm = driver.findElement(By.id("place"));
        WebElement zipForm = driver.findElement(By.id("zip"));
        WebElement streetForm = driver.findElement(By.id("street"));
        WebElement numberForm = driver.findElement(By.id("number"));
        //clear text in address elements
        placeForm.clear();
        zipForm.clear();
        streetForm.clear();
        numberForm.clear();
        //fill in dummy address form
        placeForm.sendKeys("Leuven");
        zipForm.sendKeys("3000");
        streetForm.sendKeys("Engels Plein");
        numberForm.sendKeys("14 bus 0701");

        //make variable of comment element
        WebElement commentForm = driver.findElement(By.id("comment"));
        //clear text in comment element
        commentForm.clear();
        //fill in dummy comment form
        commentForm.sendKeys("Kan alleen 's avonds komen.");


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        assertTrue(driver.findElement(By.id("pageTitle")).getText().equals("Klanten"));
        //assertTrue(driver.findElement(By.id("pageTitle")).getText().equals("Overzicht"));


    }

    @After
    public void clean() {
        driver.quit();
    }
}
