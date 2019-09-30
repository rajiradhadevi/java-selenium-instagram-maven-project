package com.raji.pages;

import com.raji.config.AppConfiguration;
import com.raji.pages.base.BasePage;
import com.raji.util.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(css = "form input[name=\"username\"]")
    private WebElement usernameTextField;

    @FindBy(css = "form input[name=\"password\"]")
    private WebElement passwordTextField;

    @FindBy(css = "form button[type=\"submit\"]")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void AtChecker() throws Exception {
        DriverHelper.AssertPageTitleContains("Login • Instagram");
        DriverHelper.AssertPageUrlContains(AppConfiguration.BaseUrl + "/accounts/login");
    }

    public void ClickOnSignIn(String email, String password) {
        usernameTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        logInButton.click();
    }

}
