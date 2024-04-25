


package tech_state_cucumber.context;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import tech_state_cucumber.domainobjects.BillingDetails;
import tech_state_cucumber.domainobjects.Cookies;
import tech_state_cucumber.domainobjects.Product;
import tech_state_cucumber.domainobjects.ProductList;
import tech_state_cucumber.utils.JacksonUtils;

public class TestContext {
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;
    public ProductList productList = new ProductList();
    public Product product;

    /**
	 * Dependency Injection using Pico container
	 */
    public TestContext() throws IOException {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
        productList.addAllProducts(JacksonUtils.deserializeJson("products.json", Product[].class));
    }
}
