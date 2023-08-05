package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BuyPageBase.class)
public class BuyPage extends BuyPageBase {

    @FindBy(xpath = "//h1[text()='All Categories']/following-sibling::ul/li/a")
    private List<ExtendedWebElement> links;
    @FindBy(xpath = "//div[@class = 'l1s-container']//h3[a[text() = '%s']]/following-sibling::ul/li")
    private List<ExtendedWebElement> containerLinks;

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

    @Override
    public List<String> getContainerLinks() {
        return containerLinks.stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }

    @DataProvider(name = "categoryNames")
    public static Object[][] categoryNames() {
        return new Object[][]{
                {"Auto Parts & Accessories"},
                {"Other Vehicles & Trailers"},
                {"Motorcycles"},
                {"Automotive Tools & Supplies"},
                {"Powersport Vehicles"},
                {"Boats"},
                {"Men's Clothing, Shoes & Accessories"},
                {"Women's Clothing, Shoes & Accessories"},
                {"Specialty Clothing, Shoes & Accessories"}
        };
    }

}
