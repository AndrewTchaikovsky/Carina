package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BuyPageBase.class)
public class BuyPage extends BuyPageBase {

    @FindBy(xpath = "//h1[text()='All Categories']/following-sibling::ul/li/a")
    private List<ExtendedWebElement> links;
    @FindBy(xpath = "//h1[text()='All Categories']")
    private ExtendedWebElement allCategories;

    public BuyPage(WebDriver driver) {
        super(driver);
        setPageURL("/n/all-categories");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(allCategories);
    }

    @Override
    public List<String> getBuyLinks() {
        return links.stream()
                .map(e -> e.getText())
                .map(e -> e.split("\n")[0])
                .collect(Collectors.toList());
    }

}
