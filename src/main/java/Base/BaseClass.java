package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utility.Utility;
import utility.WebEventListener;

public class Baseclass {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public Baseclass() {

        try {
            prop = new Properties();
            FileInputStream ip;
            ip = new FileInputStream(
                    "C:\\Users\\HP\\eclipse-workspace\\src\\test\\java\\Selenium\\BooksSwagon_Project\\src\\main\\java\\com\\config_properties\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initialization() {

        String browserName = prop.getProperty("brower");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();

        driver = e_driver;


        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Utility.Page_Load_TImeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
