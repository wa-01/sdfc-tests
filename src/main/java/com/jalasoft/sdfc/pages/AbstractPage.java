package com.jalasoft.sdfc.pages;

import com.jalasoft.sdfc.core.ui.DriverManager;
import com.jalasoft.sdfc.core.ui.WebDriverAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected WebDriverAction action;

	public AbstractPage() {
		driver = DriverManager.getInstance().getDriver();
		wait = DriverManager.getInstance().getWait();
		action = new WebDriverAction(driver, wait);

		PageFactory.initElements(driver, this);
	}
}
