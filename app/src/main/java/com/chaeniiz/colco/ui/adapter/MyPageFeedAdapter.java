package com.chaeniiz.colco.ui.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.data.model.UploadedFeed;

import java.util.List;

public class MyPageFeedAdapter extends RecyclerView.Adapter<MyPageFeedAdapter.ViewHolder> {
    Context context;
    List<UploadedFeed> items;
    int itemLayout;
    public MyPageFeedAdapter(Context context, List<UploadedFeed> items, int itemLayout) {
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public MyPageFeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_uploaded_feed, null);

        return new MyPageFeedAdapter.ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(MyPageFeedAdapter.ViewHolder holder, int position) {
        final UploadedFeed feed = items.get(position);
        Drawable thumbnail = context.getResources().getDrawable(feed.getThumbnail());
        holder.thumbnail.setBackground(thumbnail);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
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
            thumbnail = (ImageView)itemView.findViewById(R.id.iv_uploaded_feed);
            cardView = (CardView) itemView.findViewById(R.id.cardview_feed);
        }
    }
}
