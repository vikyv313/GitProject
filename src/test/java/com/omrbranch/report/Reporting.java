package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.omrbranch.utility.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends BaseClass {

	public static void generateJvmReport(String jsonFile) {
		Configuration configuration = new Configuration(new File(getProjectPath() + "//target"),
				"OMR Branch Automation");

		configuration.addClassifications("Browser", "CHROME");
		configuration.addClassifications("Browser Version", "123");
		configuration.addClassifications("Author", "Ramesh");
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

}
