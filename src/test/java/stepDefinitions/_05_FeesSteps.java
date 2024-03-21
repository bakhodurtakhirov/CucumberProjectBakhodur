package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.Dialog;
import pages.Menu;

import java.util.List;

public class _05_FeesSteps {
    Dialog dialog = new Dialog();
    Menu menu = new Menu();
    
    @And("Navigate to Fees Page")
    public void navigateToFeesPage() {
        menu.myClick(menu.setUpButton);
        menu.myClick(menu.parametersButton);
        menu.myClick(menu.feesButton);
    }
    
    @And("Fill The form out")
    public void fillTheFormOut(DataTable dataTable) {
        List<String> feesData = dataTable.asList(String.class);
        
        dialog.mySendKeys(dialog.formNameInput, feesData.get(0));
        dialog.mySendKeys(dialog.formCodeInput, feesData.get(1));
        dialog.mySendKeys(dialog.integrationCode, feesData.get(2));
        dialog.priority.clear(); //to clear default value
        dialog.mySendKeys(dialog.priority, feesData.get(3));
    }
    
    @When("Click on Save and Exit Button")
    public void clickOnSaveAndExitButton() {
        dialog.saveAndExit.click(); //need to use ordinary click first because button is always disabled, then we can use custom click with waitUntilClickable
        dialog.myClick(dialog.saveAndExit);
    }
    
    @And("Search for the Fee")
    public void searchForTheFee(DataTable dataTable) {
        List<String> feeData = dataTable.asList(String.class);
        
        dialog.mySendKeys(dialog.searchNameInput, feeData.get(0));
        dialog.mySendKeys(dialog.searchCodeInput, feeData.get(1));
        dialog.mySendKeys(dialog.searchPriorityInput, feeData.get(2));
        dialog.myClick(dialog.searchButton);
    }
}
