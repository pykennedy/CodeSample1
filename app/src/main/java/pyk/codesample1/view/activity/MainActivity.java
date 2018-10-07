package pyk.codesample1.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.omadahealth.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import pyk.codesample1.R;
import pyk.codesample1.contract.listener.Listener;
import pyk.codesample1.view.adapter.MovieListItemAdapter;

public class MainActivity extends AppCompatActivity
    implements Listener.AdapterStatusListener {
  
  ProgressBar        progressBar;
  SwipyRefreshLayout swipyRefreshLayout;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setSupportActionBar((Toolbar) findViewById(R.id.tb_mainActivity));
    getSupportActionBar().setTitle("Not IMDb");
    
    progressBar = findViewById(R.id.pb_mainActivity);
    
    RecyclerView recyclerView = findViewById(R.id.rv_movies_mainActivity);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    final MovieListItemAdapter movieListItemAdapter = new MovieListItemAdapter(this);
    recyclerView.setAdapter(movieListItemAdapter);
    
    swipyRefreshLayout = findViewById(R.id.srl_movies_mainActivity);
    swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh(SwipyRefreshLayoutDirection direction) {
        // if swiped, then ask for next page of data. let the adapter manage what pages
        movieListItemAdapter.requestNextPage();
      }
    });
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
  
  @Override public void listPopulated() {
    if (swipyRefreshLayout != null) { // null check as it had crashed due to null pointer one time
      swipyRefreshLayout.setRefreshing(false); // on success, otherwise it will spin forever
    }
    progressBar.setVisibility(View.GONE);
  }
  
  @Override public void networkError(String error) {
    if (swipyRefreshLayout != null) {
      swipyRefreshLayout.setRefreshing(false); // on fail, otherwise it will spin forever
    }
    Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
  }
}
