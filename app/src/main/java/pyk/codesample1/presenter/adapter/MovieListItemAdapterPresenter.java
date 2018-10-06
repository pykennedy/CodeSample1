package pyk.codesample1.presenter.adapter;

import android.util.Log;

import pyk.codesample1.contract.adapter.MovieListItemAdapterContract;
import pyk.codesample1.contract.listener.Listener;
import pyk.codesample1.helper.TMDbHelper;
import pyk.codesample1.model.MovieList;
import pyk.codesample1.model.item.MovieItem;

public class MovieListItemAdapterPresenter
    implements MovieListItemAdapterContract.MovieListItemAdapterPresenter,
               Listener.TMDbListener {
  
  @Override
  public void populateMovieList() {
    //TODO: after json is processed, update MovieList with  MovieItems
    //TODO: i think i'll need a reference to the adapter to notifydatasetchanged() here as well
  }
  
  @Override
  public void pullData(int page) {
    // first pull the page user wants
    // There will be other pulls that need to happen. Segregating for maintainability.
    pullPopularPage(page);
  }
  
  @Override
  public void processList() {
    // TODO: process the raw json
    // TODO: then pull the poster for each movie
  }
  
  @Override
  public MovieItem getMovie(int index) {
    return MovieList.getInstance().getMovies().get(index);
  }
  
  @Override
  public int getCount() {
    return MovieList.getInstance().getMovies().size();
  }
  
  /*
  segregated from pullData due to tmdb needing to make 2 requests:
  1. for the movies
  2. for the posters
  we first need to wait for the first response to finish before we can get poster paths
   */
  private void pullPopularPage(int page) {
    TMDbHelper.getInstance().setListener(this);
    TMDbHelper.getInstance().getMovies(page);
  }
  
  /*
  see pullPopularPage() description for reasoning
   */
  private void pullMoviePoster(String path) {
  
  }
  
  @Override public void tmdbResponse(String response) {
    //TODO: get list of movies, then query for each movies poster
    //TODO: perhaps i'll also need to grab movies individually, we'll see
    Log.e("asdf", response);
  }
}
