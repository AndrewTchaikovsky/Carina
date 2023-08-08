package com.solvd.qa.carina.demo.gui.components;

import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.CollectiblesPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.SellPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractEbayPage extends AbstractUIObject {
    @FindBy(id = "vlGlobalFooter")
    public EbayPageDesktop footerMenu;
    public AbstractEbayPage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public abstract CollectiblesPageBase openCollectiblesPage();
    public abstract BuyPageBase openBuyPage();
    public abstract SellPageBase openSellPage();
}
