package testPages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.QaEnvPropReader;

import java.io.FileInputStream;
import java.io.IOException;

import static utilities.DriverManager.driver;

public class EmployeeCreatePage {
    public EmployeeCreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//i[contains(@class, 'fa fa-users')]")
    public WebElement ClickOnEmployeeDropdown;
    @FindBy(xpath = "//a[contains(text(),' Create ')]")
    public WebElement ClickOnCreateEmployee;
    @FindBy(xpath = "//h1[contains(text(),'Employee')]")
    public WebElement VerifyEmployeeCreatePage;
    @FindBy(xpath = "//input[contains(@name, 'FirstName')]")
    public WebElement EnterFirstName;
    @FindBy(xpath = "//input[contains(@name, 'LastName')]")
    public WebElement EnterLastName;
    @FindBy(xpath = "//input[contains(@name, 'EmailId')]")
    public WebElement EnterEmailID;
    @FindBy(xpath = "//input[contains(@name, 'MobileNo')]")
    public WebElement EnterMobileNum;
    @FindBy(xpath = "//input[contains(@name, 'DOB')]")
    public WebElement ClickDOB;
    @FindBy(xpath = "(//th[contains(@class, 'datepicker-switch')])[1]")
    public WebElement ClickOnMonth;
    @FindBy(xpath = "(//th[contains(@class, 'datepicker-switch')])[2]")
    public WebElement ClickOnYear;
    @FindBy(xpath = "(//th[contains(@class, 'prev')])[3]")
    public WebElement ScrollYearLeft;
    @FindBy(xpath = "//span[contains(text(),'1995')]")
    public WebElement SelectYear;
    @FindBy(xpath = "//span[contains(text(),'Oct')]")
    public WebElement SelectMonth;
    @FindBy(xpath = "//td[contains(text(),'22')]")
    public WebElement SelectDate;
    @FindBy(xpath = "//input[contains(@id, 'rdbMale')]")
    public WebElement SelectGender;
    @FindBy(xpath = "//textarea[contains(@id, 'Address')]]")
    public WebElement EnterAddress;
    @FindBy(xpath = "//select[contains(@id, 'CountryId')]")
    public WebElement SelectCountry;
    @FindBy(xpath = "//select[contains(@id, 'CityId')]")
    public WebElement SelectCity;
    @FindBy(xpath = "//input[contains(@name, 'chkSkill_1')]")
    public WebElement SelectSkills;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    public WebElement ClickOnSave;
    @FindBy(xpath = "//div[contains(text(),'Employee details saved successfully')]")
    public WebElement VerifyCreateEmployeeSave;
    @FindBy(xpath = "//a[contains(@class, 'btn btn-danger')]")
    public WebElement ClickOnCancel;
    @FindBy(xpath = "//small[contains(text(),'Search')]")
    public WebElement VerifyCancel;
    public void CreateEmployeeFunctionality() throws IOException {
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        String excelFilePath = "C:\\Users\\Admin\\IdeaProjects\\JALA_Academy\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String firstname = row.getCell(1).getStringCellValue();
            String lastname = row.getCell(2).getStringCellValue();
            String emailId = row.getCell(3).getStringCellValue();
            double numericValue = row.getCell(4).getNumericCellValue();
            int intValue = (int) numericValue;
            String mobileNum = String.valueOf(intValue);
            String address = row.getCell(5).getStringCellValue();
            String countryName = row.getCell(6).getStringCellValue();
            String cityName = row.getCell(7).getStringCellValue();
            workbook.close();
            ClickOnEmployeeDropdown.click();
            ClickOnCreateEmployee.click();
            boolean displayed = VerifyEmployeeCreatePage.isDisplayed();
            Assert.assertTrue(displayed);
            EnterFirstName.sendKeys(firstname);
            EnterLastName.sendKeys(lastname);
            EnterEmailID.sendKeys(emailId);
            EnterMobileNum.sendKeys(mobileNum);
            ClickDOB.click();
            ClickOnMonth.click();
            ClickOnYear.click();
            ScrollYearLeft.click();
            ScrollYearLeft.click();
            ScrollYearLeft.click();
            SelectYear.click();
            SelectMonth.click();
            SelectDate.click();
            SelectGender.click();
            Select select1 = new Select(SelectCountry);
            select1.selectByVisibleText(countryName);
            Select select2 = new Select(SelectCity);
            select2.selectByVisibleText(cityName);
            SelectSkills.click();
            ClickOnSave.click();
            boolean displayed1 = VerifyCreateEmployeeSave.isDisplayed();
            Assert.assertTrue(displayed1);
        }
    }
    public void CreateEmployeeCancelFunctionality() throws IOException {
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        String excelFilePath = "C:\\Users\\Admin\\IdeaProjects\\JALA_Academy\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String firstname = row.getCell(1).getStringCellValue();
            String lastname = row.getCell(2).getStringCellValue();
            String emailId = row.getCell(3).getStringCellValue();
            double numericValue = row.getCell(4).getNumericCellValue();
            int intValue = (int) numericValue;
            String mobileNum = String.valueOf(intValue);
            String address = row.getCell(5).getStringCellValue();
            String countryName = row.getCell(6).getStringCellValue();
            String cityName = row.getCell(7).getStringCellValue();
            workbook.close();
            ClickOnEmployeeDropdown.click();
            ClickOnCreateEmployee.click();
            boolean displayed = VerifyEmployeeCreatePage.isDisplayed();
            Assert.assertTrue(displayed);
            EnterFirstName.sendKeys(firstname);
            EnterLastName.sendKeys(lastname);
            EnterEmailID.sendKeys(emailId);
            EnterMobileNum.sendKeys(mobileNum);
            ClickDOB.click();
            ClickOnMonth.click();
            ClickOnYear.click();
            ScrollYearLeft.click();
            ScrollYearLeft.click();
            ScrollYearLeft.click();
            SelectYear.click();
            SelectMonth.click();
            SelectDate.click();
            SelectGender.click();
            Select select1 = new Select(SelectCountry);
            select1.selectByVisibleText(countryName);
            Select select2 = new Select(SelectCity);
            select2.selectByVisibleText(cityName);
            SelectSkills.click();
            Actions actions = new Actions(driver);
            actions.moveToElement(ClickOnCancel).perform();
            ClickOnCancel.click();
            boolean displayed1 = VerifyCancel.isDisplayed();
            Assert.assertTrue(displayed1);
        }
    }
}
