package com.zebrunner.carina.demo.toolshop;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest implements IAbstractTest {
    final int INDEX_ONE = 1;
    final int INDEX_TWO = 2;

    @Test(description = "User can add products to cart")
    public void addProductToCartTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        ProductDetailsPageBase detailsPage = homePage.clickOnProductPage(INDEX_ONE);
        detailsPage.addToCartButtonClick();
        Assert.assertTrue(detailsPage.isCartCounterPresent(), " Counter isn`t presented");
        String titleText = detailsPage.getTitleText();
        CartPageBase cardPage = detailsPage.clickOnCartButton();
        Assert.assertTrue(cardPage.getTitleText().contains(titleText), " Card title text is not contains" +
                " product title text");
    }

    @Test(description = "User can login and checkout chosen products")
    public void checkoutProductTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        LoginPageBase loginPage = homePage.clickOnLoginButton();
        AccountPageBase accountPage = loginPage.login("tomassaw91@gmail.com", "tomas1991");
        accountPage.clickOnHomePage();
        ProductDetailsPageBase detailsPage = homePage.clickOnProductPage(INDEX_TWO);
        detailsPage.addToCartButtonClick();
        CartPageBase cardPage = detailsPage.clickOnCartButton();
        cardPage.clickToCheckoutButton();
        Assert.assertTrue(cardPage.isElementPresent(), " Logged in text is not presented");
        cardPage.clickToConfirmSingIButton();
        Assert.assertTrue(cardPage.isAddressInputPresent(), " Address input is not presented");
        cardPage.clickToConfirmAddressButton();
        cardPage.fillPaymentMethod("Tomas","12105361400");
        Assert.assertTrue(cardPage.isSuccessPaymentTextPresent(), " Success payment text is not presented");
    }
}
