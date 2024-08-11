package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(extraGlue = {"junit:target_junit/cucumber.xml"},
        glue = {"src/com.teststeps.TestSteps"},
        features = {"Feature"},
        dryRun = true,
//        strict = true,
//        tags = {},
        monochrome = true)

class RunTest {
}


