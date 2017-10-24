package com.example.damonpelser.launchpad.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.damonpelser.launchpad.CompanyDetailsActivity;
import com.example.damonpelser.launchpad.R;
import com.example.damonpelser.launchpad.models.CompanyModel;

import java.util.List;

/**
 * Created by damon on 2017/10/20.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.MyViewHolder> {

    private Context mContext;
    private List<CompanyModel> companyList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView companyName, companyDesc, companyOppo;
        public ImageView companyLogo;

        public MyViewHolder(View view){
            super(view);
            companyName = (TextView) view.findViewById(R.id.compName);
            companyDesc = (TextView) view.findViewById(R.id.compDesc);
            companyOppo = (TextView) view.findViewById(R.id.compOpport);
            companyLogo = (ImageView) view.findViewById(R.id.compLogo);
        }
    }

    public CompanyAdapter(Context mContext, List<CompanyModel> companyList) {
        this.mContext = mContext;
        this.companyList = companyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_card,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final CompanyModel company = companyList.get(position);
        holder.companyDesc.setText(company.getCompDesc());
        holder.companyOppo.setText(company.getCompOpp());
        holder.companyName.setText(company.getCompName());
        Glide.with(mContext).load(company.getCompLogo()).into(holder.companyLogo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CompanyDetailsActivity.class);

                intent.putExtra("compLogo",company.getCompLogo());
                intent.putExtra("compName",company.getCompName());
                intent.putExtra("compOpp",company.getCompOpp());
                intent.putExtra("compDesc",company.getCompDesc());
                intent.putExtra("compCrit",company.getCompCriteria());
                intent.putExtra("compTnC", company.getCompTC());
                intent.putExtra("compCDate",company.getCloseDate());
                intent.putExtra("compLat",company.getCompLat());
                intent.putExtra("compLong",company.getCompLong());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }
}
