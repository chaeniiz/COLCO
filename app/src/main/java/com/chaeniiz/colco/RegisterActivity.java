package com.chaeniiz.colco;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction fr = fm.beginTransaction();

        fr.replace(R.id.frame, new RegisterNickFragment(), "nick");
        fr.commit();
    }

    public void mOnClick(View v) {
        android.app.FragmentManager fm = getFragmentManager();
        android.app.Fragment fragment = fm.findFragmentById(R.id.frame);

        switch(v.getId()) {
            case R.id.btn_back:
                if(fragment == null) {
                    finish();
                } else if(fragment.getTag() == "nick") {
                    finish();
                } else if(fragment.getTag() == "birth") {
                    FragmentTransaction tr = fm.beginTransaction();
                    RegisterNickFragment registerNickFragment = new RegisterNickFragment();
                    tr.replace(R.id.frame, registerNickFragment, "nick");
                    tr.commit();
                } else if(fragment.getTag() == "gender") {
                    FragmentTransaction tr = fm.beginTransaction();
                    RegisterBirthFragment registerBirthFragment = new RegisterBirthFragment();
                    tr.replace(R.id.frame, registerBirthFragment, "birth");
                    tr.commit();
                } else if(fragment.getTag() == "personalColor") {
                    FragmentTransaction tr = fm.beginTransaction();
                    RegisterGenderFragment registerGenderFragment = new RegisterGenderFragment();
                    tr.replace(R.id.frame, registerGenderFragment, "gender");
                    tr.commit();
                }
                break;

            case R.id.tv_next:
                FragmentTransaction tr = fm.beginTransaction();
                if(fragment == null) {
                    finish();
                } else if(fragment.getTag() == "nick") {
                    Log.e("ok","nick");
                    RegisterBirthFragment registerBirthFragment = new RegisterBirthFragment();
                    tr.replace(R.id.frame, registerBirthFragment, "birth");
                    tr.commit();
                } else if(fragment.getTag() == "birth") {
                    RegisterGenderFragment registerGenderFragment = new RegisterGenderFragment();
                    tr.replace(R.id.frame, registerGenderFragment, "gender");
                    tr.commit();
                } else if(fragment.getTag() == "gender") {
                    RegisterPersonalColorFragment registerPersonalColorFragment = new RegisterPersonalColorFragment();
                    tr.replace(R.id.frame, registerPersonalColorFragment, "personalColor");
                    tr.commit();
                } else {
                    Intent intent = new Intent(this, FeedActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
