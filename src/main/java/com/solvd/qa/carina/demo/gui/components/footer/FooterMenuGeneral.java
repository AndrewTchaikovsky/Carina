package com.solvd.qa.carina.demo.gui.components.footer;

import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.solvd.qa.carina.demo.gui.pages.common.SellPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public abstract class FooterMenuGeneral extends AbstractUIObject {

    public FooterMenuGeneral(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract BuyPageBase openBuyPage();
    public abstract SellPageBase openSellPage();
}
