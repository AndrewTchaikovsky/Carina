package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.CollectiblesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CollectiblesPageBase.class)
public class CollectiblesPage extends CollectiblesPageBase {
    @FindBy(xpath = "//div[@class = 'b-visualnav__title']")
    private List<ExtendedWebElement> popularCategoriesLinks;

    @FindBy(xpath = "//div/h1[@class = 'title-banner__title']")
    private ExtendedWebElement titleBanner;
    public CollectiblesPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(titleBanner);
        setPageAbsoluteURL("https://www.ebay.com/b/Collectibles-Art/bn_7000259855");
    }

    public List<String> getPopularCategoriesLinks() {
        return popularCategoriesLinks.stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }
}
