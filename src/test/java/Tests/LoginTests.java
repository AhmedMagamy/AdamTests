package Tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilites.ExcelUtility;

@Listeners(utilites.ReportsGenerator.class)
public class LoginTests extends BaseTests {
    private LoginPage loginPage;

    //in this method we call all needed pages for tests
    @BeforeMethod
    public void callPages() {
        loginPage = new LoginPage(driver);

    }


    //in this method we do our tests
    @Test(description = "open login page - fill login data - verify it's done successfully")
    public void login() {

        driver.navigate().to("https://agamytask.adam.ai");
        String email = "ahmedagamy300@gmail.com";
        String password = "12345678";
        //fill email
        loginPage.setEmailField(email);
        //fill password
        loginPage.setPasswordField(password);
        //click login
        loginPage.clickLoginButton();
        //Check that the title is changed to meetpalce page
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Meetplace"));

    }

}
