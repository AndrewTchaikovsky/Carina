package com.solvd.qa.carina.demo.gui.components.navigator;

import com.solvd.qa.carina.demo.gui.pages.common.CollectiblesPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class NavigatorMenuBase extends AbstractUIObject {

    public NavigatorMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public abstract CollectiblesPageBase openCollectiblesPage();
}
