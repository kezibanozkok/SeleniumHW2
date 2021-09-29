package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q6_12 {

    WebDriver driver;
    Faker faker= new Faker();

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
        Step 1. Go to "https://www.tempmailaddress.com/"
        Step 2. Copy and save email as a string.
        Step 3. Then go to “https://practice- cybertekschool.herokuapp.com”
        Step 4. And click on “Sign Up For Mailing List".
        Step 5. Enter any valid name.
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
        //Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com/");

        //Step 2. Copy and save email as a string.
        String email= driver.findElement(By.id("email")).getText();

        //Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.xpath("//a[.='Sign Up For Mailing List']")).click();

        //Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys(faker.name().fullName());

        //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys(email);

        //Step 7. Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();

        // Step 8. Verify that following message is displayed: “Thank you for signing up.
        // Click the button below to return to the home page.”
        String actual = driver.findElement(By.name("signup_message")).getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actual,expected,"following message is NOT displayed");

        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com/");

        //Step 10. Verify that you’ve received an email from
        //  “do-not-reply@practice.cybertekschool.com”
        ////Step 11. Click on that email to open it.
        driver.findElement(By.xpath("//table//td[2]")).click();

        //Step 12. Verify that email is from: “do-not- reply@practice.cybertekschool.com”
        String actualMessage= driver.findElement(By.id("odesilatel")).getText();

        String expectedMessage= "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualMessage,expectedMessage,"following message is NOT displayed");

        // Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        String actualMessage1= driver.findElement(By.id("predmet")).getText();

        String expectedMessage1= "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualMessage1,expectedMessage1,"following message is NOT displayed");


    }
}
