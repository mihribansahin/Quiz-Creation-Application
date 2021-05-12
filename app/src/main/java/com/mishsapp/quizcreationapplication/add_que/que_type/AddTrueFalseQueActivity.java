package com.mishsapp.quizcreationapplication.add_que.que_type;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.mishsapp.quizcreationapplication.R;


public class AddTrueFalseQueActivity extends AppCompatActivity {

    private EditText editTextTrueFalseQuestion, editTextTrueFalsePoint;
    private Button buttonTrue, buttonFalse, buttonTrueFalseEasy,
    buttonTrueFalseMiddle, buttonTrueFalseHard, buttonTrueFalseSave;
    private CheckBox checkBoxTrue, checkBoxFalse;

    void init(){

        editTextTrueFalseQuestion = findViewById(R.id.editTextTestQuestion);
        editTextTrueFalsePoint = findViewById(R.id.editTextTrueFalsePoint);
        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);
        buttonTrueFalseEasy = findViewById(R.id.buttonTrueFalseEasy);
        buttonTrueFalseMiddle = findViewById(R.id.buttonTrueFalseMiddle);
        buttonTrueFalseHard = findViewById(R.id.buttonTrueFalseHard);
        buttonTrueFalseSave = findViewById(R.id.buttonTrueFalseSave);
        checkBoxTrue = findViewById(R.id.checkBoxTrue);
        checkBoxFalse = findViewById(R.id.checkBoxFalse);



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_true_false_que);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Doğru Yanlış Sorusu Ekle");
        init();
    }
}