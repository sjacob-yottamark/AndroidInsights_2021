package com.harvestmark;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class iFood_Android {

    public static AndroidDriver driver;
    //public static AppiumDriver driver;
    public static WebDriverWait wait;
    
    //String brand_name = "* Brand Name";

    @BeforeMethod
    public static void setup () throws Exception {
    	
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", "/Users/sjacob/AndroidStudioProjects/apk/ifooddecisionsciences-toolboxapp-android-releasex-86.apk");
        //caps.setCapability("app", "/Users/sjacob/AndroidStudioProjects/InsightsAutomation/apk/DCInsights v7.1.5.apk");
        //caps.setCapability("app", "/Users/sjacob/AndroidStudioProjects/InsightsAutomation/apk/DCInsightsV7-release-7.0.7.apk");
        //DCInsightsV7-release-7.0.7.apk
        
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        //caps.setCapability("platformVersion", "10.13.6");
        //caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("deviceName", "3300d4472639b2d7");  //3300d4472639b2d7 -- Galaxy Tablet
        //caps.setCapability("deviceName", "3300d4472639b2d7");
        caps.setCapability("appPackage", "com.iFood.mobileapp");
        caps.setCapability("appActivity","com.prime31.UnityPlayerNativeActivity");
        //caps.setCapability("noReset","true");
        //caps.setCapability("skipUnlock","true");
        //caps.setCapability("skipUnlock","true");
        //caps.setCapability("autoGrantPermissions","true");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        //driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        //wait = new WebDriverWait(driver, 10);
        wait = new WebDriverWait(driver,400,400);

    }
    
    public static void AllowButton () {
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        System.out.println("Clicked AllowButton");
    }
    
    
    
    public static void scroolToText(String string) {
        System.out.println("Running method --> scroolToText --> " + string);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+string+"\").instance(0))").click();
    }
    
    public static class iFood_Login {
    	
    	
        public static void emialField(String emial) {
        	
        	driver.findElement(By.xpath("//*[contains(@text, 'Username')]")).sendKeys(emial);
        }
        public static void passwordField(String password) {
        	driver.findElement(By.xpath("//*[contains(@text, 'Password')]")).sendKeys(password);
        }
        public static void sign_in_button() {
        	driver.findElement(By.xpath("//*[contains(@text, 'Sign in')]")).click();;
        }
        
    }
     
    public static void LocationsScreen(int index) {
        System.out.println("Inside LocationsScreen Function");
        //driver.findElement(By.xpath
                //("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[" + index  + "]/android.widget.TextView[1]")).click();
                        //("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[" + index  + "]")).click();
        //("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[7]/android.widget.TextView[2]")).click();
        System.out.println("Clicked on find by Xpath LocationsScreen");
    }
    
    public static void oKButton () {
        driver.findElement(By.id("android:id/button1")).click();
        System.out.println("Clicked OK Button");
    }
    
        public static class EndPoints {
        public static final int LOCALHOST = 0;
        public static final int QA_AWS = 1;
        public static final int QA5_EXT = 2;
        public static final int PROD = 3;
        //public static final int STG = 4;
        //public static final int PROD = 5;
    }

    public static class HomePage {
        public static void openEndPointSelection() {
            WebElement accessPoint = driver.findElement(By.id("com.trimble.harvestmark.insights:id/headerImage"));
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                accessPoint.click();
            }
        }

        public static void chooseEndPoint(int endPoint) {
            switch (endPoint) {
                case EndPoints.LOCALHOST:
                    selectEndPoint("LOCALHOST");
                    break;
                case EndPoints.QA_AWS:
                    selectEndPoint("QA_AWS");
                    break;
                case EndPoints.QA5_EXT:
                    selectEndPoint("QA5_EXT");
                    break;
                case EndPoints.PROD:
                    selectEndPoint("PROD");
                    break;
                default:
                    selectEndPoint("QA_AWS");
            }
        }

        private static void selectEndPoint(String endPoint) {
            WebElement endPointElement = driver.findElement(By.name(endPoint));
            endPointElement.click();
            driver.findElement(By.id("android:id/button1")).click();

        }

        public static void orderDataIcon() {
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_order_data")).click();
            System.out.println("Clicked on Order Data Icon");
        }

        public static void startNewButton() {
            //driver.findElement(By.id("com.trimble.harvestmark.insights:id/newInspectionButton")).click();
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/newInspectionButton")).click();
        }

        public static void uploadInspections() {
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_sync")).click();
        }

    }

        public static class ContainerScreen {
            public static void supplierSelection() {
            	driver.findElement(By.xpath("//*[contains(@text, 'Select Supplier')]")).click();	
            }
            
            public static void firstSupplier(int index) {
            	
            	String supplier_name =  driver.findElement(By.xpath
                        ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + index + "]/android.widget.TextView")).getText();
                System.out.println(supplier_name + " Supplier selected ");
            	driver.findElement(By.xpath
                        ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + index + "]/android.widget.TextView")).click();
            }
            public static void pOSelection() {           	
            	driver.findElement(By.xpath
                        ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[2]/android.widget.Button")).click();          
            	//driver.findElement(By.xpath("//*[contains(@text, 'Select PO Number')]")).click();
            }
            public static void firstPo(int index) {           	
                driver.findElement(By.xpath
                        ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + index + "]/android.widget.TextView")).click();
            }
            public static void startInspection() {
                driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_start")).click();
            }
            
            public static void backButton() {
				driver.findElement(By.id("android:id/up")).click();
			}
        }

    public static class ProductScreen {

        public static void productSelection (int index) {
            String product_name =  driver.findElement(By.xpath
                    ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[\" + index  + \"]/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
           System.out.println(product_name + " Product selected ");
            driver.findElement(By.xpath
            		("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[\" + index  + \"]/android.widget.RelativeLayout/android.widget.TextView[1]")).click();
        }
        public static void productName (int index) {
           String product_name =  driver.findElement(By.xpath
                    ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[\\\" + index  + \\\"]/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
           System.out.println(product_name + "product selected ");
           
        }
        public static void poSelection () {
            driver.findElement(By.xpath
                    ("/hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[2]")).click();
        }

        public static void backButton () {
            driver.findElement(By.xpath
                    ("/hierarchy/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]")).click();
        
        }
    }
        
        public static class RatingScreen {
        	
        	 public static void ApprovalRatingsIcon () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/defectsButton")).click();
        	 }
             
        	 public static void ProductDefects (int index) {
        		 String DefectName =  driver.findElement(By.xpath
                         ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[" + index + "]/android.widget.LinearLayout/android.widget.TextView")).getText();
        		 System.out.println(DefectName + " Defect Selected ");
        		 
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[" + index + "]/android.widget.LinearLayout/android.widget.CheckBox")).click();
        		   
        	 }
        	 
        	 public static void numeratorInput (String numerator) {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/numeratorEditText")).sendKeys(numerator);	 
        	 }
        	 public static void denominatorInput (String denominator) {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/denominatorEditText")).sendKeys(denominator);	 
        	 }
        	 
        	 public static void InputDone () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/okButton")).click();
        	 }
        	 
        	 public static void DefectsDone () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_done")).click();	 
        	 }
        	 
        	 public static void BrandNameInput (String brandInput) {
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.RelativeLayout/android.widget.EditText")).sendKeys(brandInput);
        		  //hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.RelativeLayout/android.widget.EditText

        		 
        		 ///hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText
        	 }
        	 
        	 public static void SelectOrigin (int index) {
        		 driver.findElement(By.xpath("//*[contains(@text, 'Select Origin')]")).click(); 
        		 driver.findElement(By.xpath
                 ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + index + "]/android.widget.TextView")).click();
        	 }
        	 
      
        	 public static void WeightInput (String weightInput) {
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.EditText")).sendKeys(weightInput);
        	      
        	 
        	 }
        	 
        	 public static void Units (int index) {
        		 driver.findElement(By.xpath("//*[contains(@text, 'Units')]")).click(); 
        		 driver.findElement(By.xpath
                 ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[" + index + "]")).click();
        	 }
        	 
        	 public static void TempFInput (String tempFInput) {
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.EditText")).sendKeys(tempFInput);
        	 }
        	 
        	 
        	 public static void CommentsInput (String comments) {
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText")).sendKeys(comments);
        	 }
        	 
        	 public static void NextSample () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/nextInspectionButton")).click();
        	 }
        	 
        	 public static void BackSample () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/previousInspectionButton")).click();
        	 }
        	 
        	 public static void FinishInspection () {
        		 System.out.println("Finishing Inspection");
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_done")).click();
        	 }
        	
        }
        
        public static class SummaryScreen {
        	
        	 public static void CancelInspection () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_delete")).click();
        	 }
        	 
        	 public static void SaveInspection () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_save")).click();
        	 }
        	 
        	 public static void FinishInspection () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_finish")).click();
        	 }
        	
        	 public static void ExpandFirstAudit () {
        		 driver.findElement(By.xpath
                		 ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.CheckedTextView")).click();
        		          
        	 }
        	 
        	 public static void UNExpandFirstAudit () {
        		 driver.findElement(By.xpath
                		 ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.CheckedTextView")).click();
        		          //hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.CheckedTextView
 
        	 }
        	 
        	 public static void ModifyInspection () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/modifyInspectionButton")).click();
        	 }
        	 
        	 public static void ChangeStatus () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/changeStatusButton")).click();
        	 }
        	 
        	 
        	 public static void SelectInspectionStatus (int index) { // 1 - Accept - 2 = Accept With Issues - 3 = Reject
        		 driver.findElement(By.xpath
                		 ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[" + index + "]")).click();
        	 }
        	 
        	 
        	 public static void ScoreNoMatchOK() { 
        		 driver.findElement(By.id("android:id/button2")).click();
        	 }
        	 
        	 public static void ScoreNoMatchFinishAnyWay() { 
        		 driver.findElement(By.id("android:id/button1")).click();
        	 }
        	 
        	 
        	 public static void SubmitInspectionCancel() { 
        		 driver.findElement(By.id("android:id/button2")).click();
        	 }
        	 
        	 public static void SubmitInspectionOK() { 
        		 driver.findElement(By.id("android:id/button1")).click();
        	 } 
        	 
        	 
        	 
        	 
        	 
        	
        	
        }
        
        
        
        
        
        
        
        
        
        //@AfterMethod
       //public void teardown(){
            //driver.quit();
        //}
           
    
 }   
        

    
    
    