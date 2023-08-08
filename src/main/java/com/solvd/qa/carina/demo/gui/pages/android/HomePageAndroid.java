package com.solvd.qa.carina.demo.gui.pages.android;

import com.solvd.qa.carina.demo.gui.components.EbayPageAndroid;
import com.solvd.qa.carina.demo.gui.pages.common.HomePageAbstract;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageAbstract.class)
public class HomePageAndroid extends HomePageAbstract {
    @FindBy(className = "vl-nav-destinations__container")
    private EbayPageAndroid navigatorMenu;
    @FindBy(xpath = "//input[@id='kw']")
    private ExtendedWebElement searchBar;
    @FindBy(xpath = "//button[@class = 'gh-search__submitbtn']")
    private ExtendedWebElement searchButton;
    public HomePageAndroid(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchButton);
    }
    @Override
    public EbayPageAndroid getNavigatorMenu() {
        return navigatorMenu;
    }
    public SearchPageAndroid openSearchPage(String searchInput) {
        searchBar.format("submit").click();
        searchBar.isElementPresent(3);
        searchBar.type(searchInput);
        searchButton.click(3);
        return new SearchPageAndroid(driver);
    }

}
