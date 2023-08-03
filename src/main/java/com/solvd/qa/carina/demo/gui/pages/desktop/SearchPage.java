package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.components.SearchItem;
import com.solvd.qa.carina.demo.gui.pages.common.SearchPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends SearchPageBase {
    @FindBy(xpath = "//div[@class='s-item__info clearfix']")
    private List<SearchItem> searchItems;

    protected SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<SearchItem> searchByName() {
        return searchItems;
    }
}
