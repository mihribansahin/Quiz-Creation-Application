package com.mishsapp.quizcreationapplication.add_que.que_type;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mishsapp.quizcreationapplication.R;

public class AddGapFillingQueActivity extends AppCompatActivity {


    private EditText editTextGapFillingQuestion, editTextGapFillingDeletedWordAnswer, editTextGapFillingPoint;
    private Button buttonGapFillingEasy, buttonGapFillingMiddle, buttonGapFillingHard, buttonGapFillingSave;

    void init(){

        editTextGapFillingQuestion = findViewById(R.id.editTextGapFillingQuestion);
        editTextGapFillingDeletedWordAnswer = findViewById(R.id.editTextGapFillingDeletedWordAnswer);
        editTextGapFillingPoint = findViewById(R.id.editTextGapFillingPoint);
        buttonGapFillingEasy = findViewById(R.id.buttonGapFillingEasy);
        buttonGapFillingMiddle = findViewById(R.id.buttonGapFillingMiddle);
        buttonGapFillingHard = findViewById(R.id.buttonGapFillingHard);
        buttonGapFillingSave = findViewById(R.id.buttonGapFillingSave);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gap_filling_que);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Boşluk Doldurma Sorusu Ekle");
        init();
    }
}