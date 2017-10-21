package com.example.damonpelser.launchpad;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.damonpelser.launchpad.adapters.CategoryAdapter;
import com.example.damonpelser.launchpad.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<CategoryModel> categoryList;

    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        categoryList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(this,categoryList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(categoryAdapter);

        addCategory();
    }

    private void addCategory() {
        final TypedArray typedArray = getResources().obtainTypedArray(R.array.cateIcons);
        String[] cateName = getResources().getStringArray(R.array.cateNames);
        int[] cateIcon = new int [cateName.length];
        for (int x = 0; x < cateName.length; x++){
            cateIcon[x] = typedArray.getResourceId(x, 0);
            CategoryModel c = new CategoryModel(cateName[x],cateIcon[x]);
            categoryList.add(c);
        }
        categoryAdapter.notifyDataSetChanged();
    }
}
