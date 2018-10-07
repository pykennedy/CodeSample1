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
  private Listener.NetworkCallsListener                         listener;
  
  public MovieListItemAdapterPresenter(
      MovieListItemAdapterContract.MovieListItemAdapterView mliav,
      Listener.NetworkCallsListener listener) {
    this.mliav = mliav;
    this.listener = listener;
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
    TMDbHelper.getInstance().setListener(this);
    TMDbHelper.getInstance().getMovies(page);
  }
  
  @Override
  public void processList(String raw) {
    Gson gson = new Gson();
    /*
    due to the structure of TMDb JSON where all movie details are an entire node
    and not broken out into a hierarchy of movie id, then details i'm forced to first
    make a class that stores the whole json first, then pick out items.
    see TMDbRawJson for what's going on
    */
    TMDbRawJson json = gson.fromJson(raw, TMDbRawJson.class);
    if (json == null) {
      return;
    }
    // convert raw json to MovieItem objects
    for (MovieItem mi : json.getResults()) {
      // convert genre ID's to a concatenated genre string: genre1 | genre2 | genre3
      // using string builder for optimization
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
    return MovieList.getInstance().getCount();
  }
  
  @Override public void tmdbResponse(String response) {
    processList(response);
  }
  
  @Override public void tmdbError(String error) {
    listener.networkError(error);
  }
}
