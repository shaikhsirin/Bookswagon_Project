package testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Homepage;
import base.Baseclass;
import pages.Loginpage;
import utility.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Loginpage extends Baseclass {

    Loginpage loginPage;
    Homepage homePage;
    Logger log = Logger.getLogger(Loginpage.class);


    Utility utility;
    public String SheetName = "Sheet1";

    public Loginpage() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        log.info("-----------Starting test cases execution  ----------");
        initialization();
        loginPage = new Loginpage();
    }
    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
        System.out.println("title:"+title);
    }
    @Test(priority = 2)
    public void ImageTest() {
        boolean flag = loginPage.validateImage();
        Assert.assertTrue(flag);
        System.out.println(flag);
    }


    @Test(priority = 3)
    public void loginTest() {
        log.info("LoginTest Method Runing...");
        homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        log.info("login successful with username and Password");
    }

    @DataProvider
    public Object[][] getLoginTestData() {
        Object data[][] = utility.getTestData(SheetName);
        return data;
    }

    @Test(dataProvider = "getLoginTestData", priority = 4)
    public void MultipleUserLoginTest(String username, String password) {
        log.info("Multiple user login Method Runing...");
        loginPage.multipleUserLogin(username, password);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        log.info("browser is closed");
    }


}
