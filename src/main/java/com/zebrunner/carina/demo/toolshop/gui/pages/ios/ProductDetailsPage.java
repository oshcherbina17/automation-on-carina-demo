package com.zebrunner.carina.demo.toolshop.gui.pages.ios;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(css = "h1[data-test='product-name']")
    private ExtendedWebElement productTitleText;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'Pliers'`][1]")
    private ExtendedWebElement productTitleTextForIOS;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addToCartButtonClick() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCartCounterPresent() {
        throw new NotImplementedException();
    }

    @Override
    public String getTitleText() {
        return productTitleTextForIOS.getText();
    }

    @Override
    public CartPageBase clickOnCartButton() {
        throw new NotImplementedException();
    }
}
