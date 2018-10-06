package pyk.codesample1.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pyk.codesample1.R;

public class MainActivity extends AppCompatActivity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setSupportActionBar((Toolbar) findViewById(R.id.tb_mainActivity));
    getSupportActionBar().setTitle("Not IMDb");
  }
  
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }
  
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_about_mainActivity:
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        MainActivity.this.startActivity(intent);
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
