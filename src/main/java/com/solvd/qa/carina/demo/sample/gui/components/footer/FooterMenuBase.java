package com.solvd.qa.carina.demo.sample.gui.components.footer;

import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.solvd.qa.carina.demo.sample.gui.pages.common.HomePageBase;
import com.solvd.qa.carina.demo.sample.gui.pages.common.NewsPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public abstract class FooterMenuBase extends AbstractUIObject {

    public FooterMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public FooterMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract NewsPageBase openNewsPage();
}
