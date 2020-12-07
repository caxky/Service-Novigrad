package com.example.service_novigrad.ui.employee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.example.service_novigrad.ui.services.ServicesAdapter;

import java.util.ArrayList;

public class ServiceRequestAdapter extends RecyclerView.Adapter<ServiceRequestAdapter.ServiceRequestViewHolder> {
    private ArrayList<ServiceRequestItem> serviceRequestList;
    private OnItemClickListener serviceRequestListener;

    public interface OnItemClickListener {
        void onItemClick(int pos);
        void onAcceptClick(int pos);
        void onDenyClick(int pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        serviceRequestListener = listener;
    }


    public static class ServiceRequestViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView serviceName;
        public TextView userName;
        public Boolean status;
        public Button acceptButton;
        public Button denyButton;

        public ServiceRequestViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.serviceRequestImageView);
            userName = itemView.findViewById(R.id.requestUserName);
            serviceName = itemView.findViewById(R.id.serviceRequestType);

            acceptButton = itemView.findViewById(R.id.acceptRequestButton);
            denyButton = itemView.findViewById(R.id.denyRequestButton);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            listener.onItemClick(pos);
                        }
                    }
                }
            });

            acceptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    if (listener != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            listener.onAcceptClick(pos);
                        }
                    }
                }
            });

            denyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    if (listener != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            listener.onDenyClick(pos);
                        }
                    }
                }
            });
        }
    }

    public ServiceRequestAdapter(ArrayList<ServiceRequestItem> serviceRequestList) {
        this.serviceRequestList = serviceRequestList;
    }

    @NonNull
    @Override
    public ServiceRequestAdapter.ServiceRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_request_item, parent, false);
        ServiceRequestViewHolder srvh = new ServiceRequestViewHolder(v, serviceRequestListener);
        return srvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceRequestAdapter.ServiceRequestViewHolder holder, int position) {
        ServiceRequestItem currentItem = serviceRequestList.get(position);

        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.serviceName.setText(currentItem.getForm().getBranchServiceItem().getBsServiceName());
        holder.userName.setText(currentItem.getUserName());
    }

    @Override
    public int getItemCount() {
        return serviceRequestList.size();
    }
}
