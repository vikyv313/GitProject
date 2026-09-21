package com.omrbranch.pagemanager;

import com.omrbranch.pages.ExploreHotelPage;
import com.omrbranch.pages.LoginPage;

public class PageObjectManager {
	private LoginPage loginPage;
	private ExploreHotelPage exploreHotelPage;

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public ExploreHotelPage getExploreHotelPage() {
		return (exploreHotelPage == null) ? exploreHotelPage = new ExploreHotelPage() : exploreHotelPage;
	}

}
