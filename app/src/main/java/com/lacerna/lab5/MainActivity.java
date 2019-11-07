package com.lacerna.lab5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] androidName, androidVersion, androidAPI, androidDate,shortMessage;
    ListView list;
    int[] androidLogo = {R.drawable.android1,R.drawable.android2, R.drawable.android3,
            R.drawable.android4,R.drawable.android5,R.drawable.android6,
            R.drawable.android7,R.drawable.android8,R.drawable.android9,
            R.drawable.android10,R.drawable.android11,R.drawable.android12,
            R.drawable.android13,R.drawable.android14, R.drawable.android15};
    ArrayList<Android> androidList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidName = getResources().getStringArray(R.array.androidTitle);
        androidVersion = getResources().getStringArray(R.array.androidVersion);
        androidAPI = getResources().getStringArray(R.array.APILevel);
        androidDate = getResources().getStringArray(R.array.releaseDate);
        shortMessage = getResources().getStringArray(R.array.androidMessage);
        list = findViewById(R.id.lvVersions);
        for (int i = 0; i<androidName.length;i++){
            androidList.add(new Android(androidLogo[i],androidName[i],"Ver. "+ androidVersion[i],"API Level " + androidAPI[i],
                    "Released Date: "+androidDate[i],shortMessage[i]));
        }
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.activity_android_list_display,androidList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "android.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            String choice = "Version Name: " + androidList.get(i).getName() +" "+androidList.get(i).getDate();
            fos.write(choice.getBytes());
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle(androidList.get(i).getName());
            dialog.setIcon(androidList.get(i).getLogo());
            dialog.setMessage(androidList.get(i).getShortMessage());
            dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    File file = new File(folder, "android.txt");
                    StringBuilder text = new StringBuilder();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;

                        while ((line = br.readLine()) != null){
                            text.append(line);
                            text.append('\n');
                        }
                        br.close();

                        Toast.makeText(MainActivity.this,text.toString(),Toast.LENGTH_LONG).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            dialog.create().show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
