package com.nopcommerce.demo.testSuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegistrationPage;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage ;
    RegistrationPage registrationPage ;
    public static String nEmail;

    @Test
    public void verifyUserShouldNavigateToLoginPage() throws InterruptedException {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        homePage.clickOnLoginLink();
        //homePage.clickOnLoginLink();
        waitFor(2);
        nEmail = randomEmail();
        loginPage.enterEmailId(nEmail);
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void verifyUserShouldNotLoginSuccessfullyWithInValidCredentials() throws InterruptedException {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        homePage. clickOnLoginLink();
        Thread.sleep(500);
        loginPage.enterEmailId("betatest123@me.com.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
