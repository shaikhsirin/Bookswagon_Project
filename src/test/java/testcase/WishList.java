package testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Baseclass;
import pages.Loginpage;
import pages.WishList;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class WishList extends Baseclass {

    Loginpage loginPage;
    WishList wishlist;
    Logger log = Logger.getLogger(WishList.class);

    public WishList() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        log.info("******** Starting test cases execution  *********");
        initialization();
        loginPage = new Loginpage();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        wishlist = new WishList();
    }

    @Test(priority = 1)
    public void feature_authTest() throws InterruptedException {
        log.info("Feature Author Method Runing...");
        wishlist.feature_auth();
        String title = wishlist.validateWishListPageTitle();
        Assert.assertEquals(title, "Buy GILLIAN FLYNN Books Online at Best Prices In India - Bookswagon");
        System.out.println("title:"+title);
    }

    @Test(priority = 2)
    public void search_BookNameTest() throws InterruptedException {
        log.info("Search by book name Method Runing...");
        wishlist.search_BookName(prop.getProperty("addwishlistByBookname"));
        String title = wishlist.validateWishListPageTitle();
        Assert.assertEquals(title,"wings of fire - Books - 24x7 online bookstore Bookswagon.com");
        System.out.println("title:"+title);
    }

    @Test(priority = 3)
    public void addWishlist_AuthorNameTest() throws InterruptedException {
        log.info("Search by Author name Method Runing...");
        wishlist.addWishlist_AuthorName(prop.getProperty("addwishlistByAuthor"));
        String title = wishlist.validateWishListPageTitle();
        Assert.assertEquals(title,"Leigh Bardugo - Books - 24x7 online bookstore Bookswagon.com");
        System.out.println("title:"+title);
    }

    @Test(priority = 4)
    public void addWishlist_PublisherTest() throws InterruptedException {
        log.info("Search by Publisher Method Runing...");
        wishlist.addWishlist_Publisher(prop.getProperty("addwishlistByPublisher"));
        String title = wishlist.validateWishListPageTitle();
        Assert.assertEquals(title,"Orion Publishing Co - Books - 24x7 online bookstore Bookswagon.com");
        System.out.println("title:"+title);
    }

    @Test(priority = 5)
    public void wishlist_Test() throws InterruptedException {
        log.info("Wishlist Method Runing...");
        wishlist.WishList();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        log.info("browser is closed");

    }

}