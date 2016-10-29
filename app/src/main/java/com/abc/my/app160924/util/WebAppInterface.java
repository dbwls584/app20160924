package com.abc.my.app160924.util;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by 1027 on 2016-10-29.
 */

public class WebAppInterface {
    Context context; //activity로 호출해서 갖다가 쓰겠다 라는 의미로 컨텍스트를 쓴것이다.

    /** Instantiate the interface and set the context */
    public WebAppInterface(Context context) { //생성자라서 public 줘야한다.
        context = context;
    }

    /** Show a toast from the web page */
    @JavascriptInterface //홈페이지에서 웹뷰 자바스크립트 사용시에보면 caution 부분 때문에 있음.
    public void showToast(String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
