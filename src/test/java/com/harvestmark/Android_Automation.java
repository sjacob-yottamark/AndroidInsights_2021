package com.harvestmark;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Android_Automation {

    public static AndroidDriver<MobileElement> driver;
    //public static AppiumDriver driver;
    public static WebDriverWait wait;
    
    String supplier_name = "ARROW FARMS INC";
	String brand_name = "* Brand Name";
	String weight= "Weight";
	String tempF = "* Temperature (°F)";
	String comments = "Comments";
	String PONUMBER = "PONUMBER";
	String modifyInspection = "MODIFY INSPECTION";
	String changeStatus = "CHANGE STATUS";
	String rejectstatus = "Reject";
   
    @BeforeMethod
    public static void setup () throws Exception {
    	
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", "/Users/sjacob/Desktop/00_Mobile_Apps/Azure/Android_builds/00_QA/7.1.5/DCInsights v7.1.5_New.apk");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1");
        //caps.setCapability("platformVersion", "10.13.6");
        caps.setCapability("deviceName", "emulator-5554"); //
        //caps.setCapability("deviceName", "23852998ff0d7ece");  //3300d4472639b2d7 -- Galaxy Tablet
        //caps.setCapability("deviceName", "3300d4472639b2d7");
        caps.setCapability("appPackage", "com.trimble.harvestmark.insights");
        caps.setCapability("appActivity","com.trimble.harvestmark.insights.LauncherActivity");
        //caps.setCapability("appActivity","com.trimble.harvestmark.insights.activity.LoginActivity");
        //caps.setCapability("appActivity","com.trimble.harvestmark.insights.activity.RequestPermissionActivity.RequestPermissionActivity");
        //caps.setCapability("noReset","true");
        //caps.setCapability("skipUnlock","true");
        caps.setCapability("autoGrantPermissions","true");
        caps.setCapability(MobileCapabilityType.FULL_RESET, true);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        //driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        //wait = new WebDriverWait(driver, 10);
        wait = new WebDriverWait(driver,400,400);

    }
    
    public static void scroolToText(String string) {
        System.out.println("Running method --> scroolToText --> " + string);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+string+"\").instance(0))").click();
    }
    
    public static class Android_Login {
    	
        public static void emialField(String emial) {
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/email")).sendKeys(emial);
        }
        public static void passwordField(String password) {
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/password")).sendKeys(password);
        }
        public static void sign_in_button() {
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/sign_in_button")).click();
            
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
        
        public static void SettingsIcon() {
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_settings")).click();
            System.out.println("Clicked on Settings Icon");
        }
        
        
        public static void orderDataIcon() {
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_order_data")).click();
            System.out.println("Clicked on Order Data Icon");
        }
        
        public static void startNewButton() {
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/newInspectionButton")).click();
            System.out.println("Clicked on startNewButton");
        }

        public static void uploadInspections() {
            driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_sync")).click();
            System.out.println("Clicked on uploadInspections");
        }

    }
    
    public static class SettingsScreen {
    	
    	 public static void XIcon() {
             driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_back")).click();
             System.out.println("Clicked on X Icon");
         }
    	 
    	 public static void InfoIcon() {
             driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_about")).click();
             System.out.println("Clicked on InfoIcon");
         }
    	
    	 public static void SyncNowButton() {
             driver.findElement(By.id("com.trimble.harvestmark.insights:id/syncButton")).click();
             System.out.println("Clicked on SyncNowButton");
         }
    	 
    	 public static void SyncOrderDataButton() {
             driver.findElement(By.id("com.trimble.harvestmark.insights:id/syncOrderDataButton")).click();
             System.out.println("Clicked on SyncOrderDataButton");
         }
    	 
    	 public static void DaysBeforeDropDown() {
             driver.findElement(By.id("com.trimble.harvestmark.insights:id/daysBeforeSpinner")).click();
             System.out.println("Clicked on DaysBeforeDropDown");    
         }
    	 
    	 public static void DaysBeforeSelection(int index) {           	
             driver.findElement(By.xpath
                     ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[" + index + "]")).click();
                      //hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[" + index + "]
                      //hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[7] 
             System.out.println("Selected " + index + " DaysBefore");
    	 }
    	 
    	 public static void DaysAfterDropDown() {
             driver.findElement(By.id("com.trimble.harvestmark.insights:id/daysAfterSpinner")).click();
             System.out.println("Clicked on DaysAfterDropDown");    
         }
    	 
    	 public static void DaysAfterSelection(int index) {           	
             driver.findElement(By.xpath
                     ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[" + index + "]")).click();
                      //hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[8]
             System.out.println("Selected " + index + " DaysAfter"); 
    	 }
    	 
    	 
    	 
    	
    }

        public static class ContainerScreen {
            public static void supplierSelection() {
            	driver.findElement(By.xpath("//*[contains(@text, 'SELECT SUPPLIER')]")).click();	
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
                        ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[2]/android.widget.Button")).click();          
            }
            public static void firstPo(int index) {           	
                driver.findElement(By.xpath
                        ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.LinearLayout[" + index + "]/android.widget.TextView[1]")).click();
            }
            public static void startInspection() {
                driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_start")).click();
                System.out.println("Clicked on startInspection");
            }
            
            public static void backButton() {
				driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
				 System.out.println("Clicked on backButton");
			}
        }

    public static class ProductScreen {

        public static void productSelection (int index) { 
            String product_name =  driver.findElement(By.xpath
                    ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[\" + index  + \"]/android.widget.RelativeLayout/android.widget.TextView[1]")).getText();
                     //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[\" + index  + \"]/android.widget.RelativeLayout/android.widget.TextView[1]
                     //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]
            
            System.out.println(product_name + " Product selected ");
            driver.findElement(By.xpath
            		("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[\" + index  + \"]/android.widget.RelativeLayout/android.widget.TextView[1]")).click();
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
        		 System.out.println("Clicked on  ApprovalRatingsIcon");
        		 
        	 }
             
        	 public static void ProductDefects (int index) {
        		 String DefectName =  driver.findElement(By.xpath
                         ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[" + index + "]/android.widget.LinearLayout/android.widget.TextView")).getText();
        		          //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[" + index + "]/android.widget.LinearLayout/android.widget.TextView
        		          //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView
        		    
        		 System.out.println(DefectName + " Defect Selected ");
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[" + index + "]/android.widget.LinearLayout/android.widget.CheckBox")).click();
        		  //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[" + index + "]/android.widget.LinearLayout/android.widget.CheckBox
		          //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox   
        	 }
        	 
        	 
        	 public static void firstnumeratorInput (String numerator) {
        		 driver.findElement(By.xpath
                         ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")).sendKeys(numerator);
        	 }
        	 
        	 public static void firstdenominatorInput (String denominator) {
        		 driver.findElement(By.xpath
                         ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[2]")).sendKeys(denominator);  
        	 }
        	 
        	 public static void secondnumeratorInput (String numerator) {
        		 driver.findElement(By.xpath
                         ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.EditText[1]")).sendKeys(numerator);
        	 }
        	 
        	 public static void seconddenominatorInput (String denominator) {
        		 driver.findElement(By.xpath
                         ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.EditText[2]")).sendKeys(denominator);  
        	 }
        	 
        	 public static void severitiesRedX () {
        		 
        	 }
        	 
        	 public static void severitiesGreenCheck () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/okButton")).click();	 
        	 }
        	 
        	 public static void numeratorInput (String numerator) {
        
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/numeratorEditText")).sendKeys(numerator);	 
        	 }
        	 public static void denominatorInput (String denominator) {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/denominatorEditText")).sendKeys(denominator);	 
        	 }
        	 
        	 public static void InputDone () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/okButton")).click();
        		 System.out.println("Clicked on  InputDone");
        	 }
        	 
        	 public static void DefectsDone () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_done")).click();
        		 System.out.println("Clicked on  DefectsDone");
        	 }
        	 
        	 public static void BrandNameInput (String brandInput) {
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.RelativeLayout/android.widget.EditText")).sendKeys(brandInput);
        		 System.out.println("Inputing Brand Name");
        	 }
        	 
        	 public static void SelectOrigin (int index) {
        		 driver.findElement(By.xpath("//*[contains(@text, 'Select Origin')]")).click(); 
        		 driver.findElement(By.xpath
                 ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + index + "]/android.widget.TextView")).click();
        	 }
        	 
      
        	 public static void WeightInput (String weightInput) {
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.EditText")).sendKeys(weightInput);
        	      //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout[2]/android.widget.EditText

        	 
        	 }
        	 
        	 public static void Units (int index) {
        		 driver.findElement(By.xpath("//*[contains(@text, 'UNITS')]")).click(); 
        		 driver.findElement(By.xpath
                 ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[\" + index + \"]")).click(); 
        	      //hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[" + index + "]
        	 }
        	 
        	 public static void TempFInput (String tempFInput) {
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.EditText")).sendKeys(tempFInput);
        	 }
        	 
        	 
        	 public static void CommentsInput (String comments) {
        		 System.out.println("Inputing Comments");
        		 driver.findElement(By.xpath
        		 ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText")).sendKeys(comments);
        	      //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText
        	 }
        	 
        	 public static void NextSample () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/nextInspectionButton")).click();
        		 System.out.println("Clicked on  NextSample");
        	 }
        	 
        	 public static void BackSample () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/previousInspectionButton")).click();
        		 System.out.println("Clicked on  BackSample");
        	 }
        	 
        	 public static void FinishInspection () {
        		 System.out.println("Finishing Inspection");
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_done")).click();
        	 }
        	
        }
        
        public static class SummaryScreen {
        	
        	 public static void CancelInspection () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_delete")).click();
        		 System.out.println("Clicked on  CancelInspection");
        	 }
        	 
        	 public static void SaveInspection () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_save")).click();
        		 System.out.println("Clicked on  SaveInspection");
        	 }
        	 
        	 public static void FinishInspection () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/action_finish")).click();
        		 System.out.println("Clicked on  FinishInspection");
        	 }
        	
        	 public static void ExpandFirstAudit () {
        		 System.out.println("Clicked on ExpandFirstAudit");
        		 driver.findElement(By.xpath
                		 ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.CheckedTextView")).click();
        		          //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.CheckedTextView
        	              //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.CheckedTextView
        	 
        	 }
        	 
        	 public static void UNExpandFirstAudit () {
        		 System.out.println("Clicked on UNExpandFirstAudit");
        		 driver.findElement(By.xpath
                		 ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.CheckedTextView")).click();
                          //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.CheckedTextView
        	 }
        	 
        	 public static void ModifyInspection () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/modifyInspectionButton")).click();
        		System.out.println("Clicked on ModifyInspection");
        		 
        	 }
        	 
        	 public static void ChangeStatusButton () {
        		 driver.findElement(By.id("com.trimble.harvestmark.insights:id/changeStatusButton")).click();
        		 System.out.println("Clicked on ChangeStatusButton");
        	 }
        	 
        	 public static void SelectInspectionStatusText(String string ) {
        		 driver.findElement(By.xpath("//*[contains(@text, 'string')]")).click(); //Accept - Reject - Accept with Issues
        		 	 
        	 }
        	 
        	 
        	 
        	 
        	 
        	 public static void SelectInspectionStatusbyxpath (int index) { // 1 - Accept - 2 = Accept With Issues - 3 = Reject
        		 driver.findElement(By.xpath
                		 ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.TextView[" + index + "]")).click();
        	 }
        	 
        	 
        	 public static void ScoreNoMatchOK() { 
        		 driver.findElement(By.id("android:id/button2")).click();
        		 System.out.println("Clicked on ScoreNoMatchOK");
        	 }
        	 
        	 public static void ScoreNoMatchFinishAnyWay() { 
        		 driver.findElement(By.id("android:id/button1")).click();
        		 System.out.println("Clicked on ScoreNoMatchFinishAnyWay");
        	 }
        	 
        	 
        	 public static void SubmitInspectionCancel() { 
        		 driver.findElement(By.id("android:id/button2")).click();
        		 System.out.println("Clicked on SubmitInspectionCancel");
        	 }
        	 
        	 public static void SubmitInspectionOK() { 
        		 driver.findElement(By.id("android:id/button1")).click();
        		 System.out.println("Clicked on SubmitInspectionOK");
        	 } 
        	 
        	 
        	 
        	 
        	 
        	
        	
        }
        
        
        
        
        
        
        
        
        
        //@AfterMethod
       //public void teardown(){
            //driver.quit();
        //}
           
    
 }   
        

    
    
    