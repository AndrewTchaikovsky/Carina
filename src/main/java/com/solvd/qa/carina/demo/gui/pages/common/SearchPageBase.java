package com.solvd.qa.carina.demo.gui.pages.common;

import com.solvd.qa.carina.demo.gui.components.SearchItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class SearchPageBase extends AbstractPage {
    @FindBy(xpath = "//div[@class='s-item__info clearfix']")
    private List<SearchItem> searchItems;
    protected SearchPageBase(WebDriver driver) {
        super(driver);
    }
    public List<SearchItem> searchByName() {
        return searchItems;
    }
}
