package com.example.service_novigrad.ui.accounts;

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

public class AccountsAdapter extends RecyclerView.Adapter<AccountsAdapter.ViewHolder> {
    private ArrayList<AccountItem> aList;
    private OnAccountClickListener aListener;

    public interface OnAccountClickListener {
        void onItemClick(int pos);
        void onDeleteClick(int pos);
    }

    public void setOnAccountClickListener(AccountsAdapter.OnAccountClickListener listener) {
        aListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView aImageView;
        public TextView aAccountName;
        public TextView aAccountID;
        public TextView aAccountUsername;
        public TextView aAccountType;
        public TextView aAccountBranchID;
        public ImageButton aDeleteButton;

        public ViewHolder(@NonNull View itemView, final AccountsAdapter.OnAccountClickListener listener) {
            super(itemView);
            aImageView = itemView.findViewById(R.id.accountImageView);
            aAccountName = itemView.findViewById(R.id.accountName);
            aAccountID = itemView.findViewById(R.id.accountID);
            aAccountUsername = itemView.findViewById(R.id.accountUsername);
            aAccountType = itemView.findViewById(R.id.accountType);
            aAccountBranchID = itemView.findViewById(R.id.accountBranchID);
            aDeleteButton = itemView.findViewById(R.id.accountDeleteButton);

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

            aDeleteButton.setOnClickListener(new View.OnClickListener() {
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

    public AccountsAdapter(ArrayList<AccountItem> list) {
        aList = list;
    }

    @NonNull
    @Override
    public AccountsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item, parent, false);
        AccountsAdapter.ViewHolder vh = new AccountsAdapter.ViewHolder(v, aListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AccountsAdapter.ViewHolder holder, int position) {
        AccountItem currentItem = aList.get(position);

        holder.aImageView.setImageResource(currentItem.getImageResource());
        holder.aAccountName.setText(currentItem.getName());
        holder.aAccountID.setText(Integer.toString(currentItem.getAccountID()));
        holder.aAccountUsername.setText(currentItem.getUsername());

        if (currentItem.getAccountType() == 0){
            holder.aAccountType.setText("Customer");
            holder.aAccountBranchID.setText("");
        } else if (currentItem.getAccountType() == 1) {
            holder.aAccountType.setText("Employee");
            holder.aAccountBranchID.setText(Integer.toString(currentItem.getBranchID()));
        } else {
            holder.aAccountType.setText("ACCOUNT TYPE ERROR");
        }

    }

    @Override
    public int getItemCount() {
        return aList.size();
    }
}
