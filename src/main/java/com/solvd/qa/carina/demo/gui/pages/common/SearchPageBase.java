package com.solvd.qa.carina.demo.gui.pages.common;

import com.solvd.qa.carina.demo.gui.components.SearchItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchPageBase extends AbstractPage {

    protected SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<SearchItem> searchByName();
}
