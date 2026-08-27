package ch.jobich.automation;

import ch.jobich.automation.base.BaseUiTest;
import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends BaseUiTest {

  private HomePage homePage;

  @BeforeMethod(alwaysRun = true)
  public void openHome() {
    homePage = openHomePage();
  }

  @Test
  public void homePageHasPrivacyPolicyLink() {
    Assert.assertTrue(homePage.footer().privacyPolicyLink().isVisible());
  }

  @Test
  public void homePageHasTermsOfUseLink(){
    Assert.assertTrue(homePage.footer().termsOfUseLink().isVisible());
  }

  @Test
  public void homePageHasLinkedInLink(){
    Assert.assertTrue(homePage.footer().LinkedInLink().isVisible());
  }

  @Test
  public void homePageHasImprintLink(){
    Assert.assertTrue(homePage.footer().ImprintLink().isVisible());
  }

  @Test
  public void homePageHasEmailLink(){
    Assert.assertTrue(homePage.footer().EmailLink().isVisible());
  }

  @Test
  public void homePageHasFeedbackLink(){
    Assert.assertTrue(homePage.footer().FeedbackLink().isVisible());
  }

}