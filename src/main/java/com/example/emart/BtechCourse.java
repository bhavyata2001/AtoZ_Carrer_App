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

public class BtechCourse extends AppCompatActivity {
    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btech_course);
        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BtechCourse.this,HscCourse.class);
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
                    Toast.makeText(BtechCourse.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("Government Engineering College", 1));
        data.add(new ComicBody("Ganpat University", 1));
        data.add(new ComicBody("Amity University Information Centre", 1));
        data.add(new ComicBody("Bhagwan Mahavir College of Engineering & Technology", 1));
        data.add(new ComicBody("Chhotubhai Gopalbhai Patel Institute of Technology", 1));
        data.add(new ComicBody("GT Engineering College", 1));
        data.add(new ComicBody("Sardar Vallabhbhai National Institute of Technology", 1));
        data.add(new ComicBody("NG Patel Polytechnic", 1));

        data.add(new ComicBody("Nirma University", 2));
        data.add(new ComicBody("Ganpat University", 2));
        data.add(new ComicBody("SAL Institute Of Management", 2));
        data.add(new ComicBody("LD College of Engineering", 2));
        data.add(new ComicBody("Vishwakarma Government Engineering College", 2));
        data.add(new ComicBody("Silver Oak College of Engineering & Technology (SOCET)", 2));
        data.add(new ComicBody("Institute of Infrastructure Technology Research and Management", 2));

        data.add(new ComicBody("Government Engineering College", 3));
        data.add(new ComicBody("LDRP Institute of Technology and Research", 3));
        data.add(new ComicBody("Pandit Deendayal Petroleum University (PDPU)", 3));
        data.add(new ComicBody("Indian Institute of Technology Gandhinagar", 3));
        data.add(new ComicBody("Dhirubhai Ambani Institute of Information and Communication Technology", 3));
        data.add(new ComicBody("Indian Institute of Technology Gandhinagar", 3));

        data.add(new ComicBody("Ganpat University", 4));
        data.add(new ComicBody("Parul University", 4));
        data.add(new ComicBody("The Maharaja Sayajirao University of Baroda (MSU, Baroda),", 4));
        data.add(new ComicBody("Navrachana University (NU, Vadodara)", 4));
        data.add(new ComicBody("AD Patel Institute of Technology", 4));
        data.add(new ComicBody("ITM Universe (ITM, Vadodara)", 4));

        data.add(new ComicBody("Marwadi University", 5));
        data.add(new ComicBody("Darshan Institute of Engineering and Technology", 5));
        data.add(new ComicBody("Lukhdhirji Engineering College", 5));
        data.add(new ComicBody("Atmiya Group of Institutions", 5));
        data.add(new ComicBody("B.H. Gardi College of Engineering and Technology/", 5));
        data.add(new ComicBody("RK University", 5));

        data.add(new ComicBody("Government Polytechnic", 6));
        data.add(new ComicBody("Dr. Subhash Technical Campus (DSTC)", 6));
        data.add(new ComicBody("OM Engineering College (OEC)", 6));
        data.add(new ComicBody("Balaji Engineering College", 6));
        data.add(new ComicBody("Noble Group of Institutions (NGI)", 6));
        data.add(new ComicBody("College of Agricultural Engineering & Technology (CAET)", 6));


        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(BtechCourse.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody11{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody11(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
