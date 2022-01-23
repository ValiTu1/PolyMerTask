package todomcv.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import todomcv.TestBase;
import todomcv.pages.BasePage;
import todomcv.pages.PolymerPage;
import todomcv.utilities.ConfigurationReader;

public class TestsPage extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        BasePage basePage = new BasePage();

        //load the website, click within the JavaScript tab,
        //and select the Polymer link.
        basePage.clickOnElements(basePage.javaScriptTab);
        basePage.clickOnElements(basePage.polymerSubTab);

        //check if redirected to polymer page
        String expectedPageTitle = "Polymer • TodoMVC";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        PolymerPage polymerPage = new PolymerPage();

        String toDoItemOne = "My first to do item";
        String toDoItemTwo = "My second to do item";
        polymerPage.todoInput.sendKeys(toDoItemOne+ Keys.ENTER);
        polymerPage.todoInput.sendKeys(toDoItemTwo+Keys.ENTER);

        Assert.assertTrue(polymerPage.createdItemElement(toDoItemOne).isDisplayed(), "My to toDoItemOne is not displayed");
        Assert.assertTrue(polymerPage.createdItemElement(toDoItemTwo).isDisplayed());

        polymerPage.editTodo(toDoItemTwo, "new value");

        /*WebElement btnForChanging = polymerPage.createdItemElement(toDoItemTwo);
        actions.doubleClick(btnForChanging).perform();

        for (int i = 0; i < toDoItemTwo.length() ; i++) {
            polymerPage.changeValue.sendKeys(Keys.BACK_SPACE);
        }
        String changedItem = "I have changed second item";
        polymerPage.changeValue.sendKeys(changedItem, Keys.ENTER);

        Assert.assertTrue(polymerPage.createdItemElement(changedItem).isDisplayed(),"My second item NOT changed");*/

    }




}
