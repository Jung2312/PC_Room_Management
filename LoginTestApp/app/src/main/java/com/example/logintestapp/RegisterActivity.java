package com.example.logintestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name, et_email, et_card, et_age, et_phn;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 액티비티 실행될때 처음으로 시작되는 애들
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 아이디 값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_card = findViewById(R.id.et_card);
        et_age = findViewById(R.id.et_age);
        et_phn = findViewById(R.id.et_phn);

        // 회원가입 버튼 클릭 시 수행
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 얘네는 Edittext에 현재 입력되어있는 값을 가져온다.
                String userID = et_id.getText().toString();
                String userPassword = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                String userEmail = et_email.getText().toString();
                String userCard = et_card.getText().toString();
                int userAge = Integer.parseInt(et_age.getText().toString());
                String userPhone = et_phn.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){ // 회원등록 성공
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                // 다시 로그인 화면으로 넘어가는 코드
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else { // 실패
                                Toast.makeText(getApplicationContext(), "회원 등록에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                // 서버로 발리를 이용해서 요청함.
                RegisterRequest registerRequest = new RegisterRequest(userID, userPassword, userName, userEmail, userCard, userAge, userPhone,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}