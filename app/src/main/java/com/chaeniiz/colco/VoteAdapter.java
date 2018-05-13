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

public class VoteAdapter extends RecyclerView.Adapter<VoteAdapter.ViewHolder> {
    Context context;
    List<Vote> items;
    int itemLayout;

    public VoteAdapter(Context context, List<Vote> items, int itemLayout) {
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public VoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_vote, null);
        return new VoteAdapter.ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(VoteAdapter.ViewHolder holder, int position) {
        final Vote item = items.get(position);
        Drawable drawable = context.getResources().getDrawable(item.getThumbnail());
        holder.thumbnail.setBackground(drawable);
        holder.shopName.setText(item.getShopName());
        holder.productName.setText(item.getProductName());
        holder.personalColor.setText(item.getPersonalColor());
        holder.percentage.setText(item.getPercentage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getPersonalColor(), Toast.LENGTH_SHORT).show();
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
