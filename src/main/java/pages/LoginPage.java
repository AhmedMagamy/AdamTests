package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("/html/body/div[4]/div/div[2]/div/div/div/div/div/form/div[3]/button");
    private By meetPLaceElement = By.xpath("/html/body/div[4]/div/div[1]/div/div[2]/div[2]/div/button/div/ng-transclude/md-icon");


    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement buttonElem = driver.findElement(loginButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(buttonElem));
        buttonElem.click();


    }

    public void login(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLoginButton();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf((driver.findElement(meetPLaceElement))));

    }


}
