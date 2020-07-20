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

public class Gseb extends AppCompatActivity {
    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gseb);

        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Gseb.this,GsebAndCbscCourse.class);
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
                    Toast.makeText(Gseb.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("GD Goenka International School, Visit link:https://www.gdgoenkasurat.com", 1));
        data.add(new ComicBody("J H Ambani Saraswati Vidya Mandir", 1));
        data.add(new ComicBody("Euro School, Visit link:http://es04.euroschoolindia.com/", 1));
        data.add(new ComicBody("Lancer Army School, Visit link:http://www.lancersarmyschool.com/", 1));

        data.add(new ComicBody("Ahmedabad International School (AIS), Visit link:www.aischool.net", 2));
        data.add(new ComicBody("Mahatma Gandhi International School, Visit link:http://www.mgis.in", 2));
        data.add(new ComicBody("Shanti Asiatic School,Visit link:http://www.shantiasiaticahmedabad.com", 2));
        data.add(new ComicBody("Amrit Jyoti School, Visit link:http://www.amritjyoti.ac.in", 2));
        data.add(new ComicBody("A One School", 2));

        data.add(new ComicBody("BAPS Swaminarayan Vidyamandir, Visit link:https://www.baps.org/SVM/Randesan.aspx", 3));
        data.add(new ComicBody("Gandhinagar International Public School - GIPS, Visit link:http://www.gipschools.com/", 3));
        data.add(new ComicBody("Mount Carmel High School, Visit link:http://www.mountcarmelgnr.in/", 3));
        data.add(new ComicBody("Purnima High School", 3));
        data.add(new ComicBody("Shree Swaminarayan Higher Secondary School", 3));

        data.add(new ComicBody("Shantaben Shantilal Patel Sarvajanik High School", 4));
        data.add(new ComicBody("Jeevan Prakash Vidyalaya", 4));
        data.add(new ComicBody("Netaji Model School", 4));
        data.add(new ComicBody("Shree Dwarkesh Sarvajanik High School", 4));
        data.add(new ComicBody("Valan High School", 4));
        data.add(new ComicBody("Sanskar Vidhyalaya", 4));

        data.add(new ComicBody("Jawahar Navodaya Vidyalaya, Visit:222805", 5));
        data.add(new ComicBody("Modi School", 5));
        data.add(new ComicBody("Shree K. G. Dholakiya School", 5));
        data.add(new ComicBody("The Galaxy School Wadi", 5));

        data.add(new ComicBody("Nebula English School, Visit:026222613153", 6));
        data.add(new ComicBody("Nobel Primary School, Visit:026222633567", 6));
        data.add(new ComicBody("Alpha Primary School, Visit:026222626518", 6));
        data.add(new ComicBody("Eklavya Public School, Visit:026222634988", 6));


        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(Gseb.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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
class ComicBody4{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody4(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
