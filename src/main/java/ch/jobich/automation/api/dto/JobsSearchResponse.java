package ch.jobich.automation.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobsSearchResponse {

  private List<JobDto> jobs;
  private int total; // elements Qty on the page
  private int totalCount; // overall Qty in db
  private int offset;
  private int limit;

  public List<JobDto> getJobs() { return jobs; }
  public void setJobs(List<JobDto> jobs) { this.jobs = jobs; }

  public int getTotal() { return total; }
  public void setTotal(int total) { this.total = total; }

  public int getTotalCount() { return totalCount; }
  public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

  public int getOffset() { return offset; }
  public void setOffset(int offset) { this.offset = offset; }

  public int getLimit() { return limit; }
  public void setLimit(int limit) { this.limit = limit; }
}