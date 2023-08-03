package com.solvd.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainPageAbstract extends AbstractPage {
    protected MainPageAbstract(WebDriver driver) {
        super(driver);
    }

    public abstract PhonePageAbstract openPhone();
}
