package pyk.codesample1;

import android.app.Application;
import android.content.Context;

public class App extends Application {
  private static Application app;
  
  @Override
  public void onCreate() {
    super.onCreate();
    app = this;
  }
  
  private static Application getApplication() {
    return app;
  }
  
  public static Context getContext() {
    return getApplication().getApplicationContext();
  }
  

}
