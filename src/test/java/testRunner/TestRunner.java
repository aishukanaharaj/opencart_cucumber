package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//Features/"}, // to execute all the feature file
					//features= {".//Features/Login.feature"}, //- to execute single feature file
					//features= {".//Features/LoginDDTExcel.feature"}, - to execute single feature file
					//features= {".//Features/Login.feature",".//Features/Registration.feature"}, //- to execute multiple feature file
					//features= {"@target/rerun.txt"},
					glue="stepDefinitions", //every step definitions file depends on hooks. so we specify package name here. s
					
					
					///plugins are useful for generating the report and execute failure scenarios
					//2 kind of reports - junit cucumber report. we can generate using -"pretty", "html:reports/myreport.html", 
					//when we run testrunner file assume some scenarios got failed. "rerun:target/rerun.txt", - this will capture the failed scenarios and in the next round it will  run those failed scenarios only
					//whenever that is running we have to enable //features= {"@target/rerun.txt"}, - this line 
					//we can see all the failed scenarios under target folder in return.txt. and comment this -//features= {".//Features/"},
					
							//features= {"@target/rerun.txt"}, //enable it when we need to run failed scenarios only
					plugin= {"pretty", "html:reports/myreport.html",  
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" //this is foe extent report
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods. checking all steps has associated methods in stepdefinition file and check the execution also. if true then it will check associated methods only not implementation
					monochrome=true,    // to avoid junk characters in output (console) when running feature file
					publish=true ,  // to publish report in cucumber server
					tags="@sanity"  // this will execute scenarios tagged with @sanity
					//tags="@regression"
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)
public class TestRunner {

		}
