package testPages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.QaEnvPropReader;

import java.io.FileInputStream;
import java.io.IOException;

import static utilities.DriverManager.driver;

public class SearchEmployee {
    public SearchEmployee(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[contains(@class, 'fa fa-users')]")
    public WebElement ClickOnEmployeeDropdown;
    @FindBy(xpath = "//a[contains(text(),' Search ')]")
    public WebElement ClickOnSearchEmployee;
    @FindBy(xpath = "//small[contains(text(),'Search')]")
    public WebElement VerifySearchEmployee;
    @FindBy(xpath = "//input[contains(@name, 'Name')]")
    public WebElement EnterSearchName;
    @FindBy(xpath = "//input[contains(@name, 'MobileNo')]")
    public WebElement EnterSearchNum;
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement ClickOnSearch;
    @FindBy(xpath = "(//td[contains(text(),'Ben')])[1]")
    public WebElement VerifySearch;
    @FindBy(xpath = "//button[contains(text(),'Clear')]")
    public WebElement ClearSearch;
    @FindBy(xpath = "(//a[contains(text(),'Delete')])[1]")
    public WebElement DeleteSearchResult;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    public WebElement DeleteYes;
    @FindBy(xpath = "//div[contains(text(),'Record deleted successfully')]")
    public WebElement VerifyDelete;
    @FindBy(xpath = "//button[contains(@class, 'toast-close-button')]")
    public WebElement CloseVerifyBar;
    @FindBy(xpath = "//a[contains(text(),' Home ')]")
    public WebElement GotoHome;



    public void SearchEmployeeFunctionality() throws IOException {
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
        EmployeeCreatePage employeeCreatePage = new EmployeeCreatePage(driver);
        employeeCreatePage.CreateEmployeeFunctionality();
        String excelFilePath = "C:\\Users\\Admin\\IdeaProjects\\JALA_Academy\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String firstname = row.getCell(1).getStringCellValue();
            double numericValue = row.getCell(4).getNumericCellValue();
            int intValue = (int) numericValue;
            String mobileNum = String.valueOf(intValue);
            workbook.close();
            ClickOnEmployeeDropdown.click();
            ClickOnSearchEmployee.click();
            boolean displayed = VerifySearchEmployee.isDisplayed();
            Assert.assertTrue(displayed);
            EnterSearchName.sendKeys(firstname);
            EnterSearchNum.sendKeys(mobileNum);
            ClickOnSearch.click();
            boolean displayed1 = VerifySearch.isDisplayed();
            Assert.assertTrue(displayed1);
        }
    }
    public void SearchEmployeeAndClearFields() throws IOException {
        SearchEmployeeFunctionality();
        ClearSearch.click();
    }
    public void SearchEmployeeAndDeleteResult() throws IOException {
        SearchEmployeeFunctionality();
        DeleteSearchResult.click();
        DeleteYes.click();
        boolean displayed = VerifyDelete.isDisplayed();
        Assert.assertTrue(displayed);
        CloseVerifyBar.click();
        ClearSearch.click();
    }
    public void SearchEmployeeAndGotoHome() throws IOException {
        SearchEmployeeFunctionality();
        GotoHome.click();
        String excelFilePath = "C:\\Users\\Admin\\IdeaProjects\\JALA_Academy\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String expectedHomePageTitle = row.getCell(3).getStringCellValue();
            String actualHomePageTitle = driver.getTitle();
            Assert.assertEquals(actualHomePageTitle,expectedHomePageTitle);
        }
    }
}
