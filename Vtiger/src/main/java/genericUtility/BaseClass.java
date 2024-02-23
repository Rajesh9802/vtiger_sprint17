package genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.jdbc.Driver;

import pomRepository.HomePage;
import pomRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public JavaUtility jUtils = new JavaUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	public DataBaseUtility dUtils = new DataBaseUtility();
	public static WebDriver sDriver;
    public Connection connection;
    
    
	@BeforeSuite
	public void bsConfig() throws SQLException {
		// SQL instance
		Driver dataBaseDriver = new Driver(); // class of mySql
		// JDB(Java Data Base) Register with my SQL
		DriverManager.registerDriver(dataBaseDriver); // class of java
		// Connection Establish
	    connection = DriverManager.getConnection(IPathConstant.DATA_BASE_URL, IPathConstant.DATA_BASE_USERNAME, IPathConstant.DATA_BASE_PASSWORD); // database
																													// connection
																													// established
		System.out.println("Data base connection Achieved");
	}

	@BeforeClass(groups = {"smoke", "regression"})
	public void bcConfig() throws IOException {
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		System.out.println("The browser is launched");
		sDriver = driver;

		wUtils.maximizeTheWindow(driver);
		wUtils.waitForElementsToLoaded(driver);
		driver.get(url);
		System.out.println("The URL is navigated");
	}

	@BeforeMethod(groups = {"smoke", "regression"})
	public void bmConfig() throws IOException {

		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");

		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("Login into the Application");
	}

	@AfterMethod(groups = {"smoke", "regression"})
	public void amConfig() {

		HomePage homepage = new HomePage(driver);
		homepage.signoutAction();
		System.out.println("Sign out from application");
	}

	@AfterClass(groups = {"smoke", "regression"})
	public void acConfig() {
		driver.quit();
		System.out.println("The browser is closed");
	}

	@AfterSuite
	public void asConfig() throws SQLException {
		 connection.close();
		System.out.println("Data base connection is closed");
	}

}
