package com.gt.cucumber.web;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;
//import org.junit.jupiter.api.TestFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/home/beyza/Masaüstü/CUCUMBERSELENIUM/src/test/java/com/gt/cucumber/web/features"
        , glue = {"/home/beyza/Masaüstü/CUCUMBERSELENIUM/src/test/java/com/gt/cucumber/web/step"},
        plugin = {"html:target/cucumberHtmlReport"}
        //plugin = {"pretty", "junit:.target/surefire-reports/TEST-Report.xml", "json:."}
)
public class RunnerTest {
//    public ChromeDriver driver = new ChromeDriver();
//    static String url="https://www.n11.com";
    public RunnerTest() {}
//    @Before
//    public static void before() {
//
//        if(browser.equalsIgnoreCase("mozilla"))
//            driver= new FirefoxDriver();
//        else if(browser.equalsIgnoreCase("ie"))
//            driver= new InternetExplorerDriver();
//            //System.setProperty("webdriver.chrome.driver","/home/beyza/Masaüstü/CUCUMBERSELENIUM/drivers/IEDriverServer.exe");
//        else if (browser.equalsIgnoreCase("chrome"))
//            //System.setProperty("webdriver.chrome.driver","/home/beyza/Masaüstü/CUCUMBERSELENIUM/drivers/chromedriver.exe");
//        driver= new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//        driver.navigate().to(url);
//    }
}