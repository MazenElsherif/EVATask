package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.beust.jcommander.Parameters;
import com.mongodb.MapReduceCommand.OutputType;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	protected static WebDriver driver;
	public static Properties prop;
	protected ATUTestRecorder recorder;
	public static com.relevantcodes.extentreports.ExtentReports report;
	public static com.relevantcodes.extentreports.ExtentTest logger;
	ExtentReports extent;
	LocalDate myObj = LocalDate.now();
	HomePage homepageobject;

	@BeforeMethod
	@org.testng.annotations.Parameters({"browser"})
	public void start(@Optional("chrome") String browername,Method method) throws ATUTestRecorderException {
		if(browername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();}
		else if (browername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to(prop.getProperty("JumiaUrl"));
		startrecord(method.getName());
		logger=report.startTest(method.getName());
		 homepageobject=new HomePage(driver);
	}

	@AfterMethod
	public void end(Method method,ITestResult result) throws ATUTestRecorderException, IOException {

		takescreenshot(method.getName());
		recorder.stop();
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Pass");
			logger.log(LogStatus.PASS, "<a href='"+result.getName()+".png"+"'><span class='label info'>Download Snapshot</span></a>");
			logger.log(LogStatus.PASS, "<a href='"+result.getName()+".mov"+"'><span class='label info'>Download Video</span></a>");
			logger.setDescription("Mazen Report");

		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getThrowable());
			logger.log(LogStatus.PASS, "<a href='"+result.getName()+".png"+"'><span class='label info'>Download Snapshot</span></a>");
			logger.log(LogStatus.PASS, "<a href='"+result.getName()+".mov"+"'><span class='label info'>Download Video</span></a>");
		}
		else {
			logger.log(LogStatus.SKIP, "Test Skipped");
		}
		driver.quit();

	}
	@BeforeSuite
	public void startreport() {
		String reportpath=System.getProperty("user.dir")+"\\TestReport\\ExtentReportResults"+myObj+".html";
		report=new com.relevantcodes.extentreports.ExtentReports(reportpath,true);
		report.addSystemInfo("Reported By", "Mazen");
		report.loadConfig(new File(System.getProperty("user.dir")+"\\extent2.xml"));

	}
	@AfterSuite
	public void endreport() {
		report.flush();
	}
	public TestBase() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src/test/java\\properties\\data.properties");
		prop.load(fis);
	}
	public static void takescreenshot(String name) throws IOException, ATUTestRecorderException {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\TestReport\\"+name+".png"));

	}
	public void startrecord(String name) throws ATUTestRecorderException {
		recorder=new ATUTestRecorder(System.getProperty("user.dir")+"\\TestReport", name, false);
		recorder.start();
	}
}
