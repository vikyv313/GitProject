package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC001_LoginStep {
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the omrbranch page")
	public void user_is_on_the_omrbranch_page() {
	}

	@When("User perfrom login {string},{string}")
	public void user_perfrom_login(String emailId, String password) {
		pom.getLoginPage().login(emailId, password);
	}

	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String expLoginMessage) {
		String actLoginMessageText = pom.getExploreHotelPage().getLoginMessageText();
		Assert.assertEquals("Verify after login", expLoginMessage, actLoginMessageText);
	}

}
