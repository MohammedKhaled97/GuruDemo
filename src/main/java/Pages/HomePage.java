package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public String HomePageURL = "https://www.demo.guru99.com/V4/manager/Managerhomepage.php";

    public String FileName = "Data/Credintials.xlsx";
    public String SheetName_InvalidCredentials = "Sheet3";
    public String SheetName_EmptyCredentials = "Sheet4";
    public String SheetName_Customer_IDS = "Sheet5";
    public String Expected_Alert_Massege ="User or Password is not valid";


    @FindBy(linkText = "Log out")
    public WebElement LogoutButton;
    public HomePage(WebDriver driver) {
        super(driver);
    }
}
