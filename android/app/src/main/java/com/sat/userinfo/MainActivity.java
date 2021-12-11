package com.sat.userinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.sat.userinfo.activity.UserListActivity;
import com.sat.userinfo.react.UserInfoReactActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnReact, btnAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReact = findViewById(R.id.main_btn_react);
        btnAndroid = findViewById(R.id.main_btn_android);
        btnReact.setOnClickListener(this);
        btnAndroid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.main_btn_react:
                startActivity(new Intent(MainActivity.this, UserInfoReactActivity.class));

                break;
            case R.id.main_btn_android:
                startActivity(new Intent(MainActivity.this, UserListActivity.class));
                break;
        }
    }
}