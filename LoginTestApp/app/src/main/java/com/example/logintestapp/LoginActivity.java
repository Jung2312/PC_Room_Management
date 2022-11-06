package com.example.logintestapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText et_id, et_pass;
    private Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);


        // 회원가입 버튼 클릭 시 수행
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = et_id.getText().toString();
                String userPassword = et_pass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){ // 로그인 성공

                                Toast.makeText(getApplicationContext(), "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
// 바코드 스캔에서 뭘 쉽게해준다는 intent integrator 초기화
                                IntentIntegrator intentIntegrator = new IntentIntegrator(
                                        LoginActivity.this
                                );
                                // 프롬프트 텍스트 설정
                                intentIntegrator.setPrompt("For flash use volume up key");
                                // 경고음 설정
                                intentIntegrator.setBeepEnabled(true);
                                // 오리엔테인션 락
                                intentIntegrator.setOrientationLocked(true);
                                // 캡쳐 동작
                                intentIntegrator.setCaptureActivity(Capture.class);
                                // 스캔 시작
                                intentIntegrator.initiateScan();

                            }
                            else { // 실패
                                Toast.makeText(getApplicationContext(), "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }

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
                    LoginActivity.this
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