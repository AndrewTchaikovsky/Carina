package com.solvd.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class BuyPageBase extends AbstractPage {
    protected BuyPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getBuyLinks();

    public abstract List<String> getContainerLinks(String containerName);
}
