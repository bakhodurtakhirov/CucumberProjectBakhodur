package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.Dialog;
import pages.Menu;
import utilities.DriverClass;
import utilities.MyMethods;

import java.util.List;

public class _07_EntranseExamSteps extends MyMethods {
    
    Menu menu = new Menu();
    Dialog dialog = new Dialog();
    
    @And("Navigate to Entrance Exams page")
    public void navigateToEntranceExamsPage() {
        menu.myClick(menu.entranceExamsButton);
        menu.myClick(menu.entranceExamsSetupButton);
        menu.myClick(menu.innerEntranceExams);
    }
    
    @And("Fill the Create Exam form")
    public void fillTheCreateExamForm(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        dialog.waitUntilVisible(dialog.description);
        dialog.mySendKeys(dialog.searchNameInput, dataList.get(0));
        dialog.myClick(dialog.academicPeriodDropDown);
        dialog.myClick(dialog.academicPeriodOption);
        dialog.myClick(dialog.gradeLevelDropDown);
        dialog.myClick(dialog.gradeLevelOption);
    }
    
    @And("Add a Description")
    public void addADescription(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        dialog.myClick(dialog.description);
        dialog.waitUntilVisible(dialog.descriptionAndNotesIFrame);
        DriverClass.getDriver().switchTo().frame(dialog.descriptionAndNotesIFrame);
        dialog.mySendKeys(dialog.descriptionAndNotesTextArea, dataList.get(0));
        DriverClass.getDriver().switchTo().defaultContent();
    }
    
    @And("Add a Note")
    public void addANote(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);
        dialog.myClick(dialog.notes);
        dialog.waitUntilVisible(dialog.descriptionAndNotesIFrame);
        DriverClass.getDriver().switchTo().frame(dialog.descriptionAndNotesIFrame);
        dialog.mySendKeys(dialog.descriptionAndNotesTextArea, dataList.get(0));
        DriverClass.getDriver().switchTo().defaultContent();
    }
    
    @And("Search for the Exam")
    public void searchForTheExam(DataTable dataTable) {
        List<String> feeData = dataTable.asList(String.class);
        dialog.mySendKeys(dialog.searchNameInput, feeData.get(0));
        dialog.myClick(dialog.searchButton);
    }
    
    @And("Search for the Exam Two")
    public void searchForTheExamTwo(DataTable dataTable) {
        List<String> feeData = dataTable.asList(String.class);
        dialog.mySendKeys(dialog.searchNameInput, feeData.get(0));
        dialog.myClick(dialog.gradeLevelDropDown2);
        dialog.myClick(dialog.gradeLevelOption);
        dialog.myClick(dialog.searchButton);
    }
}
