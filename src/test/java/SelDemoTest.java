import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class SelDemoTest {

    private WebDriver driver;
    private Actions actions;


    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }


    @Test(enabled = false)
    public void testName() throws InterruptedException {
        driver.get("https://zoom.us/");
        System.out.println(driver.getPageSource());
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
//        By btname = By.id("signupfree");
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("signupfree"));
//        element.click();
//        driver.findElement(By.xpath("//*[@id='signupfree']/a")).click();
//        System.out.println(driver.getCurrentUrl());
        actions.keyDown(Keys.CONTROL).click(element).build().perform();
        Thread.sleep(5000);
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        Thread.sleep(5000);
        driver.switchTo().window(currentWindow);
//


    }

    @Test(enabled = false)
    public void IframeTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_frameborder");
        Thread.sleep(5000);
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
        driver.switchTo().frame(frame);
        WebElement element = driver.findElement(By.xpath("/html/body/h2"));
        Assert.assertEquals(element.getText(), "Remove the Iframe Border");
    }

    @Test(enabled = false)
    public void anotherIframe() throws InterruptedException, MalformedURLException {
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[@id=\"pagetop\"]/div[2]/a[1]")).click();
        Thread.sleep(10000);
        driver.switchTo().parentFrame();

//
        driver.findElement(By.xpath("//a[@title='Video Tutorials']")).click();
        Thread.sleep(10000);
//        driver.navigate().back();
//        Thread.sleep(5000);
//        driver.navigate().forward();
//        Thread.sleep(5000);
//        driver.navigate().refresh();
//        Thread.sleep(5000);
//        driver.navigate().to(new URL("https://pragra.io"));


    }

    @Test(enabled=false)
    public void windowsTest() throws InterruptedException {
        driver.get("https://pragra.io");
//        driver.manage().window().fullscreen();
//        Thread.sleep(5000);
//        driver.manage().window().setSize(new Dimension(640,580));
//        Thread.sleep(5000);
//        driver.manage().window().setPosition(new Point(300,40));
        WebElement form = driver.findElement(By.tagName("form"));
//        form.submit();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("gincysk@gmail.com", Keys.TAB);
        Thread.sleep(5000);
        email.clear();
        System.out.println(email.getTagName());
        System.out.println(email.getAttribute("placeholder"));

    }

    @Test(enabled=false)
    public void webElementDemo() throws InterruptedException, IOException {
        driver.get("https://pragra.io/courses/front-end-course");
        WebElement element = driver.findElement(By.xpath("//input[@name =\"terms\"]"));
        if(!element.isSelected())
        {
            System.out.println("Checkbox is not checked");
            element.click();
        }

        WebElement message = driver.findElement(By.id("message"));
        Thread.sleep(5000);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].disabled=true",message);
//        if(!message.isEnabled())
//        {
//            System.out.println("Message is disabled");
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none'",message);
//        Thread.sleep(5000);
        if(!message.isDisplayed())
        {
            System.out.println("Message box is not displayed on screen");
        }

        System.out.println(message.getLocation());
        System.out.println(message.getSize());
        System.out.println(message.getRect());
        System.out.println(message.getCssValue("background-color"));
        System.out.println(message.getCssValue("padding-right"));

        WebElement form = driver.findElement(By.tagName("form"));
        File file = form.getScreenshotAs(OutputType.FILE);
        Files.copy(file.toPath(), Paths.get("form.png"));



    }
    @Test(enabled=false)
    public void dragNDrop()
    {
        driver.get("https://jqueryui.com/droppable/");
        WebElement frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable,droppable).build().perform();

    }

    @Test
    public void contextMenu() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        WebElement menu = driver.findElement(By.xpath("//span[.='right click me']"));
        actions.contextClick(menu).build().perform();
        driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[5]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();


    }

        @AfterSuite
        public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
