package Tests;

import Pages.EditCustomerPage;
import Pages.HomePage;
import Utilities.HelperFunc;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Edit_Customer extends BaseTest{
    EditCustomerPage Eob;
    HomePage Hob;
    HelperFunc HFob;

    @Test(dataProvider = "ReadID",priority = 0)
    public void EditCustomers(String ID)
    {
        Eob = new EditCustomerPage(driver);
        Eob.AccountNumb.sendKeys(ID);
        Eob.Submit.click();
        Eob.ECity.sendKeys("EditedCity");
        Eob.ESubmit.click();
        String Actual_Text =driver.switchTo().alert().getText();
        Assert.assertTrue(!(Actual_Text.equals("Edited Successfully")));
        driver.switchTo().alert().accept();

    }




    @DataProvider
    public Object[][] ReadID() throws IOException, IOException {
        Hob = new HomePage(driver);
        HFob = new HelperFunc(driver);
        return HFob.ReadData(Hob.FileName,Hob.SheetName_Customer_IDS);
    }
}
