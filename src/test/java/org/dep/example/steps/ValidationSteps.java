package org.dep.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.dep.example.config.PageObjectManager;

import java.util.List;
import java.util.Map;

public class ValidationSteps {
    @Given("the user is on my dummy website")
    public void theUserIsOnMyDummyWebsite() {
        PageObjectManager.getDefectlessDummyPage().open();
    }

    @When("the user types in {string} into input field")
    public void theUserTypesInIntoInputField(String inputValue, DataTable table) {
//        PageObjectManager.getDefectlessDummyPage().typeIntoInputField(inputValue);
        for (Map<Object, Object> map : table.asMaps(String.class, String.class)) {
            PageObjectManager.getDefectlessDummyPage().checkMap(map);
            System.out.println("XXX");
        }
    }


    @When("user types in values into input field")
    public void userTypesInValuesIntoInputField(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            String value = list.get(i).get("value");
            String expectedAppearingValue = list.get(i).get("expectedAppearingValue");
            PageObjectManager.getDefectlessDummyPage().typeIntoInputFieldAndValidate(value, expectedAppearingValue);
        }
    }

    @Then("validate that {string} characters can be typed into input field")
    public void validateThatCharactersCanBeTypedIntoInputField(String expectedMaxCharNumber) {
        PageObjectManager.getDefectlessDummyPage().validateThatCharactersCanBeTypedIntoInputField(expectedMaxCharNumber);
    }
}
