package com.solvd.qa.carina.demo.sample.pages.android;

import org.openqa.selenium.WebDriver;

import com.solvd.qa.carina.demo.sample.pages.common.MapsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    public MapsPage(WebDriver driver) {
        super(driver);
    }

}
