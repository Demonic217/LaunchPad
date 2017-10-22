package com.example.damonpelser.launchpad.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.damonpelser.launchpad.CompanyActivity;
import com.example.damonpelser.launchpad.R;
import com.example.damonpelser.launchpad.models.CategoryModel;

import java.util.List;

/**
 * Created by damon on 2017/10/15.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<CategoryModel> categoryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryName;
        public ImageView categoryIcon;

        public MyViewHolder(View view) {
            super(view);
            categoryName = (TextView)view.findViewById(R.id.cateName);
            categoryIcon = (ImageView)view.findViewById(R.id.cateIcon);
        }
    }

    public CategoryAdapter(Context mContext, List<CategoryModel> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        CategoryModel category = categoryList.get(position);
        Glide.with(mContext).load(category.getCateIcon()).into(holder.categoryIcon);
        //holder.categoryIcon.setImageResource(category.getCateIcon());
        holder.categoryName.setText(category.getCateName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext, Integer.toString(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, CompanyActivity.class);
                intent.putExtra("cateInt",holder.getAdapterPosition());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
