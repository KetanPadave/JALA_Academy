package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.QaEnvPropReader;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;
import static utilities.DriverManager.driver;

public class LogOut {
    public LogOut(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[contains(text(),'Logout')]")
    public WebElement Logout;
    @FindBy(xpath = "//p[contains(text(),'Sign in')]")
    public WebElement VerifyLogout;
    public void Logout() throws IOException {
        Logout.click();
        boolean displayed = VerifyLogout.isDisplayed();
        Assert.assertTrue(displayed);
    }
}
