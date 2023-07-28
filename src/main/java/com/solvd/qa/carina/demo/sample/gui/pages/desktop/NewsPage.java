package com.solvd.qa.carina.demo.sample.gui.pages.desktop;

import java.util.List;

import com.solvd.qa.carina.demo.sample.gui.components.NewsItem;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.qa.carina.demo.sample.gui.pages.common.NewsPageBase;
import com.zebrunner.carina.webdriver.locator.Context;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = NewsPageBase.class)
public class NewsPage extends NewsPageBase {

    @FindBy(xpath = "//div[@class='search-band']")
    private ExtendedWebElement searchDiv;

    @Context(dependsOn = "searchDiv")
    @FindBy(xpath = ".//input[@type='text']")
    private ExtendedWebElement searchTextField;

    @Context(dependsOn = "searchDiv")
    @FindBy(xpath = ".//input[@type='submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@class='news-item']")
    private List<NewsItem> news;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3");
//        setPageAbsoluteURL("");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchTextField);
    }

    @Override
    public List<NewsItem> searchNews(String q) {
        searchTextField.format("submit").click();
        searchTextField.isElementPresent(3);
        searchTextField.type(q);
        searchButton.click(3);
        return news;
    }

}
