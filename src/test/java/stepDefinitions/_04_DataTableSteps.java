package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class _04_DataTableSteps {
    @Given("Go to the website")
    public void goToTheWebsite() {
        System.out.println("Go the the web site");
    }
    
    @And("Fill the form with valid data")
    public void fillTheFormWithValidData(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println(dataList.get(i));
        }
        
    }
    
    @Then("Save the form")
    public void saveTheForm() {
    }
    
    
    @And("Enter valid data")
    public void enterValidData(DataTable dataTable) {
        List<List<String>> dataLists = dataTable.asLists(String.class);
//        for (int i = 0; i < dataLists.size(); i++) {
//            System.out.println(dataLists.get(i).get(0) + " " + dataLists.get(i).get(1));
//        }
        
        for (List<String> row : dataLists) {
            System.out.println(row.get(0) + " " + row.get(1));
        }
    }
}
