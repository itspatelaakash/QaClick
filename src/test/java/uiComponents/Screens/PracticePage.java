package uiComponents.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class PracticePage extends Base {

	// Open NEW WINDOW
	public static final By openWindowbutton = By.id("openwindow");

	// RADIO
	public static final By radioBox = By.id("radio-btn-example");
	public static final By radioBoxTitle = By.xpath("//*[@id=\"radio-btn-example\"]/fieldset/legend");
	public static final By allRadio = By.xpath("//input[@type='radio']");
	public static final By radio = By.id("radio-btn-example");
	public static final By radioButton2 = By.xpath("//input[@value='radio2']");
	public static final By showButton = By.id("show-textbox");
	public static final By hideButton = By.id("hide-textbox");
	// AUTO SUGGEST
	public static final By autosuggestbox = By.id("autocomplete");

	// dropdown-class-example
	public static final By dropdown = By.id("dropdown-class-example");

	// Checkbox
	public static final By checkBox = By.id("checkbox-example");
	public static final By allchekbox = By.xpath("//input[@type='checkbox']");

	public static WebElement getOpenWindowButton() {
		return driver.findElement(openWindowbutton);
	}

	public static WebElement grtRadioBox() {
		return driver.findElement(openWindowbutton);
	}

	public static WebElement grtradioBoxTitle() {
		return driver.findElement(radioBoxTitle);
	}

	public static WebElement grtradioButton2() {
		return driver.findElement(radioButton2);
	}

	// AUTO SUGGEST
	public static WebElement grtAutoSuggestBox() {
		return driver.findElement(autosuggestbox);
	}

	// dropdown
	public static WebElement grtDropdown() {
		return driver.findElement(dropdown);
	}

	// Checkbox
	public static WebElement grtAllchekbox() {
		return driver.findElement(allchekbox);
	}

	// ShowButton
	public static WebElement grtShowButton() {
		return driver.findElement(showButton);
	}

	public static WebElement grtHideButton() {
		return driver.findElement(hideButton);
	}

}
