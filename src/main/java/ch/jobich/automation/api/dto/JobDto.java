package ch.jobich.automation.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //ignoring unexpected new fields in response
public class JobDto {

  private String title;
  private String company;
  private String location;
  private String url;
  private String datePosted;
  private String source;
  private int matchScore;
  private String roleType;
  private String language;
  private String industry;
  private String workMode;
  private String employmentType;
  private String canton;

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getCompany() { return company; }
  public void setCompany(String company) { this.company = company; }

  public String getLocation() { return location; }
  public void setLocation(String location) { this.location = location; }

  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }

  public String getDatePosted() { return datePosted; }
  public void setDatePosted(String datePosted) { this.datePosted = datePosted; }

  public String getSource() { return source; }
  public void setSource(String source) { this.source = source; }

  public int getMatchScore() { return matchScore; }
  public void setMatchScore(int matchScore) { this.matchScore = matchScore; }

  public String getRoleType() { return roleType; }
  public void setRoleType(String roleType) { this.roleType = roleType; }

  public String getLanguage() { return language; }
  public void setLanguage(String language) { this.language = language; }

  public String getIndustry() { return industry; }
  public void setIndustry(String industry) { this.industry = industry; }

  public String getWorkMode() { return workMode; }
  public void setWorkMode(String workMode) { this.workMode = workMode; }

  public String getEmploymentType() { return employmentType; }
  public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }

  public String getCanton() { return canton; }
  public void setCanton(String canton) { this.canton = canton; }
}
