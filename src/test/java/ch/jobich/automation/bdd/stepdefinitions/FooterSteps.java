package ch.jobich.automation.bdd.stepdefinitions;

import ch.jobich.automation.bdd.hooks.TestContext;
import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class FooterSteps {
  private final TestContext testContext;
  private HomePage homePage;

  public FooterSteps(TestContext testContext) {
    this.testContext = testContext;
  }

  @Given("I open the Jobich home page")
  public void iOpenTheJobichHomePage() {
    homePage = new HomePage(testContext.getPage());
    homePage.open(ConfigReader.getInstance().config().getBaseUrl());
  }

  @Then("the footer {string} link is visible")
  public void theFooterLinkIsVisible(String linkName) {
    boolean visible = switch (linkName) {
      case "Privacy Policy" -> homePage.footer().privacyPolicyLink().isVisible();
      case "Terms of Use"   -> homePage.footer().termsOfUseLink().isVisible();
      case "LinkedIn"       -> homePage.footer().LinkedInLink().isVisible();
      case "Imprint"        -> homePage.footer().ImprintLink().isVisible();
      case "Email"          -> homePage.footer().EmailLink().isVisible();
      case "Feedback"       -> homePage.footer().FeedbackLink().isVisible();
      default -> throw new IllegalArgumentException("Unknown footer link: " + linkName);
    };
    Assert.assertTrue(visible, linkName + " link should be visible");
  }
}
