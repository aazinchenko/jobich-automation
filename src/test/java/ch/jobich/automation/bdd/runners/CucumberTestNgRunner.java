package ch.jobich.automation.bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
      features = "src/test/resources/features",
      glue = "ch.jobich.automation.bdd",
      plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class CucumberTestNgRunner extends AbstractTestNGCucumberTests {
}