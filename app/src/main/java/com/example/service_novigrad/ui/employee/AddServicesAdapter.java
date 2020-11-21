package com.example.service_novigrad.ui.employee;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.service_novigrad.R;

import java.util.ArrayList;

public class AddServicesAdapter extends RecyclerView.Adapter<AddServicesAdapter.AddServicesViewHolder> {
    private ArrayList<AddServicesItem> mlist;
    private OnItemClickListener mListener;

    public interface  OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    public static class AddServicesViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView empServiceName;
        public TextView empServiceType;

        public AddServicesViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.empServiceImage);
            empServiceName = itemView.findViewById(R.id.empServiceName);
            empServiceType = itemView.findViewById(R.id.empServiceType);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public AddServicesAdapter(ArrayList<AddServicesItem> list){
        mlist = list;
    }

    @NonNull
    @Override
    public AddServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_add_services_item, parent, false);
        AddServicesViewHolder asvh =  new AddServicesViewHolder(v, mListener);
        return asvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AddServicesViewHolder holder, int position) {
        AddServicesItem currentItem = mlist.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.empServiceName.setText(currentItem.getEmpServiceName());
        holder.empServiceType.setText((currentItem.getEmpServiceType()));
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
