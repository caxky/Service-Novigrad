package com.example.service_novigrad.ui.employee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.ServiceItem;

import java.util.ArrayList;

public class RemoveServicesAdapter extends RecyclerView.Adapter<RemoveServicesAdapter.RemoveServicesViewHolder> {
    private ArrayList<ServiceItem> mlist;
    private RemoveServicesAdapter.OnItemClickListener mListener;

    public interface  OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(RemoveServicesAdapter.OnItemClickListener listener){
        mListener = listener;
    }
    public static class RemoveServicesViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView empServiceName;
        public TextView empServiceType;
        public ImageView empDeleteImage;

        public RemoveServicesViewHolder(@NonNull View itemView, final RemoveServicesAdapter.OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.empServiceImage);
            empServiceName = itemView.findViewById(R.id.empServiceName);
            empServiceType = itemView.findViewById(R.id.empServiceType);
            empDeleteImage = itemView.findViewById(R.id.empServiceRemove);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            empDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

        public RemoveServicesAdapter(ArrayList<ServiceItem> list){
            mlist = list;
        }

        @NonNull
        @Override
        public RemoveServicesAdapter.RemoveServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_remove_services_item, parent, false);
            RemoveServicesAdapter.RemoveServicesViewHolder rsvh =  new RemoveServicesAdapter.RemoveServicesViewHolder(v, mListener);
            return rsvh;
        }

        @Override
        public void onBindViewHolder(@NonNull RemoveServicesAdapter.RemoveServicesViewHolder holder, int position) {
            ServiceItem currentItem = mlist.get(position);

            holder.mImageView.setImageResource(currentItem.getImageResource());
            holder.empServiceName.setText(currentItem.getServiceName());
            holder.empServiceType.setText((currentItem.getServiceType()));
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
}
