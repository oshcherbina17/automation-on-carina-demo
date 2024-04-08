package com.zebrunner.carina.demo.toolshop.gui.pages.android;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.AccountPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccountPageBase.class)
public class AccountPage extends AccountPageBase {

    @FindBy(xpath = "//a[@data-test='nav-favorites']")
    private ExtendedWebElement myFavoritesBtn;

    @FindBy(xpath = "//a[@data-test='nav-profile']")
    private ExtendedWebElement profileBtn;

    @FindBy(xpath = "//a[@data-test='nav-invoices']")
    private ExtendedWebElement invoicesBtn;

    @FindBy(xpath = "//a[@data-test='nav-messages']")
    private ExtendedWebElement messagesBtn;

    @FindBy(css = "a[data-test='nav-home']")
    private ExtendedWebElement homeBtn;

    @FindBy(css = "a[id='user-menu']")
    private ExtendedWebElement userMenu;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFavoritesButtonPresent() {
        return myFavoritesBtn.isElementPresent(2000);
    }

    @Override
    public boolean isProfileButtonPresent() {
        return profileBtn.isElementPresent(2000);
    }

    @Override
    public boolean isInvoicesButtonPresent() {
        return invoicesBtn.isElementPresent(2000);
    }

    @Override
    public boolean isMessagesButtonPresent() {
        return messagesBtn.isElementPresent(2000);
    }

    @Override
    public HomePageBase clickOnHomePage() {
        return null;
    }
}
