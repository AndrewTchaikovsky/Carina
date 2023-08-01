package com.solvd.qa.carina.demo.gui.pages.android;

import com.solvd.qa.carina.demo.gui.pages.common.MainPageGeneral;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageGeneral.class)
public class MainPageAndroid extends MainPageGeneral {
    @ExtendedFindBy(accessibilityId = "Phone")
    private ExtendedWebElement phoneButton;

    public MainPageAndroid(WebDriver driver) {
        super(driver);
    }

    public PhonePageAndroid openPhone() {
        phoneButton.click();
        return new PhonePageAndroid(driver);
    }
}
