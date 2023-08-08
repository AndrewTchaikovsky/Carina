package com.solvd.qa.carina.demo.gui.components;

import com.solvd.qa.carina.demo.gui.pages.android.CollectiblesPageAndroid;
import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.SellPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class EbayPageAndroid extends AbstractEbayPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//div[text() = 'Collectibles & Art']")
    private ExtendedWebElement collectiblesLink;
    public EbayPageAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public BuyPageBase openBuyPage() {
        LOGGER.error("The android mobile page does not have a Buy Page link in the footer!");
        return null;
    }

    @Override
    public SellPageBase openSellPage() {
        LOGGER.error("The android mobile page does not have a Sell Page link in the footer!");
        return null;
    }

    @Override
    public CollectiblesPageAndroid openCollectiblesPage() {
        collectiblesLink.click();
        return new CollectiblesPageAndroid(driver);
    }

}
