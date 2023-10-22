package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class MultipleTabs {
    public MultipleTabs(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[contains(@class, 'fa fa-th-list')]")
    public WebElement ClickOnMoreMenu;
    @FindBy(xpath = "//a[contains(text(),' Multiple Tabs')]")
    public WebElement ClickOnMultipleTab;
    @FindBy(xpath = "//h1[contains(text(),'Tabs')]")
    public WebElement VerifyMultipleTab;
    @FindBy(xpath = "//a[contains(text(),'Plan to Succeed')]")
    public WebElement ClickOnPlansToSucceedTab;
    @FindBy(xpath = "//a[contains(text(),'UnLearning')]")
    public WebElement ClickOnUnlearning;
    @FindBy(xpath = "//a[contains(text(),'Ways of Unlearning')]")
    public WebElement ClickOnWaysOfUnlearning;
    public void ValidateMultipleTabs() throws IOException {
        ClickOnMoreMenu.click();
        ClickOnMultipleTab.click();
        boolean displayed = VerifyMultipleTab.isDisplayed();
        Assert.assertTrue(displayed);
        boolean displayed1 = ClickOnPlansToSucceedTab.isDisplayed();
        Assert.assertTrue(displayed1);
        boolean displayed2 = ClickOnUnlearning.isDisplayed();
        Assert.assertTrue(displayed2);
        boolean displayed3 = ClickOnWaysOfUnlearning.isDisplayed();
        Assert.assertTrue(displayed3);
    }
}
