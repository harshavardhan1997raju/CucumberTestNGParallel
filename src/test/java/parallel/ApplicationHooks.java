package parallel;

import com.qa.factory.DriverFactory;

import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.sql.*;
import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    private Connection con;
    Properties prop;

   /* @BeforeAll
    public void connectDB() throws SQLException {
         con= DriverManager.getConnection("jdbc:mysql://localhost/hr","root","root");

        Statement stmt=con.createStatement();
        String s="select * from employees";
        stmt.execute(s);
    }
    @AfterAll
    public void closeDBConnection() throws SQLException {
        con.close();
    }*/



    @Before(order = 0)
    public void getBrowserFromProperty(){
        configReader =new ConfigReader();
        prop=configReader.init_properties();
    }

    @Before(order = 1)
    public void launchbrowser(){
       String browserName=prop.getProperty("browser");
       driverFactory=new DriverFactory();
       driver=driverFactory.init_driver(browserName);

    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void takeFailedScreenShot(Scenario scenario){
        if(scenario.isFailed()){
            //take ScreenShot
            String screenshotName=scenario.getName().replaceAll(" ","_");
            TakesScreenshot ss=(TakesScreenshot)driver;
            byte[] fileTaken=ss.getScreenshotAs((OutputType.BYTES));
           scenario.attach(fileTaken,"image/png",screenshotName);
        }

    }


}
