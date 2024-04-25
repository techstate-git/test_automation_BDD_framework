/**
 * @author Aipo Misirali
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework
 * Tutor:
 */

/***************************************************/

package tech_state_cucumber.stepdefinitions;

import tech_state_cucumber.context.TestContext;
import tech_state_cucumber.domainobjects.Product;
import tech_state_cucumber.enums.EndPoint;
import tech_state_cucumber.factory.PageFactoryManager;
import tech_state_cucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StoreStepDefinitions {
    private final StorePage storePage;
    private final TestContext context;

    public StoreStepDefinitions(TestContext context){
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
        storePage.load(EndPoint.STORE.url);
    }

    @When("I add it again")
    public void iAddItAgain() {
        storePage.addToCart(context.product.getName());
    }

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        storePage.addToCart(product.getName());
    }
}
