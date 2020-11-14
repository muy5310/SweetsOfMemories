package com.example.sweetsofmemories;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Basket extends AppCompatActivity {

    Button field_minus, field_plus, stick_minus, stick_plus,
            kkeobeong_minus, kkeobeong_plus, home_btn, purchase_btn;
    CheckBox field_btn, stick_btn, kkeobeong_btn;
    TextView field_name, stick_name, kkeobeong_name,
            field_num, stick_num, kkeobeong_num,
            field_price, stick_price, kkeobeong_price, message;
    LinearLayout field_layout, stick_layout, kkeobeong_layout;
    int field_cnt = 1, stick_cnt = 1, kkeobeong_cnt = 1;
    ArrayList<String> itemList;
    ArrayList<Integer> numList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        ArrayList<String> names = getIntent().getStringArrayListExtra("name");
        ArrayList<Integer> nums = getIntent().getIntegerArrayListExtra("num");

        field_minus = (Button) findViewById(R.id.field_minus);
        field_plus = (Button) findViewById(R.id.field_plus);
        field_btn = (CheckBox) findViewById(R.id.field_btn);

        stick_minus = (Button) findViewById(R.id.stick_minus);
        stick_plus = (Button) findViewById(R.id.stick_plus);
        stick_btn = (CheckBox) findViewById(R.id.stick_btn);

        kkeobeong_minus = (Button) findViewById(R.id.kkeobeong_minus);
        kkeobeong_plus = (Button) findViewById(R.id.kkeobeong_plus);
        kkeobeong_btn = (CheckBox) findViewById(R.id.kkeobeong_btn);

        home_btn = (Button) findViewById(R.id.home_btn);
        purchase_btn = (Button) findViewById(R.id.purchase_btn);

        field_name = (TextView) findViewById(R.id.field_name);
        field_num = (TextView) findViewById(R.id.field_num);
        field_price = (TextView) findViewById(R.id.field_price);

        stick_name = (TextView) findViewById(R.id.stick_name);
        stick_num = (TextView) findViewById(R.id.stick_num);
        stick_price = (TextView) findViewById(R.id.stick_price);

        kkeobeong_name = (TextView) findViewById(R.id.kkeobeong_name);
        kkeobeong_num = (TextView) findViewById(R.id.kkeobeong_num);
        kkeobeong_price = (TextView) findViewById(R.id.kkeobeong_price);

        field_layout = (LinearLayout) findViewById(R.id.field_layout);
        stick_layout = (LinearLayout) findViewById(R.id.stick_layout);
        kkeobeong_layout = (LinearLayout) findViewById(R.id.kkeobeong_layout);

        itemList = new ArrayList<String>();
        numList = new ArrayList<Integer>();
        numList.add(1);
        numList.add(1);
        numList.add(1);

        if(names.contains("field")){
            field_layout.setBackground(Drawable.createFromPath("#fff0f5"));
            field_name.setText("싱싱 논두렁");
            field_price.setText("500원");
            field_btn.setText("구매");
            field_cnt = nums.get(0);
            field_num.setText(String.valueOf(field_cnt));
            field_btn.setChecked(true);
            itemList.add("field");
            numList.set(0,field_cnt);
        }
        if(names.contains("stick")){
            stick_layout.setBackground(Drawable.createFromPath("#fff0f5"));
            stick_name.setText("무지개 쫀디기");
            stick_price.setText("1500원");
            stick_btn.setText("구매");
            stick_cnt = nums.get(1);
            stick_num.setText(String.valueOf(stick_cnt));
            stick_btn.setChecked(true);
            itemList.add("stick");
            numList.set(1,stick_cnt);
        }
        if(names.contains("kkeobeong")){
            kkeobeong_layout.setBackground(Drawable.createFromPath("#fff0f5"));
            kkeobeong_name.setText("추억의 꺼벙이");
            kkeobeong_price.setText("1300원");
            kkeobeong_btn.setText("구매");
            kkeobeong_cnt = nums.get(2);
            kkeobeong_num.setText(String.valueOf(kkeobeong_cnt));
            kkeobeong_btn.setChecked(true);
            itemList.add("kkeobeong");
            numList.set(2,kkeobeong_cnt);
        }

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
                    Toast.makeText(Basket.this, "최소 1개 이상 구매 가능합니다.", Toast.LENGTH_SHORT).show();
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
                    field_layout.setBackground(Drawable.createFromPath("#fff0f5"));
                    field_name.setText("싱싱 논두렁");
                    field_price.setText("500원");
                    field_btn.setText("구매");
                    itemList.add("field");
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
                    Toast.makeText(Basket.this, "최소 1개 이상 구매 가능합니다.", Toast.LENGTH_SHORT).show();
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
                    stick_layout.setBackground(Drawable.createFromPath("#fff0f5"));
                    stick_name.setText("무지개 쫀디기");
                    stick_price.setText("1500원");
                    stick_btn.setText("구매");
                    itemList.add("stick");
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
                    Toast.makeText(Basket.this, "최소 1개 이상 구매 가능합니다.", Toast.LENGTH_SHORT).show();
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
                    kkeobeong_layout.setBackground(Drawable.createFromPath("#fff0f5"));
                    kkeobeong_name.setText("추억의 꺼벙이");
                    kkeobeong_price.setText("1300원");
                    kkeobeong_btn.setText("구매");
                    itemList.add("kkeobeong");
                }
                else{
                    itemList.remove("kkeobeong");
                }
            }
        });
        //홈 버튼 클릭시 다이얼로그
        final AlertDialog.Builder builder = new AlertDialog.Builder(Basket.this);
        builder.setTitle("주의");
        builder.setMessage("홈 화면으로 돌아가면 장바구니가 초기화 됩니다.");
        builder.setCancelable(false);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.setCancelable(false);
            }
        });

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.show();
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
                    Toast.makeText(Basket.this, "상품을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}