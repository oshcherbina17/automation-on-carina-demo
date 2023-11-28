package com.zebrunner.carina.demo.toolshop.gui.pages.desktop;

import com.zebrunner.carina.demo.toolshop.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(css = "span[class='product-title']")
    private ExtendedWebElement productTitleText;

    @FindBy(css = "button[data-test='proceed-1']")
    private ExtendedWebElement confirmBtn;

    @FindBy(xpath = "//p[contains(text(),'already logged in')]")
    private ExtendedWebElement loggedInText;

    @FindBy(css = "button[data-test='proceed-2']")
    private ExtendedWebElement confirmSingIBtn;

    @FindBy(css = "input[id='address']")
    private ExtendedWebElement addressInput;

    @FindBy(css = "button[data-test='proceed-3']")
    private ExtendedWebElement confirmAddressBtn;

    @FindBy(css = "select[id='payment-method']")
    private ExtendedWebElement paymentMethodMenu;

    @FindBy(css = "option[value='3: Credit Card']")
    private ExtendedWebElement paymentCreditCard;

    @FindBy(css = "input[id='account-name']")
    private ExtendedWebElement accountNameInput;

    @FindBy(css = "input[id='account-number']")
    private ExtendedWebElement accountNumberInput;

    @FindBy(css = "button[data-test='finish']")
    private ExtendedWebElement confirmFinishBtn;

    @FindBy(css = "div[class='help-block']")
    private ExtendedWebElement successPaymentText;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitleText() {
        return productTitleText.getText();
    }

    @Override
    public void clickToCheckoutButton() {
        confirmBtn.click();
    }

    @Override
    public boolean isElementPresent(){
        return loggedInText.isElementPresent();
    }

    @Override
    public void clickToConfirmSingIButton() {
        confirmSingIBtn.click();
    }

    @Override
    public boolean isAddressInputPresent(){
        return addressInput.isElementPresent();
    }

    @Override
    public void clickToConfirmAddressButton() {
        confirmAddressBtn.click();
    }

    @Override
    public void fillPaymentMethod(String name, String number) {
        paymentMethodMenu.click();
        paymentCreditCard.click();
        accountNameInput.type(name);
        accountNumberInput.type(number);
        waitUntil(ExpectedConditions.elementToBeClickable(confirmFinishBtn), 10);
        confirmFinishBtn.click();
    }

    @Override
    public boolean isSuccessPaymentTextPresent(){
        return successPaymentText.isElementPresent();
    }
}
