/**
 * @author Aipo Misirali
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework
 * Tutor:
 */

/***************************************************/

package tech_state_cucumber.stepdefinitions;

import tech_state_cucumber.context.TestContext;
import tech_state_cucumber.domainobjects.BillingDetails;
import tech_state_cucumber.enums.EndPoint;
import tech_state_cucumber.factory.PageFactoryManager;
import tech_state_cucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CustomerStepDefinitions {
	private final TestContext context;
	private final StorePage storePage;

	public CustomerStepDefinitions(TestContext context) {
		this.context = context;
		storePage = PageFactoryManager.getStorePage(context.driver);
	}

	@And("my billing details are")
	public void myBillingDetailsAre(BillingDetails billingDetails) {
		context.billingDetails = billingDetails;
	}

	@Given("I'm a guest customer")
	public void iMAGuestCustomer() {
		// storePage.load(FrameworkConstants.STORE);
		storePage.load(EndPoint.STORE.url);

	}
}
