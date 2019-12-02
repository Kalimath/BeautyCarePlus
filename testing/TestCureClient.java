/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of TestCureClient.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;

public class TestCureClient {
    private WebDriver driver;
    String url = "http://localhost:8080/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\Informatica\\Fase 1\\Webontwikkeling2\\chromedriver_chrome_77\\chromedriver.exe");
        driver = new ChromeDriver();

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

        //make variables of all birthday elements
        WebElement dayForm = driver.findElement(By.id("day"));
        WebElement monthForm = driver.findElement(By.id("month"));
        WebElement yearForm = driver.findElement(By.id("year"));
        //clear text in birthday elements
        dayForm.clear();
        monthForm.clear();
        yearForm.clear();
        //fill in dummy birthday form
        dayForm.sendKeys("12");
        monthForm.sendKeys("12");
        yearForm.sendKeys("2012");

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
    }

    @Test
    public void client_can_log_in_and_access_their_cure(){
        driver.get(url + "command?=Home");
        WebElement inputName = driver.findElement(By.id("name"));
        inputName.clear();
        inputName.sendKeys("Karyna Krupianskaya");
        driver.findElement(By.id("submit"));
        driver.findElement(By.id("excellPlusLink")).click();

        assertEquals("Excell+",driver.findElement(By.id("title")));
    }

    @Test
    public void a_new_client_can_log_in_and_add_turns_to_their_cure(){
        driver.get(url + "command?=Home");
        WebElement inputName = driver.findElement(By.id("name"));
        inputName.clear();
        inputName.sendKeys("Karyna Krupianskaya");
        driver.findElement(By.id("submit"));
        driver.findElement(By.id("excellPlusLink")).click();

        assertEquals("Excell+",driver.findElement(By.id("title")));
    }


    @After
    public void clean() {
        driver.get("Controller?command=DeleteClient&name=Jan Janssens");
        driver.quit();
    }
}
