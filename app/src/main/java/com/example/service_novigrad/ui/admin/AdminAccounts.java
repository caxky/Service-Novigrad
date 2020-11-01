package com.example.service_novigrad.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.accounts.AccountItem;
import com.example.service_novigrad.ui.accounts.AccountsAdapter;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.example.service_novigrad.ui.services.ServicesAdapter;

import java.util.ArrayList;

public class AdminAccounts extends AppCompatActivity {


    private ArrayList<AccountItem> list;

    private RecyclerView mRecyclerView;
    private AccountsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String serviceTypeString;

    private ServiceItem currentService;
    private String currentServiceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_accounts);

        createList();
        buildRecyclerView();
    }

    public void createList() { //format for AccountItem is (int imageResource, int accountID, String firstName, String lastName, String username, OPTIONAL [int branchID])
        list = new ArrayList<>();
        list.add(new AccountItem(R.drawable.user_icon, 1, "test", "account", "TesterMan123"));
        list.add(new AccountItem(R.drawable.user_icon, 2, "joe", "mama", "JoeMama23"));
        list.add(new AccountItem(R.drawable.user_icon, 3, "employee", "account", "eeee333", 354));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.accountRecyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AccountsAdapter(list);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}