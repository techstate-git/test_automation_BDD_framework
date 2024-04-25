/**
 * @author Aipo Misirali
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework
 * Tutor:
 */

package tech_state_cucumber.stepdefinitions;

import org.openqa.selenium.WebDriver;

import tech_state_cucumber.context.TestContext;
import tech_state_cucumber.domainobjects.BillingDetails;

public class MyStepDefinitions {
    private final WebDriver driver;
    private BillingDetails billingDetails;

    public MyStepDefinitions(TestContext context){

        driver = context.driver;
    }
}
