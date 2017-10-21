package com.example.damonpelser.launchpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.damonpelser.launchpad.adapters.CompanyAdapter;
import com.example.damonpelser.launchpad.models.CompanyModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by damon on 2017/10/20.
 */

public class CompanyActivity extends AppCompatActivity {

    private List<CompanyModel> companyList;
    private FirebaseFirestore mFirestore;
    private CompanyAdapter companyAdapter;
    private RecyclerView recyclerView;
    private String category;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the int, telling which category was clicked
        Intent intent = getIntent();
        int cateInt = intent.getIntExtra("cateInt",0);
        selectCategory(cateInt);
        companyList = new ArrayList<>();

        mFirestore = FirebaseFirestore.getInstance();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(companyAdapter);

        loadCompany();
    }

    private void selectCategory(int cateint){
        switch(cateint){
            case 0:
                category = "science";
                break;
            case 1:
                category = "engineering";
                break;
            case 2:
                category = "healthServices";
                break;
            case 3:
                category = "commerce";
                break;
            case 4:
                category = "humanities";
                break;
            case 5:
                category = "law";
                break;
            case 6:
                category = "it";
                break;
            case 7:
                category = "general";
                break;
        }
    }

    private void loadCompany() {

        if (companyList.size() > 0)
        {
            companyList.clear();
        }
        mFirestore.collection(category)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot doc:task.getResult()){
                            CompanyModel companyDbData = new CompanyModel(doc.getString("cLogo"),
                                                                        doc.getString("cName"),
                                                                        doc.getString("closeDate"),
                                                                        doc.getString("description"),
                                                                        doc.getString("latitude"),
                                                                        doc.getString("longitude"),
                                                                        doc.getString("opportunity"),
                                                                        doc.getString("selectCriteria"),
                                                                        doc.getString("tnc"));
                            companyList.add(companyDbData);
                        }
                        companyAdapter = new CompanyAdapter(CompanyActivity.this,companyList);
                        recyclerView.setAdapter(companyAdapter);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("DB Load Error", e.getMessage());
            }
        });
    }
}
