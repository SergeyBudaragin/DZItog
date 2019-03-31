import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"ru.aplana.autotest.steps"},
        tags = {"@all"},
        plugin = {"ru.aplana.autotest.utils.AllureListener"})
public class CucumberRunner {
}
