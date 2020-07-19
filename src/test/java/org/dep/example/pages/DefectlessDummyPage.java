package org.dep.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class DefectlessDummyPage extends AbstractPage  {

    public DefectlessDummyPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("C:\\Users\\matei\\Google Drive\\DEFECTLESS\\How to validate how many characters can by typed into an input field\\index.html");
    }

    public void checkMap(Map<Object, Object> map) {
        System.out.println(map.get("A"));
    }

    public void typeIntoInputFieldAndValidate(String value, String expectedAppearingValue) {
        WebElement inputField = driver.findElement(By.cssSelector("#username"));
        inputField.clear();
        inputField.sendKeys(value);
        String actuallyAppearingValue = driver.findElement(By.cssSelector("#username")).getAttribute("value");
        Assert.assertEquals(actuallyAppearingValue, expectedAppearingValue);
    }

    public void validateThatCharactersCanBeTypedIntoInputField(String expectedMaxCharNumber) {
        String actualMaxCharNumber = driver.findElement(By.cssSelector("#username")).getAttribute("maxlength");
        Assert.assertEquals(actualMaxCharNumber, expectedMaxCharNumber);
    }
}
