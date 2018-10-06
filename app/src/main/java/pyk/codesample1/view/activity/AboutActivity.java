package pyk.codesample1.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pyk.codesample1.R;

public class AboutActivity extends AppCompatActivity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about);
    setSupportActionBar((Toolbar) findViewById(R.id.tb_aboutActivity));
    getSupportActionBar().setTitle("About This App");
  }
  
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_about, menu);
    return true;
  }
  
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_back_aboutActivity:
        onBackPressed();
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
