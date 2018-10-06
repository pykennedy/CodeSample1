package pyk.codesample1.presenter.adapter;

import pyk.codesample1.contract.adapter.MovieListItemAdapterContract;
import pyk.codesample1.model.MovieList;
import pyk.codesample1.model.item.MovieItem;

public class MovieListItemAdapterPresenter
    implements MovieListItemAdapterContract.MovieListItemAdapterPresenter {
  @Override
  public void populateMovieList() {
  
  }
  
  @Override
  public void pullData() {
  
  }
  
  @Override
  public void processList() {
  
  }
  
  @Override
  public MovieItem getMovie(int index) {
    return MovieList.getInstance().getMovies().get(index);
  }
  
  @Override
  public int getCount() {
    return MovieList.getInstance().getMovies().size();
  }
}
