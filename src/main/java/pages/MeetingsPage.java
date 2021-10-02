package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MeetingsPage {
    private WebDriver driver;

    private By createBtn = By.xpath("/html/body/div[4]/div/div[1]/div/div[2]/div[2]/div/button/div/ng-transclude/md-icon");
    private By createMeeting = By.xpath("/html/body/div[4]/div/div[1]/div/div[2]/div[2]/div/div/ng-transclude/ul/li[2]/span");
    private By meetingNameField = By.xpath("//md-input-container[@class='flex-1 margin-bottom-0 add-meeting-title-input add-meeting-title-input--shrink']//input[@id='name']");
    private By nextButton = By.xpath("//button[@aria-label='Next']");
    private By CreateMeetingBtn = By.xpath("//button[@aria-label='Create']");
    private By viewMeetingButton = By.xpath("//button[@class='round-button round-button--auto skeleton-small-button ng-scope']");


    public MeetingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCreateButton() {
        driver.findElement(createBtn).click();
    }

    public void clickOnCreateMeeting() {
        driver.findElement(createMeeting).click();
    }

    public void setMeetingName(String meetingName) {
        WebElement meetingfiled = driver.findElement(meetingNameField);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(meetingfiled));
        meetingfiled.click();
        meetingfiled.sendKeys(meetingName);

    }

    public void clickOnViewMeeting(String meetingName) {
        WebElement meetingNameElement = driver.findElement(By.xpath("//span[normalize-space()='" + meetingName + "']"));
        WebElement viewMeetingElement = driver.findElement(viewMeetingButton);
        WebElement pageTileElement = driver.findElement(By.xpath("//input[@id='page-title']"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(meetingNameElement));
        meetingNameElement.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(viewMeetingElement));
        viewMeetingElement.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(pageTileElement));
    }

    public void clickNext() {
        WebElement nextElem = driver.findElement(nextButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(nextElem));
        nextElem.click();

    }

    public void finalCreate() {
        WebElement finalCreateElement = driver.findElement(CreateMeetingBtn);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(finalCreateElement));
        finalCreateElement.click();

    }

    public boolean isMeetingCreated(String meetingName) {
        WebElement meetingNameElement = driver.findElement(By.xpath("//span[normalize-space()='" + meetingName + "']"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(meetingNameElement));
        return meetingNameElement.isDisplayed();

    }

    public void createNewMeeting(String meetingName) {
        clickOnCreateButton();
        clickOnCreateMeeting();
        setMeetingName(meetingName);
        clickNext();
        finalCreate();
    }

}
