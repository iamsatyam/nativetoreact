package com.sat.userinfo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sat.userinfo.R;
import com.sat.userinfo.adapter.UserInfoAdapter;
import com.sat.userinfo.dataHelper.DataStorageHelper;
import com.sat.userinfo.model.ModelUser;

import static com.sat.userinfo.utils.UserUtils.IsAddUser;

public class UserListActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton addUser;
    private RecyclerView listView;
    private ActivityResultLauncher<Intent> activityResultLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        initUI();
        setAdapterData();

        activityResultLaunch = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            setAdapterData();
                        }
                    }
                });
    }


    private void setAdapterData() {
        if (DataStorageHelper.getUserInfo().isEmpty()) {
            Toast.makeText(UserListActivity.this, "Please add some data", Toast.LENGTH_SHORT).show();
        } else {
            UserInfoAdapter userListAdapter = new UserInfoAdapter(UserListActivity.this, DataStorageHelper.getUserInfo(), clickListener);
            listView.setAdapter(userListAdapter);
        }
    }

    private void initUI() {
        listView = findViewById(R.id.userlist_lv);
        addUser = findViewById(R.id.userlist_fab_adduser);
        addUser.setOnClickListener(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        listView.setLayoutManager(mLayoutManager);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.list_divider));
        listView.addItemDecoration(itemDecorator);
        listView.setItemAnimator(new DefaultItemAnimator());
    }

    UserInfoAdapter.onOCClickListener clickListener = new UserInfoAdapter.onOCClickListener() {
        @Override
        public void onUserSelected(ModelUser modelUser) {
            Toast.makeText(UserListActivity.this, modelUser.toString(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userlist_fab_adduser:
                Intent addUserIntent = new Intent(UserListActivity.this, AddUpdateActivity.class);
                addUserIntent.putExtra(IsAddUser, true);
                activityResultLaunch.launch(addUserIntent);
                break;
        }
    }
}