package testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.Change_Password;
import pages.Loginpage;
import utility.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ChangePassword_Test extends Baseclass {

    Loginpage loginPage;
    Utility utility;
    Change_Password changePassword;
    Logger log = Logger.getLogger(ChangePassword_Test.class);
    public String SheetName = "Sheet1";

    public ChangePassword_Test() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        log.info("-----Starting test cases execution----");
        initialization();
        loginPage = new Loginpage();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        changePassword = new Change_Password();
    }

    @DataProvider
    public Object[][] getLoginTestData() {
        Object data[][] = utility.getTestData(SheetName);
        return data;
    }

    @Test(dataProvider = "getLoginTestData")
    @Severity(SeverityLevel.NORMAL)
    @Description("The user try to change the password")
    @Feature("Change password")
    @Story("The user try to change the password")
    public void request_a_bookTest(String currentPassword, String newPassword, String confirmPassword)
            throws InterruptedException {

        ChangePassword.ChangePassword(currentPassword, newPassword, confirmPassword);
        String actualSuccMessg = changePassword.getSuccessMessg();
        Assert.assertEquals(actualSuccMessg, "Congratulation! Your new password has been saved.");
        Thread.sleep(2000);
        System.out.println(actualSuccMessg);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        log.info("browser is closed");

    }

}