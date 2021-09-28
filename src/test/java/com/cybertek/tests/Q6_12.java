package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q6_12 {

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
    public void test6() {
        /*
        Test case #6
        Step 1. Go to "https://www.tempmailaddress.com/" Step 2. Copy and save email as a string.
        Step 3. Then go to “https://practice- cybertekschool.herokuapp.com”
        Step 4. And click on “Sign Up For Mailing List". Step 5. Enter any valid name.
        Step 6. Enter email from the Step 2.
        Step 7. Click Sign Up
        Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
        Step 9. Navigate back to the “https:// www.tempmailaddress.com/”
        Step 10. Verify that you’ve received an email from
        “do-not-reply@practice.cybertekschool.com”
        Step 11. Click on that email to open it.
        Step 12. Verify that email is from: “do-not- reply@practice.cybertekschool.com”
        Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
         */

    }
}
