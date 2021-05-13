package com.mishsapp.quizcreationapplication.add_que.que_type;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mishsapp.quizcreationapplication.R;


public class AddClassicQueActivity extends AppCompatActivity {
    int temp = 0;

    private EditText editTextClassicQuestion, editTextClassicAnswer, editTextClassicPoint;
    private Button buttonClassicEasy, buttonClassicMiddle, buttonClassicHard, buttonClassicSave;

    String que,answer,grade,point;

    void init(){

        editTextClassicQuestion  =findViewById(R.id.editTextClassicQuestion);
        editTextClassicAnswer  =findViewById(R.id.editTextClassicAnswer);
        editTextClassicPoint  =findViewById(R.id.editTextClassicPoint);
        buttonClassicEasy  =findViewById(R.id.buttonClassicEasy);
        buttonClassicMiddle  =findViewById(R.id.buttonClassictMiddle);
        buttonClassicHard  =findViewById(R.id.buttonClassicHard);
        buttonClassicSave  =findViewById(R.id.buttonClassicSave);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_classic_que);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Klasik Soru Ekle");
        init();

        buttonClassicEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = 1;
                buttonClassicMiddle.setEnabled(false);
                buttonClassicHard.setEnabled(false);

            }
        });
        buttonClassicMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = 2;
                buttonClassicEasy.setEnabled(false);
                buttonClassicHard.setEnabled(false);

            }
        });
        buttonClassicHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = 3;
                buttonClassicMiddle.setEnabled(false);
                buttonClassicEasy.setEnabled(false);

            }
        });

        buttonClassicSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClassicQuestion();
                Toast.makeText(getApplicationContext(),"SORU KAYDEDİLDİ!", Toast.LENGTH_SHORT).show();

                editTextClassicQuestion.setText("");
                editTextClassicAnswer.setText("");
                editTextClassicPoint.setText("");

                que ="";
                answer ="";
                grade ="";
                point ="";

                buttonClassicEasy.setEnabled(true);
                buttonClassicMiddle.setEnabled(true);
                buttonClassicHard.setEnabled(true);
            }
        });
    }


    private void myClassicQuestion(){

       que = String.valueOf(editTextClassicQuestion.getText());
       answer = String.valueOf(editTextClassicAnswer.getText());
       grade = String.valueOf(temp);
       point = String.valueOf(editTextClassicPoint.getText());


        Log.e("KLASİK ", que);
        Log.e("KLASİK ", answer);
        Log.e("KLASİK ", grade);
        Log.e("KLASİK ", point);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}