package com.abhi.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue= "com.abhi.stepdefinition", dryRun = false, features = "C:\\Users\\Saravana\\Abhidoc\\src\\test\\resources\\Feature")

public class TestRunnerClass {

}



	
	

