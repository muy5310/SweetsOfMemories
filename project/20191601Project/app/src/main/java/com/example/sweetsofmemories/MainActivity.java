package com.example.sweetsofmemories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button field_minus, field_plus, stick_minus, stick_plus,
            kkeobeong_minus, kkeobeong_plus, basket_btn, purchase_btn;
    CheckBox field_btn, stick_btn, kkeobeong_btn;
    TextView field_name, stick_name, kkeobeong_name,
            field_num, stick_num, kkeobeong_num, message;
    String name, num;
    int field_cnt = 1, stick_cnt = 1, kkeobeong_cnt = 1;
    ArrayList<String> itemList;
    ArrayList<Integer> numList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field_minus = (Button) findViewById(R.id.field_minus);
        field_plus = (Button) findViewById(R.id.field_plus);
        field_btn = (CheckBox) findViewById(R.id.field_btn);

        stick_minus = (Button) findViewById(R.id.stick_minus);
        stick_plus = (Button) findViewById(R.id.stick_plus);
        stick_btn = (CheckBox) findViewById(R.id.stick_btn);

        kkeobeong_minus = (Button) findViewById(R.id.kkeobeong_minus);
        kkeobeong_plus = (Button) findViewById(R.id.kkeobeong_plus);
        kkeobeong_btn = (CheckBox) findViewById(R.id.kkeobeong_btn);

        basket_btn = (Button) findViewById(R.id.basket_btn);
        purchase_btn = (Button) findViewById(R.id.purchase_btn);

        field_name = (TextView) findViewById(R.id.field_name);
        field_num = (TextView) findViewById(R.id.field_num);
        stick_name = (TextView) findViewById(R.id.stick_name);
        stick_num = (TextView) findViewById(R.id.stick_num);
        kkeobeong_name = (TextView) findViewById(R.id.kkeobeong_name);
        kkeobeong_num = (TextView) findViewById(R.id.kkeobeong_num);
        message = (TextView) findViewById(R.id.message);

        itemList = new ArrayList<String>();
        numList = new ArrayList<Integer>();

        numList.add(1);
        numList.add(1);
        numList.add(1);

        field_plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                field_cnt++;
                field_num.setText(String.valueOf(field_cnt));
                numList.set(0, field_cnt);
            }
        });
        field_minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(field_cnt <= 1) {
                    Toast.makeText(MainActivity.this, "최소 1개 이상 구매 가능합니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    field_cnt--;
                    field_num.setText(String.valueOf(field_cnt));
                    numList.set(0, field_cnt);
                }
            }
        });
        field_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(field_btn.isChecked()){
                    itemList.add("field");
                    name = field_name.getText().toString();
                    num = field_num.getText().toString();
                    message.setText(name + " 총 " + num + "개를 선택하였습니다.");
                }
                else{
                    itemList.remove("field");
                }
            }
        });

        stick_plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                stick_cnt++;
                stick_num.setText(String.valueOf(stick_cnt));
                numList.set(1, stick_cnt);
            }
        });
        stick_minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(stick_cnt <= 1) {
                    Toast.makeText(MainActivity.this, "최소 1개 이상 구매 가능합니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    stick_cnt--;
                    stick_num.setText(String.valueOf(stick_cnt));
                    numList.set(1, stick_cnt);
                }
            }
        });
        stick_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(stick_btn.isChecked()){
                    itemList.add("stick");
                    name = stick_name.getText().toString();
                    num = stick_num.getText().toString();
                    message.setText(name + " 총 " + num + "개를 선택하였습니다.");
                }
                else{
                    itemList.remove("stick");
                }
            }
        });

        kkeobeong_plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                kkeobeong_cnt++;
                kkeobeong_num.setText(String.valueOf(kkeobeong_cnt));
                numList.set(2, kkeobeong_cnt);
            }
        });
        kkeobeong_minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(kkeobeong_cnt <= 1) {
                    Toast.makeText(MainActivity.this, "최소 1개 이상 구매 가능합니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    kkeobeong_cnt--;
                    kkeobeong_num.setText(String.valueOf(kkeobeong_cnt));
                    numList.set(2, kkeobeong_cnt);
                }
            }
        });
        kkeobeong_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(kkeobeong_btn.isChecked()){
                    itemList.add("kkeobeong");
                    name = kkeobeong_name.getText().toString();
                    num = kkeobeong_num.getText().toString();
                    message.setText(name + " 총 " + num + "개를 선택하였습니다.");
                }
                else{
                    itemList.remove("kkeobeong");
                }
            }
        });

        basket_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if((field_btn.isChecked()||stick_btn.isChecked())||kkeobeong_btn.isChecked()){
                    Intent intent = new Intent(getApplicationContext(), Basket.class);
                    intent.putExtra("name", itemList);
                    intent.putExtra("num", numList);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "상품을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        purchase_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if((field_btn.isChecked()||stick_btn.isChecked())||kkeobeong_btn.isChecked()){
                    Intent intent = new Intent(getApplicationContext(), Purchase.class);
                    intent.putExtra("name", itemList);
                    intent.putExtra("num", numList);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "상품을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}