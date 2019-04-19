package uiComponents.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class QaHome extends Base {
	
	public static By practiceButton = By.xpath("//div[@class='container']/nav/ul/li[5]");
	public static By blogButton = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul/li[6]/a");
	public static final By popup = By.xpath("//div[@class='listbuilder-popup-content']");
	public static final By noThanksButton = By.xpath("//*[@id=\"homepage\"]/div[5]/div[2]/div/div/div/span/div/div[6]/div/div/button");
	public static final By popupEmail = By.xpath("//*[@id='homepage']/div[5]/div[2]/div/div/div/span/div/div[5]/div/div/input");
	public static final By testButton = By.xpath("//*[@id=\"newsletter\"]/div[2]/div[3]/a");
	public static final By navigationBar = By.className("container");
	
	public static WebElement getPracticeButton() {
		return driver.findElement(practiceButton);
	}
	public static WebElement getBlogButton() {
		return driver.findElement(blogButton);
	}
	public static WebElement getpopup() {
		return driver.findElement(popup);
	}
	public static WebElement getNoThanksButton() {
		return driver.findElement(noThanksButton);
	}
	public static WebElement getpopupemail() {
		return driver.findElement(popupEmail);
	}
	public static WebElement getTestButton() {
		return driver.findElement(testButton);
	}
	
	//GENERALIZED METHOD TO NAVIGATE 
	public static WebElement getNavigation(String text) {
		WebElement nav =driver.findElement(navigationBar);
		return nav.findElement(By.xpath("//*[text()='"+text+"']"));
		
	}

}
