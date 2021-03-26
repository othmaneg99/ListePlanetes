package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    PlaneteAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Data.installePlanetes();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.verif).setEnabled(false);
        listview = (ListView) findViewById(R.id.listView);

        adapter = new PlaneteAdapter(this);
        listview.setAdapter(adapter);




    }
}