package com.example.emart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.emart.Adapters.StudyAdapter3;
import com.example.emart.Adapters.StudyAdapter4;
import com.example.emart.Classes.RecyclerItemClickListener;
import com.example.emart.Models.StudyModel3;
import com.example.emart.Models.StudyModel4;

import java.util.ArrayList;

public class Hsc extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsc);

        recyclerView = findViewById(R.id.recyclerview4);
        ArrayList<StudyModel4> list = new ArrayList<>();

        list.add(new StudyModel4(R.drawable.btech, "Bechlor Of Technology(B.TECH)"));
        list.add(new StudyModel4(R.drawable.bsc, "Bechlor Of Science(B.SC)"));
        list.add(new StudyModel4(R.drawable.bca, "Bechlor Of Computer Application(BCA)"));
        list.add(new StudyModel4(R.drawable.ba, "Bechlor Of Arts"));
        list.add(new StudyModel4(R.drawable.fd, "Fashion Designing"));
        list.add(new StudyModel4(R.drawable.bcom, "Bachelor Of Commerce (B.COM)"));
        list.add(new StudyModel4(R.drawable.llb, "Bachelor Of Law (LLb)"));
        list.add(new StudyModel4(R.drawable.cma, "Cost And Management Accountant(CMA) "));
        list.add(new StudyModel4(R.drawable.ca, "Chartered Accountancy (CA)"));
        list.add(new StudyModel4(R.drawable.bba, "Bachelor of Business Administration(BBA) "));
        list.add(new StudyModel4(R.drawable.cs, "Company Secretary (CS)"));
        list.add(new StudyModel4(R.drawable.cfp, "Certified Financial Planner (CFP)"));
        list.add(new StudyModel4(R.drawable.be, " Bachelor Of Economics"));
        list.add(new StudyModel4(R.drawable.jmc, "Journalism And Mass Communication"));

        StudyAdapter4 adapter = new StudyAdapter4(list,this);
        recyclerView.setAdapter(adapter);

        StaggeredGridLayoutManager staggered = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggered);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                (this , recyclerView , new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position){
                            case 0:
                                Intent intent = new Intent(Hsc.this,BtechCourse.class);
                                startActivity(intent);

                                break;

                            case 1:
                                Intent i = new Intent(Hsc.this,BscCourse.class);
                                startActivity(i);

                                break;

                            case 2:
                                Intent i1 = new Intent(Hsc.this,BcaCourse.class);
                                startActivity(i1);

                                break;

                            case 3:
                                Intent i2 = new Intent(Hsc.this,ArtsCourse.class);
                                startActivity(i2);

                                break;

                            case 4:
                                Intent i3 = new Intent(Hsc.this,FashionCourse.class);
                                startActivity(i3);

                                break;

                            case 5:
                                Intent i4 = new Intent(Hsc.this,BcomCourse.class);
                                startActivity(i4);

                                break;

                            case 6:
                                Intent i5 = new Intent(Hsc.this,LlbCourse.class);
                                startActivity(i5);

                                break;

                            case 7:
                                Intent i6 = new Intent(Hsc.this,CmaCourse.class);
                                startActivity(i6);

                                break;

                            case 8:
                                Intent i7 = new Intent(Hsc.this,CaCourse.class);
                                startActivity(i7);

                                break;

                            case 9:
                                Intent i8 = new Intent(Hsc.this,BbaCourse.class);
                                startActivity(i8);

                                break;
                            case 10:
                                Intent i9 = new Intent(Hsc.this,CsCourse.class);
                                startActivity(i9);

                                break;
                            case 11:
                                Intent i10 = new Intent(Hsc.this,CfpCourse.class);
                                startActivity(i10);

                                break;
                            case 12:
                                Intent i11 = new Intent(Hsc.this,EconomicCourse.class);
                                startActivity(i11);

                                break;
                            case 13:
                                Intent i12 = new Intent(Hsc.this,JournalismCourse.class);
                                startActivity(i12);

                                break;
                            default:
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }

                ));
    }
}