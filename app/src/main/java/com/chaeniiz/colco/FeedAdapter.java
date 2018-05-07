package com.chaeniiz.colco;

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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    Context context;
    List<Feed> items;
    int itemLayout;
    public FeedAdapter(Context context, List<Feed> items, int itemLayout) {
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_feed, null);
        return new FeedAdapter.ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(FeedAdapter.ViewHolder holder, int position) {
        final Feed item = items.get(position);
        Drawable drawable = context.getResources().getDrawable(item.getThumbnail());
        holder.thumbnail.setBackground(drawable);
        holder.title.setText(item.getTitle());
        holder.explanation.setText(item.getExplanation());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView explanation;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView)itemView.findViewById(R.id.iv_thumbnail);
            title = (TextView)itemView.findViewById(R.id.tv_title);
            explanation = (TextView)itemView.findViewById(R.id.tv_explaination);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
