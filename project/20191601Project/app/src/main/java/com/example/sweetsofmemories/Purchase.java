package com.example.sweetsofmemories;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Purchase extends AppCompatActivity {

    Button purchase_btn, home_btn;
    TextView item_text, number_text, message;
    EditText address, phone;
    int total = 0;
    String user_address, user_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        purchase_btn = (Button) findViewById(R.id.purchase_btn);
        home_btn = (Button) findViewById(R.id.home_btn);
        item_text = (TextView) findViewById(R.id.item_text);
        number_text = (TextView) findViewById(R.id.number_text);
        message = (TextView) findViewById(R.id.message);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);
        ArrayList<String> names = getIntent().getStringArrayListExtra("name");
        ArrayList<Integer> nums = getIntent().getIntegerArrayListExtra("num");

        if(names.contains("field")){
            item_text.setText("싱싱 논두렁(500원)\n");
            number_text.setText(nums.get(0) + "\n");
            total += 500 * nums.get(0);
        }
        if(names.contains("stick")){
            item_text.setText(item_text.getText() + "무지개 쫀디기(1500원)\n");
            number_text.setText(number_text.getText() + String.valueOf(nums.get(1)) + "\n");
            total += 1500 * nums.get(1);
        }
        if(names.contains("kkeobeong")){
            item_text.setText(item_text.getText() + "추억의 꺼벙이(1300원)");
            number_text.setText(number_text.getText() + String.valueOf(nums.get(2)));
            total += 1300 * nums.get(2);
        }
        message.setText("총 금액은 " + total + "원 입니다.");
        //홈 버튼 클릭시 다이얼로그
        final AlertDialog.Builder home_builder = new AlertDialog.Builder(Purchase.this);
        home_builder.setTitle("주의");
        home_builder.setMessage("홈 화면으로 돌아가면 모두 초기화 됩니다.");
        home_builder.setCancelable(false);
        home_builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        home_builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                home_builder.setCancelable(false);
            }
        });
        //구매 버튼 클릭시 다이얼로그
        final AlertDialog.Builder purchase_builder = new AlertDialog.Builder(Purchase.this);
        purchase_builder.setTitle("결제");
        purchase_builder.setMessage("구매를 완료하시겠습니까");
        purchase_builder.setCancelable(false);
        purchase_builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        purchase_builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                purchase_builder.setCancelable(false);
            }
        });

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_builder.show();
            }
        });

        purchase_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_address = address.getText().toString();
                user_phone = phone.getText().toString();
                if(user_address.equals("")&&user_phone.equals("")){
                    Toast.makeText(Purchase.this, "정보 입력이 완료되지 않았습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    purchase_builder.show();
                }
            }
        });
    }
}