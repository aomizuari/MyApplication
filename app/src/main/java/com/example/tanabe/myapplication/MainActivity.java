package com.example.tanabe.myapplication;//データの場所

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testactivity.R;

public class MainActivity extends AppCompatActivity {

    TextView textData1, textData2;
    int data1 = 1;
    int data2 = 2;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //動かす上での宣言
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //レイアウトと関連付け

        textData1 = (TextView) findViewById(R.id.text_data1); //レイアウトのテキスト1との関連付け
        textData1.setText("Data1 = " + String.valueOf(data1)); //表示

        textData2 = (TextView) findViewById(R.id.text_data2);
        textData2.setText("Data2 = " + String.valueOf(data2));

        Button sendButton = (Button) findViewById(R.id.send_button); //ボタン宣言とレイアウトのボタンとの関連付け
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //クリックされたら
                Intent intent = new Intent(getApplication(), SubActivity.class);//画面遷移の宣言と遷移先
                intent.putExtra("DATA1", data1); //データ投げる準備
                intent.putExtra("DATA2", data2);
                intent.putExtra("Message", "IDイーグル");
                startActivity(intent); //遷移開始(データ投げる)
            }
        });
        Button testButton = (Button) findViewById(R.id.send_button2);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox); //checkBoxの宣言
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplication(), "チェックが付いた", Toast.LENGTH_LONG).show();//表示
                } else {
                    Toast.makeText(getApplication(), "チェックが外れた", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}