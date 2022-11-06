package com.example.logintestapp;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    // 서버 URL 설정 (php 파일 연동)
    final static private String URL = "http://192.168.35.63/Register.php";
    private Map<String, String> map;

    public RegisterRequest(String userID, String userPassword, String userName, String userEmail, String userCard ,int userAge, String userPhone,Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        map.put("userEmail", userEmail);
        map.put("userCard", userCard);
        map.put("userAge", userAge + "");
        map.put("userPhone", userPhone);
    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
