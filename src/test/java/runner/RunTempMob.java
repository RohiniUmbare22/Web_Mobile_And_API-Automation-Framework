package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/resources/features",
        glue = "stepdef.Mob",
        tags = "@Mob",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"}// For report

)
public class RunTempMob {

}
