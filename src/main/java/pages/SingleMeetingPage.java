package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleMeetingPage {
    private WebDriver driver;
    By sendInvitesButton = By.xpath("/html/body/div[5]/div/div[2]/div[2]/div[1]/div/div[1]/ul[2]/li[1]/div/div[2]/div[2]/button[2]");
    By selectAllUsersRadioBtn = By.xpath("/html/body/div[9]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/md-checkbox/div[1]");
    By sendConfirmBtn = By.xpath("//button[@class='round-button round-button--loading button-modal']");
    By successMsg = By.xpath("//div[@id='sprite-plyr']//*[name()='svg']");


    public SingleMeetingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSendInvites() {
        WebElement sendInvitesElem = driver.findElement(sendInvitesButton);
        String clickScript = "arguments[0].click();";
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(sendInvitesElem));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(sendInvitesElem));
        ((JavascriptExecutor) driver).executeScript(clickScript, sendInvitesElem);
        WebElement selectAllElem = driver.findElement(selectAllUsersRadioBtn);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(selectAllElem));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(selectAllElem));
        ((JavascriptExecutor) driver).executeScript(clickScript, selectAllElem);
        WebElement confirmSendElem = driver.findElement(sendConfirmBtn);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(confirmSendElem));
        ((JavascriptExecutor) driver).executeScript(clickScript, confirmSendElem);

    }

    public Boolean isInvitationSent() {
        WebElement successMsg = driver.findElement(sendInvitesButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(successMsg));
        return successMsg.isDisplayed();


    }
}
