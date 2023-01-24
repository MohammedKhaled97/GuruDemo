package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerPage extends BasePage{
    public EditCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "cusid")
    public WebElement AccountNumb;

    @FindBy(name = "AccSubmit")
    public WebElement Submit;

    @FindBy(name = "city")
    public WebElement ECity;

    @FindBy(name = "sub")
    public WebElement ESubmit;

    @FindBy(linkText = "Delete Account")
    public WebElement DeleteButton;

}
