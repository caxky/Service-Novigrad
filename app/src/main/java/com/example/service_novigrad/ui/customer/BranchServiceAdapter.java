package com.example.service_novigrad.ui.customer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.service_novigrad.R;

import java.util.ArrayList;

public class BranchServiceAdapter extends RecyclerView.Adapter<BranchServiceAdapter.BranchServiceViewHolder> {
    private ArrayList<BranchServiceItem> bsServicesList;
    private OnItemClickListener bsListener;

    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

    public void setOnItemClickListener(BranchServiceAdapter.OnItemClickListener listener) {
        bsListener = listener;
    }

    public static class BranchServiceViewHolder extends RecyclerView.ViewHolder {
        public ImageView bsBranchImage;
        public TextView bsServiceName;

        public BranchServiceViewHolder(View itemView, final BranchServiceAdapter.OnItemClickListener listener) {
            super(itemView);
            bsBranchImage = itemView.findViewById(R.id.branchServiceImage);
            bsServiceName = itemView.findViewById(R.id.textViewServiceNameItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            listener.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }

    public BranchServiceAdapter(ArrayList<BranchServiceItem> branchServiceList){
        bsServicesList = branchServiceList;
    }

    @Override
    public BranchServiceAdapter.BranchServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.branch_service_item, parent, false);
        BranchServiceAdapter.BranchServiceViewHolder bsvh = new BranchServiceAdapter.BranchServiceViewHolder(v, bsListener);
        return bsvh;
    }

    @Override
    public void onBindViewHolder(BranchServiceAdapter.BranchServiceViewHolder holder, int position) {
        BranchServiceItem currentItem = bsServicesList.get(position);

        holder.bsBranchImage.setImageResource(currentItem.getImageResource());
        holder.bsServiceName.setText(currentItem.getBranchServiceName());

    }

    @Override
    public int getItemCount() {
        return bsServicesList.size();
    }
}
