import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.hamcrest.core.IsEqual;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by rjongejan on 24-6-2016.
 */
public class SeleniumTest {
    @BeforeClass
    public static void setUp() {
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void navigateToGoogleHomePageAndSearch() {
//This line initializes the WebDriver
        WebDriver driver = new ChromeDriver();

//This line gives the WebDriver the command to navigate to the Google homepage.
        driver.get("http://google.com");

//Our first assertion. Let's see if we are on the Google HomePage.
        assertThat("Title is 'Google'.", driver.getTitle(), equalTo("Google"));

//This line defines by what the WebDriver will need to search the Element, as we'll see below.
        By finder = By.name("q");

//This line retrieves the WebElement from the page.
        WebElement searchField = driver.findElement(finder);

//The 'sendKeys' method of the WebElement is used to type the query in the search-field. We'll add \n to press Enter as well.
        searchField.sendKeys("First test.\n");

//Now it's time for an assertion. This will assert if the title is what we expect it to be. (It will fail ;))
        //assertThat("Title is as expected.", driver.getTitle(), containsString("First test. - Google"));
    }


}
