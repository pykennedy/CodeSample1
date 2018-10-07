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
}
