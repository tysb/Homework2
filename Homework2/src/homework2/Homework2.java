package homework2;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homework2 {
	private WebDriver driver;
	private String baseUrl;
	Thread thread;
	@Before
	public void setUp() throws IOException {
		//driver = new FirefoxDriver();
		thread = new Thread();
		String chDriver = new File(new File(".").getCanonicalPath()+"\\" 
				+ "driver/chromedriver.exe").getCanonicalPath();
		System.setProperty("webdriver.chrome.driver", chDriver);
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)"
				+ "\\Google\\Chrome\\Application\\chrome.exe");
		baseUrl ="http://www.ncfxy.com/";
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testWD(){
	
		 try {
			    String line =null;
			    BufferedReader reader = new BufferedReader(new FileReader("H:\\info.csv"));
			    while((line =reader.readLine())!=null){
			    	driver.get(baseUrl);
			    	String item[] =line.split(",");
			    	int l=item[0].length();
			    	String s=item[0].substring(4, l);
			        driver.findElement(By.id("name")).clear();
			        driver.findElement(By.id("name")).sendKeys(item[0]);
			        driver.findElement(By.id("pwd")).clear();
			        driver.findElement(By.id("pwd")).sendKeys(s);
			        driver.findElement(By.id("submit")).click();
			        assertEquals(item[1], driver.findElement(By.xpath("//tbody[@id='table-main']/tr/td[2]")).getText());}}
			    catch (Exception e) {
			
			    	e.printStackTrace();
				}
		
	}
	
}
