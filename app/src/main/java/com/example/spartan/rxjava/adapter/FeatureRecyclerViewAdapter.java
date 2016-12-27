package com.example.spartan.rxjava.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.spartan.rxjava.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FeatureRecyclerViewAdapter extends RecyclerView.Adapter<FeatureRecyclerViewAdapter.ViewHolder> {

    private final List<String> mValues;
    private final OnFeatureListListener mListener;

    public FeatureRecyclerViewAdapter(List<String> items, OnFeatureListListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feature_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mFeatureName.setText(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       @BindView(R.id.feature_name) TextView mFeatureName;

        Unbinder mUnbinder;

        public ViewHolder(View view) {
            super(view);
            mUnbinder = ButterKnife.bind(this,view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.startFeature(getAdapterPosition());
                }
            });

        }

        public void onRemove(){
            mUnbinder.unbind();
        }
    }

    /**
     * Created by pushpendra on 27/12/16.
     */
    public interface OnFeatureListListener {
        void startFeature(int position);
    }
}
