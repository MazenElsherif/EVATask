package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage {
	private WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	By Add_qty_First_Item=By.xpath("(//button[@aria-label='increase cart quantity'])[1]");
	By Add_qty_Second_Item=By.xpath("(//button[@aria-label='increase cart quantity'])[2]");
	public By First_Item=By.xpath("(//div[@class='main'])[1]");
	public By Second_Item=By.xpath("(//div[@class='main'])[2]");
public	By FirstPrice=By.xpath("(//div[@class='prc'])[1]");
public	By SecondPrice=By.xpath("(//div[@class='prc'])[2]");
 public By Total=By.cssSelector("p.-fs20.-plm.-tar");
	

	
	public void Increase_qty() throws InterruptedException{
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.findElement(Add_qty_First_Item).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Add_qty_Second_Item));
		driver.findElement(Add_qty_Second_Item).click();
		Thread.sleep(4000);
	}
}
