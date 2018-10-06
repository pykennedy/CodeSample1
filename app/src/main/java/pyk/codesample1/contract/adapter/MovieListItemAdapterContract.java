package pyk.codesample1.contract.adapter;

import pyk.codesample1.model.item.MovieItem;

public class MovieListItemAdapterContract {
  public interface MovieListItemAdapterView {
  }
  
  public interface MovieListItemAdapterPresenter {
    void populateMovieList();
    
    void pullData();
    
    void processList();
    
    MovieItem getMovie(int index);
    
    int getCount();
  }
}
