package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Dialog;
import pages.Menu;
import utilities.DBUtilities;

import java.util.List;

public class _08_StatesDBTestSteps {
    Menu menu = new Menu();
    Dialog dialog = new Dialog();
    
    @And("Navigate to States Page")
    public void navigateToStatesPage() {
        menu.myClick(menu.setUpButton);
        menu.myClick(menu.parametersButton);
        menu.myClick(menu.statesButton);
    }
    
    List<List<String>> data; //Global variable
    
    @When("Send {string} as query")
    public void sendAsQuery(String query) {
        data = DBUtilities.getData(query);
    }
    
    @Then("Check if the results from UI are in the database")
    public void checkIfTheResultsFromUIAreInTheDatabase() {
        List<WebElement> statesUI = dialog.statesList;
        
        for (int i = 0; i < statesUI.size(); i++) {
            int count = 0;
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).contains(statesUI.get(i).getText())) {
                    System.out.println(statesUI.get(i).getText());
                    count++;
                }
            }
            Assert.assertEquals(count, 1);
        }
    }
}