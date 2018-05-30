package com.chaeniiz.colco.ui.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.data.model.Feed;
import com.chaeniiz.colco.ui.adapter.FeedAdapter;

import java.util.ArrayList;
import java.util.List;

public class FeedTabLatestFragment extends Fragment {
    RecyclerView rvFeedLatest;
    FeedAdapter adapter;
    Paint p = new Paint();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_feed_latest, container, false);
        rvFeedLatest = (RecyclerView) view.findViewById(R.id.rv_feed_latest);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvFeedLatest.setLayoutManager(lm);

        List<Feed> items = new ArrayList<>();
        Feed[] item = new Feed[5];
        item[0] = new Feed(R.drawable.profile, R.drawable.profile, "chaeniiz", "여름 쿨 뮤트", "latest");
        item[1] = new Feed(R.drawable.profile, R.drawable.profile, "chaeniiz", "여름 쿨 뮤트", "latest");
        item[2] = new Feed(R.drawable.profile, R.drawable.profile, "chaeniiz", "여름 쿨 뮤트", "latest");
        item[3] = new Feed(R.drawable.profile, R.drawable.profile, "chaeniiz", "여름 쿨 뮤트", "latest");
        item[4] = new Feed(R.drawable.profile, R.drawable.profile, "chaeniiz", "여름 쿨 뮤트", "latest");

        for(int i = 0; i < 5; i++) {
            items.add(item[i]);
        }

        rvFeedLatest.setAdapter(new FeedAdapter(getActivity(), items, R.layout.tab_fragment_feed_latest));


        return view;
    }
}
