package com.chaeniiz.colco.ui.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.chaeniiz.colco.R;
import com.chaeniiz.colco.data.model.Scrap;
import com.chaeniiz.colco.ui.adapter.ScrapAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScrapActivity extends BaseActivity {

    RecyclerView rvScrap;
    ScrapAdapter adapter;
    Paint p = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        rvScrap = findViewById(R.id.rv_scrap);

        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvScrap.setLayoutManager(sgm);

        List<Scrap> items = new ArrayList<>();
        Scrap[] item = new Scrap[4];
        item[0] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[1] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[2] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");
        item[3] = new Scrap(R.drawable.thumbnail_product, "MAC", "루비우", "여름 쿨", "65%");

        for(int i = 0; i < 4; i++) {
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