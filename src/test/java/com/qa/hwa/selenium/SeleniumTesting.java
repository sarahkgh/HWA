package com.qa.hwa.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTesting {

	private WebDriver driver;

	@BeforeEach
	void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}

	@Test
	public void testIndexPageOpening() {
		driver.get("http://127.0.0.1:5500/index.html");
		Assertions.assertEquals("Courses Page", driver.getTitle());
	}

	@Test
	public void testCreateCourse() {
		driver.get("http://127.0.0.1:5500/addCourse.html");
	}

	@Test
	public void testCreateUser() {
		driver.get("http://127.0.0.1:5500/addUser.html");
	}

	@Test
	public void testDeleteCourse() {
		driver.get("http://127.0.0.1:5500/deleteCourse.html");
	}

	@Test
	public void testDeleteUser() {
		driver.get("http://127.0.0.1:5500/deleteUser.html");
	}

	@Test
	public void testUpdateUser() {
		driver.get("http://127.0.0.1:5500/updateUser.html");
	}

	@Test
	public void testUpdateCourse() {
		driver.get("http://127.0.0.1:5500/updateCourse.html");
	}

	@AfterEach
	void teardown() {
		driver.close();
	}
}