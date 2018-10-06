package pyk.codesample1.helper;

import pyk.codesample1.contract.listener.Listener;

public class TMDbHelper implements Listener.VolleyListener {
  // singleton reference to TMDbHelper
  private static final TMDbHelper            instance     = new TMDbHelper();
  private final        String                api_key      = "e6dfd67cca79e834c3c68f729e937f64";
  // TODO: this is probably not needed, but im saving it for now just in case
  private final        String                tmdbMovieURL =
      "https://api.themoviedb.org/3/movie/550?api_key=" + api_key;
  private              Listener.TMDbListener listener;
  
  public static TMDbHelper getInstance() {
    return instance;
  }
  
  // set reference for future callbacks
  // in this case, MovieListItemAdapterPresenter is always handling the callbacks
  public void setListener(Listener.TMDbListener listener) {
    this.listener = listener;
  }
  
  /*
  submits request to Volley to pull data at URL.
  appends page # so that users can pull additional pages as needed
   */
  public void getMovies(int page) {
    final String tmdbPopularURL =
        "https://api.themoviedb.org/3/movie/popular?api_key=" + api_key + "&page=";
    
    VolleyHelper.getInstance().setListener(this);
    VolleyHelper.getInstance().sendRequest(tmdbPopularURL + Integer.toString(page));
  }
  
  public String getMovie(int movie) {
    return null;
  }
  
  public String getPoster(String path) {
    return null;
  }
  
  @Override public void volleyResponse(String response) {
    listener.tmdbResponse(response);
  }
}
