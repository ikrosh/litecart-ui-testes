package ua.selenium.litecart.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminShopTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private static final String adminEndpoint = "http://localhost/litecart/admin/";
    private static final String credentials = "admin";


    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void Zadanie1() {
        driver.get(adminEndpoint);
        loginPage.enterCredentials(credentials, credentials);
        loginPage.clickLogin();

        System.err.println("current page = " + driver.getCurrentUrl());
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
