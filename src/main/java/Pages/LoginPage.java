package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public String LoginPageURL = "https://www.demo.guru99.com/V4/index.php";
    public String LogoutMessage_Alert = "You Have Succesfully Logged Out!!";
    @FindBy(linkText = "here")
    public WebElement HereButton;
    @FindBy(xpath = "//input[@name='uid']")
    public WebElement UserID;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement Pass;
    @FindBy(xpath = "//input[@name='btnLogin']")
    public WebElement LoginButton;

    @FindBy(id = "message23")
    public WebElement EmptyUserName_Text;

    @FindBy(id = "message18")
    public WebElement EmptyPass_Text;

    @FindBy(linkText = "New Customer")
    public WebElement NewCustomerButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }


}
