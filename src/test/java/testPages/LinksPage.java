package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage {
    public LinksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[contains(@class, 'fa fa-th-list')]")
    public WebElement ClickOnMoreMenu;
    @FindBy(xpath = "(//a[contains(text(),'Links')])[1]")
    public WebElement ClickOnLinks;
    @FindBy(xpath = "//h1[contains(text(),'Links')]")
    public WebElement VerifyLinksPage;
    @FindBy(xpath = "//a[contains(text(),'Working Links')]")
    public WebElement ClickOnWorkingLinks;
    @FindBy(xpath = "(//a[contains(text(),'Link 1')])[1]")
    public WebElement ClickOnWorkingLink1;
}
