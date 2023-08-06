package com.solvd.qa.carina.demo.gui.components.navigator;

import com.solvd.qa.carina.demo.gui.pages.common.CollectiblesPageBase;
import com.solvd.qa.carina.demo.gui.pages.desktop.CollectiblesPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigatorMenu extends NavigatorMenuBase{
    @FindBy(xpath = "//li[@class = 'vl-flyout-nav__js-tab']/a[text()='Collectibles']")
    public ExtendedWebElement collectiblesLink;

    public NavigatorMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CollectiblesPage openCollectiblesPage() {
        collectiblesLink.scrollTo();
        collectiblesLink.hover();
        collectiblesLink.click();
        return new CollectiblesPage(driver);
    }
}
