package Tests;

import Pages.DeleteCustomerPage;
import Pages.EditCustomerPage;
import Pages.HomePage;
import Utilities.HelperFunc;
import io.cucumber.java.eo.Do;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteCustomers extends BaseTest{
    DeleteCustomerPage Dob;
    EditCustomerPage Eob;
    HomePage Hob;
    HelperFunc HFob;


    @Test(priority = 0)
    public void GoTo_Delete_Customer()
    {
        Eob = new EditCustomerPage(driver);
        Eob.DeleteButton.click();
    }

    @Test(dataProvider = "ReadID",priority = 1)
    public void Delete_Customers(String ID) throws InterruptedException {
        Thread.sleep(3000);
        Dob = new DeleteCustomerPage(driver);
        Dob.CustID.sendKeys(ID);
        Dob.Submit.click();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }


    @DataProvider
    public Object[][] ReadID() throws IOException, IOException {
        Hob = new HomePage(driver);
        HFob = new HelperFunc(driver);
        return HFob.ReadData(Hob.FileName,Hob.SheetName_Customer_IDS);
    }
}
