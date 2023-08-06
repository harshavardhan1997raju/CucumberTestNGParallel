package parallel;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="@target/failedCases/failedRerun.txt",
        glue= {"parallel"},
        monochrome=false,
//       dryRun = true,
        plugin= {"pretty", "html:target/HTMLReports/HTMLReports.html",
                "json:target/JSONReports/JSONReports.json",
                "junit:target/JUNITReports/JUNITReports.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread",
                "rerun:target/failedCases/failedRerun.txt"
        }
//       tags = "@acc"


)

public class FailedRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {

                return super.scenarios();
        }
}
