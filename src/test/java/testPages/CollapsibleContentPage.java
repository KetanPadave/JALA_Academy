package testPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

import static utilities.DriverManager.driver;

public class CollapsibleContentPage {
    public CollapsibleContentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[contains(@class, 'fa fa-th-list')]")
    public WebElement ClickOnMoreMenu;
    @FindBy(xpath = "//a[contains(text(),' Collapsible Content')]")
    public WebElement ClickOnCollapsibleContent;
    @FindBy(xpath = "//a[contains(text(),'Single Collapse')]")
    public WebElement ClickOnSingleCollapse;
    @FindBy(xpath = "(//a[contains(@data-toggle, 'collapse')])[1]")
    public WebElement ClickOnSingleCollapseOne;
    @FindBy(xpath = "(//p[contains(text(),'')])[3]")
    public WebElement VerifySingleCollapseOne;
    @FindBy(xpath = "(//a[contains(@data-toggle, 'collapse')])[2]")
    public WebElement ClickOnSingleCollapseTwo;
    @FindBy(xpath = "(//p[contains(text(),'')])[5]")
    public WebElement VerifySingleCollapseTwo;
    @FindBy(xpath = "(//a[contains(@data-toggle, 'collapse')])[3]")
    public WebElement ClickOnSingleCollapseThree;
    @FindBy(xpath = "(//p[contains(text(),'')])[6]")
    public WebElement VerifySingleCollapseThree;
    @FindBy(xpath = "//a[contains(text(),'Multiple Collapse')]")
    public WebElement ClickOnMultipleCollapse;
    @FindBy(xpath = "(//a[contains(@data-toggle, 'collapse')])[4]")
    public WebElement ClickOnMultipleCollapseOne;
    @FindBy(xpath = "(//p[contains(text(),'')])[9]")
    public WebElement VerifyMultipleCollapseOne;
    @FindBy(xpath = "(//a[contains(@data-toggle, 'collapse')])[5]")
    public WebElement ClickOnMultipleCollapseTwo;
    @FindBy(xpath = "(//p[contains(text(),'')])[19]")
    public WebElement VerifyMultipleCollapseTwo;
    @FindBy(xpath = "(//a[contains(@data-toggle, 'collapse')])[6]")
    public WebElement ClickOnMultipleCollapseThree;
    @FindBy(xpath = "(//p[contains(text(),'')])[28]")
    public WebElement VerifyMultipleCollapseThree;
    @FindBy(xpath = "(//a[contains(@data-toggle, 'collapse')])[7]")
    public WebElement ClickOnMultipleCollapseFour;
    @FindBy(xpath = "(//p[contains(text(),'')])[41]")
    public WebElement VerifyMultipleCollapseFour;
    public void ValidateSingleCollapse() throws IOException {
        ClickOnMoreMenu.click();
        ClickOnCollapsibleContent.click();
        ClickOnSingleCollapse.click();
        ClickOnSingleCollapseTwo.click();
        boolean displayed1 = VerifySingleCollapseTwo.isDisplayed();
        Assert.assertTrue(displayed1);
        ClickOnSingleCollapseThree.click();
        boolean displayed2 = VerifySingleCollapseThree.isDisplayed();
        Assert.assertTrue(displayed2);
    }
    public void ValidateMultipleCollapse() throws IOException {
        ClickOnMoreMenu.click();
        ClickOnCollapsibleContent.click();
        ClickOnMultipleCollapse.click();
        ClickOnMultipleCollapseOne.click();
        boolean displayed = VerifyMultipleCollapseOne.isDisplayed();
        Assert.assertTrue(displayed);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");
        ClickOnMultipleCollapseTwo.click();
        boolean displayed1 = VerifyMultipleCollapseTwo.isDisplayed();
        Assert.assertTrue(displayed1);
        js.executeScript("window.scrollBy(0, 300);");
        ClickOnMultipleCollapseThree.click();
        boolean displayed2 = VerifyMultipleCollapseThree.isDisplayed();
        Assert.assertTrue(displayed2);
        js.executeScript("window.scrollBy(0, 200);");
        ClickOnMultipleCollapseFour.click();
    }
}
