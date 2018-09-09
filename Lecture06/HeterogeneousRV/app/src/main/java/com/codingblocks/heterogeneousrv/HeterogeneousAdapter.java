package com.codingblocks.heterogeneousrv;

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

    private ArrayList<Object> arrayList;

    public HeterogeneousAdapter(ArrayList<Object> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getItemViewType(int position) {
        Object currentItem = arrayList.get(position);

        if (currentItem instanceof ImageClass) {
            return 0;
        } else if (currentItem instanceof TextClass) {
            return 1;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());

        if (i == 0) {
            //This means we are inflating an ImageClass
            View view = li.inflate(R.layout.item_row_image, viewGroup, false);
            return new ImageHolder(view);
        } else if (i == 1) {
            //This means we are inflating a TextClass
            View view = li.inflate(R.layout.item_row_text, viewGroup, false);
            return new TextHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        Object currentObject = arrayList.get(position);

        if (getItemViewType(position) == 0) {
            ImageClass currentImage = (ImageClass) currentObject;
            ImageHolder imageHolder = (ImageHolder) viewHolder;
            Picasso.get()
                    .load(currentImage.getUrl())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_image)
                    .into(imageHolder.imageView);

            imageHolder.subtitle.setText(currentImage.getSubtitle());
            imageHolder.title.setText(currentImage.getTitle());

        } else if (getItemViewType(position) == 1) {
            TextClass currentImage = (TextClass) currentObject;
            TextHolder textHolder = (TextHolder) viewHolder;

            textHolder.subtitle.setText(currentImage.getSubtitle());
            textHolder.title.setText(currentImage.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;
        ImageView imageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitleImage);
            subtitle = itemView.findViewById(R.id.tvSubtitleImage);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    class TextHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;

        public TextHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            subtitle = itemView.findViewById(R.id.tvSubtitle);
        }
    }

}
