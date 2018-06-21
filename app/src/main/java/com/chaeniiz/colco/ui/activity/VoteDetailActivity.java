package com.chaeniiz.colco.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.chaeniiz.colco.R;

import java.util.ArrayList;
import java.util.List;

public class VoteDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton ibtnBack = (ImageButton) findViewById(R.id.btn_back);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnVote = (Button) findViewById(R.id.btn_vote);
        btnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showVoteAlert();
            }
        });

        Button btnVoteResult = (Button) findViewById(R.id.btn_vote_result);
        btnVoteResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showVoteResultAlert();
            }
        });
    }

    void showVoteAlert() {
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("봄 웜");
        ListItems.add("봄 웜 브라이트");
        ListItems.add("봄 웜 라이트");
        ListItems.add("여름 쿨");
        ListItems.add("여름 쿨 라이트");
        ListItems.add("여름 쿨 뮤트");
        ListItems.add("가을 웜");
        ListItems.add("가을 웜 딥");
        ListItems.add("가을 웜 뮤트");
        ListItems.add("겨울 쿨");
        ListItems.add("겨울 쿨 브라이트");
        ListItems.add("겨울 쿨 딥");
        final CharSequence[] items =  ListItems.toArray(new String[ ListItems.size()]);

        final List SelectedItems  = new ArrayList();
        int defaultItem = 0;
        SelectedItems.add(defaultItem);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle("가장 잘 맞는 퍼스널 컬러를 선택해 주세요!");
        builder.setSingleChoiceItems(items, defaultItem,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SelectedItems.clear();
                        SelectedItems.add(which);
                    }
                });
        builder.setPositiveButton("선택 완료",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String msg="";

                        if (!SelectedItems.isEmpty()) {
                            int index = (int) SelectedItems.get(0);
                            msg = ListItems.get(index);
                        }
                        Toast.makeText(getApplicationContext(),
                                "'" + msg + "' 투표 완료!", Toast.LENGTH_LONG)
                                .show();
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    void showVoteResultAlert() {
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("봄 웜 " + 0 + "%");
        ListItems.add("봄 웜 브라이트 " + 0 + "%");
        ListItems.add("봄 웜 라이트 " + 0 + "%");
        ListItems.add("여름 쿨 " + 0 + "%");
        ListItems.add("여름 쿨 라이트 " + 0 + "%");
        ListItems.add("여름 쿨 뮤트 " + 0 + "%");
        ListItems.add("가을 웜 " + 0 + "%");
        ListItems.add("가을 웜 딥 " + 0 + "%");
        ListItems.add("가을 웜 뮤트 " + 0 + "%");
        ListItems.add("겨울 쿨 " + 0 + "%");
        ListItems.add("겨울 쿨 브라이트 " + 0 + "%");
        ListItems.add("겨울 쿨 딥 " + 0 + "%");
        final CharSequence[] items =  ListItems.toArray(new String[ ListItems.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle("투표 결과");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int pos) { }
        });
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) { }
                });
        builder.show();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_vote_detail;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_vote;
    }
}
