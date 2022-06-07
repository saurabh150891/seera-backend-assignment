package cucumber.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/* TestRunner controls the execution of Test Cases.
By default all the test cases are going to get executed.
HTML/JSON/XML reports are generated under target location
To view HTML report, index.html file can be viewed under target/cucumber-reports/cucumber.html*/


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        plugin = {"summary",
                "pretty",
                "json:target/cucumber-reports/cucumber.json", "junit:target/cucumber-reports/cucumber.xml", "html:target/cucumber-reports/cucumber.html"},
        glue = {"StepDefinitions"},

//        To run all the cases under PostAsyncSearchAPI.feature, use the annotation @PostAsyncSearchAPI
//        To run all the cases under GetAutoCompleteAPI.feature, use the annotation @GetAutoCompleteAPI
//        To run all the test cases send tags as empty

        tags = {""})
public class TestRunner {
}
