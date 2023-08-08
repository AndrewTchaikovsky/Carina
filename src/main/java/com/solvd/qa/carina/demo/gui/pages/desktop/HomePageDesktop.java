package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.components.EbayPageDesktop;
import com.solvd.qa.carina.demo.gui.pages.common.HomePageAbstract;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageAbstract.class)
public class HomePageDesktop extends HomePageAbstract {
    @FindBy(className = "vl-flyout-nav__container")
    private EbayPageDesktop navigatorMenu;
    @FindBy(xpath = "//input[@id='gh-ac']")
    private ExtendedWebElement searchBar;
    @FindBy(xpath = "//select[@id='gh-cat']")
    private ExtendedWebElement allCategories;
    @FindBy(id = "gh-btn")
    private ExtendedWebElement searchButton;

    public HomePageDesktop(WebDriver driver) {
        super(driver);
    }
    @Override
    public EbayPageDesktop getNavigatorMenu() {
        return navigatorMenu;
    }
    public SearchPage openSearchPage(String searchInput) {
        searchBar.format("submit").click();
        searchBar.isElementPresent(3);
        searchBar.type(searchInput);
        searchButton.click(3);
        return new SearchPage(driver);
    }

}
