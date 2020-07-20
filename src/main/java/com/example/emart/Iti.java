package com.example.emart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Iti extends AppCompatActivity {
    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iti);

        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Iti.this,SscCourse.class);
                startActivity(i);
            }
        });
        final String names[] = {"Choose city ", "Surat", "Ahmedabad", "Gandhinagar", "Vadodara", "Rajkot", "Junagadh"};

        sp2 = (Spinner) findViewById(R.id.sp2);
        sp2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names));

        lw1 = (ListView) findViewById(R.id.lw1);
        lw1.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getComicBody()));

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position >= 0 && position < names.length) {
                    getSelectedCategoryData(position);
                } else {
                    Toast.makeText(Iti.this, "not exist", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private ArrayList<ComicBody> getComicBody() {
        ArrayList<ComicBody> data = new ArrayList<>();
        data.clear();

        data.add(new ComicBody("ITI olpad", 1));
        data.add(new ComicBody("ITI, Majura Gate", 1));
        data.add(new ComicBody("ITI (Women),Althan", 1));
        data.add(new ComicBody("ITI Ganesh Sisodra", 1));
        data.add(new ComicBody("ITI - Bardoli", 1));

        data.add(new ComicBody("Industrial Training Institute, Kubernagar", 2));
        data.add(new ComicBody("Industrial Training Center,Chandkheda", 2));
        data.add(new ComicBody("Industrial Training Institue,Mandal", 2));
        data.add(new ComicBody("Industrial Training Institue,Saraspur", 2));
        data.add(new ComicBody("ITI - Sarkhej", 2));
        data.add(new ComicBody("ITI - Maninagar", 2));
        data.add(new ComicBody("ITI - Sanand", 2));
        data.add(new ComicBody("Mahila I.T.I. Thaltej", 2));

        data.add(new ComicBody("ITI - Naswadi ", 3));
        data.add(new ComicBody("ITI - Goverment", 3));
        data.add(new ComicBody("ITI -  Kalol", 3));
        data.add(new ComicBody("Goverment Technical Institute , GTHS KALOL (Technical) ", 3));

        data.add(new ComicBody("Industrial Training Institute, Gorwa", 4));
        data.add(new ComicBody("ITI - Tarsali", 4));
        data.add(new ComicBody("ITI - Dashrath", 4));
        data.add(new ComicBody("ITI - Padra", 4));
        data.add(new ComicBody("ITI - Ajwa Road", 4));
        data.add(new ComicBody("Vakal Industrial Training Institute", 4));

        data.add(new ComicBody("Industrial Training Institute, Bhavnagar Road", 5));
        data.add(new ComicBody("ITI - Dhoraji", 5));
        data.add(new ComicBody("ITI - Moti Tanki Chowk", 5));
        data.add(new ComicBody("Mahila ITI -  Bhakti Nagar", 5));
        data.add(new ComicBody("Santiniketan Private ITI", 5));

        data.add(new ComicBody("Industrial Training Institute (ITI)", 6));
        data.add(new ComicBody("ITI - Mangrol", 6));
        data.add(new ComicBody("ITI - Talala", 6));
        data.add(new ComicBody("ITI - Keshod)", 6));
        data.add(new ComicBody("ITI(Woman)", 6));



        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(Iti.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
        }else {
            for (ComicBody comicBody : getComicBody()){
                if (comicBody.getCatID() == catID){
                    comicBodies.add(comicBody);
                }
            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,comicBodies);
        }
        lw1.setAdapter(adapter);
    }

}

class ComicBody10{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody10(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
