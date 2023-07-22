package com.solvd.qa.carina.demo.sample.gui.pages.common;

import java.util.List;

import com.solvd.qa.carina.demo.sample.gui.components.compare.ModelSpecs;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CompareModelsPageBase extends AbstractPage {

    public CompareModelsPageBase(WebDriver driver) {
        super(driver);
        this.setPageURL("/compare.php3");
    }

    public abstract List<ModelSpecs> compareModels(String... models);

}
