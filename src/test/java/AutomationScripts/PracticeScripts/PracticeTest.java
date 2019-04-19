package AutomationScripts.PracticeScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import uiComponents.Screens.PracticePage;
import uiComponents.Screens.QaHome;
import utilities.RandomUtility;
import utilities.RandomUtility.Mode;
import base.Base;

public class PracticeTest extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test
	public void shouldAnswerWithTrue() throws Exception {
		try {
			Thread.sleep(20000);
			String email = RandomUtility.generateRandomString(5, Mode.ALPHA);
			QaHome.getpopupemail().sendKeys(email + "@" + email + ".com");
			Thread.sleep(5000);
			QaHome.getNoThanksButton().click();
			QaHome.getPracticeButton().click();
			PracticePage.getOpenWindowButton().click();
			log.info("Worked");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Radio button testcases.
	@Test
	public void radio() throws IOException, InterruptedException {
		try {
			QaHome.getPracticeButton().click();
			log.info("Worked");

			WebElement radio = PracticePage.grtRadioBox();
			int size = radio.findElements(PracticePage.allRadio).size();
			System.out.println(size);

            // Validating radio box Title
			System.out.println(radio.findElement(PracticePage.radioBoxTitle).getText());

            // Selecting all radio buttons
			for (int i = 0; i < size; i++) {
				radio.findElements(PracticePage.allRadio).get(i).click();
				Thread.sleep(1000);
			}

            // Selecting by text radio2 button
			for (int i = 0; i < size; i++) {

				String button = radio.findElements(PracticePage.allRadio).get(i).getAttribute("value");
				if (button.contains("radio2")) {
					radio.findElements(PracticePage.allRadio).get(i).click();
					Assert.assertEquals(false, PracticePage.grtradioButton2().isSelected());

				}

				System.out.println(radio.findElements(PracticePage.allRadio).get(i).isSelected());

				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// AUTO Suggest
	@Test
	public void autoSuggestTest() throws IOException, InterruptedException {

		QaHome.getPracticeButton().click();
		log.info("Worked");
		PracticePage.grtAutoSuggestBox().click();
		PracticePage.grtAutoSuggestBox().sendKeys("United States");
		Thread.sleep(3000);
		PracticePage.grtAutoSuggestBox().sendKeys(Keys.ARROW_DOWN);
		PracticePage.grtAutoSuggestBox().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		System.out.print(PracticePage.grtAutoSuggestBox().getText());
	}

//DROPDOWN select
	@Test
	public void dropdownTest() throws IOException {
		log.info("Worked");
		QaHome.getPracticeButton().click();
		PracticePage.grtDropdown().click();
		Select s = new Select(PracticePage.grtDropdown());
		s.selectByVisibleText("Option2");
		PracticePage.grtDropdown().click();

	}

	// CHECKBOX
	@Test
	public void checkBoxTest() throws IOException, InterruptedException {
		log.debug("Debuged");
		QaHome.getPracticeButton().click();
		WebElement c = driver.findElement(PracticePage.checkBox);
		int size = driver.findElements(PracticePage.allchekbox).size();
		// Selecting all available boxes
		for (int i = 0; i < size; i++) {
			c.findElements(PracticePage.allchekbox).get(i).click();
			Thread.sleep(1000);
		}

		// deselecting option2
		for (int i = 0; i < size; i++) {
			String button = c.findElements(PracticePage.allchekbox).get(i).getAttribute("value");
			System.out.println(button);
			if (button.contains("option2")) {
				c.findElement(By.id("checkBoxOption2")).click();
				Thread.sleep(1000);
			}

		}
		Thread.sleep(1000);

	}

}
