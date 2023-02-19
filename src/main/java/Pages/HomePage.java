package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	By Cancel_Button=By.xpath("//button[contains(@aria-label,'close-cta')]");
	By Account_Button=By.xpath("//label[contains(.,'Account')]");
	By Signup_button=By.xpath("//a[contains(.,'Sign In')]");
	public By Logged=By.xpath("//label[@for='dpdw-login']");
	By Fashion=By.xpath("//a[@href='/category-fashion-by-jumia/']");
	By Shirts=By.xpath("//a[contains(.,'Shirts')]");
	public void cancel_popup() {
		driver.findElement(Cancel_Button).click();

	}
	public RegisterPage Signup() throws InterruptedException {
		driver.findElement(Account_Button).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(Signup_button).click();
		return new RegisterPage(driver);
	}
	public ShirtsPage Go_To_Shirts() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(Fashion)).perform();
		driver.findElement(Shirts).click();
		return new ShirtsPage(driver);
	}
}
