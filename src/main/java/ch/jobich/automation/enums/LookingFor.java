package ch.jobich.automation.enums;

public enum LookingFor {
  REMOTE("Remote"),
  HYBRID("Hybrid"),
  ONSITE("Onsite"),
  FULL_TIME("Full-time"),
  PART_TIME("Part-time"),
  CONTRACT("Contract");

  private final String label;

  LookingFor(String label) {
    this.label = label;
  }

  public String label() {
    return label;
  }
}