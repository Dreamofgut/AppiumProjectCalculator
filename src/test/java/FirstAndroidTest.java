import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class FirstAndroidTest {

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", System.getProperty("user.dir")+"/src/main/resources/Calculator.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

    @Test
    public void clickTest() throws InterruptedException {
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("eq")).click();
        Assert.assertEquals(Integer.parseInt(driver.findElement(By.id("result_final")).getText()), 3);


    }

    @AfterTest
    public void tearDown(){
        if (null != driver){
            driver.quit();
        }
    }
}
