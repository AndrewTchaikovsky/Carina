package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.components.footer.FooterMenuDesktop;
import com.solvd.qa.carina.demo.gui.pages.common.HomePageAbstract;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageAbstract.class)
public class HomePageDesktop extends HomePageAbstract {

    @FindBy(id = "vlGlobalFooter")
    private FooterMenuDesktop footerMenu;

    @FindBy(className = "vl-flyout-nav__container")
    private ExtendedWebElement navigator;

    @FindBy(id = "gh-btn")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//input[@id='gh-ac']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private ExtendedWebElement allCategories;

    public HomePageDesktop(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(navigator);
    }

    @Override
    public FooterMenuDesktop getFooterMenu() {
        return footerMenu;
    }


    public SearchPage openSearchPage(String searchInput) {
        searchBar.format("submit").click();
        searchBar.isElementPresent(3);
        searchBar.type(searchInput);
        searchButton.click(3);
        return new SearchPage(driver);
    }

}