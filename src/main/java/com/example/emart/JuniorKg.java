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

public class JuniorKg extends AppCompatActivity {
    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_kg);

        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JuniorKg.this,PlayGroupCourse.class);
                startActivity(i);
            }
        });

        final String names[] = {"Choose city ", "Surat", "Ahmedabad", "Vadodara", "Rajkot", "Junagadh"};

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
                    Toast.makeText(JuniorKg.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("Fountainhead School, Visit link:http://www.fountainheadschools.org/", 1));
        data.add(new ComicBody("Lancers Army School, Visit:http://www.lancersarmyschool.com/index.html", 1));
        data.add(new ComicBody("P. P. Savani Cambridge International School, Visit link:ppscambridge@gmail.com, ppscambridge@yahoo.com", 1));
        data.add(new ComicBody("Podar International School, Visit link:www.podareducation.org/school/surat", 1));
        data.add(new ComicBody("S.D. Jain Modern School,Visit link:sdjainmodernschool@yahoo.co.in", 1));
        data.add(new ComicBody("G.D. Goenka International School ,Visit link:gdgoenkasurat.com", 1));
        data.add(new ComicBody("Tapti Valley International School ,Visit link:www.taptivalleyschool.com", 1));

        data.add(new ComicBody("Ahmedabad International School (AIS), Visit link:www.aischool.net", 2));
        data.add(new ComicBody("Sant Kabir School, Visit link:http://www.stkabir.com", 2));
        data.add(new ComicBody("Mahatma Gandhi International School, Visit link:http://www.mgis.in", 2));
        data.add(new ComicBody("Shanti Asiatic School,Visit link:http://www.shantiasiaticahmedabad.com", 2));
        data.add(new ComicBody("Cosmos Castle International School, Visit link:http:// www.cosmoscastleschool.com", 2));
        data.add(new ComicBody("Amrut School, Visit link:http://www.www.amrutschool.edu.in", 2));

        data.add(new ComicBody("Anandalaya, Visit link:http://anandalaya.ac.in", 3));
        data.add(new ComicBody("Anand Niketan, Visit link:http://gu008cisce.org", 3));
        data.add(new ComicBody("Vibgyor High, Visit link:http://gu029cisce.org", 3));
        data.add(new ComicBody("Nalanda International Schoo,Visit link:http://gu016cisce.org", 3));
        data.add(new ComicBody("Billabong High International School , Visit link:http://gu025cisce.org", 3));

        data.add(new ComicBody("Shree Swaminayayan Gurukul", 4));
        data.add(new ComicBody("S.n. Kansagra School, Visit link:https://gu003cisce.org", 4));
        data.add(new ComicBody("Om Shanti English Medium School, Visit link:http://www.osem.ac.in", 4));
        data.add(new ComicBody("Saint Paul's School Address, Visit link:http://gu024cisce.org", 4));
        data.add(new ComicBody("Kendriya Vidyalaya Address , Visit link:http://www.kvrajkot.org", 4));
        data.add(new ComicBody("Sunflower English School, Visit link:http://www.sescampus.com", 4));

        data.add(new ComicBody("Nebula English School, Visit:026222613153", 5));
        data.add(new ComicBody("Nobel Primary School, Visit:026222633567", 5));
        data.add(new ComicBody("Alpha Primary School, Visit:026222626518", 5));
        data.add(new ComicBody("Eklavya Public School, Visit:026222634988", 5));
        data.add(new ComicBody("Carmal Covent School, Visit:026222674919", 5));


        return data;
    }



    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(JuniorKg.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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
class ComicBody2{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody2(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
