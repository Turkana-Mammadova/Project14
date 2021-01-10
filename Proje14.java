package Proje14;

import day06.MyConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Project14 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().window().maximize();


        WebElement inputemail = driver.findElement(By.cssSelector("input[type='email']"));
        inputemail.sendKeys("tmemmedova47@gmail.com");
        WebElement inputpassword = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        inputpassword.sendKeys("technostudy@123");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='New Address']")));
        driver.findElement(By.xpath("//*[text()='New Address']")).click();



        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='address[first_name]'")));
        WebElement fname=driver.findElement(By.cssSelector("input[name='address[first_name]'"));
        fname.sendKeys("Fernando");

        WebElement lname=driver.findElement(By.id("address_last_name"));
        lname.sendKeys("Torres");

        WebElement address1=driver.findElement(By.id("address_street_address"));
        address1.sendKeys("Anfield Rd");

        WebElement address2=driver.findElement(By.id("address_secondary_address"));
        address2.sendKeys("Anfield");

        WebElement city=driver.findElement(By.id("address_city"));
        city.sendKeys("Liverpool");

        List<WebElement> options = driver.findElements(By.cssSelector("#address_state>option"));
        Random random=new Random();
        int num=random.nextInt(options.size()+1);
        for (int i = 0; i < options.size(); i++) {
            options.get(num).click();
        }

        WebElement zip=driver.findElement(By.id("address_zip_code"));
        zip.sendKeys("L4 0TH");


        driver.findElement(By.id("address_country_us")).click();

        WebElement date=driver.findElement(By.id("address_birthday"));
        date.sendKeys("03/20/1984");

        WebElement dob=driver.findElement(By.id("address_age"));
        dob.sendKeys("36");

        WebElement webpage=driver.findElement(By.id("address_website"));
        webpage.sendKeys("https://www.google.com/");

        WebElement phone=driver.findElement(By.id("address_phone"));
        phone.sendKeys("8625747878");

        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();


        WebElement note=driver.findElement(By.id("address_note"));
        note.sendKeys("Never Back Down");

        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        String currentUrl = driver.getCurrentUrl();

        driver.get(currentUrl);
        driver.manage().window().maximize();

        String getname=driver.findElement(By.cssSelector("span[data-test=first_name]")).getText();
        if(getname.equals("Fernando")){
            System.out.println(true);
        }else {System.out.println(false);}


        String getlname=driver.findElement(By.cssSelector("span[data-test=last_name]")).getText();
        if(getlname.equals("Torres")){
            System.out.println(true);
        }else System.out.println(false);

        driver.findElement(By.cssSelector("a[data-test=\"addresses\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td:nth-child(6) > a")));
        driver.findElement(By.cssSelector("td:nth-child(6) > a")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='address[first_name]'")));
        WebElement editedname=driver.findElement(By.cssSelector("input[name='address[first_name]'"));
        editedname.clear();
        editedname.sendKeys("Peter");

        WebElement editedlname=driver.findElement(By.id("address_last_name"));
        editedlname.clear();
        editedlname.sendKeys("Crouch");

        driver.findElement(By.cssSelector(" input[type=\"submit\"]")).click();



        String geteditedname=driver.findElement(By.cssSelector("span[data-test=first_name]")).getText();
        if(geteditedname.equals("Peter")){
            System.out.println(true);
        }else {System.out.println(false);}


        String geteditedlname=driver.findElement(By.cssSelector("span[data-test=last_name]")).getText();
        if(geteditedlname.equals("Crouch")){
            System.out.println(true);
        }else System.out.println(false);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[data-test=\"addresses\"]")));
        driver.findElement(By.cssSelector("a[data-test=\"addresses\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td:nth-child(7) > a")));
        driver.findElement(By.cssSelector("td:nth-child(7) > a")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        List<WebElement> l= driver.findElements(By.xpath("//*[contains(text()='Peter')]"));
        if ( l.size() > 0){
            System.out.println("The addres is stil exist.");
        } else {
            System.out.println("The addres is not exist on current URL.");
        }

        driver.quit();
    }

}


