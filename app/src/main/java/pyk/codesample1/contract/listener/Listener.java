package pyk.codesample1.contract.listener;

public class Listener {
  public interface TMDbListener {
    void tmdbResponse(String response);
  }
  
  public interface VolleyListener {
    void volleyResponse(String response);
  }
  
  public interface ActivityProgressBarListener {
    void listPopulated();
  }
}
