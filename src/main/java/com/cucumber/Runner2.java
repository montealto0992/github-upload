package com.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/test1.feature",
                        glue = "com/cucumber",
                   plugin = {"html:target/test-report",
                             "junit:target/junit-xml-report.xml",
                             "json:target/json-report.json"})

public class Runner2 {

}
