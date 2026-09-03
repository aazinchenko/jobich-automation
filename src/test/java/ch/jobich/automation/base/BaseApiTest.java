package ch.jobich.automation.base;

import ch.jobich.automation.api.JobsApiClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseApiTest {

  protected JobsApiClient jobsApi;

  @BeforeMethod(alwaysRun = true)
  public void createClient() {
    jobsApi = new JobsApiClient();
  }

  @AfterMethod(alwaysRun = true)
  public void closeClient() {
    if (jobsApi != null) {
      jobsApi.close();
    }
  }
}
