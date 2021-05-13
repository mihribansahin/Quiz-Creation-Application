package com.mishsapp.quizcreationapplication.add_que.que_type;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.mishsapp.quizcreationapplication.R;

public class AddMultipleChoiceQueActivity extends AppCompatActivity {

    int temp = 0;
    private EditText editTextTestQuestion, editTextTestOption1,
            editTextTestOption2, editTextTestOption3,
            editTextTestOption4, editTextTestPoint;
    private Button buttonTestEasy, buttonTestMiddle, buttonTestHard, buttonTestSave;
    private CheckBox checkBoxOption1, checkBoxOption2, checkBoxOption3, checkBoxOption4;
    private String que, opt1, opt2, opt3, opt4, point;
    private String trueOption;


    void init() {
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

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_multiple_choice_que);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Çoktan Seçmeli Soru Ekle");
        init();

        buttonTestEasy.setOnClickListener(new View.OnClickListener() { //1
            @Override
            public void onClick(View view) {
                temp = 1;
                buttonTestMiddle.setEnabled(false);
                buttonTestHard.setEnabled(false);

            }
        });
        buttonTestMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = 2;
                buttonTestHard.setEnabled(false);
                buttonTestEasy.setEnabled(false);

            }
        });
        buttonTestHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = 3;
                buttonTestEasy.setEnabled(false);
                buttonTestMiddle.setEnabled(false);
            }
        });
        buttonTestSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTestQuestion();
/*                  if(dosyaya kaydedildiyse){
                     Toast.makeText(getApplicationContext(), "SORU KAYDEDİLDİ!", Toast.LENGTH_SHORT).show();
                }*/
                clearPage();
            }

        });
    }

    private void clearPage() {
        editTextTestQuestion.setText("");
        editTextTestOption1.setText("");
        editTextTestOption2.setText("");
        editTextTestOption3.setText("");
        editTextTestOption4.setText("");
        editTextTestPoint.setText("");


        que = "";
        opt1 = "";
        opt2 = "";
        opt3 = "";
        opt4 = "";
        point = "";

        buttonTestEasy.setEnabled(true);
        buttonTestMiddle.setEnabled(true);
        buttonTestHard.setEnabled(true);

        checkBoxOption1.setChecked(false);
        checkBoxOption2.setChecked(false);
        checkBoxOption3.setChecked(false);
        checkBoxOption4.setChecked(false);

        checkBoxOption1.setEnabled(true);
        checkBoxOption2.setEnabled(true);
        checkBoxOption3.setEnabled(true);
        checkBoxOption4.setEnabled(true);


    }


    @SuppressLint("LongLogTag")
    private void myTestQuestion() {
        que = String.valueOf(editTextTestQuestion.getText());
        opt1 = String.valueOf(editTextTestOption1.getText());
        opt2 = String.valueOf(editTextTestOption2.getText());
        opt3 = String.valueOf(editTextTestOption3.getText());
        opt4 = String.valueOf(editTextTestOption4.getText());
        point = String.valueOf(editTextTestPoint.getText());
        onCheckboxClicked(checkBoxOption1);
        onCheckboxClicked(checkBoxOption2);
        onCheckboxClicked(checkBoxOption3);
        onCheckboxClicked(checkBoxOption4);

        try { //eğer eksik bir durum varsa crash olmaması icin, try catch ile yazdık.
            Log.e("*** ÇOKTAN SEÇMELİ - SORU: ", que);
            Log.e("*** ÇOKTAN SEÇMELİ - DOĞRU CEVAP: ", trueOption);
            Log.e("*** ÇOKTAN SEÇMELİ - PUAN: ", point);
            Log.e("*** ÇOKTAN SEÇMELİ - ZORLUK SEVİYESİ: ", String.valueOf(temp));
            Log.e("*** ÇOKTAN SEÇMELİ - 1.SEÇENEK : ", opt1);
            Log.e("*** ÇOKTAN SEÇMELİ - 2.SEÇENEK : ", opt2);
            Log.e("*** ÇOKTAN SEÇMELİ - 3.SEÇENEK : ", opt3);
            Log.e("*** ÇOKTAN SEÇMELİ - 4.SEÇENEK : ", opt4);

        } catch (Exception e) {
            Log.e("crash olduk... ", e.toString());
            Toast.makeText(getApplicationContext(), "ESKİK SORU KAYDEDİLEMEZ", Toast.LENGTH_SHORT).show();

        }

        if (opt1.equals("") || opt2.equals("") || opt3.equals("") || opt4.equals("")) {
            Toast.makeText(getApplicationContext(), "Sorunuz Eksik olduğu için kaydedilemedi!", Toast.LENGTH_SHORT).show();
        }

    }


    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkBoxOption1:
                if (checked) {
                    trueOption = opt1;
                    checkBoxOption2.setEnabled(false);
                    checkBoxOption3.setEnabled(false);
                    checkBoxOption4.setEnabled(false);}
                else{
                    checkBoxOption2.setEnabled(true);
                    checkBoxOption3.setEnabled(true);
                    checkBoxOption4.setEnabled(true);
                }
                break;

            case R.id.checkBoxOption2:
                if (checked){
                    trueOption = opt2;
                    checkBoxOption1.setEnabled(false);
                    checkBoxOption3.setEnabled(false);
                    checkBoxOption4.setEnabled(false);
                }else {
                    checkBoxOption1.setEnabled(true);
                    checkBoxOption3.setEnabled(true);
                    checkBoxOption4.setEnabled(true);
                }
                break;

            case R.id.checkBoxOption3:
                if (checked){
                    trueOption = opt3;
                    checkBoxOption1.setEnabled(false);
                    checkBoxOption2.setEnabled(false);
                    checkBoxOption4.setEnabled(false);
                }else{
                    checkBoxOption1.setEnabled(true);
                    checkBoxOption2.setEnabled(true);
                    checkBoxOption4.setEnabled(true);
                }
                break;

            case R.id.checkBoxOption4:
                if (checked){
                    trueOption = opt4;
                    checkBoxOption1.setEnabled(false);
                    checkBoxOption2.setEnabled(false);
                    checkBoxOption3.setEnabled(false);

                }else{
                    checkBoxOption1.setEnabled(true);
                    checkBoxOption2.setEnabled(true);
                    checkBoxOption3.setEnabled(true);
                }
                break;



        }
    }
}