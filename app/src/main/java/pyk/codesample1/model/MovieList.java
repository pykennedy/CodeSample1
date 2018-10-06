package pyk.codesample1.model;

import java.util.ArrayList;
import java.util.List;

import pyk.codesample1.model.item.MovieItem;

public class MovieList {
  private static final MovieList       instance = new MovieList();
  private              List<MovieItem> movies;
  
  private MovieList() {
    movies = new ArrayList<>();
    fakeData();
  }
  
  public List<MovieItem> getMovies() {
    return movies;
  }
  
  public int getCount() {
    return movies.size();
  }
  
  public static MovieList getInstance() {
    return instance;
  }
  
  private void fakeData() {
    List<String> genres = new ArrayList<>();
    genres.add("Action");
    genres.add("Comedy");
    genres.add("Drama");
    genres.add("Romance");
    genres.add("Documentary");
    for (int i = 0; i < 30; i++) {
      movies.add(new MovieItem("A Movie Title",
                               "2018",
                               "PG-13",
                               123,
                               genres,
                               0.83,
                               "A purple pig and a green donkey flew a kite in the middle of the night and ended up sunburnt I am counting my calories, yet I really want dessert. How was the math test?",
                               "4359872348795623498756"));
    }
  }
}
