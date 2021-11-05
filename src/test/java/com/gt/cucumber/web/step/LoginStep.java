
package com.gt.cucumber.web.step;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LoginStep {


        static final ChromeDriver driver = new ChromeDriver();
        private String loginMail = null;
        private String username = "Leyla Meram";

        @Given("User navigate to the login page")
        public void userNavigateToTheLoginPage() throws Throwable {

            driver.get("https://www.n11.com/");

        }


        @And("User click login button")
        public void userClickLoginButton() throws Throwable {
            WebElement loginBtn = driver.findElement(By.className("btnSignIn"));

            Assertions.assertNotNull(loginBtn);

            loginBtn.click();
        }

        @And("User click login with Facebook button")
        public void userClickLoginWithFacebookButton() {
            WebElement element = driver.findElement(By.className("facebook_large"));

            Assertions.assertNotNull(element);

            element.click();
        }

        //@Parameters({"email","password"})
        //@Test
        @When("User enter the email as {string} and password as {string}")
        public void userEnterTheEmailAsAndPasswordAs(String email, String pass) throws InterruptedException {

            loginMail = email;
            Thread.sleep(3000);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            WebElement emailInput = driver.findElement(By.id("email"));
            WebElement passInput = driver.findElement(By.id("pass"));
            WebElement loginBtn = driver.findElement(By.name("login"));

            Assertions.assertNotNull(emailInput);
            Assertions.assertNotNull(passInput);
            Assertions.assertNotNull(loginBtn);

            emailInput.sendKeys(email);
            passInput.sendKeys(pass);

            loginBtn.click();
            Thread.sleep(3000);
            try {
                WebElement contBtn = driver.findElement(By.className("n00je7tq"));

                Assertions.assertNotNull(contBtn);

                contBtn.click();
            } catch (Exception ex) {
                System.out.println("Facebook already allowed...");
            }
        }

        @Then("User should see login mail")
        public void userShouldSeeLoginMail() throws Throwable {
            Thread.sleep(3000);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(5000);

            //WebElement loginUserLink = driver.findElementByPartialLinkText(loginMail);
            WebElement user_name = driver.findElementByPartialLinkText(username);

            //Assertions.assertEquals(loginMail, loginUserLink.getText());
            Assertions.assertEquals(username, user_name.getText());

            //driver.close();
        }













    @When("Write all the links at the footer to the text file")
    public void writeAllTheLinksAtTheFooterToTheTextFile() throws Throwable {

        BufferedWriter writer = new BufferedWriter(new FileWriter("footer.txt"));
        List<String> footerLinks = new ArrayList<>();
        WebElement elementByXPath =  driver.findElementByXPath("//*[@id='footer']");
        List<WebElement> aElements = ((RemoteWebElement) elementByXPath).findElementsByTagName("a");
        WebElement brandsAElement = null;
        for (WebElement aElement : aElements) {
            if (aElement.getText().equals("Markalar")) {
                brandsAElement = aElement;
            }

            String href = aElement.getAttribute("href");
            footerLinks.add(href);
            writer.write(href);
        }

        Assert.assertNotNull(brandsAElement);

        brandsAElement.click();

        Thread.sleep(1000);

        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentUrl);
        Assert.assertEquals(brandsAElement.getAttribute("href"), currentUrl);
        writer.flush();
        writer.close();
    }
    }

