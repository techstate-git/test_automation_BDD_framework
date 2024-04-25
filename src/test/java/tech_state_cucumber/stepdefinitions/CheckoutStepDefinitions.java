/**
 * @author Aipo Misirali
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework
 * Tutor:
 */

/***************************************************/

package tech_state_cucumber.stepdefinitions;

import org.testng.Assert;

import tech_state_cucumber.context.TestContext;
import tech_state_cucumber.enums.EndPoint;
import tech_state_cucumber.factory.PageFactoryManager;
import tech_state_cucumber.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepDefinitions {
    private final TestContext context;
    private final CheckoutPage checkoutPage;

    public CheckoutStepDefinitions(TestContext context){
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
    	/*
		 * context.billingDetails -> We are using the same billing details set in
		 * CustomerStepDefinitions (Method: myBillingDetailsAre())
		 */
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }
}
