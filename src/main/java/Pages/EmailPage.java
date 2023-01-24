package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends BasePage {
    public EmailPage(WebDriver driver) {
        super(driver);
    }
    public String FileName = "Data/Credintials.xlsx";
    public String SheetName_Valid_Credintials = "Sheet1";
    public String SheetName_Email = "Sheet2";
    public String EmailPageURL = "https://demo.guru99.com/";
    @FindBy(name = "emailid")
    public WebElement EmailField;
    @FindBy(name = "btnLogin")
    public WebElement SubmitButton;
    @FindBy(xpath = "/html/body/table/tbody/tr[4]/td[2]")
    public WebElement UserID;
    @FindBy(xpath = "/html/body/table/tbody/tr[5]/td[2]")
    public WebElement Password;


}
