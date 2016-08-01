package com.example.tanabe.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testactivity.R;

public class SubActivity extends AppCompatActivity {

    TextView textView1, textView2;
    int data1 = 0;
    int data2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();//受け取る宣言
        data1 = intent.getIntExtra("DATA1", 0); //宣言と受け取る
        data2 = intent.getIntExtra("DATA2", 0);
        String message = intent.getStringExtra("Message");

        textView1 = (TextView) findViewById(R.id.textview1);
        textView1.setText(message);

        textView2 = (TextView) findViewById(R.id.textview2);
        String add = String.valueOf(data1 + data2);
        textView2.setText(add);

        Button sendButton = (Button) findViewById(R.id.return_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}