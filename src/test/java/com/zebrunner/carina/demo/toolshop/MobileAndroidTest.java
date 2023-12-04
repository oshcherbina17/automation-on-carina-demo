package com.zebrunner.carina.demo.toolshop;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.AccountPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.GooglePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileAndroidTest implements IAbstractTest, IMobileUtils {
    @Test(description = "User can login")
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testLoginUser() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.clickOnHamburgerMenu();
        LoginPageBase login = homePage.clickOnSingInButton();
        AccountPageBase accountPage = login.login("tomas1992@gmail.com", "tomas1991");
        Assert.assertTrue(accountPage.isFavoritesButtonPresent(), "Favorites button isn`t presented");
        Assert.assertTrue(accountPage.isProfileButtonPresent(), "Profile button isn`t presented");
        Assert.assertTrue(accountPage.isInvoicesButtonPresent(), "Invoices button isn`t presented");
        Assert.assertTrue(accountPage.isMessagesButtonPresent(), "Messages button isn`t presented");
    }
}
