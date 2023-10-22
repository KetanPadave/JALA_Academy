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

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@name, 'UserName')]")
    public WebElement Username;
    @FindBy(xpath = "//input[contains(@name, 'Password')]")
    public WebElement Password;
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    public WebElement Login;
    @FindBy(xpath = "//p[contains(text(),'Guest User')]")
    public WebElement VerifyLogin;
    @FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
    public WebElement ForgotPassword;
    @FindBy(xpath = "//input[contains(@name, 'Email')]")
    public WebElement ForgotEmail;
    @FindBy(xpath = "//button[contains(text(),'Get Password')]")
    public WebElement GetPassword;
    @FindBy(xpath = "//div[contains(text(),'Success!')]")
    public WebElement VerifySuccessMsg;
    @FindBy(xpath = "//button[contains(@class, 'close-button')]")
    public WebElement CloseSuccessMsg;
    @FindBy(xpath = "//a[contains(text(),'Admin Login')]")
    public WebElement AdminLogin;
    @FindBy(xpath = "//p[contains(text(),'Admin - Sign in')]")
    public WebElement VerifyAdminLoginWindow;
    @FindBy(xpath = "//span[contains(text(),'Invalid Email and Password.')]")
    public WebElement VerifyAdminLoginError;
    @FindBy(xpath = "//div[contains(text(),'Please fill all the required field')]")
    public WebElement VerifyEmptyFieldLogin;
    @FindBy(xpath = "//span[contains(text(),'Please enter email or mobile no.')]")
    public WebElement VerifyEmptyEmailError;
    @FindBy(xpath = "//span[contains(text(),'Please enter password.')]")
    public WebElement VerifyEmptyPasswordError;
    public void Login() throws IOException {
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
        String excelFilePath = "C:\\Users\\Admin\\IdeaProjects\\JALA_Academy\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String username = row.getCell(1).getStringCellValue();
            String password = row.getCell(2).getStringCellValue();
            workbook.close();
            Username.sendKeys(username);
            Password.sendKeys(password);
            Login.click();
            boolean displayed = VerifyLogin.isDisplayed();
            Assert.assertTrue(displayed);
        }
    }

    public void ForgetPassword() throws IOException, InterruptedException {
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
        String excelFilePath = "C:\\Users\\Admin\\IdeaProjects\\JALA_Academy\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String email = row.getCell(1).getStringCellValue();
            workbook.close();
            ForgotPassword.click();
            ForgotEmail.sendKeys(email);
            GetPassword.click();
            Thread.sleep(2000);
            boolean displayed = VerifySuccessMsg.isDisplayed();
            Assert.assertTrue(displayed);
            CloseSuccessMsg.click();
        }
    }
    public void AdminLogin() throws IOException {
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
        String excelFilePath = "C:\\Users\\Admin\\IdeaProjects\\JALA_Academy\\src\\test\\resources\\Project.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String username = row.getCell(1).getStringCellValue();
            String password = row.getCell(2).getStringCellValue();
            workbook.close();
            AdminLogin.click();
            boolean displayed1 = VerifyAdminLoginWindow.isDisplayed();
            Assert.assertTrue(displayed1);
            Username.sendKeys(username);
            Password.sendKeys(password);
            Login.click();
            boolean displayed2 = VerifyAdminLoginError.isDisplayed();
            Assert.assertTrue(displayed2);
        }
    }
    public void EmptyFieldLogin() throws IOException {
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
        Login.click();
        boolean displayed = VerifyEmptyFieldLogin.isDisplayed();
        Assert.assertTrue(displayed);
        CloseSuccessMsg.click();
        boolean displayed1 = VerifyEmptyEmailError.isDisplayed();
        Assert.assertTrue(displayed1);
        boolean displayed2 = VerifyEmptyPasswordError.isDisplayed();
        Assert.assertTrue(displayed2);
    }
}