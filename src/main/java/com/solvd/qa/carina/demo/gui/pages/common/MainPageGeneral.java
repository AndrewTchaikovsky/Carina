package com.solvd.qa.carina.demo.gui.pages.common;

import com.solvd.qa.carina.demo.gui.pages.android.PhonePageAndroid;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainPageGeneral extends AbstractPage {
    protected MainPageGeneral(WebDriver driver) {
        super(driver);
    }

    public abstract PhonePageGeneral openPhone();
}
