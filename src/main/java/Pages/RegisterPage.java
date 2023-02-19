package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	private WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	By Email_Textbox=By.name("email");
	By Continue_Button=By.xpath("//button[contains(.,'Continue')]");
	By Password_TextBox=By.name("password");
	By Confirm_Password_TextBox=By.xpath("//input[contains(@class,'mdc-text-field__input confirm-password-input')]");
	By Continue=By.xpath("//button[@class='mdc-button mdc-button--touch mdc-button--raised to-personal-details mdc-ripple-upgraded']");
	By First_Name=By.id("input_first_name");
	By Last_Name=By.id("input_last_name");
	By Phone_Number=By.name("phone[number]");
	By Continue_Button2=By.xpath("//button[@class='mdc-button mdc-button--touch mdc-button--raised to-personal-details-part-2 mdc-ripple-upgraded']");
	By Gender_dropdown=By.id("gender");
	By Male=By.xpath("//li[contains(.,'Male')]");
	By Birth_Date=By.id("input_birth_date");
	By AcceptTC=By.id("acceptTC");
	By Continue_Button3=By.id("confirmBtn");
	By Skip=By.xpath("//button[contains(.,'Skip')]");
	By Login_Button=By.id("loginButton");
	

	
	public void Register(String email,String password , String firstname,String lastname, String mobile_number, String date) throws InterruptedException {
		driver.findElement(Email_Textbox).sendKeys(email);
		driver.findElement(Continue_Button).click();
		driver.findElement(Password_TextBox).sendKeys(password);
		driver.findElement(Confirm_Password_TextBox).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(Continue).click();
		driver.findElement(First_Name).sendKeys(firstname);
		driver.findElement(Last_Name).sendKeys(lastname);
		driver.findElement(Phone_Number).sendKeys(mobile_number);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(Continue_Button2).click();
		driver.findElement(Gender_dropdown).click();
		driver.findElement(Male).click();
		driver.findElement(Birth_Date).sendKeys(date);
		//driver.findElement(First_Name).sendKeys(date);
		driver.findElement(AcceptTC).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(Continue_Button3).click();
		driver.findElement(Skip).click();
		

	}
	public void login(String email,String password) throws InterruptedException {
		driver.findElement(Email_Textbox).sendKeys(email);
		driver.findElement(Continue_Button).click();
		driver.findElement(Password_TextBox).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(Login_Button).click();
	}
}
