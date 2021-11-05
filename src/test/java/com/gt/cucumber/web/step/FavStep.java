package com.gt.cucumber.web.step;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.After;
import org.junit.AfterClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class FavStep {


            static ChromeDriver driver = new ChromeDriver();
            private String proName = null;
             @Given("User navigate to homepage")
             public void userNavigateToHomepage() {

                     driver.get("https://www.n11.com/");


                     WebElement loginBtn = driver.findElement(By.className("btnSignIn"));

                     Assertions.assertNotNull(loginBtn);

                     loginBtn.click();

                     WebElement element = driver.findElement(By.className("facebook_large"));

                     Assertions.assertNotNull(element);

                     element.click();
             }

                    @And("User login email as {string} and password as {string}")
                    public void userLoginEmailAsAndPasswordAs(String email, String pass) throws InterruptedException {
//                        ChromeOptions options = new ChromeOptions();
//                        options.addArguments("disable-blink-features=AutomationControlled");
//                        ChromeDriver driver = new ChromeDriver(options);

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
                @And("User navigate to Perfume-Deodorant under the Cosmetic-Personal Care tab")
                public void userNavigateToPerfumeDeodorantUnderTheCosmeticPersonalCareTab() throws Throwable{

                    Thread.sleep(3000);
                    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                    driver.switchTo().window(tabs.get(0));
                    Thread.sleep(5000);

                    WebElement menuItem =driver.findElementByPartialLinkText("Kozmetik");
                    menuItem.click();

                    WebElement secondMenuItem =driver.findElementByPartialLinkText("Parfüm & Deodorant");
                    secondMenuItem.click();
                }

            @And("User search for {string} in Brand filter")
            public void userSearchforInbrandFilter(String marka) {
                WebElement Search = driver.findElement(By.className("openSearchBtn"));
                Assertions.assertNotNull(Search);
                Search.click();
                WebElement markaInput = driver.findElement(By.className("attributeSearch"));
                Assertions.assertNotNull(markaInput);
                markaInput.sendKeys("Lacoste");

        };
            @And("^User select ‘Lacoste’")
                public void userSelect() {
                WebElement checkLacoste = driver.findElement(By.id("brand-m-Lacoste"));
                Assertions.assertNotNull(checkLacoste);
                checkLacoste.click();
        };


            @And("User click sevennth product on the search result page")
            public void userClickSevennthProductOnTheSearchResultPage() {
            WebElement parfumclick = driver.findElement(By.id("p-191390412"));
            Assertions.assertNotNull(parfumclick);
            parfumclick.click();
        }

            @And("User add product to the ‘Favorites’")
            public void userAddProductToTheFavorites() throws Throwable {
                Thread.sleep(3000);
                proName = driver.findElementByClassName("proName").getText();
                Thread.sleep(3000);
                WebElement favIkn = driver.findElement(By.id("getWishList"));
                Assertions.assertNotNull(favIkn);
                favIkn.click();
                Thread.sleep(3000);
                WebElement favBtn = driver.findElement(By.id("addToFavouriteWishListBtn"));
                favBtn.click();
        }

            @And("User navigate to Favorites")
            public void userNavigateToFavorites() {
                WebElement myaccount =driver.findElementByPartialLinkText("Hesabım");
                myaccount.click();

                WebElement favorites =driver.findElementByPartialLinkText("Favorilerim / Listelerim");
                favorites.click();

                WebElement favorite =driver.findElement(By.className("listItemTitle"));
                favorite.click();
        }

            @Then("User should be see the product title is the same as with the product details page")
            public void userShouldBeSeeTheProductTitleIsTheSameAsWithTheProductDetailsPage() throws Throwable {
                String productName =driver.findElement(By.className("productName")).getText();

                Assertions.assertEquals(proName,productName );

                driver.close();
            }
            }

