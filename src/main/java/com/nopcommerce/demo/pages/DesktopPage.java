package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//h2[@class='title']//a[contains(text(),'Desktops')]")
    WebElement _deskTopLink;

    @FindBy(xpath = "//h2[@class='product-title']")
    List<WebElement> _productTitle;

    @FindBy(id = "products-orderby")
    WebElement _productOrderBy;

    @FindBy(xpath = "//input[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']")
    WebElement _addToCartButton1;

    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement _actualMessageBuildYourOwnComputer;

    //click on desktop Link
    public void clickDesktopLink() {
        Reporter.log("DeskTop Link Click " + _deskTopLink.toString() + "<br>");
        clickOnElement(_deskTopLink);
        log.info("Clicks on Desktop Link " + _deskTopLink.toString());
    }


    //sort by position "Name: Z to A"
    public void sortProductsOrderByZToA() {
        Reporter.log("Sorting Z TO A " + _productOrderBy.toString() + "<br>");
        selectByVisibleTextFromDropDown(_productOrderBy, "Name: Z to A");
        log.info("sorts Z To A " + _productOrderBy.toString());

        //Getting list of web elements of product name

       // List<WebElement> deskTopPCs = driver.findElements(_productTitle);

        //Declaring the String List to store product name
        List<String> deskTopNames = new ArrayList<>();

        for (WebElement deskTop : _productTitle) {
            deskTopNames.add(deskTop.getText());
        }
        System.out.println(deskTopNames);
        // Create the temp list of product name and sort it using Collections.sort method
        List<String> tempList = new ArrayList<>();
        tempList.addAll(deskTopNames);

        Collections.sort(tempList, Collections.reverseOrder());
        Assert.assertEquals(deskTopNames, tempList);
    }


    // This Method sorts Product by A To Z
    public void deskTopPageAction() {
        Reporter.log("Sorts Product AtoZ" + _productOrderBy.toString() + "<br>");
        waitFor(2);
        clickOnElement(_productOrderBy); // clicks on Sort dropDown
        selectByVisibleTextFromDropDown(_productOrderBy, "Name: A to Z");// selects AtoZ from dropdown
        log.info(" sorts AtoZ " + _productOrderBy.toString());
    }
     //This method clicks on Add to Cart Button
    public void clickonAddToCartBtn() {
        Reporter.log("Clicks on Add to Cart Button " + _addToCartButton1.toString() + "<br>");
        clickOnElement(_addToCartButton1);
        log.info("Clicks on Add to cart Button " + _addToCartButton1.toString());

    }
    //This method verifies Actual Message
    public String actualMessageBuildYourOwnDesktop() {
        Reporter.log("Actual Message on Build your commputer Page " + _actualMessageBuildYourOwnComputer + "<br>");
        log.info("Verify Actual Message " + _actualMessageBuildYourOwnComputer.toString());
        return getTextFromElement(_actualMessageBuildYourOwnComputer);
    }


    }
