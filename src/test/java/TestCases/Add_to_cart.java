package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.RegisterPage;
import Pages.ShirtsPage;

public class Add_to_cart extends TestBase {

	public Add_to_cart() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Test
	public void Add_To_Cart() throws InterruptedException {


		homepageobject.cancel_popup();
		RegisterPage registerpageobject=homepageobject.Signup();
		registerpageobject.login(prop.getProperty("email"),prop.getProperty("password"));

		Assert.assertEquals(driver.findElement(homepageobject.Logged).getText(),"Hi, "+prop.getProperty("firstname"));
		ShirtsPage shirtpageobject =homepageobject.Go_To_Shirts();
		CartPage	cartpageobject= shirtpageobject.add_item_to_cart();
		cartpageobject.Increase_qty();

		Assert.assertTrue(driver.findElement(cartpageobject.First_Item).isDisplayed());
		Assert.assertTrue(driver.findElement(cartpageobject.Second_Item).isDisplayed());
		String First_Price=driver.findElement(cartpageobject.FirstPrice).getText();
		String first=First_Price.replace("EGP ", "");
		String Second_Price=driver.findElement(cartpageobject.SecondPrice).getText();
		String second=Second_Price.replace("EGP ", "");
		String Total_Price=driver.findElement(cartpageobject.Total).getText();
		String total=Total_Price.replace("EGP ", "");
		String total1=total.replace(",", "");

		Double t=Double.parseDouble(first);
		System.out.println(t);
		Double s=Double.parseDouble(second);
		System.out.println(s);
		Double y=Double.parseDouble(total1);
		System.out.println(y);
		Assert.assertTrue(y==((t*2)+(s*2)));		

	}

}
