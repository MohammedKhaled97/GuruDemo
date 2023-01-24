package Pages;

import io.cucumber.java.an.E;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;


public class NewCustomerPage extends BasePage {

    Actions action;

    public static String Year = "2023";
    public static String Month = "10";
    public static String Day = "26";
    public String Customer_Name = "Mohamed";
    public String CAddress = "I Live At Cairo in Egypt I Live At Cairo in Egypt I Live At Cairo in Egypt.";
    public String CCity = "Cairo";
    public String CState = "Obour";
    public String Pin = "123456";
    public String mobile = "01253687777";
    public String email = "mo@gmail.com";
    public String pass = "0000";
    public String ExpectedAdding = "Customer Registered Successfully!!!";
    public String NewCustomerPage_URL = "https://www.demo.guru99.com/V4/manager/addcustomerpage.php";
    @FindBy(name = "name")
    public WebElement CustomerNameField;
    @FindBy(xpath = "//input[@value='m']")
    public WebElement Gender;
    @FindBy(id = "dob")
    public WebElement DateOfBirth;
    @FindBy(name = "addr")
    public WebElement Address;
    @FindBy(name = "city")
    public WebElement City;
    @FindBy(name = "state")
    public WebElement State;
    @FindBy(name = "pinno")
    public WebElement PIN;
    @FindBy(name = "telephoneno")
    public WebElement MobileNumber;
    @FindBy(name = "emailid")
    public WebElement Email;
    @FindBy(name = "password")
    public WebElement Password;
    @FindBy(name = "sub")
    public WebElement Submit;
    @FindBy(name = "res")
    public WebElement Reset;
    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[1]/td/p")
    public WebElement Successful_Regesteration;

    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    public WebElement Customer_ID;

    @FindBy(linkText = "Edit Customer")
    public WebElement Edit_Customer;


    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    public String Unige_Email() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        String RemoveChar = uuidAsString.replaceAll("[-+.^:,]", "");
        StringBuilder sb = new StringBuilder(RemoveChar);
        sb.delete(0, 25);
        String NewUniqueMail = sb + email;
        return NewUniqueMail;
    }

    public void Fill_All_Data() throws InterruptedException {
        action = new Actions(driver);
        CustomerNameField.sendKeys(Customer_Name);
        Gender.click();
        DateOfBirth.sendKeys(Year);
        DateOfBirth.sendKeys(Keys.TAB);
        DateOfBirth.sendKeys(Month);
        DateOfBirth.sendKeys(Day);
        Address.sendKeys(CAddress);
        City.sendKeys(CCity);
        State.sendKeys(CState);
        PIN.sendKeys(Pin);
        MobileNumber.sendKeys(mobile);
        Email.sendKeys(Unige_Email());
        Password.sendKeys(pass);
        Submit.click();
    }

    public void ResetButton()
    {
        Reset.click();
    }

}
