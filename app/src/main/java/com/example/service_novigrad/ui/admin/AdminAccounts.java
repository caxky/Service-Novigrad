package com.example.service_novigrad.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.accounts.AccountItem;
import com.example.service_novigrad.ui.accounts.AccountsAdapter;
import com.example.service_novigrad.ui.services.ServiceItem;

import java.util.ArrayList;

public class AdminAccounts extends AppCompatActivity {


    private ArrayList<AccountItem> list;

    private RecyclerView aRecyclerView;
    private AccountsAdapter aAdapter;
    private RecyclerView.LayoutManager aLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_accounts);

        createList();
        buildRecyclerView();
    }

    public void removeItem(int pos) {
        list.remove(pos);
        aAdapter.notifyItemRemoved(pos);
    }

    public void createList() { //format for AccountItem is (int imageResource, int accountID, String firstName, String lastName, String username, OPTIONAL [int branchID])
        list = new ArrayList<>();
        list.add(new AccountItem(R.drawable.user_icon, 1, "test", "account", "TesterMan123"));
        list.add(new AccountItem(R.drawable.user_icon, 2, "joe", "mama", "JoeMama23"));
        list.add(new AccountItem(R.drawable.user_icon, 3, "employee", "account", "eeee333", 354));
    }

    public void buildRecyclerView() {
        aRecyclerView = findViewById(R.id.accountRecyclerView);
        aLayoutManager = new LinearLayoutManager(this);
        aAdapter = new AccountsAdapter(list);

        aRecyclerView.setLayoutManager(aLayoutManager);
        aRecyclerView.setAdapter(aAdapter);


        aAdapter.setOnAccountClickListener(new AccountsAdapter.OnAccountClickListener() {
            @Override
            public void onItemClick(int pos) {

            }

            @Override
            public void onDeleteClick(int pos) {
                removeItem(pos);
            }
        });
    }
}