package com.solvd.qa.carina.demo.gui.components;

import com.solvd.qa.carina.demo.gui.pages.desktop.BuyPage;
import com.solvd.qa.carina.demo.gui.pages.desktop.CollectiblesPage;
import com.solvd.qa.carina.demo.gui.pages.desktop.SellPage;
import com.solvd.qa.carina.demo.gui.pages.desktop.SignInPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class EbayPageDesktop extends AbstractEbayPage {
    @FindBy(xpath = "//div[@id='gf-BIG']//td[1]/h3/a")
    private ExtendedWebElement buyLink;
    @FindBy(xpath = "//div[@id='gf-BIG']//td[2]/h3[1]/a")
    private ExtendedWebElement sellLink;
    @FindBy(xpath = "//li[@class = 'vl-flyout-nav__js-tab']/a[text()='Collectibles']")
    private ExtendedWebElement collectiblesLink;
    @FindBy(xpath = "//span[@id='gh-ug']/a")
    private ExtendedWebElement signInLink;
    public EbayPageDesktop(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BuyPage openBuyPage() {
        buyLink.scrollTo();
        buyLink.hover();
        buyLink.click();
        return new BuyPage(driver);
    }

    public SellPage openSellPage() {
        sellLink.scrollTo();
        sellLink.hover();
        sellLink.click();
        return new SellPage(driver);
    }

    @Override
    public CollectiblesPage openCollectiblesPage() {
        collectiblesLink.scrollTo();
        collectiblesLink.hover();
        collectiblesLink.click();
        return new CollectiblesPage(driver);
    }
    public SignInPage signIn() {
        signInLink.hover();
        signInLink.click();
        return new SignInPage(driver);
    }

}

