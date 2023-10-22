package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolTipPage {
    public ToolTipPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[contains(@class, 'fa fa-th-list')]")
    public WebElement ClickOnMoreMenu;
    @FindBy(xpath = "//a[contains(text(),' Tooltips')]")
    public WebElement ClickOnToolTip;
    @FindBy(xpath = "//h1[contains(text(),' Tooltip')]")
    public WebElement VerifyToolTip;
    @FindBy(xpath = "//button[contains(@class, 'btn btn-primary btn-flat')]")
    public WebElement ToolTipTextChecker;
    @FindBy(xpath = "//div[contains(text(),'You have not clicked this BUTTON yet')]")
    public WebElement VerifyToolTipPresence1;
    @FindBy(xpath = "//div[contains(text(),'Thank you for being here!')]")
    public WebElement VerifyToolTipPresence2;

}
