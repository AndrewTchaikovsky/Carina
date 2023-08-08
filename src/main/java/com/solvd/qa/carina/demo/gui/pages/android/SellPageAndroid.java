package com.solvd.qa.carina.demo.gui.pages.android;

import com.solvd.qa.carina.demo.gui.pages.common.SellPageBase;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

public class SellPageAndroid extends SellPageBase {

    public SellPageAndroid(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(listAnItemButton);
        setPageAbsoluteURL("https://www.ebay.com/sl/sell");
    }

    @Override
    public HomePageAndroid clickLogo() {
        eBayLogo.click();
        return new HomePageAndroid(driver);
    }
}
