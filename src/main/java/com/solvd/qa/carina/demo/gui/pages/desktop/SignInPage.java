package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.SignInPageAbstract;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends SignInPageAbstract {
    @FindBy(xpath = "//input[@id = 'userid']")
    private ExtendedWebElement emailTextBox;
    @FindBy(xpath = "//button[@id = 'signin-continue-btn']")
    private ExtendedWebElement continueButton;
    @FindBy(id = "signin-error-msg")
    private ExtendedWebElement errorText;
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void setEmail() {
        emailTextBox.type("andy.sky@inbox.ru");
    }

    @Override
    public void clickOnContinueButton() {
        continueButton.click();
    }

    @Override
    public String getErrorText() {
        return errorText.getText();
    }
}
