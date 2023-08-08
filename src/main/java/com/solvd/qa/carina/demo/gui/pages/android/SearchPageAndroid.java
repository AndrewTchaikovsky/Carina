package com.solvd.qa.carina.demo.gui.pages.android;

import com.solvd.qa.carina.demo.gui.pages.common.HomePageAbstract;
import com.solvd.qa.carina.demo.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPageAndroid extends SearchPageBase {
    protected SearchPageAndroid(WebDriver driver) {
        super(driver);
    }
}
