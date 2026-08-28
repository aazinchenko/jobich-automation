package ch.jobich.automation.enums;

public enum LanguageRegion {
  ALL_SWITZERLAND("All Switzerland"),
  DE("DE"),
  FR("FR"),
  IT("IT");

  private final String label;

  LanguageRegion(String label) {
    this.label = label;
  }

  public String label() {
    return label;
  }
}