package w4day1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class SortingTable {
public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ArrayList<String> listid = new ArrayList<String>();
		WebElement elementTable = driver.findElement(By.id("table_id"));
		List<WebElement> listRows = elementTable.findElements(By.tagName("tr"));
		for (int i = 1; i < listRows.size(); i++) {
			WebElement currentRow = listRows.get(i);
			List<WebElement> listColumns = currentRow.findElements(By.tagName("td"));
			String id = listColumns.get(0).getText();
			listid.add(id);
			System.out.println(id);
	     }
		Collections.sort(listid);
		for (String eachid : listid) {
			System.out.println(eachid);
          }
		driver.findElement(By.xpath("//th[@colspan='1']")).click();
		ArrayList<String> sortableid = new ArrayList<String>();
		WebElement elementTable1 = driver.findElement(By.id("table_id"));
		List<WebElement> listRows1 = elementTable1.findElements(By.tagName("tr"));
		for (int i = 1; i < listRows1.size(); i++) {
			WebElement currentRow = listRows1.get(i);
			List<WebElement> listColumns = currentRow.findElements(By.tagName("td"));
			String id1 = listColumns.get(0).getText();
			listid.add(id1);
			System.out.println(id1);
			}
		if (listid.equals(sortableid)) {
			System.out.println("sorted");
		} else {
			System.out.println("Not sorted");
		}
}
}
