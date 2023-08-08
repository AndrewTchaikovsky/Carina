package com.solvd.qa.carina.demo.gui.pages.android;

import com.solvd.qa.carina.demo.gui.pages.common.CollectiblesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CollectiblesPageBase.class)
public class CollectiblesPageAndroid extends CollectiblesPageBase {
    @FindBy(xpath = "//div[@class = 'b-visualnav__title']")
    private List<ExtendedWebElement> popularCategoriesLinks;

    @FindBy(xpath = "//div/h1[@class = 'title-banner__title']")
    private ExtendedWebElement titleBanner;

    public CollectiblesPageAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getPopularCategoriesLinks() {
        return popularCategoriesLinks.stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }

}
