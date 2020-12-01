package com.example.service_novigrad.ui.customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import com.example.service_novigrad.R;
import com.example.service_novigrad.ui.accounts.AccountItem;
import com.example.service_novigrad.ui.accounts.AccountsAdapter;
import com.example.service_novigrad.ui.employee.ServiceRequestInformation;
import com.example.service_novigrad.ui.register.Branch;

import java.util.ArrayList;

public class CustomerPanel extends AppCompatActivity {
    private ArrayList<BranchItem> branchList;

    private RecyclerView bRecyclerView;
    private BranchesAdapter bAdapter;
    private RecyclerView.LayoutManager bLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_panel);

        createList();
        buildRecyclerView();
    }

    public void createList(){
        branchList = new ArrayList<>();
        branchList.add(new BranchItem(R.drawable.branch, "234", "8:30", "16:00"));
        branchList.add(new BranchItem(R.drawable.branch, "555", "7:30", "13:00"));
        branchList.add(new BranchItem(R.drawable.branch, "114", "9:00", "20:30"));
        branchList.add(new BranchItem(R.drawable.branch, "590", "7:15", "15:00"));
        branchList.add(new BranchItem(R.drawable.branch, "690", "8:00", "16:00"));
        branchList.add(new BranchItem(R.drawable.branch, "417", "7:30", "20:30"));
        branchList.add(new BranchItem(R.drawable.branch, "236", "8:30", "16:00"));
        branchList.add(new BranchItem(R.drawable.branch, "557", "7:30", "13:00"));
        branchList.add(new BranchItem(R.drawable.branch, "118", "9:00", "20:30"));
        branchList.add(new BranchItem(R.drawable.branch, "599", "7:15", "15:00"));
        branchList.add(new BranchItem(R.drawable.branch, "692", "8:00", "16:00"));
        branchList.add(new BranchItem(R.drawable.branch, "414", "7:30", "20:30"));
    }

    public void buildRecyclerView(){
        bRecyclerView = findViewById(R.id.branchRecyclerView);
        bLayoutManager = new LinearLayoutManager(this);
        bAdapter = new BranchesAdapter(branchList);

        bRecyclerView.setLayoutManager(bLayoutManager);
        bRecyclerView.setAdapter(bAdapter);

        bAdapter.setOnItemClickListener(new BranchesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent intent = new Intent(getBaseContext(), CustomerBranchServices.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.branch_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                bAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}