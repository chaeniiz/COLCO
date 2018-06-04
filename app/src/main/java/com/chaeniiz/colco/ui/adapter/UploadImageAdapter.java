package com.chaeniiz.colco.ui.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.data.model.UploadImage;
import com.chaeniiz.colco.ui.activity.VoteDetailActivity;

import java.util.List;

public class UploadImageAdapter extends RecyclerView.Adapter<UploadImageAdapter.ViewHolder> {
    Context context;
    List<UploadImage> items;
    int itemLayout;

    public UploadImageAdapter(Context context, List<UploadImage> items, int itemLayout) {
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public UploadImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_upload_image, null);
        return new UploadImageAdapter.ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(UploadImageAdapter.ViewHolder holder, int position) {
        final UploadImage item = items.get(position);
        Drawable drawable = context.getResources().getDrawable(item.getThumbnail());
        holder.thumbnail.setBackground(drawable);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VoteDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView)itemView.findViewById(R.id.iv_thumbnail);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}