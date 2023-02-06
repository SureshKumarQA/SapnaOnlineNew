package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;

public class LoginPage {

	private static WebDriver driver;
	private static int x;
	private static By myAccountLinkXpath = By.xpath("//div[contains(text(),'My Account')]");
	private static By exisitngUserTabXpath = By.xpath("//a[contains(text(),'Existing User')]");
	private static By userNameTextXpath = By.xpath("//input[@placeholder='Email Address']");
	private static By passWordTextXpath = By.xpath("//input[@placeholder='Enter Password']");
	private static By ContinueBtnXpath = By.xpath("//div[@class='sc-Axmtr iPDAko ButtonText']");
	private static By healthCareTabXpath = By.xpath("//div[contains(text(),'Health Care')]");
	private static By faceMasksubTabXpath = By.xpath("//div[contains(text(),'Face Masks')]");
	private static By faceMaskPageTextXpath = By.xpath("//div[@class='sc-Axmtr CategoryTab__Title-sc-1otr9x4-3 kGFUAT']/h1");
private static By faceMaskItemXpath = By.xpath("//*[@id=\"infinite-container\"]/div/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/a/h2");
private static By faceMaskItemTextPath = By.xpath("//div[@class='sc-Axmtr ProductImageDetailCard__TitleText-xxaxm9-1 dJMXcH']/h1");
private static By faceMaskAddToCartPath = By.xpath("//button[@btnsize='MEDIUM'])[1]/div[2]");


	public static void writeText(By xpath, String sendKeysvalue) {

		driver.findElement(xpath).sendKeys(sendKeysvalue);
		
		
		
	}

	public WebDriver getDriver() {

		return driver;

	}

	public static void onClick(By xpath) {

		driver.findElement(xpath).click();
	}

	public static String getText(By xpath) {
		String givenValue =  driver.findElement(xpath).getText();
		return givenValue;
	}

	
	public static void moveToElement(WebElement ele) {
		Actions action = new Actions(driver);

		action.moveToElement(ele).perform();
	}
	public static void moveToElementAndClick(WebElement ele) {
		Actions action = new Actions(driver);

		action.moveToElement(ele).click().build().perform();
	}

	public static void waitUntilElementPresent(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(4000));
		wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
	}

	public static void launchBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsi\\OneDrive\\Desktop\\chromedriver.exe");
		int x = 10;
		ChromeOptions popupBlocker = new ChromeOptions();
		popupBlocker.addArguments("--disable-notifications");

		driver = new ChromeDriver(popupBlocker);

		driver.get("https://www.sapnaonline.com");
		driver.manage().window().maximize();

		Thread.sleep(4000);
	}

	/*
	 * public static void myAccountClick() { onClick(myAccountLinkXpath);
	 * //driver.findElement(myAccountLinkXpath).click(); }
	 * 
	 * public static void exisitngUserElementClick() {
	 * 
	 * onClick(exisitngUserTabXpath);
	 * 
	 * WebElement exsistingUser = driver.findElement(exisitngUserTabXpath);
	 * 
	 * exsistingUser.click();
	 * 
	 * }
	 */

	public static void login() throws InterruptedException {
		launchBrowser();
		onClick(myAccountLinkXpath);
		onClick(exisitngUserTabXpath);
		writeText(userNameTextXpath, "kumar.suresh575@gmail.com");
		writeText(passWordTextXpath, "Hire@1234");
		onClick(ContinueBtnXpath);
	}

	public static void HealthCare() throws InterruptedException {
		Thread.sleep(3000);
		//waitUntilElementPresent(healthCareTabXpath);
		moveToElement(driver.findElement(healthCareTabXpath));
		Thread.sleep(2000);
		waitUntilElementPresent(faceMasksubTabXpath);
		
	}
	public static void faceMask() {
		WebElement facemask = driver.findElement(faceMasksubTabXpath);
		moveToElementAndClick(facemask);
		String actualfaceMaskText = getText(faceMaskPageTextXpath);
		boolean flagFaceMask = false;
		if (actualfaceMaskText.equalsIgnoreCase("FACE MASKS")) {
			flagFaceMask = true;
		}
		Assert.assertTrue(flagFaceMask);

	}

	public static void main(String[] args) throws InterruptedException {
		login();
		HealthCare();
		faceMask();
	
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow"+parentWindow);
		
		onClick(faceMaskItemXpath);
		
		Set<String> childWindows = driver.getWindowHandles();
		
		Iterator<String> eachWindowIterator= childWindows.iterator();
		while(eachWindowIterator.hasNext()) {
			
			String childWindow = eachWindowIterator.next();
			if(!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("childwindow"+driver.getWindowHandle());
		
		onClick(By.xpath("(//button[@btnsize='MEDIUM'])[1]/div[2]"));
		
		
		
		
    
		/*
		 * launchBrowser(); myAccountClick(); exisitngUserElementClick();
		 */

		// driver.findElement(By.xpath("//input[@placeholder='Email
		// Address']")).sendKeys();

		/*
		 * driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).
		 * sendKeys("Hire@1234");
		 * 
		 * driver.findElement(By.xpath("//div[@class='sc-Axmtr iPDAko ButtonText']")).
		 * click();
		 */
		// Thread.sleep(4000);

		// WebElement ele = driver.findElement(healthCareTabXpath);

		/*
		 * Actions action = new Actions(driver);
		 * 
		 * action.moveToElement(ele).perform();
		 */
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(20));
		 * wait.until(ExpectedConditions..visibilityOfElementLocated(healthCareTabXpath)
		 * );
		 */

		

		// driver.findElement(By.xpath("//div[contains(text(),'Face Masks')]")).click();

	
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		//onClick();
		
		

		// Assert.assertEquals("Both Expected FaceMask and Actual value "+
		// FaceMaskpageText + " Did Not Meet" + FaceMaskpageText,"FACE MASKS");

		// driver.findElement(By.xpath("//img[@alt='Cross Color Ultra Shield Reusable
		// Face Mask']")).click();

		// String FaceMaskItemText = driver.findElement(null)

	}
}
