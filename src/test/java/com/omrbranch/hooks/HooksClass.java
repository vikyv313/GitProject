package com.omrbranch.hooks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.omrbranch.utility.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	Logger log = LogManager.getLogger(HooksClass.class);

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		browserLaunch(getPropertyFileValue("browser"));
		log.info("Browser Launch");
		enterApplicationUrl(getPropertyFileValue("url"));
		log.info("Enter URL");
		maximizeWindow();
		log.info("Maximize Window");
		implictlyWait();

	}

	@AfterStep
	public void afterEachStep(Scenario scenario) {
		scenario.attach(screenshot(), "images/png", "Every Step");
	}

	@After
	public void afterScenario() {
		closeBrowser();
	}

}
