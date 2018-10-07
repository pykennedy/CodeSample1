package pyk.codesample1.contract.adapter;

import pyk.codesample1.model.item.MovieItem;

public class MovieListItemAdapterContract {
  public interface MovieListItemAdapterView {
    void triggerRefresh();
  }
  
  public interface MovieListItemAdapterPresenter {
    void notifyOfUpdates();
    
    void pullData(int page);
    
    void processList(String raw);
    
    MovieItem getMovie(int index);
    
    int getCount();
  }
}
