# tech_state_Framework_BDD

------------------------------------------------------------
**Framework features:**
1. Uses Domain objects
2. Support multiple Runners - TestNG, JUnit, CLI
3. Uses Dependency Injection Framework
4. Supports parallel execution
5. Uses API to setup the Application state
6. Captures screenshot on Scenario Failure
7. Supports command line execution using Maven
8. Supports CI/CD integration
------------------------------------------------------------
-----------------------------------------------------------
**Screenshot on failure to Reports** 
-----------------------------------------------------------
**Execution**
1. mvn clean test (This will execute with default env (Stg) and browser (Edge))
2. mvn clean test -Denv=INT -Dbrowser=firefox (his will execute with on Int and Firefox browser)
3. mvn clean test -Denv=INT -Dbrowser=firefox -Dcucumber.filter.tags@smoke (This will execute with on Int and Firefox browser and scenarios tagged as smoke)
------------------------------------------------------------

