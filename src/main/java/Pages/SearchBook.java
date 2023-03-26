package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Baseclass;

public class SearchBook extends Baseclass{

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
    private WebElement searchBook;

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
    private WebElement searchBtn;

    @FindBy(xpath = "//input[@value ='Buy Now']")
    private WebElement clickOnBookNow;

    @FindBy(xpath = "//input[@id='BookCart_lvCart_imgPayment']")
    private WebElement clickOnPlaceOrder;


    public SearchBook() {
        PageFactory.initElements(driver, this);
    }


    public void SearchBookItem(String strBookName) {
        searchBook.sendKeys(strBookName);
    }


    public void SearchBtn() {
        searchBtn.click();
    }


    public Homepage clickSearchButton(String strSearchBookName) throws InterruptedException {
        this.SearchBookItem(strSearchBookName);
        Thread.sleep(3000);
        this.SearchBtn();
        Thread.sleep(3000);
        return new Homepage();
    }


    public void clickOnBookNow() throws InterruptedException {
        clickOnBookNow.click();
        Thread.sleep(3000);
    }


}