package com.solvd.qa.carina.demo.gui.components.footer;

import com.solvd.qa.carina.demo.gui.pages.desktop.BuyPage;
import com.solvd.qa.carina.demo.gui.pages.desktop.SellPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class FooterMenuDesktop extends FooterMenuGeneral {

    @FindBy(xpath = "//div[@id='gf-BIG']//td[1]/h3/a")
    private ExtendedWebElement buyLink;

    @FindBy(xpath = "//div[@id='gf-BIG']//td[2]/h3[1]/a")
    private ExtendedWebElement sellLink;


    public FooterMenuDesktop(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public BuyPage openBuyPage() {
        buyLink.scrollTo();
        buyLink.hover();
        buyLink.click();
        return new BuyPage(driver);
    }

    @Override
    public SellPage openSellPage() {
        sellLink.scrollTo();
        sellLink.hover();
        sellLink.click();
        return new SellPage(driver);
    }

}
