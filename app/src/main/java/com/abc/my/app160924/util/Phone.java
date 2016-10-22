package com.abc.my.app160924.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by 1027 on 2016-10-22.
 */

public class Phone { //extends로 가도 구현되고.
    private Context context; //외부의 클래스인 Phone mvp 패턴중 p로 호출되어야한다(activity) 그러므로 컨텍스트가 필요함.
    private Activity activity; //은닉화를 위해 private 엑티비티를 쓴건 기능을 그대로 갖겟다는의미.

    public Phone(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    } //상속을 받지않고 직접 생성자를 줘서 코딩.
    public void dial(String PhoneNumber){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+PhoneNumber));
        context.startActivity(intent);
    }
    public void directCall(String PhoneNumber){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+PhoneNumber));
        if(ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE},2);
            return;
        } //안드로이드에서 전화거는 폼! 사이트에 양식처럼나와있음.
        context.startActivity(intent);
    }
}
