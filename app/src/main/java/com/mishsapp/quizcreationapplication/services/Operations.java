package com.mishsapp.quizcreationapplication.services;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Operations {
    static File file;

    // dosya yazar
   public static void writeFile(List<HashMap<String, String>> arrayList) {
        try {
            File path = Environment.getExternalStorageDirectory(); // storage/emulator/0
            File file = new File(path,"Questions.txt");
            if(!file.exists()){ //dosya var mı yok mu kontrolu
                //yoksa
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter yazici = new BufferedWriter(fw);

            for(HashMap<String, String> str: arrayList) {
                yazici.write(str + System.lineSeparator());
            }
            // yazici.write("");
            yazici.flush(); //yazarken bir hata yaparsa kendi kendine düzeltsin diye
            yazici.close();

        } catch (IOException e) {
            e.printStackTrace();
        }}

    public static void appendFile(List<HashMap<String, String>> arrayList){ //veri ekler
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFile(){
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
    }; // dosyadan okur

