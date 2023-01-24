package Tests;

import Pages.EmailPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.HelperFunc;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class InvalidLogin extends BaseTest {

    HelperFunc Hob;
    HomePage Hbob;
    Actions action;
    LoginPage Lob;

    @Test(dataProvider = "ReadInValidCredentials", priority = 0)
    public void InValid_Credentials(String UserID, String Pass) {
        Lob = new LoginPage(driver);
        Hbob = new HomePage(driver);
        driver.get(Lob.LoginPageURL);
        Lob.UserID.sendKeys(UserID);
        Lob.Pass.sendKeys(Pass);
        Lob.LoginButton.submit();

        String Actual_Alert_Massage = driver.switchTo().alert().getText();
        Assert.assertEquals(Actual_Alert_Massage, Hbob.Expected_Alert_Massege);

        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.getCurrentUrl(), Lob.LoginPageURL);
    }

    @Test(dataProvider = "ReadEmptyCredentials", priority = 1)
    public void Empty_Credentials(String UserID, String Pass)  {
        Lob = new LoginPage(driver);
        Hbob = new HomePage(driver);


        action = new Actions(driver);

        Lob.UserID.clear();
        Lob.Pass.clear();

        Lob.UserID.sendKeys(UserID);

        Lob.Pass.sendKeys(Pass);

        if (UserID.equals("") && !(Pass.equals(""))) {
            Assert.assertTrue(Lob.EmptyUserName_Text.isDisplayed());
        } else if (!(UserID.equals("")) && Pass.equals("")) {
            action.keyDown(Keys.TAB).perform();
            Assert.assertTrue(Lob.EmptyPass_Text.isDisplayed());
        } else {
            action.keyDown(Keys.TAB).perform();
            Assert.assertTrue(Lob.EmptyUserName_Text.isDisplayed());
            Assert.assertTrue(Lob.EmptyPass_Text.isDisplayed());
        }
        Lob.LoginButton.submit();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        String Actual_Alert_Massage = driver.switchTo().alert().getText();
        Assert.assertEquals(Actual_Alert_Massage, Hbob.Expected_Alert_Massege);

        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getCurrentUrl(), Lob.LoginPageURL);

    }

//    @Test(dataProvider = "ReadValidCredentials",priority = 2)
//    public void Valid_Login(String UserID, String Pass) {
//        Lob = new LoginPage(driver);
//        Hbob = new HomePage(driver);
//
//        Lob.UserID.sendKeys(UserID);
//        Lob.Pass.sendKeys(Pass);
//        Lob.LoginButton.click();
//    }

    @DataProvider
    public Object[][] ReadInValidCredentials() throws IOException {
        Hob = new HelperFunc(driver);
        Hbob = new HomePage(driver);
        return Hob.ReadData(Hbob.FileName, Hbob.SheetName_InvalidCredentials);
    }

    @DataProvider
    public Object[][] ReadEmptyCredentials() throws IOException {
        Hob = new HelperFunc(driver);
        Hbob = new HomePage(driver);
        return Hob.ReadData(Hbob.FileName, Hbob.SheetName_EmptyCredentials);
    }
//
//    @DataProvider
//    public Object[][] ReadValidCredentials() throws IOException {
//        Hob = new HelperFunc(driver);
//        Eob = new EmailPage(driver);
//        return Hob.ReadData(Eob.FileName, Eob.SheetName_Valid_Credintials);
//    }
}
