package TestRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\Features",
        glue = {"StepDefinitions"},
        //plugin = {"pretty","jason:target/cucumber--reports/cucumber.json"},
         //plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber-json-report.json" },
        //plugin = {"pretty", "json:target/jsonReports/cucumber.json","html:target/site/cucumber-pretty" },
        plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty" },
        monochrome=true

)
public class CucumberRunner
{
}
