package pyk.codesample1.helper;

import java.util.HashMap;

import pyk.codesample1.contract.listener.Listener;

public class TMDbHelper implements Listener.VolleyListener {
  // singleton reference to TMDbHelper
  private static final TMDbHelper               instance     = new TMDbHelper();
  private              Listener.TMDbListener    listener;
  private              HashMap<Integer, String> genreMapping = new HashMap<>();
  
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
    final String api_key = "e6dfd67cca79e834c3c68f729e937f64";
    final String tmdbPopularURL =
        "https://api.themoviedb.org/3/movie/popular?api_key=" + api_key + "&page=";
    
    VolleyHelper.getInstance().setListener(this);
    VolleyHelper.getInstance().sendRequest(tmdbPopularURL + Integer.toString(page));
  }
  
  /*
  putting this here instead of elsewhere due to this technically being TMDb data
   */
  public String getGenre(int id) {
    // hardcoded to avoid needless network calls for static data
    if (genreMapping.isEmpty()) {
      genreMapping.put(28, "Action");
      genreMapping.put(12, "Adventure");
      genreMapping.put(16, "Animation");
      genreMapping.put(35, "Comedy");
      genreMapping.put(80, "Crime");
      genreMapping.put(99, "Documentary");
      genreMapping.put(18, "Drama");
      genreMapping.put(10751, "Family");
      genreMapping.put(14, "Fantasy");
      genreMapping.put(36, "History");
      genreMapping.put(27, "Horror");
      genreMapping.put(10402, "Music");
      genreMapping.put(9648, "Mystery");
      genreMapping.put(10749, "Romance");
      genreMapping.put(878, "Science Fiction");
      genreMapping.put(10770, "TV Movie");
      genreMapping.put(53, "Thriller");
      genreMapping.put(10752, "War");
      genreMapping.put(37, "Western");
    }
    return genreMapping.get(id);
  }
  
  @Override public void volleyResponse(String response) {
    listener.tmdbResponse(response);
  }
}
