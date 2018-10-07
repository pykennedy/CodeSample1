package pyk.codesample1.model.item;

import java.util.List;

public class MovieItem {
  private String        title;
  private String        release_date;
  private List<Integer> genre_ids;
  private double        vote_average;
  private String        overview;
  private String        poster_path;
  
  public String getPoster_path() {
    return poster_path;
  }
  
  private String parsedGenres;
  
  public String getTitle() {
    return title;
  }
  
  public String getRelease_date() {
    return release_date;
  }
  
  public List<Integer> getGenre_ids() {
    return genre_ids;
  }
  
  public double getVote_average() {
    return vote_average;
  }
  
  public String getOverview() {
    return overview;
  }
  
  public String getParsedGenres() {
    return parsedGenres;
  }
  
  public void setParsedGenres(String parsedGenres) {
    this.parsedGenres = parsedGenres;
  }
}