package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest",//hangi senaryolarda bu etiket varsa onlar ritualistically
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
        //plugin= {"html:target//cucumber-reports.html"}
)
public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}
