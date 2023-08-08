package com.solvd.qa.carina.demo.gui.pages.android;

import com.solvd.qa.carina.demo.gui.pages.common.HomePageAbstract;
import com.solvd.qa.carina.demo.gui.pages.common.SellPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SellPageBase.class)
public class SellPageAndroid extends SellPageBase {

    public SellPageAndroid(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(listAnItemButton);
        setPageAbsoluteURL("https://www.ebay.com/sl/sell");
    }

    @Override
    public HomePageAndroid clickLogo() {
        eBayLogo.click();
        return new HomePageAndroid(driver);
    }
}
