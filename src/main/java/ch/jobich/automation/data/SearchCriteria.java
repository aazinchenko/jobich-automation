package ch.jobich.automation.data;

import ch.jobich.automation.enums.Domain;
import ch.jobich.automation.enums.LanguageRegion;
import ch.jobich.automation.enums.LookingFor;

import java.util.ArrayList;
import java.util.List;

public final class SearchCriteria {

  private final String query;
  private final LanguageRegion region;
  private final Domain domain;
  private final List<LookingFor> filters;

  private SearchCriteria(Builder builder) {
    this.query = builder.query;
    this.region = builder.region;
    this.domain = builder.domain;
    this.filters = builder.filters;
  }

  public String query() {
    return query;
  }

  public LanguageRegion region() {
    return region;
  }

  public Domain domain() {
    return domain;
  }

  public List<LookingFor> filters() {
    return filters;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String query = "";
    private LanguageRegion region;
    private Domain domain;
    private final List<LookingFor> filters = new ArrayList<>();

    public Builder query(String query) {
      this.query = query;
      return this;
    }

    public Builder region(LanguageRegion region) {
      this.region = region;
      return this;
    }

    public Builder domain(Domain domain) {
      this.domain = domain;
      return this;
    }

    public Builder withFilter(LookingFor filter) {
      this.filters.add(filter);
      return this;
    }

    public SearchCriteria build() {
      return new SearchCriteria(this);
    }
  }

}