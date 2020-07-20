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

public class ArtsCourse extends AppCompatActivity {

    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_course);
        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ArtsCourse.this,HscCourse.class);
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
                    Toast.makeText(ArtsCourse.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("P P Savani University", 1));
        data.add(new ComicBody("Akhand Anand Arts & Commerce College ( AAACC)", 1));
        data.add(new ComicBody("Sheth P.T. Mahila College Of Arts And Home Science ( SPTMCAHS)", 1));
        data.add(new ComicBody("M. T. B. Arts College ( MAC)", 1));

        data.add(new ComicBody("Shri HK Arts College", 2));
        data.add(new ComicBody("CU Shah Arts College", 2));
        data.add(new ComicBody("LD Arts College", 2));
        data.add(new ComicBody("Bhavans Shri IL Pandya Arts Science and Jashodabahen Shah Commerce College", 2));

        data.add(new ComicBody("Shree P.K.Chaudhari Mahila Arts College ( SPKCMAC)", 3));
        data.add(new ComicBody("Samarpan Arts And Commerce College ( SACC)", 3));
        data.add(new ComicBody("Government Arts College ( GAC)", 3));
        data.add(new ComicBody("Pandit Deendayal Petroleum University ( PDPU)", 3));

        data.add(new ComicBody("Smt Kusumben Kadakia Arts And Commerce College ( KADAKIA COLLEGE)", 4));
        data.add(new ComicBody("Parul University", 4));
        data.add(new ComicBody("Navrachana University ( NUV)", 4));
        data.add(new ComicBody("Government Arts & Commerce College ( GACC)", 4));

        data.add(new ComicBody("Marwadi University", 5));
        data.add(new ComicBody("Arpit College Of Education ( ARPIT COLLEGE)", 5));
        data.add(new ComicBody("Smt. R. P. Bhalodiya Mahila Arts", 5));
        data.add(new ComicBody("Atmiya Group of Institutions", 5));
        data.add(new ComicBody("SAURASHTRA UNIVERSITY", 5));

        data.add(new ComicBody("DR SUBHASH MAHILA ARTS COMMERCE AND HOME SCIENCE COLLEGE, JUNAGADH", 6));
        data.add(new ComicBody("SARDAR PATEL MAHILA ARTS & COMMERCE COLLEGE", 6));

        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(ArtsCourse.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody14{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody14(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
