package com.cybertek.tests;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Q9_12_Ziya {

    /*
Optional: If you want to to be a real selenium hero,
use @DataProvider for tests cases from 9
through 12.
Please use following documentation: https://testng.org/doc/documentationmain.html#parameters-dataproviders

Test case #9
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed:
“This page returned a 200 status code”
*/

    /*
Test case #10
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “301”.
Step 4. Verify that following message is displayed:
“This page returned a 301 status code”
 */


/*
Test case #11
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “404”.
Step 4. Verify that following message is displayed:
“This page returned a 404 status code”
*/

/*
Test case #12
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “500”.
Step 4. Verify that following message is displayed:
“This page returned a 500 status code”
 */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @DataProvider (name="testdata")
    public Object[][] getData(){

        Object[][] data = {

                //par1   par2
                {"200", "This page returned a 200 status code" },
                {"301", "This page returned a 301 status code" },
                {"404", "This page returned a 404 status code" },
                {"500", "This page returned a 500 status code" },
        };

        return data;
    }

    @Test (dataProvider = "testdata")
    public void test9_12(String par1, String par2){

        // Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        // Step 2. And click on “Status Codes”
        driver.findElement(By.linkText("Status Codes")).click();

        // Step 3. Then click status numbers using par1
        driver.findElement(By.linkText(par1)).click();

        // Step 4. Verify that following message is displayed: “This page returned a 200 status code”
        // Define our Expected result using par2
        String expectedResult = par2;
        System.out.println("expectedResult = " + expectedResult);

        // Get the text of web element as our actual result
        String text = driver.findElement(By.xpath("//p")).getText();
        String actualResult = text.substring(0, text.indexOf("."));
        // This page returned a 200 status code. For a definition and common list of HTTP status codes, go here

        System.out.println("actualResult = " + actualResult);

        //Verify
        Assert.assertEquals(actualResult, expectedResult,"Verify that "+ par2 +" status message is not displayed");
    }


}