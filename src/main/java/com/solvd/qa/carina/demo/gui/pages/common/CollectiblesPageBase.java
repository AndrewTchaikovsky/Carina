package com.solvd.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CollectiblesPageBase extends AbstractPage {
    protected CollectiblesPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract List<String> getPopularCategoriesLinks();
}
