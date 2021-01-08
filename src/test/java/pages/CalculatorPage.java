package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class CalculatorPage extends BasePage {
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void openCloudPage(){
        driver.get("https://cloud.google.com/");
    }

    public void goToGoogleCloudPlatformPricingCalculatorPage(String keyForCalculatorPageOpening){
        driver.findElement(By.className("devsite-search-form")).click();
        WebElement textForGoogleSearch =
                driver.findElement(By.xpath("//input[@class='devsite-search-field devsite-search-query']"));
        textForGoogleSearch.click();
        textForGoogleSearch.sendKeys(keyForCalculatorPageOpening);
        textForGoogleSearch.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']/parent::a")).click();
    }

   public void sendKeyInToNumberOfInstancesField(String keyForNumberOfInstances){
       WebElement element = driver.findElement(By.xpath("//iframe[contains(@name,'goog_')]"));
       driver.switchTo().frame(element);
       driver.switchTo().frame("myFrame");
        WebElement numberOfInstancesField =
                driver.findElement(
                        By.xpath("//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']"));
        numberOfInstancesField.sendKeys(keyForNumberOfInstances);
       }

       public void selectSeriesOfMachine(){
        driver.findElement(By.xpath("//md-select[@name='series']/parent::md-input-container")).click();
        driver.findElement(By.xpath("//md-option[@value='n1']")).click();
       }

       public void selectMachineType(){
        driver.findElement(By.xpath("//label[text()='Machine type']/parent::md-input-container")).click();
        driver.findElement(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")).click();
       }
       public void clickAddGpusCheckBox(){
        driver.findElement(By.xpath("//md-checkbox[@aria-label='Add GPUs']")).click();
       }

       public void selectNumberOfGpus(){
        driver.findElement(By.xpath("//md-select[@placeholder='Number of GPUs']")).click();
        driver.findElement(By.cssSelector("md-option[value='1'][class='ng-scope md-ink-ripple'][ng-disabled]")).click();
       }

       public void selectGpuType(){
        driver.findElement(By.xpath("//md-select[@placeholder='GPU type']")).click();
           driver.findElement(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']")).click();
       }

       public void selectLocalSsd(){
        driver.findElement(By.xpath("//md-select[@placeholder='Local SSD']")).click();
        driver.findElement(By.cssSelector("md-option[value='2'][ng-repeat*='supportedSsd']")).click();
       }

       public void selectDataCenterLocation(){
        driver.findElement(By.xpath("//md-select[@placeholder='Datacenter location']")).click();
        driver.findElement(By.cssSelector("md-select-menu[class='md-overflow']" +
                " md-option[value='europe-west3'][ng-repeat*='fullRegionList']")).click();
       }

       public void selectCommittedUsage(){
        driver.findElement(By.xpath("//md-select[@placeholder='Committed usage']")).click();
        driver.findElement(By.cssSelector("div[class='md-select-menu-container md-active md-clickable']" +
                " md-option[value='1'][class='md-ink-ripple']")).click();
       }
       public void pushAddToEstimate(){
           driver.findElement(By.xpath("//button[@aria-label='Add to Estimate']")).click();
       }

       public void checkInformationInVmClassIsRegular(){
           driver.findElement(By.xpath("//div[contains (text(),'VM class: regular')]"));
       }

       public void checkInformationInInstanceTypeIncludeN1Standard8(){
           driver.findElement(By.xpath("//div[contains (text(),'Instance type: n1-standard-8')]"));
       }

       public void checkRegionIsFrankfurt(){
           driver.findElement(By.xpath("//div[contains (text(),'Region: Frankfurt')]"));
       }

       public void checkLocalSsdSpace2x375Gib(){
           driver.findElement(By.xpath("//div[contains (text(),'Total available local SSD space 2x375 GiB')]"));
       }

       public void checkCommitmentTermOneYear(){
           driver.findElement(By.xpath("//div[contains (text(),'Commitment term: 1 Year')]"));
       }
}
