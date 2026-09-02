package ch.jobich.automation;

import ch.jobich.automation.api.dto.JobsSearchResponse;
import ch.jobich.automation.base.BaseApiTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobsApiTest extends BaseApiTest {

  @Test
  public void searchByTeacherReturnsResults() {
    JobsSearchResponse response = jobsApi.search("teacher", 5);

    Assert.assertNotNull(response.getJobs(), "jobs list should not be null");
    Assert.assertFalse(response.getJobs().isEmpty(), "expected at least one job");
    Assert.assertTrue(response.getTotalCount() > 0, "totalCount should be greater than 0");
  }
}