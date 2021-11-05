package com.gt.cucumber.web.step;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class locationStep {


    static final ChromeDriver driver = new ChromeDriver();
    String proOption = null;
    String disOption = null;
    @Given("User click on the homepage")
    public void userClickontheHomepage() throws Throwable {

        driver.get("https://www.n11.com/");

    }

    @And("Select the random province and district")
    public void selectTheRandomProvinceAndDistrict() throws InterruptedException {
        Thread.sleep(2000);
        WebElement konum1 = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[1]/div[1]/span"));
        konum1.getText().equals("Konum Belirle");
        konum1.click();
        Thread.sleep(2000);
        //WebElement popup = driver.findElement(By.className("myLocationMenu hOpenMenu"));
        Select province = new Select(driver.findElementById("headerMyLocationCityId"));
        province.selectByVisibleText("İstanbul");
        proOption = province.getFirstSelectedOption().getText();
        Thread.sleep(2000);
        Select district = new Select(driver.findElementById("headerMyLocationDistrictId"));
        district.selectByVisibleText("Üsküdar");
        disOption = district.getFirstSelectedOption().getText();
        Thread.sleep(2000);


    }
    @And("User click the select location")
    public void userClickTheSelectLocation() {
        WebElement konumsec = driver.findElementById("headerSetMyLocationBtn");
        Assertions.assertNotNull(konumsec);
        konumsec.click();
       // WebElement selectlocation = driver.findElementById("headerSetMyLocationBtn");
        //Assertions.assertNotNull(selectlocation);
        //selectlocation.click();
    }


    @When("User write the search box {string}")
    public void userWriteTheSearchBoxShoes(String ayakkabi) throws InterruptedException {
        Thread.sleep(3000);
        WebElement search = driver.findElementById("searchData");
        Assertions.assertNotNull(search);
        search.sendKeys("Ayakkabı");

    }

    @And("User click search button")
    public void userClickSearchButton() throws InterruptedException {
        Thread.sleep(3000);

        WebElement searchikon = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[1]/div/a/span"));
        Assertions.assertNotNull(searchikon);
        searchikon.click();
    }

    @Then("Verify location")
    public void verifyLocation() throws InterruptedException {
        Thread.sleep(3000);
        //WebElement locationname = driver.findElementByPartialLinkText(province1+"/"+district1);
        WebElement locationname = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[1]/div[1]/span"));
        //WebElement locationname =driver.findElement(By.className("menuLink pin  "));
        //WebElement loca = driver.findElementByPartialLinkText("İstanbul / Üsküdar");
        Thread.sleep(3000);
        String loc = locationname.getText();
       //String fullLocation = proOption+" / "+disOption;
        Assertions.assertEquals(proOption+" / "+disOption,loc);

    }
}