import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by rjongejan on 24-6-2016.
 */
public class SeleniumTest {
    @BeforeClass
    public static void setUp(){
        ChromeDriverManager.getInstance().setup();
    }


    @Test
    public void seleniumTest(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        assertThat("On Google HomePage.", driver.getTitle(), equalTo("Google"));

        driver.quit();
    }

}
