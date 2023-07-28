package com.solvd.qa.carina.demo.web;

import java.lang.invoke.MethodHandles;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePageWeb extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected HomePageWeb(WebDriver driver) {
        super(driver);
    }
}
