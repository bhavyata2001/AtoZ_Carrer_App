 package com.example.emart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


 public class SignUp_Activity extends AppCompatActivity {

     public static final String TAG = "TAG";

     EditText edtname, edtnum, edtmail, edtpsw;
     TextView havecreate;
     Button buttonregistration;
     FirebaseAuth firebaseAuth;
     ProgressBar progressBar;
     FirebaseFirestore fstore;
     String userID;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_sign_up);

         getWindow().setFlags(
                 WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                 WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
         );
         getSupportActionBar().setTitle("Sign UP");

         buttonregistration = findViewById(R.id.butoonregistration);
         havecreate = findViewById(R.id.havecreate);
         edtname = findViewById(R.id.edtname);
         edtnum = findViewById(R.id.edtnum);
         edtmail = findViewById(R.id.edtmail);
         edtpsw = findViewById(R.id.edtpsw);
         progressBar = findViewById(R.id.progressBar2);

         firebaseAuth = FirebaseAuth.getInstance();
         fstore = FirebaseFirestore.getInstance();
         if (firebaseAuth.getCurrentUser() != null){
             startActivity(new Intent(getApplicationContext(), HomeActivity.class));
             finish();

         }

         buttonregistration.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 final String mail = edtmail.getText().toString().trim();
                 String psw = edtpsw.getText().toString().trim();
                 final String name = edtname.getText().toString();
                 final String number = edtnum.getText().toString();

                 if(TextUtils.isEmpty(mail)){
                     edtmail.setError("Email IS REquired");
                     return;
                 }
                 if (TextUtils.isEmpty(psw)){
                     edtpsw.setError("Password Is Required");
                     return;
                 }
                 if(psw.length() < 8){
                     edtpsw.setError("Password Must Be >= 8 Characters");
                     return;
                 }
                 progressBar.setVisibility(View.VISIBLE);
                 firebaseAuth.createUserWithEmailAndPassword(mail,psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()){
                             Toast.makeText(SignUp_Activity.this, "User Created", Toast.LENGTH_SHORT).show();
                             userID = firebaseAuth.getCurrentUser().getUid();
                             DocumentReference documentrefrence  = fstore.collection("users").document(userID);
                             Map<String,Object> user = new HashMap<>();
                             user.put("uname",name);
                             user.put("email",mail);
                             user.put("number",number);
                             documentrefrence.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                 @Override
                                 public void onSuccess(Void aVoid) {
                                     Log.d(TAG, "On Success: User Profile Is Created For"+ userID);
                                 }
                             }).addOnFailureListener(new OnFailureListener() {
                                 @Override
                                 public void onFailure(@NonNull Exception e) {
                                     Log.d(TAG,"onfailure:"+ e.toString());
                                 }
                             });
                             startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                             finish();
                         }else {
                             Toast.makeText(SignUp_Activity.this, "Error !" +  task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                             progressBar.setVisibility(View.GONE);
                         }
                     }
                 });
             }
         });
         havecreate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(SignUp_Activity.this, SignIn_Activity.class);
                 startActivity(i);
             }
         });
     }
 }
