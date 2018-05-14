package com.chaeniiz.colco;

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
import android.widget.TextView;

import java.util.List;

public class ScrapAdapter extends RecyclerView.Adapter<ScrapAdapter.ViewHolder> {
    Context context;
    List<Scrap> items;
    int itemLayout;

    public ScrapAdapter(Context context, List<Scrap> items, int itemLayout) {
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ScrapAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_scrap, null);
        return new ScrapAdapter.ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ScrapAdapter.ViewHolder holder, int position) {
        final Scrap item = items.get(position);
        Drawable drawable = context.getResources().getDrawable(item.getThumbnail());
        holder.thumbnail.setBackground(drawable);
        holder.shopName.setText(item.getShopName());
        holder.productName.setText(item.getProductName());
        holder.personalColor.setText(item.getPersonalColor());
        holder.percentage.setText(item.getPercentage());
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
        TextView shopName;
        TextView productName;
        TextView personalColor;
        TextView percentage;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView)itemView.findViewById(R.id.iv_thumbnail);
            shopName = (TextView)itemView.findViewById(R.id.tv_shop_name);
            productName = (TextView)itemView.findViewById(R.id.tv_product_name);
            personalColor = (TextView)itemView.findViewById(R.id.tv_personal_color);
            percentage = (TextView)itemView.findViewById(R.id.tv_percentage);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
