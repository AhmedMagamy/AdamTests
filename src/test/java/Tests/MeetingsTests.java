package Tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MeetingsPage;

public class MeetingsTests extends BaseTests {

    private LoginPage loginPage;
    private MeetingsPage meetingsPage;

    //in this method we call all needed pages for tests
    @BeforeMethod
    public void callPages() {
        loginPage = new LoginPage(driver);
        meetingsPage = new MeetingsPage(driver);

    }

    //in this method we do our tests
    @Test(description = "open adam and login - go to meetings - create meeting - verify it's created")
    public void createMeeting() throws InterruptedException {
        //open Adam.ai
        driver.navigate().to("https://agamytask.adam.ai");
        String email = "ahmedagamy300@gmail.com";
        String password = "12345678";
        String meetingName = "NewCreatedMeeting";
        //Login
        loginPage.login(email, password);
        //open meetings screen
        driver.navigate().to("https://agamytask.adam.ai/#!/meetings");
        //click on create meeting
        meetingsPage.clickOnCreateButton();
        meetingsPage.clickOnCreateMeeting();
        //fill meeting name
        meetingsPage.setMeetingName(meetingName);
        meetingsPage.clickNext();
        //click create meeting
        meetingsPage.finalCreate();
        //verify meeting is created
        Assert.assertTrue(meetingsPage.isMeetingCreated(meetingName));

    }


}
