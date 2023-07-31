package com.solvd.qa.carina.demo.sample.gui.components.footer;

import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.solvd.qa.carina.demo.sample.gui.pages.common.HomePageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.qa.carina.demo.sample.gui.pages.desktop.CompareModelsPage;
import com.solvd.qa.carina.demo.sample.gui.pages.desktop.HomePage;
import com.solvd.qa.carina.demo.sample.gui.pages.desktop.NewsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class FooterMenu extends FooterMenuBase {

    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = ".//a[contains(text(),'Compare')]")
    private ExtendedWebElement compareLink;

    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
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
