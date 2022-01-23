package todomcv.pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import todomcv.utilities.Driver;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[text()='JavaScript']")
    public WebElement javaScriptTab;

    @FindBy(xpath = "//div[text()='Compile-to-JS']")
    public WebElement compileToJsTab;

    @FindBy(xpath = "//div[text()='Labs']")
    public WebElement labsTab;

    @FindBy(linkText = "Polymer")
    public WebElement polymerSubTab;







    public void clickOnElements(WebElement element){
        element.click();
    }


}
