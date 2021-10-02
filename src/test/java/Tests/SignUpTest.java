package Tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;

public class SignUpTest extends BaseTests {

    private SignUpPage signUpPage;

    //in this method we call all needed pages for tests
    @BeforeMethod
    public void callPages() {
        signUpPage = new SignUpPage(driver);

    }

    //in this method we do our tests
    @Test(description = "Open signup page - fill data - verify it's done ")
    public void signUp() {

        driver.navigate().to("https://adam.ai/signup?lang=en");
        String email = "ahmedagamy800@gmail.com";
        String password = "12345678";
        String firstName = "ali";
        String lastName = "zaki";
        String urlmeetpalce = "alizaki";

        //Fill sign up data
        signUpPage.setFirstNameField(firstName);
        signUpPage.setLastNameField(lastName);
        signUpPage.setEmailField(email);
        signUpPage.setPasswordField(password);
        signUpPage.setMeetplaceField(urlmeetpalce);
        //submit the form
        signUpPage.clickCreate();
        //verfiy that sign up done and yoy redirected to confirm email screen
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Confirm"));


    }

}
