package pyk.codesample1.model.item;

import java.util.List;

public class MovieItem {
  private String       title;
  private String       releaseDate;
  private String       restriction;
  private int          runtime;
  private List<String> genres;
  private double       rating;
  private String       overview;
  private String       poster;
  
  
  public MovieItem() {
    super();
  }
  
  public MovieItem(String title, String releaseDate, String overview) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.overview = overview;
  }
  
  public MovieItem(String title, String releaseDate, String restriction, int runtime,
                   List<String> genres, double rating, String overview, String poster) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.restriction = restriction;
    this.runtime = runtime;
    this.genres = genres;
    this.rating = rating;
    this.overview = overview;
    this.poster = poster;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getReleaseDate() {
    return releaseDate;
  }
  
  public String getRestriction() {
    return restriction;
  }
  
  public int getRuntime() {
    return runtime;
  }
  
  public List<String> getGenres() {
    return genres;
  }
  
  public double getRating() {
    return rating;
  }
  
  public String getOverview() {
    return overview;
  }
  
  public String getPoster() {
    return poster;
  }
}