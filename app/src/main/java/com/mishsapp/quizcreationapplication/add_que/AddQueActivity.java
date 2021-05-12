package com.mishsapp.quizcreationapplication.add_que;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.mishsapp.quizcreationapplication.R;
import com.mishsapp.quizcreationapplication.add_que.que_type.AddClassicQueActivity;
import com.mishsapp.quizcreationapplication.add_que.que_type.AddGapFillingQueActivity;
import com.mishsapp.quizcreationapplication.add_que.que_type.AddMultipleChoiceQueActivity;
import com.mishsapp.quizcreationapplication.add_que.que_type.AddTrueFalseQueActivity;

public class AddQueActivity extends AppCompatActivity {

    private Button buttonTest, buttonClassic, buttonTrueFalse, buttonGapFilling;


    private void init() {
        buttonClassic = findViewById(R.id.buttonClassic);
        buttonTest = findViewById(R.id.buttonTest);
        buttonTrueFalse = findViewById(R.id.buttonTrueFalse);
        buttonGapFilling = findViewById(R.id.buttonGapFilling);

        buttonClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddQueActivity.this, AddClassicQueActivity.class);
                startActivity(intent);

            }
        });


       buttonTest.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(AddQueActivity.this, AddMultipleChoiceQueActivity.class);
               startActivity(intent);

           }
       });

       buttonGapFilling.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(AddQueActivity.this, AddGapFillingQueActivity.class);
               startActivity(intent);
           }
       });
        buttonTrueFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AddQueActivity.this, AddTrueFalseQueActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_que);
        init();
    }
}