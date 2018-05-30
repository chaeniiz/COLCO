package com.chaeniiz.colco.ui.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.data.model.Vote;
import com.chaeniiz.colco.ui.adapter.VoteAdapter;

import java.util.ArrayList;
import java.util.List;

public class VoteTabFashionFragment extends Fragment {
    RecyclerView rvVoteFashion;
    VoteAdapter adapter;
    Paint p = new Paint();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_vote_fashion, container, false);
        rvVoteFashion = (RecyclerView) view.findViewById(R.id.rv_vote_fashion);
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvVoteFashion.setLayoutManager(sgm);

        List<Vote> items = new ArrayList<>();
        Vote[] item = new Vote[6];
        item[0] = new Vote(R.drawable.thumbnail_fashion, "리얼옐로우", "베이직 NB - 블루", "여름 쿨", "65%");
        item[1] = new Vote(R.drawable.thumbnail_fashion, "리얼옐로우", "베이직 NB - 블루", "여름 쿨", "65%");
        item[2] = new Vote(R.drawable.thumbnail_fashion, "리얼옐로우", "베이직 NB - 블루", "여름 쿨", "65%");
        item[3] = new Vote(R.drawable.thumbnail_fashion, "리얼옐로우", "베이직 NB - 블루", "여름 쿨", "65%");
        item[4] = new Vote(R.drawable.thumbnail_fashion, "리얼옐로우", "베이직 NB - 블루", "여름 쿨", "65%");
        item[5] = new Vote(R.drawable.thumbnail_fashion, "리얼옐로우", "베이직 NB - 블루", "여름 쿨", "65%");

        for(int i = 0; i < 6; i++) {
            items.add(item[i]);
        }

        rvVoteFashion.setAdapter(new VoteAdapter(getActivity(), items, R.layout.tab_fragment_vote_fashion));


        return view;
    }
}

