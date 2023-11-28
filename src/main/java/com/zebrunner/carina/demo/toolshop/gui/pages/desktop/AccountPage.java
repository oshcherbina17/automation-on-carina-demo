package com.zebrunner.carina.demo.toolshop.gui.pages.desktop;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.AccountPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountPageBase.class)
public class AccountPage extends AccountPageBase {

    @FindBy(css = "a[data-test='nav-favorites']")
    private ExtendedWebElement myFavoritesBtn;

    @FindBy(css = "a[data-test='nav-profile']")
    private ExtendedWebElement profileBtn;

    @FindBy(css = "a[data-test='nav-invoices'")
    private ExtendedWebElement invoicesBtn;

    @FindBy(css = "a[data-test='nav-messages']")
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
        homeBtn.click();
        return initPage(driver, HomePageBase.class);
    }
}
