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
  
  /*
  after adding movies to the list, tell the adapter to refresh
   */
  @Override
  public void notifyOfUpdates() {
    mliav.triggerRefresh();
  }
  
  @Override
  public void pullData(int page) {
    // first pull the page user wants
    // There will be other pulls that need to happen. Segregating for maintainability.
    TMDbHelper.getInstance().setListener(this);
    TMDbHelper.getInstance().getMovies(page);
  }
  
  @Override
  public void processList(String raw) {
    Gson        gson = new Gson();
    TMDbRawJson json = gson.fromJson(raw, TMDbRawJson.class);
    if(json == null) {
      return;
    }
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
  
  @Override public void tmdbResponse(String response) {
    processList(response);
  }
}
