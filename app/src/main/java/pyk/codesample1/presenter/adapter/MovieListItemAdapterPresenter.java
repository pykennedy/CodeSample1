package pyk.codesample1.presenter.adapter;

import com.google.gson.Gson;

import pyk.codesample1.contract.adapter.MovieListItemAdapterContract;
import pyk.codesample1.contract.listener.Listener;
import pyk.codesample1.helper.TMDbHelper;
import pyk.codesample1.model.MovieList;
import pyk.codesample1.model.TMDbRawJson;
import pyk.codesample1.model.item.MovieItem;

public class MovieListItemAdapterPresenter
    implements MovieListItemAdapterContract.MovieListItemAdapterPresenter,
               Listener.TMDbListener {
  
  private MovieListItemAdapterContract.MovieListItemAdapterView mliav;
  
  public MovieListItemAdapterPresenter(
      MovieListItemAdapterContract.MovieListItemAdapterView mliav) {
    this.mliav = mliav;
  }
  
  @Override
  public void notifyOfUpdates() {
    //TODO: after json is processed, update MovieList with  MovieItems
    //TODO: i think i'll need a reference to the adapter to notifydatasetchanged() here as well
    mliav.triggerRefresh();
  }
  
  @Override
  public void pullData(int page) {
    // first pull the page user wants
    // There will be other pulls that need to happen. Segregating for maintainability.
    pullPopularPage(page);
  }
  
  @Override
  public void processList(String raw) {
    // TODO: process the raw json
    // TODO: then pull the poster for each movie
    Gson        gson = new Gson();
    TMDbRawJson json = gson.fromJson(raw, TMDbRawJson.class);
    // convert raw json to MovieItem objects
    for (MovieItem mi : json.getResults()) {
      // convert genre ID's to a concatenated genre string: genre1 | genre2 | genre3
      StringBuilder genres = new StringBuilder("");
      for (int i : mi.getGenre_ids()) {
        if (genres.length() < 1) {
          genres.append(TMDbHelper.getInstance().getGenre(i));
        } else {
          genres.append(" | ");
          genres.append(TMDbHelper.getInstance().getGenre(i));
        }
      }
      mi.setParsedGenres(genres.toString());
      
      MovieList.getInstance().getMovies().add(mi);
    }
    notifyOfUpdates();
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
    processList(response);
  }
}
