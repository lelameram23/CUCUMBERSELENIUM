package com.gt.cucumber.web.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrandsStep {

    //WebElement brandsAElement = null;
    //BufferedWriter writer = new BufferedWriter(new FileWriter("footer.txt"));;

    //public BrandsStep() throws IOException {
    //}
    /*
    //WebDriver driver;
//    @When("Write all the links at the footer to the the text file")
//    public void writeAllTheLinksAtTheFooterToTheTextFile() throws Throwable {
//        ChromeDriver driver = new ChromeDriver();
//        writer = new BufferedWriter(new FileWriter("footer.txt"));
//        List<String> footerLinks = new ArrayList<>();
//        WebElement elementByXPath =  driver.findElementByXPath("//*[@id='footer']");
//        List<WebElement> aElements = ((RemoteWebElement) elementByXPath).findElementsByTagName("a");
//        for (WebElement aElement : aElements) {
////            if (aElement.getText().equals("Markalar")) {
////                brandsAElement = aElement;
////            }
//            String href = aElement.getAttribute("href");
//            footerLinks.add(href);
//            writer.write(href);
//        }
//        @When("Write all the links at the footer to {string}")
//        public void writeAllTheLinksAtTheFooterTo() throws Throwable {
//            ChromeDriver driver = new ChromeDriver();
//            writer = new BufferedWriter(new FileWriter("footer.txt"));
//            List<String> footerLinks = new ArrayList<>();
//            WebElement elementByXPath =  driver.findElementByXPath("//*[@id='footer']");
//            List<WebElement> aElements = ((RemoteWebElement) elementByXPath).findElementsByTagName("a");
//            for (WebElement aElement : aElements) {
////            if (aElement.getText().equals("Markalar")) {
////                brandsAElement = aElement;
////            }
//                String href = aElement.getAttribute("href");
//                footerLinks.add(href);
//                writer.write(href);
//            }
//            //String writer1 = BufferedWriter.toString(writer);
//        }

//        @And("User click Brands Link")
//        public void userClickBrandsLink() throws Throwable{
////        ChromeDriver driver = new ChromeDriver();
//        Thread.sleep(3000);
//        WebElement brandsAElement = driver.findElementByPartialLinkText("Markalar");
//        brandsAElement.click();
//        Assert.assertNotNull(brandsAElement);
//        brandsAElement.click();
//
//    }
//
////    @Then("User should see {string} link inside the {string}")
////    public void userShouldSeeBrandsLinkInsideTheTextFile(WebElement brandsAElement, BufferedWriter writer) throws Throwable {
////
////    }
//
//    @Then("User should see {string} link inside {string}")
//    public void userShouldSeeLinkInside(WebElement brandsAElement, BufferedWriter writer) throws Throwable{
//        Thread.sleep(2000);
//        String currentUrl = driver.getCurrentUrl();
//
//        System.out.println(currentUrl);
//        Assert.assertEquals(brandsAElement.getAttribute("href"), currentUrl);
//        writer.flush();
//        writer.close();
//    }


    @When("Write all the links at the footer to the text file")
    public void writeAllTheLinksAtTheFooterToTheTextFile() throws IOException {

        List<String> footerLinks = new ArrayList<>();
        WebElement elementByXPath =  LoginStep.driver.findElementByXPath("//*[@id='footer']");
        List<WebElement> aElements = ((RemoteWebElement) elementByXPath).findElementsByTagName("a");
        for (WebElement aElement : aElements) {
//            if (aElement.getText().equals("Markalar")) {
//                brandsAElement = aElement;
//            }
            String href = aElement.getAttribute("href");
            footerLinks.add(href);
            writer.write(href);
        }
    }

    @And("User click Brands Link")
    public void userClickBrandsLink() throws InterruptedException {
        //        ChromeDriver driver = new ChromeDriver();
        Thread.sleep(3000);
        brandsAElement = LoginStep.driver.findElementByPartialLinkText("Markalar");
        Assert.assertNotNull(brandsAElement);
        brandsAElement.click();

    }


    @Then("User should see Brands link inside the text file")
    public void userShouldSeeBrandsLinkInsideTheTextFile() throws InterruptedException, IOException {
                Thread.sleep(2000);
        String currentUrl = LoginStep.driver.getCurrentUrl();

        System.out.println(currentUrl);
        Assert.assertEquals(brandsAElement.getAttribute("href"), currentUrl);
        //writer.flush();
        writer.close();
    }*/
}
