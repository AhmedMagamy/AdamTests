package Tests;

import base.BaseTests;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MeetingsPage;
import pages.SingleMeetingPage;

public class SingleMeetingTests extends BaseTests {
    private LoginPage loginPage;
    private MeetingsPage meetingsPage;
    private SingleMeetingPage singleMeetingPage;

    //in this method we call all needed pages for tests
    @BeforeMethod
    public void callPages() {
        loginPage = new LoginPage(driver);
        meetingsPage = new MeetingsPage(driver);
        singleMeetingPage = new SingleMeetingPage(driver);

    }

    @Test(description = "Open website and login - Create meeting - Invite users to that meeting ")
    public void inviteUsers() {
        //open Adam.ai
        driver.navigate().to("https://agamytask.adam.ai");
        String email = "ahmedagamy300@gmail.com";
        String password = "12345678";
        String meetingName = "AutomatedMeetingRecorded";
        //login to the system
        loginPage.login(email, password);
        //open meetings screen
        driver.navigate().to("https://agamytask.adam.ai/#!/meetings");
        //create new meeting
        meetingsPage.createNewMeeting(meetingName);
        //open that meeting
        meetingsPage.clickOnViewMeeting(meetingName);
        //invite the users to the meeting
        singleMeetingPage.clickOnSendInvites();
        //Verify that you received the success message of the invitation
        Assert.assertTrue(singleMeetingPage.isInvitationSent());


    }
}
