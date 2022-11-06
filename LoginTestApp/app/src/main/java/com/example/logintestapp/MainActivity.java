package com.example.logintestapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // intent result 초기화
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode,resultCode,data
        );
        // 컨디션 체크
        if(intentResult.getContents() != null){
            // 제대로 잘 되면
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this
            );
            // 제목 설정
            builder.setTitle("Result");
            // 메시지 설정
            builder.setMessage(intentResult.getContents());
            // 잘되는 버튼 설정
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // 다이어로그 버리기
                    dialogInterface.dismiss();
                }
            });
            // 다이어로그 알람 보여주기
            builder.show();
        }else {
            // 스캔 안햇을때
            Toast.makeText(getApplicationContext()
                            ,"didn't scan anything",Toast.LENGTH_SHORT)
                    .show();
        }
    }
    }
