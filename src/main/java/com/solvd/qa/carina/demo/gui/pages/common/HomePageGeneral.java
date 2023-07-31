package com.solvd.qa.carina.demo.gui.pages.common;

import com.solvd.qa.carina.demo.gui.components.SearchItem;
import com.solvd.qa.carina.demo.gui.components.footer.FooterMenuDesktop;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

import java.util.List;

public abstract class HomePageGeneral extends AbstractPage {

    protected HomePageGeneral(WebDriver driver) {
        super(driver);
    }

    public abstract FooterMenuDesktop getFooterMenu();

    public abstract List<SearchItem> search(String searchInput);

}
