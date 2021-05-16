package com.mishsapp.quizcreationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mishsapp.quizcreationapplication.add_que.AddQueActivity;
import com.mishsapp.quizcreationapplication.add_que.que_type.AddClassicQueActivity;
import com.mishsapp.quizcreationapplication.list_all_que.ListAllQueActivity;
import com.mishsapp.quizcreationapplication.remove_que.RemoveQueActivity;


public class MainActivity extends AppCompatActivity {
    private Button buttonAddQue, buttonRemoveQue, buttonAllListQue, buttonCreatingExam;

    AddClassicQueActivity acq = new AddClassicQueActivity();

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
                Intent intent = new Intent(MainActivity.this, RemoveQueActivity.class);
                startActivity(intent);


            }
        });

        buttonAllListQue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListAllQueActivity.class);
                startActivity(intent);


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