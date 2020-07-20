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

public class BbaCourse extends AppCompatActivity {
    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bba_course);
        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BbaCourse.this,HscCourse.class);
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
                    Toast.makeText(BbaCourse.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("AURO UNIVERSITY", 1));
        data.add(new ComicBody("P.P. SAVANI UNIVERSITY", 1));
        data.add(new ComicBody("AMBABA COMMERCE COLLEGE", 1));
        data.add(new ComicBody("Shri J D Gabani Commerce College ( SJDGCC)", 1));
        data.add(new ComicBody("Vivekanand College", 1));

        data.add(new ComicBody("L. J. Institute of Business Administration", 2));
        data.add(new ComicBody("Gujarat Vidhyabharati Education Academy", 2));
        data.add(new ComicBody("IIPM - The Indian Institute of Planning & Management", 2));
        data.add(new ComicBody("Indira Gandhi National Open University - IGNOU", 2));
        data.add(new ComicBody("GLS Institute of Business Administration", 2));

        data.add(new ComicBody("Kameshwar BBA College ( KBC)", 3));
        data.add(new ComicBody("Karnavati University ( KU )", 3));
        data.add(new ComicBody("Pandit Deendayal Petroleum University (PDPU)", 3));

        data.add(new ComicBody("Balaji Colleges", 4));
        data.add(new ComicBody("Parul University", 4));
        data.add(new ComicBody("The Maharaja Sayajirao University of Baroda (MSU, Baroda),", 4));
        data.add(new ComicBody("Navrachana University (NU, Vadodara)", 4));
        data.add(new ComicBody("ITM Universe", 4));
        data.add(new ComicBody("Dr. J.K. Patel Institute of Management", 4));

        data.add(new ComicBody("Marwadi University", 5));
        data.add(new ComicBody("Shree G.K. & C.K. Bosamia Arts & Commerce College", 5));
        data.add(new ComicBody("Shree H. N. Shukla Group of College", 5));
        data.add(new ComicBody("Smt. M. T. Dhamsania College of Commerce (MTDCC)", 5));


        data.add(new ComicBody("FACULTY OF MANAGEMENT, NOBLE GROUP OF INSTITUTION", 6));
        data.add(new ComicBody("Noble Group of Institutions (NGI)", 6));
        data.add(new ComicBody("SHRI PATEL KELAVANI MANDAL COLLEGE OF TECHNOLOGY & BED", 6));


        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(BbaCourse.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody20{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody20(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}