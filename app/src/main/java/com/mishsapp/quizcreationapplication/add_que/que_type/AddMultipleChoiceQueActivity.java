package com.mishsapp.quizcreationapplication.add_que.que_type;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mishsapp.quizcreationapplication.R;
public class AddMultipleChoiceQueActivity extends AppCompatActivity {

    private EditText editTextTestQuestion,
            editTextTestOption1, editTextTestOption2, editTextTestOption3, editTextTestOption4,
            editTextTestPoint;
    private Button buttonTestEasy, buttonTestMiddle, buttonTestHard,
            buttonTestSave;
    private CheckBox checkBoxOption1, checkBoxOption2, checkBoxOption3, checkBoxOption4;

    void init(){
        editTextTestQuestion = findViewById(R.id.editTextTestQuestion);
        editTextTestOption1 = findViewById(R.id.editTextTestOption1);
        editTextTestOption2 = findViewById(R.id.editTextTestOption2);
        editTextTestOption3 = findViewById(R.id.editTextTestOption3);
        editTextTestOption4 = findViewById(R.id.editTextTestOption4);
        editTextTestPoint = findViewById(R.id.editTextTestPoint);
        buttonTestEasy = findViewById(R.id.buttonTestEasy);
        buttonTestMiddle = findViewById(R.id.buttonTestMiddle);
        buttonTestHard = findViewById(R.id.buttonTestHard);
        buttonTestSave = findViewById(R.id.buttonTestSave);
        checkBoxOption1 = findViewById(R.id.checkBoxOption1);
        checkBoxOption2 = findViewById(R.id.checkBoxOption2);
        checkBoxOption3 = findViewById(R.id.checkBoxOption3);
        checkBoxOption4 = findViewById(R.id.checkBoxOption4);

        buttonTestEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonTestMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonTestHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonTestSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        editTextTestQuestion.getText();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_multiple_choice_que);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Çoktan Seçmeli Soru Ekle");
        init();

    }
}