package w4day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html ");
		WebElement from= driver.findElement(By.id("table_id"));
		List<WebElement> rows = from.findElements(By.tagName("tr"));
	    System.out.println("Total number of Rows :"+rows.size());
	        WebElement firstRow = rows.get(1);
	        int totalColumns = firstRow.findElements(By.tagName("td")).size();
	        System.out.println("Total number of Columns :"+totalColumns);
	        for(int i=0;i<rows.size();i++) {
	   	     WebElement currentRow=rows.get(i);
	   	    List<WebElement> listcolumns=currentRow.findElements(By.tagName("td"));
	   	     for(int j=0;j<listcolumns.size();j++) {
	   	    System.out.println(listcolumns.get(j).getText());
	   	    }
	   	    }
	   	
	}

}
