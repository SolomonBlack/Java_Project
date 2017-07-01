package selenium_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebElement;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Wait;

public class FB_Automation_Script{

public static void chromelogin() throws Exception {
	System.setProperty("webdriver.chrome.Chromedriver", "C:/Users/Solomon/workspace/selenium_2/assets/drivers/chromedriver.exe");
	// Optional, if not specified, WebDriver will search your path for chromedriver.
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.facebook.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    //Ask any sort of person to input text with user email
    System.out.println("Please type in your username");
    Scanner Username_input = new Scanner(System.in); 
    String Username = Username_input.nextLine();
    
    //Ask any sort of person to input text with user password
    System.out.println("Please type in your password");
    Scanner Password_input = new Scanner(System.in); 
    String Password = Password_input.nextLine();
    
    //finds username input box then types in useremail based on user input
    System.out.println("Typing in Username");
    WebElement email_box = driver.findElement(By.id("email"));
    email_box.sendKeys(Username);
    
    //finds user password box then Types in password based on user input
    System.out.println("Typing in password");
    WebElement pass_box = driver.findElement(By.id("pass"));
    pass_box.sendKeys(Password);
    
    //Presses the log in button and then bring user to homepage
    System.out.println("Loggin in");
    WebElement log_in_button = driver.findElement(By.id("loginbutton"));
    log_in_button.click();
    
    //Wait for conteent box to be availible
    
    /*
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement Contentarea = driver.findElement(By.id("contentArea"));
    WebElement2 Failedlogin = driver.findElement(By.id("login_form"));
    
    if(Contentarea.isDisplayed())
    	{
    //Closes browser at the end of test
    	System.out.println("You have successfully logged in!");
    	driver.close();
    	}
    
    else if(Failedlogin.isDisplayed())
    	{	
    	System.out.println("You have failed to log in!");
    	driver.close();
    	}
    	*/

    boolean loginSuccess = false;
    try {
        WebElement contentarea = driver.findElement(By.id("contentArea"));
        loginSuccess = true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
        loginSuccess = false;
    }
    if(!loginSuccess)
    {
        System.out.println("Failed to log in");
    } else 
    {
        System.out.println("Login Success");
    }
 
    driver.close();    
 }

public static void Firefoxlogin() throws Exception {
	// Optional, if not specified, WebDriver will search your path for chromedriver.
    System.setProperty("webdriver.firefox.marionette", "C:/Users/Solomon/workspace/selenium_2/assets/drivers/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.get("http://www.facebook.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    //Ask any sort of person to input text with user email
    System.out.println("Please type in your username");
    Scanner Username_input = new Scanner(System.in); 
    String Username = Username_input.nextLine();
    
    //Ask any sort of person to input text with user password
    System.out.println("Please type in your password");
    Scanner Password_input = new Scanner(System.in); 
    String Password = Password_input.nextLine();
    
    //finds username input box then types in useremail based on user input
    System.out.println("Typing in Username");
    WebElement email_box = driver.findElement(By.id("email"));
    email_box.sendKeys(Username);
    
    //finds user password box then Types in password based on user input
    System.out.println("Typing in password");
    WebElement pass_box = driver.findElement(By.id("pass"));
    pass_box.sendKeys(Password);
    
    //Presses the log in button and then bring user to homepage
    System.out.println("Loggin in");
    WebElement log_in_button = driver.findElement(By.id("loginbutton"));
    log_in_button.click();
    
    //Test for valid user credentials
    boolean loginSuccess = false;
    try {
        WebElement contentarea = driver.findElement(By.id("contentArea"));
        loginSuccess = true;
    } catch (org.openqa.selenium.NoSuchElementException e) {
        loginSuccess = false;
    }
    if(!loginSuccess)
    {
        System.out.println("Failed to log in");
    } else 
    {
        System.out.println("Login Success");
    }
    
    //Closes browser at the end of test
    driver.close();
 }
	
public static void main(String[] args) throws Exception {
    System.out.println("STARTING!");
    System.out.println("Which browser are you currently using?");
    Scanner Browser_input = new Scanner(System.in);    
    String Browser = Browser_input.nextLine();
    	if (Browser.equals("Chrome"))
			chromelogin();
		else if (Browser.equals("Firefox"))
    		Firefoxlogin();
    	else
    		System.out.println("Please enter a proper Browser name");
    System.out.println("ENDING!");
   
  }
  
}
