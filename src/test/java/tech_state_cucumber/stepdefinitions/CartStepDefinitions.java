/**
 * @author Aipo Misirali
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework
 * Tutor:
 */

/***************************************************/

package tech_state_cucumber.stepdefinitions;

import org.testng.Assert;

import tech_state_cucumber.apis.CartApi;
import tech_state_cucumber.context.TestContext;
import tech_state_cucumber.domainobjects.Product;
import tech_state_cucumber.factory.PageFactoryManager;
import tech_state_cucumber.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CartStepDefinitions {
	private final CartPage cartPage;
	private final TestContext context;

	public CartStepDefinitions(TestContext context) {
		this.context = context;
		cartPage = PageFactoryManager.getCartPage(context.driver);
	}

	@Then("I should see {int} {product} in the cart")
	public void iShouldSeeInTheCart(int quantity, Product product) {
		Assert.assertEquals(product.getName(), cartPage.getProductName());
		Assert.assertEquals(quantity, cartPage.getProductQuantity());
	}

	@And("I have {int} {product} in the cart")
	public void iHaveInTheCart(int quantity, Product product) throws Exception {
//        storePage.addToCart("Blue Shoes");
//		CartApi cartApi = new CartApi(context.cookies.get());
		CartApi cartApi = new CartApi(context.cookies.getCookies());
		product = context.productList.getProductByName(product.getName());
		cartApi.addToCart(product.getId(), quantity);
		// context.cookies.set(cartApi.getCookies());
		context.cookies.setCookies(cartApi.getCookies());
		context.cookies.injectCookiesToBrowser(context.driver);
		context.product = product;
	}
}
