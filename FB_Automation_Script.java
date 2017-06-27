package selenium_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.Scanner;

public class FB_Automation_Script{

public static void Facebooklogin() throws InterruptedException {
	// Optional, if not specified, WebDriver will search your path for chromedriver.
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.facebook.com");
    // Let the user actually see something!
    Thread.sleep(5000);
    
    System.out.println("Please type in your username and password");
    
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
    Thread.sleep(5000);
    
    //finds user password box then Types in password based on user input
    System.out.println("Typing in password");
    WebElement pass_box = driver.findElement(By.id("pass"));
    pass_box.sendKeys(Password);
    Thread.sleep(5000);
    
    //Presses the log in button and then bring user to homepage
    System.out.println("Loggin in");
    WebElement log_in_button = driver.findElement(By.id("loginbutton"));
    log_in_button.click();
 }
	
  public static void main(String[] args) throws InterruptedException {
    System.out.println("STARTING!");
    Facebooklogin();
    System.out.println("ENDING!");
  }
}
