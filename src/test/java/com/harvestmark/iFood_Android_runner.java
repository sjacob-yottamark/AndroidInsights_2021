package com.harvestmark;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
//import io.appium.java_client.PerformsTouchActions;
//import io.appium.java_client.TouchAction;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class iFood_Android_runner extends iFood_Android{
		
@Test
  public void Delhaize() throws Exception {
	
	driver.manage().timeouts().implicitlyWait(350, TimeUnit.SECONDS);	
	
	String supplier_name = "ARROW FARMS INC";
	String brand_name = "* Brand Name";
	String weight= "Weight";
	String tempF = "* Temperature (°F)";
	String comments = "Comments";
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();
	
	
	LocalDateTime end = LocalDateTime.now();
	
	
	System.out.println(dtf.format(now) + " iFood Test Started" );  
	
	Thread.sleep(8000);
	
	iFood_Android.AllowButton();
	
	
	  System.out.println("Delhaize Test Started");  
	  iFood_Android.iFood_Login.emialField("harvestSal");
	  iFood_Android.iFood_Login.passwordField("harvestSal1");
	  iFood_Android.iFood_Login.sign_in_button();
	  Thread.sleep(10000);
	  
	  /**
	  
	  WebDriverWait waitsync = new WebDriverWait(driver, 300);
	  System.out.println("Waiting for Sync to Finish");
	  waitsync.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.trimble.harvestmark.insights:id/locationListView")));
	  driver.findElement(By.xpath("//*[contains(@text, '54 Hemco Rd')]")).click();
	  Thread.sleep(2000);
      Android_Automation.HomePage.orderDataIcon();
      Thread.sleep(2000);
      WebDriverWait waitorderdata = new WebDriverWait(driver, 300);
	  System.out.println("Waiting for Order Data Download to Finish");
	  waitorderdata.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.TextView")));
	  String odmsg = driver.findElement(By.className("android.widget.TextView")).getText();
	  System.out.println("Printing Order Data Message " + odmsg);
	  Thread.sleep(2000);
	  Android_Automation.oKButton();
	  Thread.sleep(2000);
	  Android_Automation.HomePage.startNewButton();
	  Thread.sleep(2000);
	  Android_Automation.ContainerScreen.supplierSelection();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[contains(@text, 'ARROW FARMS INC')]")).click();
      //Android_Automation.ContainerScreen.firstSupplier(1);
      Thread.sleep(2000);
      Android_Automation.ContainerScreen.pOSelection();
      Thread.sleep(2000);
      Android_Automation.ContainerScreen.firstPo(2); // index 2 is first PO
      Thread.sleep(2000);
      Android_Automation.ContainerScreen.startInspection();
      Thread.sleep(2000);
      Android_Automation.ProductScreen.productSelection(1);
      
      /**
      Android_Automation.RatingScreen.ApprovalRatingsIcon();
      Android_Automation.RatingScreen.ProductDefects(1);
      Android_Automation.RatingScreen.numeratorInput("1.5");
      Android_Automation.RatingScreen.denominatorInput("100");
      Android_Automation.RatingScreen.InputDone();

      Android_Automation.RatingScreen.ProductDefects(2);
      Android_Automation.RatingScreen.numeratorInput("8.8");
      Android_Automation.RatingScreen.denominatorInput("100");
      Android_Automation.RatingScreen.InputDone();

      Android_Automation.RatingScreen.ProductDefects(3);
      Android_Automation.RatingScreen.numeratorInput("10.5");
      Android_Automation.RatingScreen.denominatorInput("100");
      Android_Automation.RatingScreen.InputDone();
 
      Android_Automation.RatingScreen.DefectsDone();
      
      //Thread.sleep(5000);
      //Android_Automation.RatingScreen.SelectOrigin(1);
      
      Thread.sleep(2000);
      Android_Automation.scroolToText(brand_name);
      Thread.sleep(2000);
      Android_Automation.RatingScreen.BrandNameInput("Automation QA Brand");
      Thread.sleep(2000);
      Android_Automation.scroolToText(weight);
      Thread.sleep(2000);
      Android_Automation.RatingScreen.WeightInput("40");
      Thread.sleep(2000);
      Android_Automation.RatingScreen.Units(2);
      //Thread.sleep(2000);
      //Android_Automation.scroolToText(tempF);
      //Thread.sleep(2000);
      //Android_Automation.RatingScreen.TempFInput("35");
      Thread.sleep(2000);
      Android_Automation.scroolToText(comments);
      Thread.sleep(2000);
      Android_Automation.RatingScreen.CommentsInput("Comments Automation Testing");
      Thread.sleep(2000);
      Android_Automation.RatingScreen.NextSample();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.NextSample();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.BackSample();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.NextSample();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.FinishInspection();
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.ExpandFirstAudit();
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.ModifyInspection();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.BackSample();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.FinishInspection();
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.ExpandFirstAudit(); 
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.ChangeStatus();
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.SelectInspectionStatus(3);
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.UNExpandFirstAudit(); 
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.FinishInspection();
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.ScoreNoMatchFinishAnyWay();
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.SubmitInspectionOK();
      Thread.sleep(2000);
      Android_Automation.ContainerScreen.backButton();
      
      **/
      
      
      System.out.println(dtf.format(end) + " iFood Test" ); 
        
	  }     
  } 
  

