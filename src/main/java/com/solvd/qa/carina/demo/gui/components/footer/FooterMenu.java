package com.solvd.qa.carina.demo.gui.components.footer;

import com.solvd.qa.carina.demo.sample.gui.components.footer.FooterMenuBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.qa.carina.demo.sample.gui.pages.desktop.CompareModelsPage;
import com.solvd.qa.carina.demo.sample.gui.pages.desktop.HomePage;
import com.solvd.qa.carina.demo.sample.gui.pages.desktop.NewsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class FooterMenu extends FooterMenuBase {

    @FindBy(xpath = "//div[@id='gf-BIG']//td[1]/h3/a")
    private ExtendedWebElement buyLink;

    @FindBy(xpath = "//div[@id='gf-BIG']//td[2]/h3[1]/a")
    private ExtendedWebElement sellLink;

    @FindBy(linkText = "eBay companies")
    private ExtendedWebElement ebayCompaniesLink;

    @FindBy(xpath = "//div[@id='gf-BIG']//td[4]/h3/a")
    private ExtendedWebElement aboutEbayLink;

    @FindBy(xpath = "//div[@id='gf-BIG']//td[5]/h3[1]/a")
    private ExtendedWebElement helpAndContactLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    @Override
    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public CompareModelsPage openComparePage() {
        compareLink.scrollTo();
        compareLink.hover();
        compareLink.click();
        return new CompareModelsPage(driver);
    }

    public NewsPage openNewsPage() {
        newsLink.scrollTo();
        newsLink.hover();
        newsLink.click();
        return new NewsPage(driver);
    }
}

