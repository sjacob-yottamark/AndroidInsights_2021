package com.harvestmark;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class Delhaize_Test extends Android_Automation{
		
@Test
  public void Delhaize() throws Exception {
	
	driver.manage().timeouts().implicitlyWait(350, TimeUnit.SECONDS);	

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now();
	
	System.out.println(dtf.format(now) + " Delhaize Test Started" );  
	
	  System.out.println("Delhaize Test Started");  
	  Android_Automation.Android_Login.emialField("user@delhaize.com");
	  Android_Automation.Android_Login.passwordField("password");
	  Android_Automation.Android_Login.sign_in_button();
	  Thread.sleep(2000);
	  WebDriverWait waitsync = new WebDriverWait(driver, 300);
	  System.out.println("Waiting for Sync to Finish");
	  waitsync.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.trimble.harvestmark.insights:id/locationListView")));
	  driver.findElement(By.xpath("//*[contains(@text, '54 Hemco Rd')]")).click();
	  Thread.sleep(2000);
	  Android_Automation.HomePage.SettingsIcon();
	  Thread.sleep(2000);
	  Android_Automation.SettingsScreen.DaysBeforeDropDown();
	  Thread.sleep(2000);
	  Android_Automation.SettingsScreen.DaysBeforeSelection(4);
	  Thread.sleep(2000);
	  Android_Automation.SettingsScreen.DaysAfterDropDown();
	  Thread.sleep(2000);
	  Android_Automation.SettingsScreen.DaysAfterSelection(4);
	  Thread.sleep(2000);
	  Android_Automation.SettingsScreen.XIcon();
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
	  driver.findElement(By.xpath("//*[contains(@text, 'BAILEY FARMS')]")).click();
      //Android_Automation.ContainerScreen.firstSupplier(1);
      Thread.sleep(2000);
      Android_Automation.ContainerScreen.pOSelection();
      Thread.sleep(2000);
      Android_Automation.ContainerScreen.firstPo(2); // index 2 is first PO
      Thread.sleep(2000);
      Android_Automation.ContainerScreen.startInspection();
      Thread.sleep(2000);
      Android_Automation.ProductScreen.productSelection(1);
      Thread.sleep(2000);
      Android_Automation.RatingScreen.ApprovalRatingsIcon();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.ProductDefects(1);
      Thread.sleep(2000);
      Android_Automation.RatingScreen.firstnumeratorInput("1.4");
      Thread.sleep(2000);
      Android_Automation.RatingScreen.firstdenominatorInput("100");
      Thread.sleep(2000);
      Android_Automation.RatingScreen.secondnumeratorInput("10.10");
      Thread.sleep(2000);
      Android_Automation.RatingScreen.seconddenominatorInput("100");
      Thread.sleep(2000);
      Android_Automation.RatingScreen.severitiesGreenCheck();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.DefectsDone();
     
      /**
      Thread.sleep(2000);
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
      **/
      
      //Thread.sleep(5000);
      //Android_Automation.RatingScreen.SelectOrigin(1);
      //Thread.sleep(2000);
      //Android_Automation.scroolToText(brand_name);
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
      Android_Automation.scroolToText(modifyInspection);
      Thread.sleep(2000);
      //Android_Automation.SummaryScreen.ModifyInspection();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.BackSample();
      Thread.sleep(2000);
      Android_Automation.RatingScreen.FinishInspection();
      Thread.sleep(2000);
      Android_Automation.SummaryScreen.ExpandFirstAudit(); 
      Thread.sleep(2000);
      Android_Automation.scroolToText(changeStatus);
      Thread.sleep(6000);
      //Android_Automation.SummaryScreen.SelectInspectionStatus(3);
      //Thread.sleep(2000);
      driver.findElement(By.xpath("//*[contains(@text, 'Reject')]")).click();
      //Android_Automation.SummaryScreen.SelectInspectionStatusText(rejectstatus); //Accept - Reject - Accept with Issues
      Thread.sleep(2000);
      Android_Automation.scroolToText(PONUMBER);
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
      LocalDateTime end = LocalDateTime.now();
      System.out.println(dtf.format(end) + " Delhaize Test Ended" ); 
        
	  }     
  } 
  

