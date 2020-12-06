package com.example.service_novigrad.ui.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.service_novigrad.R;
import com.example.service_novigrad.accounts.CustomerAccount;
import com.example.service_novigrad.accounts.EmployeeAccount;
import com.example.service_novigrad.ui.accounts.AccountItem;
import com.example.service_novigrad.ui.accounts.AccountsAdapter;
import com.example.service_novigrad.ui.register.Branch;
import com.example.service_novigrad.ui.services.ServiceItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    public void removeItem(final int pos) {
        //first get the key aka location in the server of the account that we are deleting
        String accountKeyToDelete = list.get(pos).getAccountKey();

        //find the account type
        int accountType = list.get(pos).getAccountType();

        DatabaseReference accountReference;

        //delete depending on the type of account
        if (accountType == 0){
            accountReference = FirebaseDatabase.getInstance().getReference("Customer Accounts").child(accountKeyToDelete);
            accountReference.removeValue();
        }else if (accountType == 1){
            accountReference = FirebaseDatabase.getInstance().getReference("Employee Accounts").child(accountKeyToDelete);
            accountReference.removeValue();
            //deleting the corresponding branch class before also deleting it from the list
            DatabaseReference branchRef = FirebaseDatabase.getInstance().getReference("Branches");
            branchRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot child: snapshot.getChildren()){
                        Branch temp = child.getValue(Branch.class);
                        if (temp.getBranchID() == list.get(pos).getBranchID()){
                            child.getRef().removeValue();
                        }
                    }

                    //remove the account in the recycle view list
                    list.remove(pos);
                    aAdapter.notifyItemRemoved(pos);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


    }

    public void createList() { //format for AccountItem is (int imageResource, int accountID, String firstName, String lastName, String username, OPTIONAL [int branchID])
        list = new ArrayList<>();
        //Reads the preexisting Customer Accounts from the server and add them to the list
        DatabaseReference accountsReference = FirebaseDatabase.getInstance().getReference("Customer Accounts");
        accountsReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> children = snapshot.getChildren(); //gets an iterable of the service
                for (DataSnapshot child: children){
                    CustomerAccount tempCustomer = child.getValue(CustomerAccount.class);
                    list.add(new AccountItem(R.drawable.user_icon, tempCustomer));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}

        });

        //Reads the preexisting Employee Accounts from the server and add them to the list
        accountsReference = FirebaseDatabase.getInstance().getReference("Employee Accounts");
        accountsReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> children = snapshot.getChildren(); //gets an iterable of the service
                for (DataSnapshot child: children){
                    EmployeeAccount tempEmployee = child.getValue(EmployeeAccount.class);
                    list.add(new AccountItem(R.drawable.user_icon, tempEmployee));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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