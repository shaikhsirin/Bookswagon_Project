package testcase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.Homepage;
import pages.Loginpage;
import pages.SearchBook;

public class SearchBook extends  Baseclass{

    SearchBook searchBook;
    Homepage homePage;
    Loginpage loginPage;
    Logger log = Logger.getLogger(SearchBook.class);

    public SearchBook () {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        log.info("******** Starting test cases execution  *********");
        initialization();
        loginPage = new Loginpage();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        searchBook = new SearchBook();
        homePage = new Homepage();
    }

    @Test(priority=1)
    public void verifySearchPageTest() throws Exception{
        searchBook.clickSearchButton("Vagabond");
        searchBook.clickOnBookNow();
        log.info("Verify Successfully Search Feature");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("browser is closed");


    }


}