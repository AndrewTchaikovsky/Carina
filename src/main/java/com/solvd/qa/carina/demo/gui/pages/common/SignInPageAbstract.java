package com.solvd.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageAbstract extends AbstractPage {
    protected SignInPageAbstract(WebDriver driver) {
        super(driver);
    }

    public abstract void setEmail();

    public abstract void clickOnContinueButton();

    public abstract String getErrorText();
}
