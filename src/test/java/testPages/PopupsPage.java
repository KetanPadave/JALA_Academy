package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.DriverManager.driver;

public class PopupsPage {
    public PopupsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[contains(@class, 'fa fa-th-list')]")
    public WebElement ClickOnMoreMenu;
    @FindBy(xpath = "//a[contains(text(),' Popups')]")
    public WebElement ClickOnPopups;
    @FindBy(xpath = "//input[contains(@id, 'alertBox')]")
    public WebElement ClickOnAlertBox;
    @FindBy(xpath = "//input[contains(@id, 'confirmBox')]")
    public WebElement ClickOnConfirmBox;
    @FindBy(xpath = "//button[contains(text(),'Prompt Box')]")
    public WebElement ClickOnPromptBox;
    public void ValidatePopups(){
        ClickOnMoreMenu.click();
        ClickOnPopups.click();
        ClickOnAlertBox.click();
        driver.switchTo().alert().accept();
        ClickOnConfirmBox.click();
        driver.switchTo().alert().accept();
        ClickOnConfirmBox.click();
        driver.switchTo().alert().dismiss();
        ClickOnPromptBox.click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        ClickOnPromptBox.click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().dismiss();
    }

}
