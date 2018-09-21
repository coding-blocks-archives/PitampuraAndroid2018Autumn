package com.codingblocks.asynctasknetworking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubHolder> {

    private ArrayList<Item> items;

    public GithubAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public GithubHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row, viewGroup, false);

        return new GithubHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubHolder githubHolder, int i) {
        Item currentItem = items.get(i);
        githubHolder.userName.setText(currentItem.getLogin());
        Picasso.get().load(currentItem.getAvatar_url()).into(githubHolder.userImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class GithubHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView userName;

        public GithubHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.userImage);
            userName = itemView.findViewById(R.id.userName);
        }
    }

}
