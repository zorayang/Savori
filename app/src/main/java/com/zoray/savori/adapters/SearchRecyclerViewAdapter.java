package com.zoray.savori.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zoray.savori.R;
import com.zoray.savori.ResultActivity;
import com.zoray.savori.data.SearchResult;

import java.util.ArrayList;
import java.util.List;

public class SearchRecyclerViewAdapter
        extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<SearchResult> searchResults;

    public SearchRecyclerViewAdapter(Context context) {
        this.context = context;
        searchResults = new ArrayList<>();

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int position) {
        View row = LayoutInflater.from(context).inflate(
                R.layout.list_row_search_result, parent, false
        );
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display details
                ResultActivity rsActivity = (ResultActivity) context;
                rsActivity.showDetail(searchResults.get(position).getParseId());
            }
        });
        return new ViewHolder(row);
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        SearchResult item = searchResults.get(position);
        holder.tvDishName.setText(item.getName());
        holder.tvDishPrice.setText(item.getPrice());
        if(item.getDishImage()!= null) {
            Bitmap dishImageBmp = BitmapFactory.decodeByteArray(item.getDishImage(), 0,
                    item.getDishImage().length);
            holder.ivDishImage.setImageBitmap(dishImageBmp);
        }
    }

    public void updateResultList(List<SearchResult> resultList){
        searchResults = resultList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvDishName;
        private final TextView tvDishPrice;
        private final ImageView ivDishImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDishName = (TextView) itemView.findViewById(R.id.tvDishName);
            tvDishPrice = (TextView) itemView.findViewById(R.id.tvDishPrice);
            ivDishImage = (ImageView) itemView.findViewById(R.id.ivDishImage);
            }

    }


}
