package ch.jobich.automation.api;

import ch.jobich.automation.api.dto.JobsSearchResponse;
import ch.jobich.automation.config.ConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

import java.util.Locale;

public class JobsApiClient implements AutoCloseable {

  // Playwright.request() - for operating api requests

  private final Playwright playwright;
  private final APIRequestContext request;
  private final ObjectMapper mapper = new ObjectMapper();

  public JobsApiClient() {
    this.playwright = Playwright.create();
    this.request = playwright.request().newContext(new APIRequest.NewContextOptions()
          .setBaseURL(ConfigReader.getInstance().config().getBaseUrl()));
  }

  public APIResponse searchRaw(String query, int limit) {
    String path = String.format(Locale.ROOT,
          "/api/jobs?q=%s&limit=%d&sort=date&sort_dir=desc", query, limit);
    return request.get(path);
  }

  public JobsSearchResponse search(String query, int limit) {
    APIResponse response = searchRaw(query, limit);

    if (!response.ok()) {
      throw new IllegalStateException(
            "GET /api/jobs failed: " + response.status() + " " + response.statusText());
    }

    try {
      return mapper.readValue(response.text(), JobsSearchResponse.class);
    } catch (Exception e) {
      throw new IllegalStateException(
            "Failed to parse /api/jobs", e);
    }
  }

  @Override
  public void close() {
    request.dispose();
    playwright.close();
  }
}