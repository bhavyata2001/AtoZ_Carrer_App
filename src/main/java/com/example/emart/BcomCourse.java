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

public class BcomCourse extends AppCompatActivity {

    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcom_course);
        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BcomCourse.this,HscCourse.class);
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
                    Toast.makeText(BcomCourse.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("Amity University", 1));
        data.add(new ComicBody("Navyug Commerce College", 1));
        data.add(new ComicBody("Ambaba Commerce College", 1));
        data.add(new ComicBody("AURO University", 1));
        data.add(new ComicBody("Government Arts and Commerce Collage", 1));
        data.add(new ComicBody("P.P. SAVANI UNIVERSITY", 1));

        data.add(new ComicBody("Gujarat University", 2));
        data.add(new ComicBody("Ganpat University", 2));
        data.add(new ComicBody("Rai University", 2));
        data.add(new ComicBody("Amity University", 2));
        data.add(new ComicBody("H L College of Commerce", 2));
        data.add(new ComicBody("C U Shah Commerce College", 2));
        data.add(new ComicBody("C C Sheth College of Commerce", 2));

        data.add(new ComicBody("Karnavati University ( KU )", 3));
        data.add(new ComicBody("Government Commerce College ( GCC)", 3));
        data.add(new ComicBody("Pandit Deendayal Petroleum University (PDPU)", 3));
        data.add(new ComicBody("Ashvinbhai A. Patel. Commerce College ( AAPCC)", 3));

        data.add(new ComicBody("Amity University", 4));
        data.add(new ComicBody("Parul University", 4));
        data.add(new ComicBody("The Maharaja Sayajirao University of Baroda (MSU, Baroda),", 4));
        data.add(new ComicBody("Smt. S. C. P. F. Commerce College", 4));
        data.add(new ComicBody("Institute of Technology and Management Universe Technical Campus", 4));

        data.add(new ComicBody("AVPT College", 5));
        data.add(new ComicBody("Marwadi University", 5));
        data.add(new ComicBody("M.B. Arts & Commerce College", 5));
        data.add(new ComicBody("Shree G.K. & C.K. Bosamia Arts & Commerce College", 5));

        data.add(new ComicBody("Dr. Subhash Technical Campus (DSTC)", 6));
        data.add(new ComicBody("FACULTY OF COMMERCE, NOBLE GROUP OF INSTITUTION", 6));
        data.add(new ComicBody("Noble Group of Institutions (NGI)", 6));
        data.add(new ComicBody("SHRI PATEL KELAVANI MANDAL COLLEGE OF TECHNOLOGY", 6));
        data.add(new ComicBody("Mahila Arts & Commerce College", 6));


        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(BcomCourse.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody16{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody16(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
