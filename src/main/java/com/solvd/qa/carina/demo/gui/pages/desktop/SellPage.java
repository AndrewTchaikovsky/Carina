package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.SellPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SellPageBase.class)
public class SellPage extends SellPageBase {
    @FindBy(xpath = "//section[@id='image_banner_1']//a")
    private ExtendedWebElement listAnItemButton;

    public SellPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(listAnItemButton);
        setPageAbsoluteURL("https://www.ebay.com/sl/sell");
    }

    public HomePageDesktop clickLogo() {
        eBayLogo.hover();
        eBayLogo.click();
        return new HomePageDesktop(driver);
    }
}
