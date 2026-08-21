package ch.jobich.automation.config;

public class EnvironmentConfig {

  private String baseUrl;
  private boolean headless;
  private String browser;

  public String getBaseUrl() {
    return baseUrl;
  }

  public boolean isHeadless() {
    return headless;
  }

  public void setHeadless(boolean headless) {
    this.headless = headless;
  }

  public String getBrowser() {
    return browser;
  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }
}