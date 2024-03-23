package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

import java.util.List;

public class Dialog extends MyMethods {
    
    public Dialog() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }
    
    @FindBy(css = "input[placeholder=\"Username\"]")
    public WebElement username;
    
    @FindBy(css = "input[placeholder=\"Password\"]")
    public WebElement password;
    
    @FindBy(xpath = "//span[normalize-space()=\"LOGIN\"]")
    public WebElement loginButton;
    
    @FindBy(css = "ms-add-button[class=\"ng-star-inserted\"]")
    public WebElement addButton;
    
    @FindBy(xpath = "(//input[@data-placeholder=\"Name\"])[2]")
    public WebElement formNameInput;
    
    @FindBy(xpath = "(//input[@data-placeholder=\"Code\"])[2]")
    public WebElement formCodeInput;
    
    @FindBy(xpath = "//span[text()=\"Save\"]")
    public WebElement saveButton;
    
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;
    
    @FindBy(xpath = "(//input[@data-placeholder=\"Name\"])[1]")
    public WebElement searchNameInput;
    
//    @FindBy(xpath = "//span[text()=\"Search\"]")
    @FindBy(xpath = "//*[@id=\"container-3\"]//ms-search-button")
    public WebElement searchButton;
    
    @FindBy(css = "ms-edit-button[class=\"ng-star-inserted\"]")
    public WebElement editButton;
    
    @FindBy(css = "ms-delete-button[class=\"ng-star-inserted\"]")
    public WebElement deleteButton;
    
    @FindBy(css = "button[type=\"submit\"]")
    public WebElement deleteConfirmButton;
    
    @FindBy(xpath = "(//input[@data-placeholder=\"Short Name\"])[2]")
    public WebElement citizenshipFormShortNameInput;
    
    @FindBy(css = "input[data-placeholder=\"Integration Code\"]")
    public WebElement integrationCode;
    
    @FindBy(xpath = "(//input[@data-placeholder=\"Priority\"])[2]")
    public WebElement priority;
    
    @FindBy(xpath = "(//ms-save-button[@class='ng-star-inserted'])[2]")
    public WebElement saveAndExit;
    
    @FindBy(xpath = "(//input[@data-placeholder=\"Code\"])[1]")
    public WebElement searchCodeInput;
    
    @FindBy(xpath = "(//input[@data-placeholder=\"Priority\"])[1]")
    public WebElement searchPriorityInput;
    
    @FindBy(css = "mat-select[formcontrolname=\"academicPeriod\"]")
    public WebElement academicPeriodDropDown;
    
    @FindBy(css = "mat-option[role=\"option\"]")
    public WebElement academicPeriodOption;
    
    @FindBy(css = "mat-select[formcontrolname=\"id\"]")
    public WebElement gradeLevelDropDown;
    
    @FindBy(xpath = "//span[text()=\" violet _ i \"]")
    public WebElement gradeLevelOption;
    
    @FindBy(xpath = "//span[text()=\"Description\"]")
    public WebElement description;
    
    @FindBy(css = "iframe[title=\"Rich Text Area\"]")
    public WebElement descriptionAndNotesIFrame;
    
    @FindBy(css = "body[id=\"tinymce\"]>p")
    public WebElement descriptionAndNotesTextArea;
    
    @FindBy(xpath = "//span[text()=\"Notes\"]")
    public WebElement notes;
    
    
    //    @FindBy(css = "mat-select[id=\"mat-select-2\"]")
    @FindBy(xpath = "(//mat-form-field)[3]")
    public WebElement gradeLevelDropDown2;
    
    @FindBy(xpath = "td[contains(@class, 'column-name')]")
    //@FindBy(className = "cdk-column-name")
    public List<WebElement> statesList;
    
    
}
