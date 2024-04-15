package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

	 WebDriver driver;
	 Properties p;
     
	@Before
    public void setup() throws IOException
    {
    	driver=BaseClass.initilizeBrowser();   //it will return the initialize driver
    	    	
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().window().maximize();
    
    			
	}
		
    
    @After
    public void tearDown(Scenario scenario) {
        		
       driver.quit();
       
    }
    

    @AfterStep
    public void addScreenshot(Scenario scenario) { //Scenario is predefined class
        
    	// this is for cucumber junit report
    	//if scenario got failed then only it will capture screen shot.and this screenshot sutomatically attach to report
        if(scenario.isFailed()) {   
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);// we take output as Byte format. so we store in byte array
        	scenario.attach(screenshot, "image/png",scenario.getName()); //attaching the screenshot in png format by getting the scenerio name
        	            
        }
      
    }
   
}
