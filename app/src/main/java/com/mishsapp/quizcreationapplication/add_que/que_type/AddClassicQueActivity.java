package com.mishsapp.quizcreationapplication.add_que.que_type;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mishsapp.quizcreationapplication.R;


public class AddClassicQueActivity extends AppCompatActivity {

    private EditText editTextClassicQuestion, editTextClassicAnswer, editTextClassicPoint;
    private Button buttonClassicEasy, buttonClassicMiddle, buttonClassicHard, buttonClassicSave;


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


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}