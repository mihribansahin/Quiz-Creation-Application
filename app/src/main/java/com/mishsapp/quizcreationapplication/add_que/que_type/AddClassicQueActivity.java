package com.mishsapp.quizcreationapplication.add_que.que_type;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mishsapp.quizcreationapplication.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class AddClassicQueActivity extends AppCompatActivity {
    int temp = 0;

    private EditText editTextClassicQuestion, editTextClassicAnswer, editTextClassicPoint;
    private Button buttonClassicEasy, buttonClassicMiddle, buttonClassicHard, buttonClassicSave;

    String que, answer, grade, point;
    private Context context;

    void init() {

        editTextClassicQuestion = findViewById(R.id.editTextClassicQuestion);
        editTextClassicAnswer = findViewById(R.id.editTextClassicAnswer);
        editTextClassicPoint = findViewById(R.id.editTextClassicPoint);
        buttonClassicEasy = findViewById(R.id.buttonClassicEasy);
        buttonClassicMiddle = findViewById(R.id.buttonClassictMiddle);
        buttonClassicHard = findViewById(R.id.buttonClassicHard);
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

        buttonClassicSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClassicQuestion();


                HashMap<String,String> hm;
                hm=new HashMap<String,String>();

                hm.put("SORU: ",que);
                hm.put("CEVAP",answer);
                hm.put("PUAN: ",point);
                hm.put("ZORLUK DERECESİ: ", grade);

                method2(hm);

                Toast.makeText(getApplicationContext(), "SORU KAYDEDİLDİ!", Toast.LENGTH_SHORT).show();

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
    }

    public void method2(HashMap<String,String> map) {

              /////////////////  WRITE  ///////////////////
            try {
                File myFile=new File("questions.txt");
                FileOutputStream fos= openFileOutput("questions.txt", Context.MODE_PRIVATE);
                PrintWriter pw=new PrintWriter(fos);

                for(Map.Entry<String,String> m :map.entrySet()){
                    pw.println(m.getKey()+"="+m.getValue());
                }
                pw.flush();
                pw.close();
                fos.close();
                Toast.makeText(getApplicationContext(),"questions.txt" + " saved",
                        Toast.LENGTH_LONG).show();
            } catch(Exception e) {
                Log.e("DOSYA MEVZUSU", e.toString());
            }

            /////////////////  READ ///////////////////

            try {

                File toRead=new File("questions.txt");
                FileInputStream fis=new FileInputStream(toRead);

                Scanner sc=new Scanner(fis);

                HashMap<String,String> mapInFile=new HashMap<String,String>();

                //read data from file line by line:
                String currentLine;
                while(sc.hasNextLine()) {
                    currentLine=sc.nextLine();
                    //now tokenize the currentLine:
                    StringTokenizer st=new StringTokenizer(currentLine,"=",false);
                    //put tokens ot currentLine in map
                    mapInFile.put(st.nextToken(),st.nextToken());
                }
                fis.close();

                //print All data in MAP
                for(Map.Entry<String,String> m :mapInFile.entrySet()) {
                    System.out.println(m.getKey()+" : "+m.getValue());
                }
            }catch(Exception e) {}


    }
}
