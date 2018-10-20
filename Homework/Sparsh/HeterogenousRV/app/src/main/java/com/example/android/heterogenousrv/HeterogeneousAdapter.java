package com.example.android.heterogenousrv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeterogeneousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Object> arrayList;

    public HeterogeneousAdapter(ArrayList<Object> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getItemViewType(int position) {

        Object currentItem = arrayList.get(position);
        if(currentItem instanceof  ImageClass){
            return 0;
        }
        else if(currentItem instanceof  TextClass){
            return 1;
        }

        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());

        if(viewType == 0){
            View view = li.inflate(R.layout.item_row_image,parent,false);
            return new ImageHolder(view);
        }else if(viewType == 1){
            View view =li.inflate(R.layout.item_row_text,parent,false);
            return new TextHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object currentObject = arrayList.get(position);
        if(getItemViewType(position) == 0){
            // Why Have We Done This//
            ImageClass currentImage = (ImageClass) currentObject;
            ImageHolder imageHolder = (ImageHolder) holder;
            Picasso.get()
                    .load(currentImage.getUrl())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageHolder.imageView);
            imageHolder.subtitle.setText(currentImage.getSubtitle());
            imageHolder.title.setText(currentImage.getTitle());
        }else if(getItemViewType(position) == 1){
            TextClass textClass = (TextClass) currentObject;
            TextHolder textHolder = (TextHolder) holder;
            textHolder.title.setText(textClass.getTitle());
            textHolder.subtitle.setText(textClass.getSubtitle());
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder{
        TextView title,subtitle;
        ImageView imageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitleImage);
            subtitle = itemView.findViewById(R.id.tvSubtitleImage);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
    class TextHolder extends RecyclerView.ViewHolder{
        TextView title,subtitle;
        public TextHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            subtitle= itemView.findViewById(R.id.tvSubtitle);
        }
    }
}
