package com.mishsapp.quizcreationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mishsapp.quizcreationapplication.add_que.AddQueActivity;


public class MainActivity extends AppCompatActivity {
    private Button buttonAddQue, buttonRemoveQue, buttonAllListQue, buttonCreatingExam;

    private void init(){

        buttonAddQue = findViewById(R.id.buttonAddQue);
        buttonRemoveQue = findViewById(R.id.buttonRemoveQue);
        buttonAllListQue = findViewById(R.id.buttonAllListQue);
        buttonCreatingExam = findViewById(R.id.buttonCreatingExam);


        buttonAddQue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddQueActivity.class);
                startActivity(intent);

            }
        });

        buttonRemoveQue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonAllListQue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonCreatingExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();








    }
}