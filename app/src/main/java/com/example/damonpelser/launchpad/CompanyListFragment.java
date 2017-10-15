package com.example.damonpelser.launchpad;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Damon Pelser on 2017/09/12.
 */

public class CompanyListFragment extends Fragment {

    private int[] cateIcon;
    private int[] cateIndex;
    private String[] cateName;

    public static CompanyListFragment newInstance() {
        return new CompanyListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        final Resources resources = context.getResources();
        cateName = resources.getStringArray(R.array.cateNames);
        final TypedArray typedArray = resources.obtainTypedArray(R.array.subjectIcons);
        final int imageCount = cateName.length;
         cateIcon = new int[imageCount];
         cateIndex = new int[imageCount];
        for (int i = 0; i < imageCount; i++) {
            cateIcon[i] = typedArray.getResourceId(i, 0);
            cateIndex[i] = i;
        }
        typedArray.recycle();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.company_list_fragment, container, false);

        final Activity activity = getActivity();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new SubjectListAdapter(activity));

        return view;
    }


    class SubjectListAdapter extends RecyclerView.Adapter<ViewHolder> {

        private LayoutInflater mLayoutInflator;

        public SubjectListAdapter(Context context) {
            mLayoutInflator = LayoutInflater.from(context);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(mLayoutInflator.inflate(R.layout.category_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final int icon =  cateIcon[position];
            final String name = cateName[position];
            holder.setData(icon,name);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), Integer.toString(cateIndex[position]), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return cateName.length;
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        private ViewHolder(View inflate) {
            super(inflate);

            imageView = (ImageView) inflate.findViewById(R.id.subjectIcon);
            textView = (TextView) inflate.findViewById(R.id.subjectName);
        }
        private void setData(int imageResId, String name){
            imageView.setImageResource(imageResId);
            textView.setText(name);
        }
    }
}

