/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo.toolshop.gui.pages.ios;

import java.util.List;

import com.zebrunner.carina.demo.toolshop.gui.enums.ByCategoty;
import com.zebrunner.carina.demo.toolshop.gui.enums.SortDropdown;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.toolshop.gui.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//a[@data-test='filters']")
    private ExtendedWebElement webFilterBtn;

    @FindBy(xpath = "//*[contains(@text,'Filters')]")
    private ExtendedWebElement filterBtn;

    @FindBy(xpath = "//span[@class='navbar-toggler-icon']")
    private ExtendedWebElement hamburgerMenu;

    @FindBy(xpath = "//a[@data-test='nav-sign-in']")
    private ExtendedWebElement singInBtn;

    @FindBy(xpath = "//h5[@data-test='product-name']")
    private List<ExtendedWebElement> productNameList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickOnLoginButton() {
        throw new NotImplementedException();
    }

    @Override
    public void searchForProduct(String query) {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getProductTitles() {
        throw new NotImplementedException();
    }

    @Override
    public void getProductTitleText(String name) {
        throw new NotImplementedException();
    }

    @Override
    public void clickOnDropdownMenu() {
        throw new NotImplementedException();
    }

    @Override
    public void sortDropdownMenu(SortDropdown sortDropdown) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isProductsSortedFromLowToHighPrice() {
        throw new NotImplementedException();
    }

    @Override
    public void setCheckboxByCategory(ByCategoty byCategory) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isChosenNameCorrect(String name) {
        throw new NotImplementedException();
    }

    @Override
    public ProductDetailsPageBase clickOnProductPage(int index) {
        productNameList.get(index).click();
        return initPage(driver, ProductDetailsPageBase.class);
    }

    @Override
    public boolean isFilterButtonPresent() {
        return webFilterBtn.isElementPresent();
    }

    @Override
    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }

    @Override
    public LoginPageBase clickOnSingInButton() {
        throw new NotImplementedException();
    }

    @Override
    public String getProductTitleTextByIndex(int index) {
      return   productNameList.get(index).getText();
    }

}
