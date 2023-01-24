package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomerPage extends BasePage{

    @FindBy(name = "accountno")
    public WebElement CustID;

    @FindBy(name = "AccSubmit")
    public WebElement Submit;

    public DeleteCustomerPage(WebDriver driver) {
        super(driver);
    }
}
