package com.windowhandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToParentWindow {
	static WebDriver driver;
	@Test
	public void initBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sites.google.com/view/testurls/valid-urls");
////		getAllWindows(driver);
		driver.switchTo().frame("48273484f22f94a7_5");
		Thread.sleep(1000);
		driver.switchTo().frame("innerFrame");
		Thread.sleep(1000);
		driver.switchTo().frame("userHtmlFrame");
		driver.findElement(By.xpath("//a[contains(text(),'Adobe')]")).isDisplayed();
		driver.close();
	}

}
