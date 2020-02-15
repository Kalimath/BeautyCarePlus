/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2020. All Rights Reserved
 * Unauthorized copying of TestMeasureClient.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (mathi), Month Year
 */

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

import static junit.framework.TestCase.assertEquals;

public class TestMeasureClient {
    private WebDriver driver;
    String url = "http://localhost:8080/";
    Properties properties;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\Informatica\\Overige\\chromedriver_80\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /*@Before
    public void login(){
        driver.get(url + "logInForm.jsp");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("mathieu_broe@yahoo.com");

        WebElement psswd = driver.findElement(By.id("password"));
        psswd.sendKeys("bxSe8685");

        driver.findElement(By.id("submit")).click();
    }*/

    @Test
    public void view_cure_from_client(){
        driver.get(url + "logInForm.jsp");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("mathieu_broe@yahoo.com");

        WebElement psswd = driver.findElement(By.id("password"));
        psswd.sendKeys("bxSe8685");

        driver.findElement(By.id("submit")).click();

        driver.get(url + "Controller?command=FindClient&name=Karyna%20Krupianskaya");
        assertEquals(driver.findElement(By.id("clientName")).getText(), "Karyna Krupianskaya");
    }

    @Test
    public void when_cure_with_checkup_is_clicked_checkupform_is_shown(){
        driver.get(url + "logInForm.jsp");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("mathieu_broe@yahoo.com");

        WebElement psswd = driver.findElement(By.id("password"));
        psswd.sendKeys("bxSe8685");

        driver.findElement(By.id("submit")).click();

        driver.get(url + "Controller?command=FindClient&name=Karyna%20Krupianskaya");
        assertEquals(driver.findElement(By.id("clientName")).getText(), "Karyna Krupianskaya");

        driver.get("http://localhost:8080/Controller?command=ExcellPlusCureView");

        WebElement submitCheckup = driver.findElement(By.id("submitStartCureWithCheckup"));
        submitCheckup.click();

        assertEquals(driver.findElement(By.id("pageName")).getText(), "Opmeting");

    }

    @Test
    public void Weights_are_added_to_database_when_form_is_submitted(){
        driver.get(url + "logInForm.jsp");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("mathieu_broe@yahoo.com");

        WebElement psswd = driver.findElement(By.id("password"));
        psswd.sendKeys("bxSe8685");

        driver.findElement(By.id("submit")).click();

        driver.get(url + "Controller?command=FindClient&name=Karyna%20Krupianskaya");
        assertEquals(driver.findElement(By.id("clientName")).getText(), "Karyna Krupianskaya");

        driver.get("http://localhost:8080/Controller?command=ExcellPlusCureView");

        WebElement submitCheckup = driver.findElement(By.id("submitStartCureWithCheckup"));
        submitCheckup.click();

        assertEquals(driver.findElement(By.id("pageName")).getText(), "Opmeting");


        //        weights
        double gewicht = 68;
        double vetmassa = 21.5;
        double spiermassa = 28.5;
        double vochtmassa = 4.5;
        double botmassa = 13.5;
        double bmr = 3099;
        double metabolischeLeeftijd = 38;
        double visceraleVetwaarde = 10;
        double idealeVetmassaBegin = 14;
        double idealeVetmassaEinde = 23;

        WebElement gewichtWE = driver.findElement(By.id("gewicht"));
        gewichtWE.sendKeys(gewicht + "");

        WebElement vetmassaWE = driver.findElement(By.id("vetmassa"));
        vetmassaWE.sendKeys(vetmassa + "");

        WebElement spiermassaWE = driver.findElement(By.id("spiermassa"));
        spiermassaWE.sendKeys(spiermassa + "");

        WebElement vochtmassaWE = driver.findElement(By.id("vochtmassa"));
        vochtmassaWE.sendKeys(vochtmassa + "");

        WebElement botmassaWE = driver.findElement(By.id("botmassa"));
        botmassaWE.sendKeys(botmassa + "");

        WebElement bmrWE = driver.findElement(By.id("bmr"));
        bmrWE.sendKeys(bmr + "");

        WebElement metabolischeLeeftijdWE = driver.findElement(By.id("metabolischeLeeftijd"));
        metabolischeLeeftijdWE.sendKeys(metabolischeLeeftijd + "");

        WebElement visceraleVetwaardeWE = driver.findElement(By.id("visceraleVetwaarde"));
        visceraleVetwaardeWE.sendKeys(visceraleVetwaarde + "");

        WebElement idealeVetmassaBeginWE = driver.findElement(By.id("idealeVetmassaBegin"));
        idealeVetmassaBeginWE.sendKeys(idealeVetmassaBegin + "");

        WebElement idealeVetmassaEindeWE = driver.findElement(By.id("idealeVetmassaEinde"));
        idealeVetmassaEindeWE.sendKeys(idealeVetmassaEinde + "");

//         circumferences
        double heup = 43.7;
        double taille = 35.2;
        double dij = 56.7;
        double kuit = 28.9;
        double arm = 14.7;
        double knie = 15.6;

        WebElement heupWE = driver.findElement(By.id("heupO"));
        heupWE.sendKeys(heup + "");

        WebElement tailleWE = driver.findElement(By.id("tailleO"));
        tailleWE.sendKeys(taille + "");

        WebElement dijWE = driver.findElement(By.id("dijO"));
        dijWE.sendKeys(dij + "");

        WebElement kuitWE = driver.findElement(By.id("kuitO"));
        kuitWE.sendKeys(kuit + "");

        WebElement armWE = driver.findElement(By.id("armO"));
        armWE.sendKeys(arm + "");

        WebElement knieWE = driver.findElement(By.id("knieO"));
        knieWE.sendKeys(knie + "");

        driver.findElement(By.id("submit")).click();

//        CheckupDb checkupDb = new CheckupDbSql()
//        nog niet af !!!

    }

    /*@Test
    public void Circumferences_are_added_to_database_when_form_is_submitted(){

    }*/

   /* @After
    public void terminate(){
//        driver.quit();
    }*/
}
