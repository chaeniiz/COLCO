package com.chaeniiz.colco.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.chaeniiz.colco.R;

public class UploadItemActivity extends BaseActivity {
    ArrayAdapter<CharSequence> spinnerAdapter1, spinnerAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton ibtnUploadItem = (ImageButton) findViewById(R.id.ibtn_upload_item);
        ibtnUploadItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(intent);
            }
        });

        ImageButton ibtnClose = (ImageButton) findViewById(R.id.btn_close);
        ibtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Spinner spin1 = (Spinner)findViewById(R.id.sp_lv_1);
        final Spinner spin2 = (Spinner)findViewById(R.id.sp_lv_2);

        spinnerAdapter1 = ArrayAdapter.createFromResource(this, R.array.spinner_lv_1, android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(spinnerAdapter1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinnerAdapter1.getItem(i).equals("코스메틱")) {
                    spinnerAdapter2 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.spinner_lv_2_cosmetic, android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(spinnerAdapter2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if(spinnerAdapter1.getItem(i).equals("염색")) {
                    spinnerAdapter2 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.spinner_lv_2_hair, android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(spinnerAdapter2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                } else if(spinnerAdapter1.getItem(i).equals("패션")) {
                    spinnerAdapter2 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.spinner_lv_2_fashion, android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(spinnerAdapter2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_upload_item;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.menu_upload;
    }
}
