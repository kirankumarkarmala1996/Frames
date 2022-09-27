package com.windowhandles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sites.google.com/view/testurls/valid-urls");
		getAllWindows(driver);
		driver.switchTo().frame("48273484f22f94a7_5");
		Thread.sleep(1000);
		driver.switchTo().frame("innerFrame");
		Thread.sleep(1000);
		driver.switchTo().frame("userHtmlFrame");
		driver.findElement(By.xpath("//a[contains(text(),'Adobe')]")).click();
		windowHandles();

		driver.switchTo().frame("48273484f22f94a7_5");
		Thread.sleep(1000);
		driver.switchTo().frame("innerFrame");
		Thread.sleep(1000);
		driver.switchTo().frame("userHtmlFrame");
		driver.findElement(By.xpath("//a[contains(text(),'Google')]")).click();
		windowHandles();

		driver.switchTo().frame("48273484f22f94a7_5");
		Thread.sleep(1000);
		driver.switchTo().frame("innerFrame");
		Thread.sleep(1000);
		driver.switchTo().frame("userHtmlFrame");
		driver.findElement(By.xpath("//a[contains(text(),'Facebook')]")).click();
		windowHandles();

		driver.switchTo().frame("48273484f22f94a7_5");
		Thread.sleep(1000);
		driver.switchTo().frame("innerFrame");
		Thread.sleep(1000);
		driver.switchTo().frame("userHtmlFrame");
		driver.findElement(By.xpath("//a[contains(text(),'Netflix')]")).click();
		windowHandles();
		
		driver.close();

	}

	public static void windowHandles() throws InterruptedException {
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
				
				driver.close();
				
				driver.switchTo().window(parent);

				

			}

		}
		

	}
	
	public static void getAllWindows(WebDriver driver) {
		Set<String>allwindows=driver.getWindowHandles();
		Iterator<String>it=allwindows.iterator();
		String parent=it.next();
		System.out.println(parent);
		
	}

}
