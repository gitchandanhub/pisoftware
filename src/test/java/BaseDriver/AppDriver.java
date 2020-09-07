package BaseDriver;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class AppDriver 
{
	 public static WebDriver driver = null;
     public static Properties config = new Properties();
     public static Logger log=Logger.getLogger("devpinoyLogger");
     public static ExtentHtmlReporter htmlreporter;
     public static ExtentReports extentreport;
     public static ExtentTest extenttest; 
     @BeforeTest
      public void Initialize() throws Exception {
    	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	    LocalDateTime now = LocalDateTime.now();  
    	    String x = dtf.format(now);
    	   htmlreporter = new ExtentHtmlReporter("D:\\Software\\Phantom_workspace\\PisoftwareSimple\\ExtentReport\\piresult.html");
    	  //htmlreporter = new ExtentHtmlReporter(config.getProperty("ExtentReport_path")+"Steriaresult"+dtf.format(now)+".html");
    	     
    	     htmlreporter.config().setEncoding("utf-8");
    	     htmlreporter.config().setDocumentTitle("Automation Test");
    	     htmlreporter.config().setReportName("Automation result");
    	     htmlreporter.config().setTheme(Theme.STANDARD);      
    	      extentreport = new ExtentReports();
    	      extentreport.setSystemInfo("Organization", "pisofteware");    
    	    extentreport.attachReporter(htmlreporter);    
    	  FileInputStream fis = new FileInputStream("D:\\Software\\Phantom_workspace\\PisoftwareSimple\\src\\test\\java\\Property\\config.properties");
    	  config.load(fis);
    	  if(config.getProperty("BrowserName").equalsIgnoreCase("Chrome"))
    	  {
    		  System.setProperty("webdriver.chrome.driver", config.getProperty("ChromeDriver_path"));
              System.setProperty("webdriver.chrome.silentOutput", "true");
    		  driver = new ChromeDriver();
    	  }
    	  else  if(config.getProperty("BrowserName").equalsIgnoreCase("Firefox"))
          {
       	   System.setProperty("webdriver.gecko.driver", config.getProperty("FireFoxDriver_path"));
       	   driver = new FirefoxDriver();
          }
          else  if(config.getProperty("BrowserName").equalsIgnoreCase("IE"))
          {
       	   System.setProperty("webdriver.internetExplorer.driver", config.getProperty("InternetExplorerpath"));
       	   driver = new InternetExplorerDriver();
          }
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          driver.navigate().to(config.getProperty("URL"));
      }
      
      @AfterTest
      public void close()
      {
    	  extentreport.flush();
    	 // driver.quit();
      }
}
