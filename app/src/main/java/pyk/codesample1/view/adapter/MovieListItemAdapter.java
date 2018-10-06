package pyk.codesample1.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pyk.codesample1.R;
import pyk.codesample1.model.MovieList;
import pyk.codesample1.model.item.MovieItem;

public class MovieListItemAdapter
    extends RecyclerView.Adapter<MovieListItemAdapter.ItemAdapterViewHolder> {
  
  @NonNull @Override
  public ItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent,
                                                                 false);
    return new ItemAdapterViewHolder(view);
  }
  
  @Override
  public void onBindViewHolder(@NonNull ItemAdapterViewHolder holder, int position) {
    holder.update(MovieList.getInstance().getMovies().get(position));
  }
  
  @Override
  public int getItemCount() {
    return MovieList.getInstance().getCount();
  }
  
  static class ItemAdapterViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView releaseDate;
    TextView overview;
    
    public ItemAdapterViewHolder(View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.tv_title_movieItem);
      //releaseDate = itemView.findViewById(R.id.tv_releaseDate_movieItem);
      overview = itemView.findViewById(R.id.tv_overview_movieItem);
    }
    
    void update(MovieItem movieItem) {
      // TODO: set text, etc.
    }
  }
}

