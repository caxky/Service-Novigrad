package com.example.service_novigrad.ui.services;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.service_novigrad.R;

import java.util.ArrayList;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder>{
    private ArrayList<ServiceItem> mList;
    private OnServiceClickListener mListener;

    public interface OnServiceClickListener {
        void onItemClick(int pos);
        void onDeleteClick(int pos);
    }

    public void setOnServiceClickListener(OnServiceClickListener listener) {
        mListener = listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ImageButton mDeleteButton;

        public ViewHolder(@NonNull View itemView, final OnServiceClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.serviceImageView);
            mTextView1 = itemView.findViewById(R.id.serviceName);
            mTextView2 = itemView.findViewById(R.id.serviceType);
            mDeleteButton = itemView.findViewById(R.id.serviceDeleteButton);

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

            mDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    if (listener != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(pos);
                        }
                    }
                }
            });

        }

    }

    public ServicesAdapter(ArrayList<ServiceItem> list) {
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item, parent, false);
        ViewHolder vh = new ViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ServiceItem currentItem = mList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getServiceName());
        holder.mTextView2.setText(currentItem.getServiceType());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
