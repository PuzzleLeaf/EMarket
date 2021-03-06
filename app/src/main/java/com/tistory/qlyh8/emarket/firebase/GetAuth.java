package com.tistory.qlyh8.emarket.firebase;

import com.google.firebase.auth.FirebaseAuth;

//현재 사용자 uid, phone 정보 가져오기
public class GetAuth {

    private static FirebaseAuth mAuth = FirebaseAuth.getInstance();

    /*public static String getGoogleUserId(){

        String result;
        try {
            result = mAuth.getCurrentUser().getUid();
        } catch (NullPointerException e){
            result = "public";
        }
        return result;
    }*/

    /*public static String getUserId() {
        return mAuth.getCurrentUser().getUid();
    }*/

    /*public static String getGoogleUserName(){
        String result;
        try {
            result = mAuth.getCurrentUser().getDisplayName();
        } catch (NullPointerException e){
            result = "사용자";
        }
        return result;
    }*/

    public static String getUserId(){

        String result;
        try {
            result = mAuth.getCurrentUser().getUid();
        } catch (NullPointerException e){
            result = "public";
        }
        return result;
    }

    public static String getUserPhone(){

        String result;
        try {
            result = mAuth.getCurrentUser().getPhoneNumber();
        } catch (NullPointerException e){
            result = "";
        }
        return result;
    }
}
