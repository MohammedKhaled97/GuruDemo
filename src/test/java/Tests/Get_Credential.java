package Tests;
import Pages.EmailPage;
import Pages.LoginPage;
import Utilities.HelperFunc;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class Get_Credential extends BaseTest {
    LoginPage Lob ;
    EmailPage Eob;
    HelperFunc Hob;

    @Test(priority = 0)
    public void Click_On_Here()  {
        Lob = new LoginPage(driver);
        Eob = new EmailPage(driver);
        Lob.HereButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), Eob.EmailPageURL);
    }

    @Test(dataProvider = "ReadEmail",priority = 1)
    public void Enter_Email(String Email)   {
        Eob = new EmailPage(driver);
        Hob = new HelperFunc(driver);
        Eob.EmailField.sendKeys(Email);
        Eob.SubmitButton.click();
    }

    @Test(priority = 2)
    public void Get_UserName_Password() throws IOException{
        Eob = new EmailPage(driver);
        Hob = new HelperFunc(driver);
        String UserName = Eob.UserID.getText();
        String Password = Eob.Password.getText();
        Hob.WriteDataToSheet(Eob.FileName,Eob.SheetName_Valid_Credintials,UserName,Password);
    }

    @DataProvider
    public Object[][] ReadEmail() throws IOException {
        Hob = new HelperFunc(driver);
        return Hob.ReadData(Eob.FileName,Eob.SheetName_Email);
    }
}
