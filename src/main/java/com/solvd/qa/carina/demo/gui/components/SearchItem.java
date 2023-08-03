package com.solvd.qa.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchItem extends AbstractUIObject {
    @FindBy(xpath = "./a/div/span")
    public ExtendedWebElement titleLink;

    public SearchItem(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public String readTitle() {
        return titleLink.getText();
    }
}
