package com.harvestmark;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Aldi_Test extends iOS_Automation{
		
@Test
  public void Aldi() throws Exception {
	
	driver.manage().timeouts().implicitlyWait(350, TimeUnit.SECONDS);	
	
	String southportland ="SOUTH PORTLAND";
	  
	  System.out.println("iOS Test Started");  
	  
	  //iOS_Automation.iOS_Login.emialField("demo.derrimut@aldi.com");
	  //iOS_Automation.iOS_Login.passwordField("password");
	  //iOS_Automation.iOS_Login.sign_in_button();
	  
	  System.out.println("iOS Test Finished");
	  Thread.sleep(5000);
	  
	 
	  }


    }
	  
	 
  

