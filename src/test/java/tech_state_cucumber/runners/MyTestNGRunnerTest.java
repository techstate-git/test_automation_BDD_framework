
package tech_state_cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		plugin = { 
				"html:target/cucumber/cucumber.html" ,
				"me.jvt.cucumber.report.PrettyReports:target/cucumber/"
		}, 
		glue = {"tech_state_cucumber"},
		// glue = {"awesomecucumber.stepdefinitions","awesomecucumber.hooks"},
		features = "src/test/resources/features",
		tags = "@smoke")
		//tags = "@regression")
		//tags = "@demo")
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {

	/**
	 * https://cucumber.io/docs/guides/parallel-execution/#testng
	 * 
	 * Cucumber can be executed in parallel using TestNG and Maven test execution
	 * plugins by setting the dataprovider parallel option to true.
	 * 
	 * In TestNG the scenarios and rows in a scenario outline are executed in
	 * multiple threads. One can use either Maven Surefire or Failsafe plugin for
	 * executing the runners.
	 **/

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}
}
