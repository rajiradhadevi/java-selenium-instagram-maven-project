package com.raji.pages;

import com.raji.config.AppConfiguration;
import com.raji.pages.base.BasePage;
import com.raji.util.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(css = "main header section h1")
    private WebElement profilenameLabel;

    @FindBy(css = "main header section button span[aria-label=\"Options\"]")
    private WebElement settingsButton;

    @FindBy(css = "div[role=\"dialog\"] button:nth-of-type(7)")
    private WebElement logoutButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void AtChecker() throws Exception {
        DriverHelper.AssertPageTitleContains("Instagram");
        DriverHelper.AssertPageUrlStartsWith(AppConfiguration.BaseUrl);
        DriverHelper.AssertPageUrlContains(AppConfiguration.username);
        profilenameLabel.isDisplayed();
        profilenameLabel.getText().compareTo(AppConfiguration.username);
        settingsButton.isDisplayed();
    }

    public void ClickOnSettingsButton() {
        settingsButton.isSelected();
        settingsButton.click();
    }

    public void ClickOnLogout() {
        logoutButton.click();
    }

}




