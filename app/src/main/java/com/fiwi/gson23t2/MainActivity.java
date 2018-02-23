package com.fiwi.gson23t2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView tvTextjson;
    Button btHientext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btHientext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noidung=Getfile("listvideo.json",MainActivity.this);
                tvTextjson.setText(noidung);
            }
        });

//sdfsfsfsfsf
        String test;


    }

    private String Getfile(String fileName, Context context) {
        String json=null;
        InputStream input= null;
        try {
            input = context.getAssets().open(fileName);
            int size =input.available();
            byte[] buffer=new byte[size];
            input.read(buffer);
            input.close();
            json=new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    private void Anhxa() {
        tvTextjson=(TextView)findViewById(R.id.tvTextjson);
        btHientext=(Button)findViewById(R.id.btHientext);
    }
}
