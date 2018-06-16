package com.chaeniiz.colco.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.data.model.Scrap;
import com.chaeniiz.colco.ui.adapter.ScrapAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScrapActivity extends BaseActivity {

    RecyclerView rvScrap;
    ScrapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvScrap = findViewById(R.id.rv_scrap);

        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvScrap.setLayoutManager(sgm);

        List<Scrap> items = new ArrayList<>();
        Scrap[] item = new Scrap[8];
        item[0] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[1] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[2] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[3] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[4] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[5] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[6] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[7] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");

        for(int i = 0; i < 8; i++) {
            items.add(item[i]);
        }

        adapter = new ScrapAdapter(this, items, R.layout.activity_scrap);
        rvScrap.setAdapter(adapter);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_scrap;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_scrap;
    }
}
