package com.raji.pages;

import com.raji.config.AppConfiguration;
import com.raji.pages.base.BasePage;
import com.raji.util.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(css = "div[role=dialog] button:nth-of-type(2)")
    private WebElement dialogBox;


    @FindBy(css = "nav span[aria-label=\"Profile\"]")
    private WebElement profileLink;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void AtChecker() throws Exception {
        DriverHelper.AssertPageTitleContains("Instagram");
        DriverHelper.AssertPageUrlStartsWith(AppConfiguration.BaseUrl);
        profileLink.isDisplayed();
    }

    public void ClickOnDialogBox() {
        dialogBox.click();
    }


    public void ClickOnProfileLink() {
        profileLink.click();
    }

}




