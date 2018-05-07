package com.chaeniiz.colco;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FeedTabHottestFragment extends Fragment {
    RecyclerView rvFeedHottest;
    FeedAdapter adapter;
    Paint p = new Paint();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_feed_hottest, container, false);
        rvFeedHottest = (RecyclerView) view.findViewById(R.id.rv_feed_hottest);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvFeedHottest.setLayoutManager(lm);

        List<Feed> items = new ArrayList<>();
        Feed[] item = new Feed[5];
        item[0] = new Feed(R.drawable.thumbnail, "title", "explanation");
        item[1] = new Feed(R.drawable.thumbnail, "title", "explanation");
        item[2] = new Feed(R.drawable.thumbnail, "title", "explanation");
        item[3] = new Feed(R.drawable.thumbnail, "title", "explanation");
        item[4] = new Feed(R.drawable.thumbnail, "title", "explanation");

        for(int i = 0; i < 5; i++) {
            items.add(item[i]);
        }

        rvFeedHottest.setAdapter(new FeedAdapter(getActivity(), items, R.layout.tab_fragment_feed_hottest));


        return view;
    }
}
