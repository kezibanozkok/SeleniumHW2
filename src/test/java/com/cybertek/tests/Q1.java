package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q1 {

    /*

    Test case #1
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter “wrong_dob” into date of birth input box.
    Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        WebElement registrationFormLink = driver.findElement(By.xpath("//a[.= 'Registration Form']"));
        registrationFormLink.click();

        //Step 3. Enter “wrong_dob” into date of birth input box.
        WebElement dateOfBirth = driver.findElement(By.name("birthday"));
        dateOfBirth.sendKeys("wrong_dob");



    }

}
