

/***************************************************/

package tech_state_cucumber.customtype;

import tech_state_cucumber.domainobjects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

	/**
	 * .* -> means all are allowed
	 */
	@ParameterType(".*")
	public Product product(String name) {
		return new Product(name.replace("\"", ""));
	}
}
