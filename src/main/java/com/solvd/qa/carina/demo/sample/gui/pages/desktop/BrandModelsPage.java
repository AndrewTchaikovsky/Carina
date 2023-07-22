package com.solvd.qa.carina.demo.sample.gui.pages.desktop;

import java.util.List;

import com.solvd.qa.carina.demo.sample.gui.components.ModelItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.qa.carina.demo.sample.gui.pages.common.BrandModelsPageBase;
import com.solvd.qa.carina.demo.sample.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BrandModelsPageBase.class)
public class BrandModelsPage extends BrandModelsPageBase {

    @FindBy(xpath = "//div[@id='review-body']//li")
    private List<ModelItem> models;

    public BrandModelsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ModelInfoPageBase selectModel(String modelName) {
        for (ModelItem model : models) {
            if (model.readModel().equalsIgnoreCase(modelName)) {
                return model.openModelPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + modelName);
    }

    public List<ModelItem> getModels() {
        return models;
    }

}
