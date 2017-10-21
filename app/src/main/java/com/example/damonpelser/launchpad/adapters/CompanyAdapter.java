package com.example.damonpelser.launchpad.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        CompanyModel company = companyList.get(position);
        holder.companyDesc.setText(company.getCompDesc());
        holder.companyOppo.setText(company.getCompOpp());
        holder.companyName.setText(company.getCompName());
    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }
}
