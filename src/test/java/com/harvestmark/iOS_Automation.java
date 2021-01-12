package com.harvestmark;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class iOS_Automation {

    public static IOSDriver<IOSElement> driver;
    //public static AppiumDriver driver;
    public static WebDriverWait wait;

    @BeforeMethod
    public static void setup () throws Exception {
    	
        DesiredCapabilities caps = new DesiredCapabilities();
        
        caps.setCapability("app", "/Users/sjacob/Development/2020/iFoods_Automation/appfiles/Insights.app");
        caps.setCapability("bundleId", "com.trimble.harvestmark.enterprise.insights");
        
        //caps.setCapability("app", "/Users/sjacob/Development/2020/iFoods_Automation/appfiles/BonusApp.app");
        //caps.setCapability("bundleId", "iOS.BonusApp");
        
        
        //caps.setCapability("platformName", "iOS");
		//caps.setCapability("deviceName", "iPhone X");
		//caps.setCapability("platformVersion", "11.4");
		//caps.setCapability("automationName", "XCUITest");
        //caps.setCapability("clearSystemFiles", "true");
        caps.setCapability("xcodeSigningId", "iPhone Developer");
        caps.setCapability("xcodeOrgId", "9F44W5TA79");
        
        
		
		//caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
        //caps.setCapability("udid","A23CD105-27BF-46FE-8DA5-A80DDA0F8273");
        
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Sal’s iPhone");
        caps.setCapability(MobileCapabilityType.UDID, "954a019d7aefa77c45d9c14e9f0965b8b7330469");
        
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.5");	
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
		caps.setCapability (MobileCapabilityType.CLEAR_SYSTEM_FILES, "true");
		
		
		//caps.setCapability("skipUnlock","true");
		//caps.setCapability("noReset","true");
		//caps.setCapability("autoGrantPermissions","true");
		//caps.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1");
		
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		//caps.setCapability("newCommandTimeout", 2000);
		
		driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        //driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        //wait = new WebDriverWait(driver, 10);
        wait = new WebDriverWait(driver,400,400);

    }
    
    public static class iOS_Login {
        public static void emialField(String emial) {
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys(emial);
        }
        public static void passwordField(String password) {
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")).sendKeys(password);
        }
        public static void sign_in_button() {
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
            
        }
    }
    
    
    public static void LocationsScreen(int index) {
        System.out.println("Inside LocationsScreen Function");
        driver.findElement(By.xpath
                //("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[" + index  + "]/android.widget.TextView[1]")).click();
                        ("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[" + index  + "]")).click();
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
                driver.findElement(By.xpath
                        ("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[1]/android.widget.Button")).click();
            }
            public static void firstSupplier(int index) {
                driver.findElement(By.xpath
                        ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + index + "]/android.widget.TextView")).click();
            }
            public static void pOSelection() {
                driver.findElement(By.xpath
                        ("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.GridView/android.widget.LinearLayout[2]/android.widget.Button")).click();
            }
            public static void firstPo(int index) {
                driver.findElement(By.xpath
                        ("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[" + index + "]/android.widget.TextView")).click();
            }
            public static void startInspection() {
                driver.findElement(By.id
                        ("com.trimble.harvestmark.insights:id/action_start")).click();
            }
        }

    public static class ProductScreen {

        public static void productSelection (int index) {
            System.out.println("productSelection (int index)");
            driver.findElement(By.xpath
                    //("/hierarchy/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ExpandableListView[1]/android.widget.LinearLayout[" + index  + "]")).click();
            ("/hierarchy/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[" + index  + "]")).click();
        }
        public static void productName (int index) {
            driver.findElement(By.xpath
                    ("/hierarchy/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ExpandableListView[1]/android.widget.LinearLayout[" + index  + "]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).getText();
        }
        public static void poSelection () {
            System.out.println("poSelection (int index)");

            driver.findElement(By.xpath
                    ("/hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[2]")).click();
        }

        public static void backButton () {
            driver.findElement(By.xpath
                    ("/hierarchy/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]")).click();

        }
        
        
        
        
        
        

    
    
    }    
}
    
    
    