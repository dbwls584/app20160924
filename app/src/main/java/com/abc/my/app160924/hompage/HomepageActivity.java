package com.abc.my.app160924.hompage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.abc.my.app160924.R;
import com.abc.my.app160924.util.WebAppInterface;

public class HomepageActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        WebView webView = (WebView) findViewById(R.id.webview);
        //webView.loadUrl("http://www.naver.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        String html= "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<video width=\"400\" controls>\n" +
                "  <source src=\"mov_bbb.mp4\" type=\"video/mp4\">\n" +
                "  <source src=\"mov_bbb.ogg\" type=\"video/ogg\">\n" +
                "  Your browser does not support HTML5 video.\n" +
                "</video>\n" +
                "\n" +
                "<p>\n" +
                "Video courtesy of\n" +
                "<a href=\"http://www.bigbuckbunny.org/\" target=\"_blank\">Big Buck Bunny</a>.\n" +
                "</p>\n" +
                "\n"
                +"<button id='mypage'>마이페이지</button>" //"" 사이에는 ''줘야한다.
                +"<script>"+
                ""+
                "</script>"+
                "</body>\n" +
                "</html>";
        webView.loadDataWithBaseURL("",html,"text/html","UTF-8",null);
        // baseurl -> naver.com ==>null처리
        // data -> html소스코딩한 파일
        // minetype -> text/html
        // encoding -> UTF-8
        // historyurl -> null처리
    }
}
