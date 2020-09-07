package Execution;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseDriver.AppDriver;
import Pages.Contactus;
import Pages.Dashboard;
import Utility.Verifylinks;

@Listeners(Listen.TestNG_Listeners.class)
public class TestCaseExecution extends AppDriver
{
     @Test(priority = 0)
     public void verifydashboard() throws InterruptedException
     {
    	 Dashboard  dbobj = new Dashboard();
    	 dbobj.MHproduct();
    	 Thread.sleep(3000);
    	 dbobj.EnterSearch("chandan");
     }
     @Test(priority = 1)
     public void vrflinks() throws IOException, InterruptedException
     {
    	 Verifylinks vlobj = new Verifylinks();
    	 vlobj.linktest();
     }
     @Test(priority = 2)
     public void verifycontactus() throws InterruptedException
     {
    	 Contactus  cuobj = new Contactus();
    	 cuobj.opencontactus();
    	 cuobj.EnterDetail("Chandan", "schandan@pisoftek.com",  "this is cscs test");
    	 cuobj.verifycaptcha();
    	 cuobj.clicksendbutton();
     }
}
