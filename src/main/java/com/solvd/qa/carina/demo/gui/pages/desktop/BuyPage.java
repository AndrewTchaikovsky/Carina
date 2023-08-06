package com.solvd.qa.carina.demo.gui.pages.desktop;

import com.solvd.qa.carina.demo.gui.pages.common.BuyPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BuyPageBase.class)
public class BuyPage extends BuyPageBase {

    @FindBy(xpath = "//h1[text()='All Categories']/following-sibling::ul/li/a")
    private List<ExtendedWebElement> links;
    @FindBy(xpath = "//div[@class = 'l1s-container']//h3[a[text() = '%s']]/following-sibling::ul/li")
    private ExtendedWebElement containerLink;

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
    public List<String> getContainerLinks(String containerName) {
        return containerLink.formatToList(containerName).stream()
                .map(e -> e.getText())
                .map(e -> e.split("\n")[0])
                .collect(Collectors.toList());
    }

    static List<String> autoPartsAndAccessoriesLinks = Arrays.asList("Car & Truck Parts & Accessories", "Motorcycle & Scooter Parts & Accessories", "Performance & Racing Parts", "In-Car Technology, GPS & Security Devices", "Boat Parts", "Vehicle Repair Manuals & Literature", "View all in Auto Parts & Accessories");
    static List<String> otherVehiclesAndTrailersLinks = Arrays.asList("RVs & Campers", "Commercial Trucks", "Buses", "Vehicle Trailers", "Aircraft", "Golf Carts", "View all in Other Vehicles & Trailers");
    static List<String> motorcyclesLinks = Arrays.asList("Harley-Davidson Motorcycles", "Honda Motorcycles");
    @DataProvider(name = "containerData")
    public static Object[][] containerData() {
        return new Object[][]{
                {"Auto Parts & Accessories", autoPartsAndAccessoriesLinks},
                {"Other Vehicles & Trailers", otherVehiclesAndTrailersLinks},
                {"Motorcycles", motorcyclesLinks}
        };
    }

}
