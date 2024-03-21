package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Dialog;
import pages.Menu;
import utilities.ExcelUtilities;

import java.util.List;

public class _03_CitizenshipSteps {
    
    Dialog dialog = new Dialog();
    Menu menu = new Menu();
    
    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        menu.myClick(menu.setUpButton);
        menu.myClick(menu.parametersButton);
        menu.myClick(menu.citizenshipsButton);
    }
    
    @And("Enter {string} and {string}")
    public void enterAnd(String citizenshipName, String citizenshipShortName) {
        dialog.mySendKeys(dialog.formNameInput, citizenshipName);
        dialog.mySendKeys(dialog.citizenshipFormShortNameInput, citizenshipShortName);
    }
    
    @And("Search for the {string}")
    public void searchForThe(String citizenshipName) {
        dialog.mySendKeys(dialog.searchNameInput, citizenshipName);
        dialog.myClick(dialog.searchButton);
    }
    
    @Then("Create a Citizenship by using ApachePOI")
    public void createACitizenshipByUsingApachePOI() {
        List<List<String>> citizenshipData = ExcelUtilities.getDataFromExcel("C:\\Users\\takhi\\OneDrive\\Desktop\\SDET\\IntelliJ Projects\\ApacheExcel2.xlsx", "testCitizen");
        
        for (int i = 0; i < citizenshipData.size(); i++) {
            dialog.myClick(dialog.addButton);
            dialog.mySendKeys(dialog.formNameInput, citizenshipData.get(i).get(0));
            dialog.mySendKeys(dialog.citizenshipFormShortNameInput, citizenshipData.get(i).get(1));
            dialog.myClick(dialog.saveButton);
            dialog.waitUntilVisible(dialog.successMessage);
            Assert.assertTrue(dialog.successMessage.getText().contains("successfully"));
            dialog.waitUntilInVisible(dialog.successMessage);
        }
    }
}
