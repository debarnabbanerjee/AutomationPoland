package com.debarnab.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BBCLink {
	
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Automation Poland\\geckodriver-v0.11.1-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://timesofindia.indiatimes.com/");	
		checkPageIsReady();
		driver.findElement(By.linkText("City")).click();
		checkPageIsReady();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='fsts']/h1/a")));
		//driver.findElement(By.xpath("//*[@id='fsts']/h1/a")).click();
		driver.findElement(By.linkText("Spurned 'FB friend' stabs Tamil Nadu girl with bottle at first meet")).click();
				
		Thread.sleep(5000);
		//driver.quit();
		
	}
	
	public static  void waitforElementVisibiity(String Xpath){
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Xpath)));
		
	}
	
	public static void checkPageIsReady(){
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   System.out.println("Page Is loaded.");
		   return; 
		  } 
		  
		//This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }	
		
	}

}
