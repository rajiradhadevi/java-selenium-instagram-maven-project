package com.raji.tests;

import com.raji.config.AppConfiguration;
import com.raji.pages.HomePage;
import com.raji.pages.LandingPage;
import com.raji.pages.LoginPage;
import com.raji.pages.ProfilePage;
import com.raji.tests.base.FunctionalTest;
import com.raji.util.WaitHelper;
import org.junit.Test;


public class UIFlowsLoginLogoutTest extends FunctionalTest {


    @Test
    public void LoginLogoutFlowTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.AtChecker();
        TakeScreenshot("Home Page");
        homePage.ClickOnloginLink();
        WaitHelper.WaitForPageLoad();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.AtChecker();
        TakeScreenshot("Login Page");
        loginPage.ClickOnSignIn(AppConfiguration.Email, AppConfiguration.Password);
        WaitHelper.WaitForPageLoad();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.ClickOnDialogBox();
        landingPage.AtChecker();
        TakeScreenshot("Landing Page");
        landingPage.ClickOnProfileLink();
        WaitHelper.WaitForPageLoad();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.AtChecker();
        TakeScreenshot("Profile Page");
        profilePage.ClickOnSettingsButton();
        profilePage.ClickOnLogout();
        WaitHelper.WaitForPageLoad();

        homePage = new HomePage(driver);
        homePage.AtChecker();
        TakeScreenshot("Home Page");


    }
}