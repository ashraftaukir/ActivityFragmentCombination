package com.example.taukir.activityfragmentcombination.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.taukir.activityfragmentcombination.fragment.BottomFragment;
import com.example.taukir.activityfragmentcombination.fragment.TopFragment;
import com.example.taukir.activityfragmentcombination.myinterface.Databack;
import com.example.taukir.activityfragmentcombination.R;

public class MainActivity extends FragmentActivity implements Databack {


    TopFragment topFragment;
    BottomFragment bottomFragment;
    FragmentTransaction transaction;
    LinearLayout linearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearlayout = (LinearLayout) findViewById(R.id.linearlayout);
        topFragment = new TopFragment();
        bottomFragment = new BottomFragment();
        FragmentManager manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.firstfragment, topFragment, "Frag_Top_tag");
        transaction.add(R.id.secondfragment, bottomFragment, "Frag_Bottom_tag");
        transaction.commit();

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientation = newConfig.orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            linearlayout.setOrientation(LinearLayout.HORIZONTAL);

        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {

            linearlayout.setOrientation(LinearLayout.VERTICAL);

        } else {
            Log.d("other", "onConfigurationChanged: " + "other");

        }

    }

    @Override
    public void callback(String value) {

        bottomFragment.displayValue(value);

    }

}
