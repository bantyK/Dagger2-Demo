package com.example.vuclip.daggerex.activities.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vuclip.daggerex.R;
import com.example.vuclip.daggerex.activities.detail.DetailActivity;
import com.example.vuclip.daggerex.models.Superhero;

import java.util.List;

/**
 * Created by Banty on 20/03/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Superhero> mSuperheroList;

    public void updateList(List<Superhero> list) {
        mSuperheroList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.nameTextView.setText(mSuperheroList.get(position).getName());
        holder.nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.nameTextView.getContext();
                Intent detailActivityIntent = new Intent(context, DetailActivity.class);
                detailActivityIntent.putExtra(DetailActivity.INTENT_KEY, mSuperheroList.get(position));
                context.startActivity(detailActivityIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSuperheroList != null ? mSuperheroList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
        }
    }
}
