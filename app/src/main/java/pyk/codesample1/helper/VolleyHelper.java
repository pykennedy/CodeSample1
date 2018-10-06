package pyk.codesample1.helper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import pyk.codesample1.App;
import pyk.codesample1.contract.listener.Listener;

class VolleyHelper {
  // singleton reference for VolleyHelper
  private static final VolleyHelper            instance = new VolleyHelper();
  // singleton reference for RequestQueue
  private static final RequestQueue            queue    = Volley.newRequestQueue(App.getContext());
  private              Listener.VolleyListener listener;
  
  static VolleyHelper getInstance() {
    return instance;
  }
  
  // set reference for future callbacks
  // in this case, TMDbHelper is always handling the callbacks
  void setListener(Listener.VolleyListener listener) { this.listener = listener; }
  
  void sendRequest(String url) {
    StringRequest request =
        new StringRequest(Request.Method.GET, url,
                          new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                              listener.volleyResponse(response);
                            }
                          }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            listener.volleyResponse(null);
          }
        });
    queue.add(request);
  }
}
