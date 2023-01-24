package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewCustomerPage;
import Utilities.HelperFunc;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Adding_NewCustomer extends BaseTest{
    NewCustomerPage Ncob ;
    HelperFunc HFob;
    HomePage Hob;

    @Test(priority = 0)
    public void Click_New_Customer()  {
        Lob = new LoginPage(driver);
        Ncob = new NewCustomerPage(driver);
        Lob.NewCustomerButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),Ncob.NewCustomerPage_URL);
    }


    @Test(priority = 1)
    public void Fill_All_Data() throws InterruptedException {

        Ncob = new NewCustomerPage(driver);
        Ncob.Fill_All_Data();
        Assert.assertEquals(Ncob.Successful_Regesteration.getText(),Ncob.ExpectedAdding);

    }

    @Test(priority = 2)
    public void Get_Customer_ID() throws IOException {
        Ncob = new NewCustomerPage(driver);
        Hob = new HomePage(driver);
        String CustomerID= Ncob.Customer_ID.getText();
        System.out.println(CustomerID);
        HFob = new HelperFunc(driver);
        HFob.WriteIDToSheet(Hob.FileName,Hob.SheetName_Customer_IDS,CustomerID);
    }

    @Test(priority = 3)
    public void Go_toEdit_Customer() throws IOException {
        Ncob = new NewCustomerPage(driver);
        Ncob.Edit_Customer.click();
    }




//    @Test(priority = 3)
//    public void RemoveDataEntered()
//    {
//        Ncob = new NewCustomerPage(driver);
//        Ncob.ResetButton();
//    }

}
