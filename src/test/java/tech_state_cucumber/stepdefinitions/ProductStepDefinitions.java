/**
 * @author Aipo Misirali
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework
 * Tutor:
 */

package tech_state_cucumber.stepdefinitions;

import org.testng.Assert;

import tech_state_cucumber.context.TestContext;
import tech_state_cucumber.domainobjects.Product;
import tech_state_cucumber.factory.PageFactoryManager;
import tech_state_cucumber.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStepDefinitions {
	private final ProductPage productPage;
	private final TestContext context;

	public ProductStepDefinitions(TestContext context) {
		this.context = context;
		productPage = PageFactoryManager.getProductPage(context.driver);
	}

	@Given("I'm browsing {product}")
	public void iAmBrowsing(Product product) {
		productPage.load("/product/" + product.getName().replaceAll("\\s", "-") + "/");
		context.product = product;
	}

	@When("I add {int} quantity to the cart")
	public void iAddToTheCart(int quantity) {
		productPage.enterQuantity(quantity);
		productPage.addToCart();
	}

	@When("I add {int} quantity")
	public void iSelectQuantity(int quantity) {
		productPage.enterQuantity(quantity);
		productPage.pressAddToCartBtn();
		context.product = new Product();
		context.product.setQuantity(quantity);
	}

	@Then("I should see an error")
	public void iShouldSeeAnError() {
		Assert.assertEquals(productPage.getValidationMsg(), "Value must be greater than or equal to 1.");
		Assert.fail("Failing this step intentionally to check the screenshot attached int the Report");
	}

	@And("the selected quantity is {int}")
	public void theSelectedQuantityIs(int currentQuantity) {
		productPage.enterQuantity(currentQuantity);
	}

	@When("I use {word} arrow to change the quantity")
	public void iUseDirectionArrowToChangeTheQuantity(String direction) {
		context.product = new Product();
		context.product.setQuantity(productPage.updateQuantityUsingArrows(direction));
	}

	@Then("the selected quantity changes to {int}")
	public void theSelectedQuantityChangesToNewQuantity(int newQuantity) {
		Assert.assertEquals(context.product.getQuantity(), newQuantity);
	}

	@Then("I should see the banner with text {string}")
	public void iShouldSeeTheBannerWithTxt(String text) {
		Assert.assertTrue(productPage.getBannerTxt().contains(text),
				"Expected: " + text + ", ACTUAL: " + productPage.getBannerTxt());
	}
}
