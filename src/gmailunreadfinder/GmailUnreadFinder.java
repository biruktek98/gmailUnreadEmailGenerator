/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailunreadfinder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver; 
/**
 *
 * @author G
 */
public class GmailUnreadFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here
         System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
         WebDriver driver;
         driver = new FirefoxDriver();
         
         driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
         
         driver.findElement(By.id("identifierId")).sendKeys("biruktek1998@gmail.com");
         driver.findElement(By.id("identifierNext")).click();
         Thread.sleep(2000);
         driver.findElement(By.name("password")).sendKeys("password");
         driver.findElement(By.id("passwordNext")).click();
         Thread.sleep(10000);
         
         File list = new File("./emailsList.txt");
         BufferedWriter writer = new BufferedWriter(new FileWriter(list));
         List<WebElement> unread = driver.findElements(By.className("zE"));
         for(WebElement email: unread){
             //location of the sender element:
             writer.write(email.findElement(By.className("yW")).getText());
             //location of the subject element:
             writer.write(email.findElement(By.className("y6")).getText());
         }
         
         
         
         
    }
    
}
