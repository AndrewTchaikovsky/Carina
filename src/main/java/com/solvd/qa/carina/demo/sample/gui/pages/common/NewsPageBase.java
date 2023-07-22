package com.solvd.qa.carina.demo.sample.gui.pages.common;

import java.util.List;

import com.solvd.qa.carina.demo.sample.gui.components.NewsItem;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class NewsPageBase extends AbstractPage {

    public NewsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<NewsItem> searchNews(String searchInput);

}
