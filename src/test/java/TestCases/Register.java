package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.RegisterPage;

public class Register extends TestBase {

	public Register() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Test
	public void register() throws InterruptedException {
		
		homepageobject.cancel_popup();
	RegisterPage registerpageobject=	homepageobject.Signup();
		registerpageobject.Register(prop.getProperty("email"),prop.getProperty("password")
				,prop.getProperty("firstname"),prop.getProperty("lastname")
				,prop.getProperty("mobilenumber"),prop.getProperty("date"));
		Assert.assertEquals(driver.findElement(homepageobject.Logged).getText(),"Hi, "+prop.getProperty("firstname"));
	}

}
