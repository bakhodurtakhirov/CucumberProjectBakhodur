package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverClass;
import utilities.MyMethods;

public class Menu extends MyMethods {
    
    public Menu() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }
    
    @FindBy(xpath = "//span[text()=\"Dashboard \"]")
    public WebElement dashBoardTitle;
    
    @FindBy(xpath = "(//span[text()=\"Setup\"])[1]")
    public WebElement setUpButton;
    
    @FindBy(xpath = "(//span[text()=\"Parameters\"])[1]")
    public WebElement parametersButton;
    
    @FindBy(xpath = "(//span[text()=\"Countries\"])[1]")
    public WebElement countriesButton;
    @FindBy(xpath = "(//span[text()=\"Citizenships\"])[1]")
    public WebElement citizenshipsButton;
    
    @FindBy(xpath = "//span[text()=\"Fees\"]")
    public WebElement feesButton;
    
    @FindBy(xpath = "(//span[text()=\"Entrance Exams\"])[1]")
    public WebElement entranceExamsButton;
    
    @FindBy(xpath = "(//span[text()=\"Setup\"])[2]")
    public WebElement entranceExamsSetupButton;
    
    @FindBy(xpath = "(//span[text()=\"Entrance Exams\"])[2]")
    public WebElement innerEntranceExams;
    
    @FindBy(xpath = "(//span[text()='States'])[1]")
    public WebElement statesButton;
}
