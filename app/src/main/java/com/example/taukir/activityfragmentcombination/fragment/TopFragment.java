package com.example.taukir.activityfragmentcombination.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.taukir.activityfragmentcombination.myinterface.Databack;
import com.example.taukir.activityfragmentcombination.R;

public class TopFragment extends Fragment implements View.OnClickListener {

    View view;
    EditText editText;
    Button sendbutton;
    Databack databack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.topfragment, container, false);
        initView(view);
        initListener();
        return view;
    }

    private void initListener() {
        sendbutton.setOnClickListener(this);

    }

    private void initView(View view) {
        editText = (EditText) view.findViewById(R.id.editText);
        sendbutton = (Button) view.findViewById(R.id.btn_send);
    }

    @Override
    public void onClick(View v) {
        String value = editText.getText().toString();
        databack.callback(value);

    }


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        try {
            databack = (Databack) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Datacallback interface");
        }
    }
}