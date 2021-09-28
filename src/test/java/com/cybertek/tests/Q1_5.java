package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q1_5 {

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
        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. Click on “Registration Form”
        WebElement registrationFormLink = driver.findElement(By.xpath("//a[.= 'Registration Form']"));
        registrationFormLink.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {


        //Step 3. Enter “wrong_dob” into date of birth input box.
        WebElement dateOfBirth = driver.findElement(By.name("birthday"));
        dateOfBirth.sendKeys("wrong_dob");

        WebElement errorMessage = driver.findElement(By.xpath("//input[@name='birthday']/following-sibling::small[2]"));
        String actualMessage = errorMessage.getText();

        Assert.assertEquals(actualMessage, "The date of birth is not valid", "Verify failed");

    }
      /*
    Test case #3
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into first name input box.
Step 4. Verify that warning message is displayed:
“first name must be more than 2 and less than 64 characters long”
     */

    @Test
    public void test3(){
        driver.findElement(By.name("firstname")).sendKeys("a");

        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//small[@data-bv-for='firstname'][2]")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"warning messages are not as expected");

    }
    /*
    Test case #4
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
       Step 2. Click on “Registration Form”
       Step 3. Enter only one alphabetic character into last name input box.
      Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void test4(){
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("A");
        String expectedResult="The last name must be more than 2 and less than 64 characters long";

        String actualResult = driver.findElement(By.xpath("(//small[@class='help-block'])[6]")).getText();
        Assert.assertEquals(actualResult,expectedResult,"warning message is NOT displayed");


    }

}
