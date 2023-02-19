package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShirtsPage {
	private WebDriver driver;
	public ShirtsPage(WebDriver driver) {
		this.driver=driver;
	}
	By First_Item=By.xpath("(//div[@class='info'])[52]");
	By Item=By.xpath("(//div[@class='info'])[1]");
	By Add_first_Item_To_Cart=By.xpath("(//button[contains(.,'Add To Cart')])[52]");
	By select_variation_Button=By.xpath("(//button[@value='in'])[1]");
	By Continue_Shopping=By.xpath("//button[contains(.,'Continue Shopping')]");
	By Second_Item=By.xpath("(//div[@class='info'])[51]");
	By Add_Second_Item_To_Cart=By.xpath("(//button[contains(.,'Add To Cart')])[51]");
	By View_Cart=By.xpath("//a[contains(.,'View Cart and Checkout')]");
	
	
	
	
	public CartPage add_item_to_cart() throws InterruptedException {
		Actions action=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebDriverWait wait=new WebDriverWait(driver, 20);
		js.executeScript("scrollBy(0,500)");
		action.moveToElement(driver.findElement(First_Item)).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Add_first_Item_To_Cart));
		driver.findElement(Add_first_Item_To_Cart).click();
		driver.findElement(select_variation_Button).click();
		wait.until(ExpectedConditions.elementToBeClickable(Continue_Shopping));
		Thread.sleep(2000);
		driver.findElement(Continue_Shopping).click();
	
		action.moveToElement(driver.findElement(Second_Item)).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Add_Second_Item_To_Cart));
		driver.findElement(Add_Second_Item_To_Cart).click();
		driver.findElement(select_variation_Button).click();
		wait.until(ExpectedConditions.elementToBeClickable(Continue_Shopping));
		wait.until(ExpectedConditions.elementToBeClickable(View_Cart));
		Thread.sleep(2000);

		driver.findElement(View_Cart).click();
		return new CartPage(driver);
	}
}
