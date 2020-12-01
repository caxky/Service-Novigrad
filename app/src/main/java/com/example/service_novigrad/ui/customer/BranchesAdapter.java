package com.example.service_novigrad.ui.customer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.service_novigrad.R;

import java.util.ArrayList;
import java.util.List;

public class BranchesAdapter extends RecyclerView.Adapter<BranchesAdapter.BranchesViewHolder> implements Filterable {
    private ArrayList<BranchItem> bBranchList;
    private ArrayList<BranchItem> bBranchListFull;
    private OnItemClickListener bListener;

    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        bListener = listener;
    }

    public static class BranchesViewHolder extends RecyclerView.ViewHolder {
        public ImageView bBranchImage;
        public TextView bBranchID;
        public TextView bBranchOpen;
        public TextView bBranchClose;

        public BranchesViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            bBranchImage = itemView.findViewById(R.id.branchImage);
            bBranchID = itemView.findViewById(R.id.textViewBranchID);
            bBranchOpen = itemView.findViewById(R.id.textViewBranchOpeningHour);
            bBranchClose = itemView.findViewById(R.id.textViewBranchClosingHour);

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

    public BranchesAdapter(ArrayList<BranchItem> branchList){
        bBranchList = branchList;
        bBranchListFull = new ArrayList<>(branchList);
    }

    @Override
    public BranchesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.branch_item, parent, false);
        BranchesViewHolder bvh = new BranchesViewHolder(v, bListener);
        return bvh;
    }

    @Override
    public void onBindViewHolder(BranchesViewHolder holder, int position) {
        BranchItem currentItem = bBranchList.get(position);

        holder.bBranchImage.setImageResource(currentItem.getImageResource());
        holder.bBranchID.setText(currentItem.getBranchID());
        holder.bBranchOpen.setText(currentItem.getBranchOpen());
        holder.bBranchClose.setText(currentItem.getBranchClose());

    }

    @Override
    public int getItemCount() {
        return bBranchList.size();
    }

    @Override
    public Filter getFilter() {
        return branchFilter;
    }

    private Filter branchFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<BranchItem> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(bBranchListFull);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (BranchItem item : bBranchListFull) {
                    String[] servicesOffered = item.getServicesOffered();
                    Boolean flag = false;

                    for (int i = 0; i < item.getNumServicesOffered(); i++) {
                        if (servicesOffered[i].toLowerCase().contains(filterPattern))
                            flag = true;
                    }

                    if (item.getBranchID().toLowerCase().contains(filterPattern) || item.getBranchOpen().toLowerCase().contains(filterPattern) || item.getBranchClose().toLowerCase().contains(filterPattern) || flag){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            bBranchList.clear();
            bBranchList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
