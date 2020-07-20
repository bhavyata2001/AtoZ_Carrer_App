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

public class BcaCourse extends AppCompatActivity {

    ListView lw1;
    Spinner sp2;
    ArrayAdapter<ComicBody> adapter;
    Button abt_course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca_course);
        abt_course = (Button)findViewById(R.id.abt_course);

        abt_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BcaCourse.this,HscCourse.class);
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
                    Toast.makeText(BcaCourse.this, "not exist", Toast.LENGTH_LONG).show();
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

        data.add(new ComicBody("Veer Narmad South Gujarat University", 1));
        data.add(new ComicBody("BCA College", 1));
        data.add(new ComicBody("Shri Shambhubhai V Patel College Of Computer Science & Business Management", 1));
        data.add(new ComicBody("Ambaba Commerce College", 1));
        data.add(new ComicBody("Bhagwan Mahavir College of Computer Application", 1));
        data.add(new ComicBody("Uka Tarsadia University", 1));
        data.add(new ComicBody("Vidyabharti Trust College of BBA and BCA", 1));
        data.add(new ComicBody("NG Patel Polytechnic", 1));

        data.add(new ComicBody("L. J. College of Computer Application", 2));
        data.add(new ComicBody("P. D. Pandya Institute of Computer Application", 2));
        data.add(new ComicBody("Dr. Babasaheb Ambedkar Open University", 2));
        data.add(new ComicBody("GLS Institute of Computer Applications", 2));
        data.add(new ComicBody("H. L. Institute of Computer Applications", 2));
        data.add(new ComicBody("Indira Gandhi National Open University", 2));
        data.add(new ComicBody("Navgujarat College of Computer Application", 2));

        data.add(new ComicBody("Kalol Institute and Research Center", 3));
        data.add(new ComicBody("Shri Akhil Anjana Kelvani Mandal College of Computer Application", 3));
        data.add(new ComicBody("Gujarat Institute of Management", 3));
        data.add(new ComicBody("Kadi Sarva Vishwavidyalaya", 3));

        data.add(new ComicBody("Navrachana University", 4));
        data.add(new ComicBody("The Maharaja Sayajirao University", 4));
        data.add(new ComicBody("BALAJI COLLEGES", 4));
        data.add(new ComicBody("Baroda Institute of Management Study", 4));


        data.add(new ComicBody("Smt. R. D. Gardi B.C.A. College", 5));
        data.add(new ComicBody("Vivekanand College Of Computer Science & Managemen", 5));
        data.add(new ComicBody("Shree G.K. & C.K. Bosamia Arts & Commerce College", 5));
        data.add(new ComicBody("R P Bhalodia College", 5));
        data.add(new ComicBody("Smt. K.S.N. Kansagara Mahila College", 5));

        data.add(new ComicBody("Vekaria Institute", 6));
        data.add(new ComicBody("Dr. Subhash Technical Campus (DSTC)", 6));
        data.add(new ComicBody("OM Engineering College (OEC)", 6));
        data.add(new ComicBody("Balaji Engineering College", 6));
        data.add(new ComicBody("Noble Group of Institutions (NGI)", 6));


        return data;
    }
    private void getSelectedCategoryData(int catID){
        ArrayList<ComicBody> comicBodies = new ArrayList<>();
        if (catID==0)
        {
            Toast.makeText(BcaCourse.this,"Choose a right school in your favourite city for your course",Toast.LENGTH_SHORT).show();
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

class ComicBody13{
    private  String name;
    private int catID;

    public String getName(){
        return name;
    }
    public int getCatID(){
        return catID;
    }
    public ComicBody13(String name,int catID){
        this.name = name;
        this.catID = catID;
    }
    public String toString(){
        return name;
    }
}
