package com.ui.pojo;

import java.util.Map;

public class Config {

	Map<String, Environment> environments;

	// getters & setters
	public Map<String, Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Map<String, Environment> environments) {
		this.environments = environments;
	}

}
