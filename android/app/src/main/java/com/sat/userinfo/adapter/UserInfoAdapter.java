package com.sat.userinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sat.userinfo.R;
import com.sat.userinfo.model.ModelUser;

import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.MyViewHolder> {
    private final Context context;
    private List<ModelUser> dataList;
    private onOCClickListener listener;

    public UserInfoAdapter(Context context, List<ModelUser> data, onOCClickListener listner) {
        this.context = context;
        this.dataList = data;
        this.listener = listner;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvPhone, tvCity;


        public MyViewHolder(View view) {
            super(view);

            tvName = view.findViewById(R.id.tvUserName);
            tvPhone = view.findViewById(R.id.tvUserPhone);
            tvCity = view.findViewById(R.id.tvUserCity);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onUserSelected(dataList.get(getAdapterPosition()));
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_userinfo, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        try {
            ModelUser modelUser = dataList.get(position);
            holder.tvName.setText(modelUser.getName());
            holder.tvPhone.setText(modelUser.getPhone());
            holder.tvCity.setText(modelUser.getCity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public interface onOCClickListener {
        void onUserSelected(ModelUser modelUser);
    }
}