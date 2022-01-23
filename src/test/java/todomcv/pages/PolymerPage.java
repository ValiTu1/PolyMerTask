package todomcv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import todomcv.utilities.Driver;

import java.security.Key;
import java.util.List;

public class PolymerPage extends BasePage{

    Actions actions = new Actions(Driver.get());
    WebDriverWait wait;

    @FindBy(id = "new-todo")
    public WebElement todoInput;

    @FindBy(id = "edit")
    public WebElement changeValue;

    @FindBy(xpath = "//section/ul//label")
    public List<WebElement> todoTasks;


    public void editTodo(String currentValue, String newValue){

            for(int i=0;i<todoTasks.size();i++){
                if(todoTasks.get(i).getText().equals(currentValue)){
                    actions.doubleClick(todoTasks.get(i)).perform();

                    changeValue.sendKeys(Keys.CONTROL, "a");
                    changeValue.sendKeys(Keys.DELETE);
                    changeValue.sendKeys(newValue, Keys.ENTER);
                }
            }
    }

    public WebElement createdItemElement( String str){
        return Driver.get().findElement(By.xpath("//label[.='"+ str +"']"));
    }


}
