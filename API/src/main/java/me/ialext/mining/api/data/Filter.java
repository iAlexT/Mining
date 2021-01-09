package me.ialext.mining.api.data;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Filter {

  public static final Filter EMPTY_FILTER = new Filter(Collections.emptyMap());

  private final Map<String, Object> query;
  private String sortBy = null;

  public Filter(Map<String, Object> query) {
    this.query = query;
  }

  public Filter set(String field, Object value) {
    query.put(field, value);

    return this;
  }

  public Filter sort(String field) {
    sortBy = field;

    return this;
  }

  public Optional<String> getSortBy() {
    return Optional.ofNullable(sortBy);
  }

  public Map<String, Object> getQuery() {
    return query;
  }

  public static Filter create() {
    return new Filter(new LinkedHashMap<>());
  }

}
