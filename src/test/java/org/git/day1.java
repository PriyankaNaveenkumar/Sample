package org.git;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class day1 {
	public WebDriver driver;
	@BeforeClass
	private void launch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		}
	
	@Test(dataProvider="products")
	private void Launch(String name) throws InterruptedException {
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(name);
		WebElement button1 = driver.findElement(By.xpath("//input[@type='submit']"));
		button1.click();
		List<WebElement> listname = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("total no of products: "+listname.size());
		Thread.sleep(2000);

	}
	@DataProvider(name="products")
	private String[][] productname() {
		return new String[][] {
			{"hp laptop"},{"samsung mobile"},{"tcl tv"},
			{"dell"},{"bluetooth headset"}
				
				
				
		};
		
		

	}
	@BeforeMethod
	private void start() {
		Date d=new Date();
		System.out.println(d);

	}

}
