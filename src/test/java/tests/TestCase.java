package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testPages.*;

import java.io.IOException;
import java.util.Set;


public class TestCase extends BaseTest{

    @Test
    public void VerifyLogin() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
    }
    @Test
    public void VerifyLogOut() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        LogOut logOut = new LogOut(driver);
        logOut.Logout();
    }
    @Test
    public void ForgotPasswordFunctionality() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.ForgetPassword();
    }
    @Test
    public void AdminLoginFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.AdminLogin();
    }
    @Test
    public void EmptyFieldsLoginFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EmptyFieldLogin();
    }
    @Test
    public void CreateEmployeeAndSaveFunctionality() throws IOException {
        EmployeeCreatePage employeeCreatePage = new EmployeeCreatePage(driver);
        employeeCreatePage.CreateEmployeeFunctionality();
    }
    @Test
    public void CreateEmployeeCancelFunctionality() throws IOException {
        EmployeeCreatePage employeeCreatePage = new EmployeeCreatePage(driver);
        employeeCreatePage.CreateEmployeeCancelFunctionality();
    }
    @Test
    public void SearchEmployeeFunctionality() throws IOException {
        SearchEmployee searchEmployee = new SearchEmployee(driver);
        searchEmployee.SearchEmployeeFunctionality();
    }
    @Test
    public void SearchEmployeeAndClearFieldsFunctionality() throws IOException {
        SearchEmployee searchEmployee = new SearchEmployee(driver);
        searchEmployee.SearchEmployeeAndClearFields();
    }
    @Test
    public void SearchEmployeeAndDeleteResultFunctionality() throws IOException {
        SearchEmployee searchEmployee = new SearchEmployee(driver);
        searchEmployee.SearchEmployeeAndDeleteResult();
    }
    @Test
    public void SearchEmployeeAndGotoHomeFunctionality() throws IOException {
        SearchEmployee searchEmployee = new SearchEmployee(driver);
        searchEmployee.SearchEmployeeAndGotoHome();
    }
    @Test
    public void MultipleTabsFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        MultipleTabs multipleTabs = new MultipleTabs(driver);
        multipleTabs.ValidateMultipleTabs();
    }
    @Test
    public void ValidateSingleMenuFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        MenuPage menuPage = new MenuPage(driver);
        menuPage.ValidateSingleMenu();
    }
    @Test
    public void ValidateSubMenuTestingFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        MenuPage menuPage = new MenuPage(driver);
        menuPage.ValidateSubMenuTesting();
    }
    @Test
    public void ValidateSingleCollapseFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        CollapsibleContentPage collapsibleContentPage = new CollapsibleContentPage(driver);
        collapsibleContentPage.ValidateSingleCollapse();
    }
    @Test
    public void ValidateMultipleCollapseFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        CollapsibleContentPage collapsibleContentPage = new CollapsibleContentPage(driver);
        collapsibleContentPage.ValidateMultipleCollapse();
    }
    @Test
    public void PopupsPageFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        PopupsPage popupsPage = new PopupsPage(driver);
        popupsPage.ValidatePopups();
    }
    @Test
    public void SliderFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        SliderPage sliderPage = new SliderPage(driver);
        sliderPage.ClickOnMoreMenu.click();
        sliderPage.ClickOnSlider.click();
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sliderPage.Slider, 200, 0).build().perform();
    }
    @Test
    public void ToolTipPageFunctionality() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        ToolTipPage toolTipPage = new ToolTipPage(driver);
        toolTipPage.ClickOnMoreMenu.click();
        toolTipPage.ClickOnToolTip.click();
        boolean displayed = toolTipPage.VerifyToolTip.isDisplayed();
        Assert.assertTrue(displayed);
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTipPage.ToolTipTextChecker).perform();
        boolean displayed1 = toolTipPage.VerifyToolTipPresence1.isDisplayed();
        Assert.assertTrue(displayed1);
        toolTipPage.ToolTipTextChecker.click();
        boolean displayed2 = toolTipPage.VerifyToolTipPresence2.isDisplayed();
        Assert.assertTrue(displayed2);
    }
    @Test
    public void WorkingLinkFunctionality() throws IOException {
        String firstWindowHandle = driver.getWindowHandle();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.ClickOnMoreMenu.click();
        linksPage.ClickOnLinks.click();
        boolean displayed = linksPage.VerifyLinksPage.isDisplayed();
        Assert.assertTrue(displayed);
        linksPage.ClickOnWorkingLinks.click();
        linksPage.ClickOnWorkingLink1.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(firstWindowHandle)) {
                driver.switchTo().window(windowHandle);
                String linkTitle = driver.getTitle();
                Assert.assertEquals(linkTitle,"Workinglinks.co.uk – A job, employment, work and occupation");
                driver.close();
            }
        }
        driver.switchTo().window(firstWindowHandle);
    }
}
