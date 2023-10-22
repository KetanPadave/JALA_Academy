package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage {
    public SliderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[contains(@class, 'fa fa-th-list')]")
    public WebElement ClickOnMoreMenu;
    @FindBy(xpath = "//a[contains(text(),' Slider')]")
    public WebElement ClickOnSlider;
    @FindBy(xpath = "(//div[contains(@class, 'slider-handle')])[1]")
    public WebElement Slider;
}
