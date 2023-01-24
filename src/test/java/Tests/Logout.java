package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Logout extends BaseTest {

    HomePage Hob;
    LoginPage Lob;

    @Test
    public void Logout() {
        Hob = new HomePage(driver);
        Lob = new LoginPage(driver);
        Hob.LogoutButton.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        String Actual_Alert_Massage = driver.switchTo().alert().getText();
        Assert.assertEquals(Actual_Alert_Massage, Lob.LogoutMessage_Alert);

        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.getCurrentUrl(), Lob.LoginPageURL);
    }
}
