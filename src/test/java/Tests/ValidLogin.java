package Tests;

import Pages.EmailPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewCustomerPage;
import Utilities.HelperFunc;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidLogin extends BaseTest {

    HelperFunc Hob;
    EmailPage Eob;
    LoginPage Lob;
    HomePage HBob;



    @Test(dataProvider = "ReadValidCredentials")
    public void Valid_Login(String UserID, String Pass) {
        Lob = new LoginPage(driver);
        HBob = new HomePage(driver);
        driver.get(Lob.LoginPageURL);
        Lob.UserID.sendKeys(UserID);
        Lob.Pass.sendKeys(Pass);
        Lob.LoginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),HBob.HomePageURL);
    }

    @DataProvider
    public Object[][] ReadValidCredentials() throws IOException {
        Hob = new HelperFunc(driver);
        Eob = new EmailPage(driver);
        return Hob.ReadData(Eob.FileName, Eob.SheetName_Valid_Credintials);
    }
}
