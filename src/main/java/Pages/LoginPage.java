package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage extends BaseClass {
    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
    WebElement email;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
    WebElement pass;

    @FindBy(xpath = "//a[@id='ctl00_phBody_SignIn_btnLogin']")
    WebElement login;

    @FindBy(xpath="(//img[@class='w-100'])[39]")
    WebElement image;

    public Loginpage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateImage() {
        return image.isDisplayed();
    }

    public Homepage login(String username,String password) {

        email.sendKeys(username);
        pass.sendKeys(password);
        login.click();

        return new Homepage();

    }

    public void multipleUserLogin(String username,String password) {
        email.sendKeys(username);
        pass.sendKeys(password);
        login.click();

    }



}
