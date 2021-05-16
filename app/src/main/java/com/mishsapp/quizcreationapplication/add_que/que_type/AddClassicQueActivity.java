package com.mishsapp.quizcreationapplication.add_que.que_type;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mishsapp.quizcreationapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class AddClassicQueActivity extends AppCompatActivity {

    int temp = 0;
    private EditText editTextClassicQuestion, editTextClassicAnswer, editTextClassicPoint;
    private Button buttonClassicEasy, buttonClassicMiddle, buttonClassicHard, buttonClassicSave, buttonClassicNewQueAdd;
    String que, answer, grade, point, queCount;;
    private Context context;
    public List<HashMap<String, String>> myClassicQueList=new ArrayList<>();



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
                myClassicQuestionGetText();

                HashMap<String,String> hm;
                hm=new HashMap<String,String>();

                queCount = String.valueOf(myClassicQueList.size()+1);

                hm.put("KAÇINCI SORU: ",queCount);
                hm.put("SORU: ",que);
                hm.put("CEVAP",answer);
                hm.put("PUAN: ",point);
                hm.put("ZORLUK DERECESİ: ", grade);

                myClassicQueList.add(hm);

                editTextClassicQuestion.setText("");
                editTextClassicAnswer.setText("");
                editTextClassicPoint.setText("");

         /*       que = "";
                answer = "";
                grade = "";
                point = "";*/

                buttonClassicEasy.setEnabled(true);
                buttonClassicMiddle.setEnabled(true);
                buttonClassicHard.setEnabled(true);
            }
        });

        buttonClassicSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveToExternal(myClassicQueList);
readToExternal();

                Toast.makeText(getApplicationContext(), " DOSYAYA KAYDEDİLDİ ! ", Toast.LENGTH_SHORT).show();

                for (int i =0 ; i< myClassicQueList.size(); i++){
                    Log.e("MyList: ", String.valueOf(myClassicQueList.get(i)));
                }

            try {
                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                     Log.e("MyList Kontrol: ", String.valueOf(myClassicQueList.get(1).getOrDefault("PUAN: ",String.valueOf(0))));
             }
            } catch (Exception e){

                    Log.e("MyList Kontrol: ", e.toString());
                    Log.e("MyList Kontrol: ", "Crash olmak uzereydi, kurtardik");

                }
/*
                Intent intent = new Intent(AddClassicQueActivity.this, MainActivity.class);
                startActivity(intent);*/

            }
        });
    }


    private void myClassicQuestionGetText() {


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

 //       method2(myClassicQueList);
   //     saveArrayList(myClassicQueList);

        Toast.makeText(getApplicationContext(), "SORU KAYDEDİLDİ!", Toast.LENGTH_SHORT).show();

        for (int i =0 ; i< myClassicQueList.size(); i++){
            Log.e("MyLıst: ", String.valueOf(myClassicQueList.get(i)));
        }

    }

  public void saveToExternal(List<HashMap<String, String>> arrayList) {
      try {
           File path = Environment.getExternalStorageDirectory(); // storage/emulator/0
           File file = new File(path,"Questions.txt");
             if(!file.exists()){ //dosya var mı yok mu kontrolu
              //yoksa
              file.createNewFile();
             }

          FileWriter fw = new FileWriter(file,true); //true yaptik ust uste yazmasi icin
          BufferedWriter yazici = new BufferedWriter(fw);

          for(HashMap<String, String> str: myClassicQueList) {
              yazici.write(str + System.lineSeparator());
          }
            // yazici.write("");
             yazici.flush(); //yazarken bir hata yaparsa kendi kendine düzeltsin diye
             yazici.close();

          } catch (IOException e) {
              e.printStackTrace();
          }
  }

    public void readToExternal() {
        try {
            File path = Environment.getExternalStorageDirectory(); // storage/emulator/0
            File file = new File(path,"Questions.txt");

            FileReader fr = new FileReader(file);
            BufferedReader okuyucu = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String satir ="";

            int read;
            while((read = fr.read()) != -1){
                sb.append((char) read);
            }

            okuyucu.close();

            Log.e("BufferedReader: ", sb.toString());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

