package ch.jobich.automation;

import ch.jobich.automation.base.BaseUiTest;
import ch.jobich.automation.config.ConfigReader;
import ch.jobich.automation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseUiTest {

  @Test
  public void homePageHasPrivacyPolicyLink() {
    HomePage homePage = new HomePage(page);
    homePage.open(ConfigReader.getInstance().config().getBaseUrl());

    Assert.assertTrue(homePage.footer().privacyPolicyLink().isVisible());
  }
}