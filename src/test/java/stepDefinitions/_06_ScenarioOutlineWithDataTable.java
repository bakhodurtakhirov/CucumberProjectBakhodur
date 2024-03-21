package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class _06_ScenarioOutlineWithDataTable {
    @Given("Step one")
    public void stepOne(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        System.out.println(dataList.get(0) + " " + dataList.get(1));
    }
    
    @When("Step two")
    public void stepTwo(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        System.out.println(dataList.get(0) + " " + dataList.get(1));
    }
    
    @Then("Step three")
    public void stepThree(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        System.out.println(dataList.get(0) + " " + dataList.get(1));
    }
}
