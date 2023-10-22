package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

import static utilities.DriverManager.driver;

public class MenuPage {
    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[contains(@class, 'fa fa-th-list')]")
    public WebElement ClickOnMoreMenu;
    @FindBy(xpath = "//a[contains(text(),' Menu')]")
    public WebElement ClickMenu;
    @FindBy(xpath = "//a[contains(text(),'Single Menus')]")
    public WebElement ClickOnSingleMenu;
    @FindBy(xpath = "(//a[contains(text(),'Testing')])[1]")
    public WebElement ClickOnSingleTesting;
    @FindBy(xpath = "//span[contains(text(),'Testing')]")
    public WebElement VerifySingleTesting;
    @FindBy(xpath = "(//a[contains(text(),'Java')])[1]")
    public WebElement ClickOnSingleJAVA;
    @FindBy(xpath = "//span[contains(text(),'Java')]")
    public WebElement VerifySingleJAVA;
    @FindBy(xpath = "(//a[contains(text(),'.Net')])[1]")
    public WebElement ClickOnSingleDotNet;
    @FindBy(xpath = "//span[contains(text(),'.Net')]")
    public WebElement VerifySingleDotNe;
    @FindBy(xpath = "(//a[contains(text(),'Data Base')])[1]")
    public WebElement ClickOnSingleDataBase;
    @FindBy(xpath = "(//span[contains(@id, 'label')])[1]]")
    public WebElement VerifySingleDataBase;
    @FindBy(xpath = "//a[contains(text(),'Sub Menus')]")
    public WebElement ClickOnSubMenus;
    @FindBy(xpath = "(//a[contains(text(),'Testing')])[2]")
    public WebElement ClickOnSubTesting;
    @FindBy(xpath = "//a[contains(text(),'Selenium')]")
    public WebElement ClickOnSubTestingSelenium;
    @FindBy(xpath = "//span[contains(text(),'Selenium')]")
    public WebElement VerifySelenium;
    @FindBy(xpath = "//a[contains(text(),'Manual Testing')]")
    public WebElement ClickOnSubTestingManual;
    @FindBy(xpath = "//span[contains(text(),'Manual Testing')]")
    public WebElement VerifyManual;
    @FindBy(xpath = "//a[contains(text(),'DB Testing')]")
    public WebElement ClickOnSubTestingDB;
    @FindBy(xpath = "//span[contains(text(),'DB Testing')]")
    public WebElement VerifyDB;
    @FindBy(xpath = "//a[contains(text(),'Unit Testing')]")
    public WebElement ClickOnSubTestingUnit;
    @FindBy(xpath = "//span[contains(text(),'Unit Testing')]")
    public WebElement VerifyUnit;



    public void ValidateSingleMenu() throws IOException {
        ClickOnMoreMenu.click();
        ClickMenu.click();
        ClickOnSingleMenu.click();
        ClickOnSingleTesting.click();
        boolean displayed = VerifySingleTesting.isDisplayed();
        Assert.assertTrue(displayed);
        ClickOnSingleJAVA.click();
        boolean displayed1 = VerifySingleJAVA.isDisplayed();
        Assert.assertTrue(displayed1);
        ClickOnSingleDotNet.click();
        boolean displayed2 = VerifySingleDotNe.isDisplayed();
        Assert.assertTrue(displayed2);
        ClickOnSingleDataBase.click();
    }
    public void ValidateSubMenuTesting() throws IOException {
        ClickOnMoreMenu.click();
        ClickMenu.click();
        ClickOnSubMenus.click();
        ClickOnSubTesting.click();
        ClickOnSubTestingSelenium.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(ClickOnSubMenus).perform();
        boolean displayed = VerifySelenium.isDisplayed();
        Assert.assertTrue(displayed);
        ClickOnSubTesting.click();
        ClickOnSubTestingManual.click();
        actions.moveToElement(ClickOnSubMenus).perform();
        boolean displayed1 = VerifyManual.isDisplayed();
        Assert.assertTrue(displayed1);
        ClickOnSubTesting.click();
        ClickOnSubTestingDB.click();
        actions.moveToElement(ClickOnSubMenus).perform();
        boolean displayed2 = VerifyDB.isDisplayed();
        Assert.assertTrue(displayed2);
        ClickOnSubTesting.click();
        ClickOnSubTestingUnit.click();
        actions.moveToElement(ClickOnSubMenus).perform();
        boolean displayed3 = VerifyUnit.isDisplayed();
        Assert.assertTrue(displayed3);
    }
}
