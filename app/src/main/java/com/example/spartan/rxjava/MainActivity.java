package com.example.spartan.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.spartan.rxjava.adapter.FeatureRecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements FeatureRecyclerViewAdapter.OnFeatureListListener {

    @BindView(R.id.list) RecyclerView mFeatureRecyclerView;
    FeatureRecyclerViewAdapter mFeatureRecyclerViewAdapter;

    Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);

        mFeatureRecyclerViewAdapter = new FeatureRecyclerViewAdapter(getFeatureList(),this);
        mFeatureRecyclerView.setAdapter(mFeatureRecyclerViewAdapter);

        getFeatureList();
    }

    private ArrayList<String> getFeatureList() {
        ArrayList<String> mFeatureList = new ArrayList<>();
        mFeatureList.add(getResources().getString(R.string.feature1));
        mFeatureList.add(getResources().getString(R.string.feature2));
        mFeatureList.add(getResources().getString(R.string.feature3));
        mFeatureList.add(getResources().getString(R.string.feature4));

        return mFeatureList;
    }

    @Override
    public void startFeature(int position) {
        switch (position){
            case 0:
                break;
            default:
                Toast.makeText(this, "Feature yet to come!", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
