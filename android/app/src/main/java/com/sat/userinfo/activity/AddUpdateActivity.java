package com.sat.userinfo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.sat.userinfo.R;
import com.sat.userinfo.dataHelper.DataStorageHelper;
import com.sat.userinfo.model.ModelUser;

public class AddUpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnProceed;
    private TextInputEditText etName, etPhone, etCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update);
        initUI();
    }

    private void initUI() {
        etName = findViewById(R.id.addupdate_et_user_name);
        etPhone = findViewById(R.id.addupdate_et_user_phone);
        etCity = findViewById(R.id.addupdate_et_user_city);
        btnProceed = findViewById(R.id.addupdate_btn_user_proceed);
        btnProceed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addupdate_btn_user_proceed:
                validateData();
                break;
        }
    }

    private void validateData() {
        etName.setError(null);
        etPhone.setError(null);
        etCity.setError(null);

        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String city = etCity.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            etName.setError("Please enter name");
        } else if (TextUtils.isEmpty(phone)) {
            etPhone.setError("Please enter phone");
        } else if (TextUtils.isEmpty(city)) {
            etCity.setError("Please enter city");
        } else {
            ModelUser modelUser = new ModelUser(name, phone, city);
            DataStorageHelper.addUserInfo(modelUser);
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        }
    }
}