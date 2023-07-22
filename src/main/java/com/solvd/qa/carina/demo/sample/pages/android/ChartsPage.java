package com.solvd.qa.carina.demo.sample.pages.android;

import org.openqa.selenium.WebDriver;

import com.solvd.qa.carina.demo.sample.pages.common.ChartsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

}
