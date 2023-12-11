package com.zebrunner.carina.demo.toolshop;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSSafariTest implements IAbstractTest, IMobileUtils {

    final int INDEX_ONE = 1;

    @Test(description = "User can click on PDP and compare titles")
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void safariTest() {
        MobileContextUtils contextHelper = new MobileContextUtils();
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isFilterButtonPresent(), "Filter button isn't presented");
        String productTitleText = homePage.getProductTitleTextByIndex(INDEX_ONE);
        ProductDetailsPageBase detailsPage = homePage.clickOnProductPage(INDEX_ONE);
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
        String titleText = detailsPage.getTitleText();
        Assert.assertEquals(productTitleText,titleText, "Title texts are not equals");
    }
}
