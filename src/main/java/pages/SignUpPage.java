package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    private WebDriver driver;
    private By firstNameField = By.name("first name");
    private By lastNameField = By.name("last name");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By meetplaceField = By.name("subdomain");
    private By createButton = By.xpath("/html/body/div[1]/div[1]/div/div[2]/main/div/div[2]/form/button");
    private By coockiesPopup = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/button/span[1]/span");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstNameField(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setMeetplaceField(String meetplace) {
        driver.findElement(meetplaceField).sendKeys(meetplace);
    }

    public void clickCreate() {
        WebElement cBtn = driver.findElement(createButton);
        WebElement cookiesBar = driver.findElement(coockiesPopup);
        //click on cookies bar that hide the button
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(cookiesBar));
        cookiesBar.click();
        //scroll to the button
        String scrollScript = "arguments[0].scrollIntoView();";
        String clickScript = "arguments[0].click();";
        ((JavascriptExecutor) driver).executeScript(scrollScript, cBtn);
        //click on th button
        ((JavascriptExecutor) driver).executeScript(clickScript, cBtn);

        //wait until the button to be clickable
        //   new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(cBtn));
        //clcik
        //   cBtn.click();
    }
}
