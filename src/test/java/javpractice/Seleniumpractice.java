package javpractice;

import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Seleniumpractice {
	
	public static void main(String[] agrs) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println("current url"+ driver.getCurrentUrl());
		System.out.println("get windowhandle" + driver.getWindowHandle());
		
		driver.findElement(By.id("name")).sendKeys("vikas");
		driver.findElement(By.xpath("//input[@placeholder='Enter EMail']")).sendKeys("naik67035@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("8074786830");
		
		WebElement tex=driver.findElement(By.id("textarea"));
		
		tex.sendKeys("i am automation tester ");
		
		
		driver.findElement(By.id("male")).click();
		
		driver.findElement(By.id("sunday")).click();
		
		
	WebElement text=	driver.findElement(By.xpath("//div/div/div/div/div/div/div[2]/p/span"));
	          System.out.println( text.getText());
	            //  text.clear();
	          
	          driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("wikipida");
	          driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
	          driver.findElement(By.xpath("//button[contains(.,'START')]")).click();
		
	          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		        WebElement country=driver.findElement(By.id("country"));
		        
		        Select c=new Select(country);
		               c.selectByIndex(2);
		               c.selectByValue("australia");
		              
		      List<WebElement> a=c.getOptions();
		      
		      System.out.println("get size of drop down" + a.size());
		      
		      for(int i=0;i<a.size();i++) {
		    	  
		    	  System.out.println(a.get(i).getText());
		      }
		for(WebElement op:a)
		{
			System.out.println("print text"+ op.getText());
		}
		
	int row= driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		
		System.out.println("print rows in a table :"+row);
		
		
			int col=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
			System.out.println("print column in a table :"+col);
		
		
		String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("bookname" +bookname);
	
	
        for(int r=2;r<=row;r++) {
        	
        	
			for(int c1=1;c1<=col;c1++) {
        		
		String Value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c1+"]")).getText();
				
				System.out.print(Value +  " ");
        	}
				System.out.println();
        }
        
      List<WebElement> checkboxes= driver.findElements(By.xpath("//input[@class='form-check-input'and @type='checkbox']"));
	
	for(int i=0;i<checkboxes.size();i++) {
		
		checkboxes.get(i).click();
	}
	for(  WebElement d:checkboxes) {
		
		d.click();
	//	d.getSize();
		System.out.println("print Size of checkboxes:" +	d.getSize());
	System.out.println("print text of checkboxes:" +	d.getText());
		
	}
for(int i=0;i<4;i++) {
		
		checkboxes.get(i).click(); Thread.sleep(4000);
	}
for(int i=4;i<7;i++) {
	
	checkboxes.get(i).click();
}
driver.findElement(By.id("alertBtn")).click();

Alert myalerat=driver.switchTo().alert();

    System.out.println( myalerat.getText());
    myalerat.accept(); Thread.sleep(2000);

driver.findElement(By.id("confirmBtn")).click();
driver.switchTo().alert().accept();Thread.sleep(2000);
//driver.switchTo().alert().dismiss();
//prompting alret
driver.findElement(By.id("promptBtn")).click();
Alert myalerat1=driver.switchTo().alert();

WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
mywait.until(ExpectedConditions.alertIsPresent());
myalerat1.sendKeys("champion");
//System.out.println( myalerat1.getText());
myalerat1.accept(); Thread.sleep(2000);

//driver.switchTo().alert().dismiss();

driver.findElement(By.xpath("//button[contains(.,'New Tab')]")).click();

Set<String> setst=driver.getWindowHandles();

List<String> wind=new ArrayList(setst);

String parentId=wind.get(0);
String childId=wind.get(1);
//String father=wind.get(2);

driver.switchTo().window(parentId);
System.out.println(driver.getTitle());
driver.switchTo().window(childId);
System.out.println(driver.getTitle());
//System.out.println(driver.getWindowHandle());

for(String adc:wind) {
	
	
System.out.println(	driver.switchTo().window(adc).getTitle()) ;
}

Thread.sleep(3000);
driver.findElement(By.xpath("//button[@id='reload-button']")).click();
{
	driver.close();
}
driver.switchTo().window(parentId);

Thread.sleep(3000);
//driver.navigate().back();
driver.findElement(By.linkText("Udemy Courses")).click();

Thread.sleep(3000);
driver.findElement(By.linkText("View Course")).click();

                  Set<String>   adc  =driver.getWindowHandles();
               //   Set<String> setst=driver.getWindowHandles();

                  List<String> win=new ArrayList(adc);

                  String par=win.get(0);
                  String chil=win.get(1);

                  driver.switchTo().window(par);
                  System.out.println(driver.getTitle());
                  driver.switchTo().window(chil);
                  System.out.println(driver.getTitle());
                  driver.switchTo().window(par);
                  System.out.println(driver.getTitle());
                  
                  Thread.sleep(3000);
                  driver.navigate().back();
                  
                  Thread.sleep(3000);
                  
                  driver.findElement(By.xpath("//button[@id='PopUp']")).click();
                  
           
                  
                  Set<String>   ad  =driver.getWindowHandles();
                  //   Set<String> setst=driver.getWindowHandles();

                     List<String> wi=new ArrayList(adc);

                     String pa=wi.get(0);
                     String chi=wi.get(1);

                     driver.switchTo().window(pa);
                     System.out.println(driver.getTitle());
                     driver.switchTo().window(chi);
                     System.out.println(driver.getTitle());
                     
                     

//driver.switchTo().window(childId);
//System.out.println(driver.getTitle());



	
	
	
	
}
}

