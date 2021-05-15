package com.mishsapp.quizcreationapplication.add_que.que_type;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mishsapp.quizcreationapplication.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AddClassicQueActivity extends AppCompatActivity {
    int temp = 0;

    private EditText editTextClassicQuestion, editTextClassicAnswer, editTextClassicPoint;
    private Button buttonClassicEasy, buttonClassicMiddle, buttonClassicHard, buttonClassicSave, buttonClassicNewQueAdd;

    String queCount;
    String que, answer, grade, point;
    private Context context;
    public List<HashMap<String, String>> myList=new ArrayList<>();
    void init() {

        editTextClassicQuestion = findViewById(R.id.editTextClassicQuestion);
        editTextClassicAnswer = findViewById(R.id.editTextClassicAnswer);
        editTextClassicPoint = findViewById(R.id.editTextClassicPoint);
        buttonClassicEasy = findViewById(R.id.buttonClassicEasy);
        buttonClassicMiddle = findViewById(R.id.buttonClassictMiddle);
        buttonClassicHard = findViewById(R.id.buttonClassicHard);
        buttonClassicNewQueAdd = findViewById(R.id.buttonClassicNewQueAdd);
        buttonClassicSave = findViewById(R.id.buttonClassicSave);

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
        buttonClassicNewQueAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClassicQuestion();
                HashMap<String,String> hm;
                hm=new HashMap<String,String>();
                queCount = String.valueOf(myList.size()+1);

                hm.put("KAÇINCI SORU: ",queCount);
                hm.put("SORU: ",que);
                hm.put("CEVAP",answer);
                hm.put("PUAN: ",point);
                hm.put("ZORLUK DERECESİ: ", grade);


                myList.add(hm);

                editTextClassicQuestion.setText("");
                editTextClassicAnswer.setText("");
                editTextClassicPoint.setText("");

                que = "";
                answer = "";
                grade = "";
                point = "";

                buttonClassicEasy.setEnabled(true);
                buttonClassicMiddle.setEnabled(true);
                buttonClassicHard.setEnabled(true);
            }
        });

        buttonClassicSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                method2(myList);
                saveArrayList(myList);

                Toast.makeText(getApplicationContext(), "SORU KAYDEDİLDİ!", Toast.LENGTH_SHORT).show();

                for (int i =0 ; i< myList.size(); i++){
                    Log.e("MyLıst: ", String.valueOf(myList.get(i)));
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Log.e("MyList Kontrol: ", String.valueOf(myList.get(1).getOrDefault("PUAN: ",String.valueOf(0))));
                }

            }
        });
    }


    private void myClassicQuestion() {


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

        method2(myList);
        saveArrayList(myList);

        Toast.makeText(getApplicationContext(), "SORU KAYDEDİLDİ!", Toast.LENGTH_SHORT).show();

        for (int i =0 ; i< myList.size(); i++){
            Log.e("MyLıst: ", String.valueOf(myList.get(i)));
        }

    }

    public List<HashMap<String, String>> method2(List<HashMap<String, String>> arrayList) {




        try {
            FileInputStream inputStream = openFileInput("myQuestions.txt");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            arrayList = (List<HashMap<String, String>>) in.readObject();
            in.close();
            inputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return arrayList;

    }private void saveArrayList(List<HashMap<String, String>> arrayList) {
        try {
            FileOutputStream fileOutputStream = openFileOutput("myQuestions.txt", Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(arrayList);
            out.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

