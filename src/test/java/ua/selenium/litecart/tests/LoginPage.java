package ua.selenium.litecart.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private static final int PAGE_LOAD_TIMEOUT = 10;

    protected WebDriverWait wait;
    protected WebDriver driver;

    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "login")
    private WebElement login;


    public LoginPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 20);
        this.driver = driver;
    }

    void inputInTextField(WebElement webElement, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(value);

        while (!webElement.getAttribute("value").replace("string:", "").equals(value)) {
            wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
            inputInTextField(webElement, value);
        }
    }

    void enterCredentials(String username, String password) {
        inputInTextField(this.username, username);
        inputInTextField(this.password, password);
    }

     void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
    }
}
