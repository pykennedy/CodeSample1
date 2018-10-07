package pyk.codesample1.model;

import java.util.List;

import pyk.codesample1.model.item.MovieItem;

public class TMDbRawJson {
  private int             page;
  private int             total_results;
  private int             total_pages;
  private List<MovieItem> results;
  
  public int getPage() {
    return page;
  }
  
  public int getTotal_results() {
    return total_results;
  }
  
  public int getTotal_pages() {
    return total_pages;
  }
  
  public List<MovieItem> getResults() {
    return results;
  }
}
