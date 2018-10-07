package pyk.codesample1.contract.listener;

public class Listener {
  public interface TMDbListener {
    void tmdbResponse(String response);
    
    void tmdbError(String error);
  }
  
  public interface VolleyListener {
    void volleyResponse(String response);
    
    void volleyError(String error);
  }
  
  public interface AdapterStatusListener {
    void listPopulated();
    
    void networkError(String error);
  }
  
  public interface NetworkCallsListener {
    void networkError(String error);
  }
}
