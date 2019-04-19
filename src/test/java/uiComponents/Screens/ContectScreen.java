package uiComponents.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class ContectScreen extends Base {

	public static WebElement getField(String text) {
		
	return driver.findElement(By.id("contact-input-"+text));
	}
}
