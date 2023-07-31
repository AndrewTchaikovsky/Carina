package com.solvd.qa.carina.demo.gui.pages.desktop;

import java.lang.invoke.MethodHandles;
import java.util.List;


import com.solvd.qa.carina.demo.gui.components.SearchItem;
import com.solvd.qa.carina.demo.gui.components.footer.FooterMenuDesktop;
import com.solvd.qa.carina.demo.gui.pages.common.HomePageGeneral;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageGeneral.class)
public class HomePageDesktop extends HomePageGeneral {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "vlGlobalFooter")
    private FooterMenuDesktop footerMenu;

    @FindBy(className = "vl-flyout-nav__container")
    private List<ExtendedWebElement> navigator;

    @FindBy(id = "gh-btn")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//input[@id='gh-ac']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private ExtendedWebElement allCategories;

    @FindBy(xpath = "//div[@class='s-item__info clearfix']")
    private List<SearchItem> searchItems;

    public HomePageDesktop(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchBar);

    }

    @Override
    public FooterMenuDesktop getFooterMenu() {
        return footerMenu;
    }

    @Override
    public List<SearchItem> search(String searchInput) {
        searchBar.format("submit").click();
        searchBar.isElementPresent(3);
        searchBar.type(searchInput);
        searchButton.click(3);
        return searchItems;
    }


}
