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

public class Diploma extends AppCompatActivity {
    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diploma);

        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Diploma.this,SscCourse.class);
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
                    Toast.makeText(Diploma.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("P P Savani University (PPSU)", 1));
        data.add(new ComicBody("N.G. Patel Polytechnic ( NGPP) ", 1));
        data.add(new ComicBody("Dr. S & S.S Ghandhy College Of Engineering & Technology ( SSSGCET)", 1));
        data.add(new ComicBody("Government Polytechnic For Girls (GPG), Surat", 1));
        data.add(new ComicBody("WLC College of India (WLC), Surat", 1));
        data.add(new ComicBody("Frameboxx Animation and Visual Effects, Surat", 1));

        data.add(new ComicBody("Rai University", 2));
        data.add(new ComicBody("International Institute Of Hotel Management ( IIHM)", 2));
        data.add(new ComicBody("LD College Of Engineering ( LDCE)", 2));
        data.add(new ComicBody("National Academy Of Event Management & Development ( NAEMD AHMEDABAD)", 2));
        data.add(new ComicBody("L.J. Polytechnic ( LJP)", 2));
        data.add(new ComicBody("NIRMA UNIVERSITY ", 2));
        data.add(new ComicBody("VISHWAKARMA GOVERNMENT ENGINEERING COLLEGE - [VGEC]", 2));

        data.add(new ComicBody("Government Polytechnic ( GP) ", 3));
        data.add(new ComicBody("VPMP Polytechnic", 3));
        data.add(new ComicBody("Swarrnim Startup And Innovation University ( SSIU)", 3));
        data.add(new ComicBody("VPMP Polytechnic ( VPMPP)", 3));

        data.add(new ComicBody("Parul University", 4));
        data.add(new ComicBody("MSU - The Maharaja Sayajirao University of Baroda", 4));
        data.add(new ComicBody("Gujarat Institute Of Hotel Management ( GIHM)", 4));
        data.add(new ComicBody("Faculty Of Management Studies ( FMS)", 4));
        data.add(new ComicBody("S.B. Polytechnic College, Vadodara", 4));

        data.add(new ComicBody("RK University ( RKU)", 5));
        data.add(new ComicBody("Atmiya University", 5));
        data.add(new ComicBody("Government Polytechnic ( GP)", 5));
        data.add(new ComicBody("R. K. COLLEGE OF DIPLOMA ENGINEERING", 5));
        data.add(new ComicBody("Marwadi University", 5));
        data.add(new ComicBody("Sanjaybhai Group Of Rajguru", 5));

        data.add(new ComicBody("Dr. Subhash Technical Campus", 6));
        data.add(new ComicBody("Government Polytechnic ( GP)", 6));
        data.add(new ComicBody("Balaji Institute of Engineering and Technology", 6));
        data.add(new ComicBody("OM Engineering College", 6));
        data.add(new ComicBody("Noble Group of Institutions", 6));
        data.add(new ComicBody("N. R. Vekaria Institute of Technology", 6));
        data.add(new ComicBody("UKV Mahila College", 6));

        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(Diploma.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody6{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody6(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
