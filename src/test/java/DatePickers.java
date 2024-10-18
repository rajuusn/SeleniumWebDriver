import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DatePickers {
	static void SelectFutureDate(WebDriver driver, String year, String month,  String date) throws InterruptedException {
		
		
		while(true) {
			String getyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year'] ")).getText();
			String getmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			if(getmonth.equals(month)&& getyear.equals(year)) {
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
			
			for(WebElement dt:alldates) {
				if(dt.getText().equals(date)) {
					Thread.sleep(3000);
					dt.click();
					break;
				}
				
			}
		
			
		
	}}

	static String  convertMonth(String month) {
		HashMap<String, String> monthmap=new HashMap<String, String>();
		monthmap.put("January", "0");
		monthmap.put("February", "1");
		monthmap.put("March", "2");
		monthmap.put("April", "3");
		String value=monthmap.get(month);
		return value;

		
			
		
		
		
		
	}

	

}
