package com.example.listeplanetes;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

class PlaneteAdapter extends BaseAdapter {


    private ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    Activity context;


    public PlaneteAdapter(Activity context){
        this.context =  context;
    }


    @Override
    public int getCount() {
        return Data.planetes.size();
    }

    @Override
    public Object getItem(int arg0) {
        return Data.planetes.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button verif = (Button) context.findViewById(R.id.verif);
        View itemView = convertView;



        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }
        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) context.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) context.findViewById(R.id.spinner);
        nomPlanete.setText(Data.planetes.get(position));
        verif.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                List<String> selections = new ArrayList<String>();
                for (int i = 0; i < spinner.getChildCount(); i++) {

                    // Get row's spinner
                    View listItem = spinner.getChildAt(i);
                    Spinner spinner = (Spinner) listItem.findViewById(R.id.spinner);

                    // Get selection
                    String selection = (String) spinner.getSelectedItem();
                    selections.add(selection);

                }   String reponse ="reponses justes :";
                for (int j = 0; j < selections.size(); j++) {
                    /*String element = selections.get(j);
                    if(element == Data.taillePlanetes[j]){*/

                        reponse += Data.planetes.get(j)+" ";

                   // }


                }

                Toast.makeText(context,reponse, Toast.LENGTH_SHORT).show();





                }

        });


        //  installer l'adaptateur pour la liste déroulante (spinner)
        /*Activity a = (Activity) context;
        a.setContentView(R.layout.listitem);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

                verif.setEnabled(false);

            }

        });*/
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, Data.taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox)  compoundButton.findViewById(R.id.checkbox);
                if (checkBox.isChecked()) {
                    spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();
                    checkBoxes.add(checkBox);
                    if(checkBoxes.size() == Data.planetes.size()){
                        verif.setEnabled(true);
                    }
                } else {
                    spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                    verif.setEnabled(false);
                    if(checkBoxes.contains(checkBox)){
                        checkBoxes.remove(checkBox);
                    }
                }
            }



});

    return itemView;}
}