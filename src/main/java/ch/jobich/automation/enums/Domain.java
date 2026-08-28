package ch.jobich.automation.enums;

public enum Domain {
  IT_SOFTWARE("IT & Software"),
  HEALTHCARE_PHARMA("Healthcare & Pharma"),
  FINANCE_INSURANCE("Finance & Insurance"),
  ENGINEERING_MANUFACTURING("Engineering & Manufacturing"),
  CONSTRUCTION_REAL_ESTATE("Construction & Real Estate"),
  ENERGY_UTILITIES("Energy & Utilities"),
  LOGISTICS_TRANSPORT("Logistics & Transport"),
  SALES_RETAIL("Sales & Retail"),
  MARKETING_MEDIA("Marketing & Media"),
  EDUCATION_ACADEMIA("Education & Academia"),
  GOVERNMENT_PUBLIC("Government & Public"),
  HOSPITALITY_TOURISM("Hospitality & Tourism"),
  BUSINESS_CONSULTING("Business & Consulting");

  private final String label;

  Domain(String label) {
    this.label = label;
  }

  public String label() {
    return label;
  }
}