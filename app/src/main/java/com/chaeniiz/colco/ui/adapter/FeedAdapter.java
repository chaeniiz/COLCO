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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.data.model.Feed;
import com.chaeniiz.colco.ui.activity.FeedCommentActivity;

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

        ImageButton ibHeart = (ImageButton) v.findViewById(R.id.ib_heart);
        ImageButton ibComment = (ImageButton) v.findViewById(R.id.ib_comment);
        ImageButton ibScrap = (ImageButton) v.findViewById(R.id.ib_scrap);

        ibHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(v.getContext(), "Liked it!", Toast.LENGTH_SHORT).show();
            }
        });

        ibComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(v.getContext(), FeedCommentActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        ibScrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(v.getContext(), "아이템이 스크랩되었습니다", Toast.LENGTH_SHORT).show();
            }
        });

        return new FeedAdapter.ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(FeedAdapter.ViewHolder holder, int position) {
        final Feed item = items.get(position);
        Drawable thumbnail = context.getResources().getDrawable(item.getThumbnail());
        Drawable profile = context.getResources().getDrawable(item.getProfile());
        holder.thumbnail.setBackground(thumbnail);
        holder.profile.setBackground(profile);
        holder.id.setText(item.getId());
        holder.personalColor.setText(item.getPersonalColor());
        holder.explanation.setText(item.getExplanation());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        ImageView profile;
        TextView id;
        TextView personalColor;
        TextView explanation;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView)itemView.findViewById(R.id.iv_thumbnail);
            profile = (ImageView)itemView.findViewById(R.id.iv_profile);
            id = (TextView)itemView.findViewById(R.id.tv_id);
            personalColor = (TextView)itemView.findViewById(R.id.tv_personal_color);
            explanation = (TextView)itemView.findViewById(R.id.tv_explaination);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
