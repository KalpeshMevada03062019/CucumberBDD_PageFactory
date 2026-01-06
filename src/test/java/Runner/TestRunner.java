package Runner;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.*;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value="StepsDefination")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value="\"pretty,\" +\r\n"
		+ "                \"html:target/reports/html/cucumber.html,\" +\r\n"
		+ "                \"json:target/reports/json/cucumber.json,\" +\r\n"
		+ "                \"junit:target/reports/xml/cucumber.xml\"")

/* -------- PARALLEL EXECUTION-------- */
@ConfigurationParameter(
       key = "cucumber.execution.parallel.enabled",
       value = "true"
)
@ConfigurationParameter(
       key = "cucumber.execution.parallel.config.strategy",
       value = "fixed"
)
@ConfigurationParameter(
       key = "cucumber.execution.parallel.config.fixed.parallelism",
       value = "2"
)

public class TestRunner {
	
}
