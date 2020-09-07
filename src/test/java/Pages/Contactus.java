package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseDriver.AppDriver;

public class Contactus extends AppDriver
{
	Actions act;
        public Contactus()
        {
        	PageFactory.initElements(driver, this);
        }

           @FindBy(xpath = "//div[@class='span2']//a[contains(text(),'Contact Us')]")  WebElement contact;
           @FindBy(xpath = "//*[@id='contact']/div[2]/div[1]/div/input") WebElement name;
           @FindBy(xpath = "//*[@id='contact']/div[2]/div[2]/div/input")  WebElement email;
           @FindBy(xpath = "//*[@id='contact']/div[2]/div[3]/div/textarea")  WebElement inequiry;
          
           @FindBy(xpath = "//*[@id='contact']/div[2]/div[4]/div/div[2]/a/span")  WebElement contiue;
           
    public void opencontactus() throws InterruptedException
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	Thread.sleep(2000);
    	contact.click();
    	log.info("Contact Us page opned");
    	System.out.println("Contact Us page opned");
    }
    
    public void EnterDetail(String nam, String emal, String detail) throws InterruptedException
    {
    	
    	Thread.sleep(2000);
    	name.clear();
    	name.sendKeys(nam);
    	log.info("Name has been entered");
    	System.out.println("Name has been entered");
    	email.clear();
    	email.sendKeys(emal);
    	log.info("Emails has been entered");
    	System.out.println("Emails has been entered");
   
    	inequiry.clear();
    	inequiry.sendKeys(detail);
    	log.info("inequiry has been entered");
    	System.out.println("inequiry has been entered");
    }
    public void verifycaptcha() throws InterruptedException
    {
    	
    	if(driver.findElement(By.xpath("//*[@id='contact']/div[2]/div[4]/div/input")).isDisplayed())
    	{
    		System.out.println("Please Enter the capta manually");
    		Thread.sleep(15000);
    	}
    	
    	
    }
    public void clicksendbutton()
    {
    	contiue.click();
    	log.info("send msg  button clicked");
    	System.out.println("send msg  button clicked");
    	driver.switchTo().defaultContent();
    }
    
    
}
