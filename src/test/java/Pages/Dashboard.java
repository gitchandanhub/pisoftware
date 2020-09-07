package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseDriver.AppDriver;

public class Dashboard extends AppDriver
{
	Actions act;
        public Dashboard()
        {
        	PageFactory.initElements(driver, this);
        }
        
        @FindBy(xpath = "//input[@placeholder='Search']")  WebElement searchbox;
        @FindBy(xpath = "//*[@id='menu']/div/div/div/ul/li[1]/a")  WebElement product;
        @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Services')]")  WebElement Services;
        
        
        public void EnterSearch(String text)
        {
        	searchbox.clear();
        	searchbox.sendKeys(text);
        	log.info("Text in searchbox entered");
        	System.out.println("Text in searchbox entered");
        }
        
        public void MHproduct()
        {
             act =  new Actions(driver);
        	act.moveToElement(product).build().perform();
        	log.info("Mouse hover on product tab");
        	System.out.println("Mouse hover on product tab");
        }
        
        public void MhServices()
        {
        	act =  new Actions(driver);
        	act.moveToElement(Services).build().perform();
        	log.info("Mouse hover on Service tab");
        	System.out.println("Mouse hover on Service tab");
        }
}
