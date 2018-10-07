package pyk.codesample1.model;

import java.util.ArrayList;
import java.util.List;

import pyk.codesample1.model.item.MovieItem;

public class MovieList {
  private static final MovieList       instance = new MovieList();
  private              List<MovieItem> movies;
  
  private MovieList() {
    movies = new ArrayList<>();
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
      movies.add(new MovieItem());
    }
  }
}
