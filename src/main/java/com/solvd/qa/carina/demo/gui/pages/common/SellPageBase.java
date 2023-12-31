package com.solvd.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class SellPageBase extends AbstractPage {
    @FindBy(xpath = "//section[@id='image_banner_1']//a")
    protected ExtendedWebElement listAnItemButton;
    @FindBy(xpath = "//*[@id='gh-logo']")
    protected ExtendedWebElement eBayLogo;
    protected SellPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract HomePageAbstract clickLogo();
}
