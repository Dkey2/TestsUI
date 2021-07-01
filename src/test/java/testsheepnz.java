import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testsheepnz {

    private static final String CALCULATOR = "https://testsheepnz.github.io/BasicCalculator.html";
    private static final String RANDOM_NUMBER = "https://testsheepnz.github.io/random-number.html";
    private ChromeDriver chromeDriver;
    WebDriverWait webDriverWait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Cat/Downloads/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(chromeDriver, 10);
    }

    @Test
    public void Subtract() {
        chromeDriver.get(CALCULATOR);
        chromeDriver.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        chromeDriver.findElementById("number1Field").sendKeys("2");
        chromeDriver.findElementById("number2Field").sendKeys("3");
        chromeDriver.findElementById("selectOperationDropdown").sendKeys("Subtract");
        chromeDriver.findElementById("calculateButton").click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numberAnswerField")));
        Assert.assertEquals("-1", chromeDriver.findElementById("numberAnswerField").getAttribute("value"));
    }

    @Test
    public void Prototype() {
        chromeDriver.get(CALCULATOR);
        chromeDriver.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        chromeDriver.findElementById("number1Field").sendKeys("gs");
        chromeDriver.findElementById("number2Field").sendKeys("bu");
        chromeDriver.findElementById("selectOperationDropdown").sendKeys("Concatenate");
        chromeDriver.findElementById("calculateButton").click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numberAnswerField")));
        Assert.assertEquals("gsbu", chromeDriver.findElementById("numberAnswerField").getAttribute("value"));
    }

    @Test
    public void Number() {
        chromeDriver.get(RANDOM_NUMBER);
        chromeDriver.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        chromeDriver.findElementById("buildNumber").sendKeys("Demo");
        chromeDriver.findElementById("rollDiceButton").click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numberGuess")));
        chromeDriver.findElementById("numberGuess").sendKeys("string");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("feedbackLabel")));
        chromeDriver.findElementById("submitButton").click();
        String bodyText = chromeDriver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("string: Not a number!"));
    }

    @After
    public void close() {
        chromeDriver.quit();
    }
}
