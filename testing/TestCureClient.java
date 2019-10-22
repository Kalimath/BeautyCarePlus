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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCureClient {
    private WebDriver driver;
    String url = "http://localhost:8080/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\Informatica\\Fase 1\\Webontwikkeling2\\chromedriver_chrome_77\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void t(){

    }
    @After
    public void clean() {
        driver.quit();
    }
}
