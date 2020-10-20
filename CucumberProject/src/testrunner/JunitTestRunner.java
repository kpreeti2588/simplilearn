package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				features="classpath:features",
				glue="stepdefinitions",
				//tags="@smoke"
			    //tags="~@smoke"
			    //tags="@reg"
				//tags="@datadriven"
				//tags={"@smoke","@datadriven"} // it is & combination of two tags
				//tags={"@smoke,@datadriven"} // it is OR operation
				tags={"@datadriven"}
		)

public class JunitTestRunner {

}
