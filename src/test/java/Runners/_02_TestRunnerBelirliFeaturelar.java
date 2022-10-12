package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
   features ={"src/test/java/FeatureFiles/_01_Login.feature",
           "src/test/java/FeatureFiles/_02_Country.feature"},
        glue = {"StepDefinitions"},
        dryRun =false //true oldugunda testi calistirma sadece feature lara ait
                      // ait steplerin varligini kontrol eder
                      // false oldugunda ise testi calistirir
)
public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {


}
