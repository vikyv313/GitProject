package com.omrbranch.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.report.Reporting;
import com.omrbranch.utility.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, plugin = { "pretty",
		"json:target/output.json" }, features = "src/test/resources", glue = { "com.omrbranch.stepdefinition",
				"com.omrbranch.hooks" })
public class TestRunnerClass extends BaseClass {
	@AfterClass
	public static void afterClass() {
		Reporting.generateJvmReport(getProjectPath() + "//target//output.json");
	}

}
