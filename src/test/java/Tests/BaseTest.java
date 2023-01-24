package Tests;

import Pages.EmailPage;
import Pages.LoginPage;
import Utilities.HelperFunc;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    LoginPage Lob;
    EmailPage Eob;
    HelperFunc HFob;

    @BeforeTest
    @Parameters("browser")
    public void Open_Browser(@Optional("Chrome") String browser) {
        Lob = new LoginPage(driver);
        Eob = new EmailPage(driver);

        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome_HeadLess")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            //options.setHeadless(true);
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(Lob.LoginPageURL);

    }

//
//    @AfterTest
//    public void Close_Browser() {
//        driver.quit();
//    }


    @AfterMethod
    public void AfterMethod(ITestResult TestResult) throws IOException {
        String Statues = String.valueOf(TestResult.getStatus());

        HFob = new HelperFunc(driver);

        if (Statues.equalsIgnoreCase("1")) {
            Statues = "PassTestCases";
        } else {
            Statues = "FailTestCases";
        }
        String Path = "ScreenShoot/" + Statues + "/" + TestResult.getName() + ".png";
        if (TestResult.getStatus() == ITestResult.FAILURE) {
            HFob.ScreenShoot(Path);
            Allure.addAttachment(TestResult.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } else if (TestResult.getStatus() == ITestResult.SUCCESS) {

            HFob.ScreenShoot(Path);
            Allure.addAttachment(TestResult.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }

    }
}
