package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtlity {

	public static Environment readJSON(Env env) {

		Gson gson = new Gson();

		String path = System.getProperty("user.dir") + "\\config\\config.json";
		File jsonFile = new File(path);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get("QA");
		return environment;

	}
}
