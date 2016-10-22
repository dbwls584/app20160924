package com.abc.my.app160924.member;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.abc.my.app160924.R;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-22.
 */

public class MemberAdapter extends BaseAdapter{
    ArrayList<MemberDTO> list;
    LayoutInflater inflater;
    private int[] photos = {
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.kitkat,
            R.drawable.jellybean,
            R.drawable.lollipop,
            R.drawable.icecream
    };

    public MemberAdapter(Context context, ArrayList<MemberDTO> list) {
        this.list = list;
        this.inflater = LayoutInflater.from(context); //이렇게 써야함... context는 액티비티로 생각하면 좋음.
    }

    @Override
    public int getCount() {
        return list.size(); //java에서 쓰이는거임..list에있는 값들만 제어하기위해서..
    }

    @Override
    public Object getItem(int i) {
        return list.get(i); //java 컬렉션:특정 인스턴스를 긁어오는 문법. (몇번째있는걸가져와라.)
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        ViewHolder holder;
        if(v==null){ //null체크는 리스트중에 개별의 리스트 목록을 체크한다.
            v = inflater.inflate(R.layout.member_list,null);
            holder = new ViewHolder();
            holder.iv_Photo = (ImageView) v.findViewById(R.id.iv_photo);
            holder.tv_Name = (TextView) v.findViewById(R.id.tv_name);
            holder.tv_Phone = (TextView) v.findViewById(R.id.tv_phone);
            v.setTag(holder); //v = 부터 v.settag까지 문법적으로굳어졌다.
        }else{
            holder = (ViewHolder) v.getTag();
        }
        Log.d("어댑터에서 체크한 이름",list.get(i).getName());
        holder.iv_Photo.setImageResource(photos[i]);
        holder.tv_Name.setText(list.get(i).getName());
        holder.tv_Phone.setText(list.get(i).getPhone());
        return v;
    } //method 스코프내에 if문을가진 알고리즘을 짠다.!
    static class ViewHolder{ //하도 많이 쓰일예정이라. 스태틱줌.. 스태틱은 공유하는 객체 / 인스턴스는 하나를위한 객체.
        ImageView iv_Photo;
        TextView tv_Name;
        TextView tv_Phone; // 모양이대략 사진|이름|폰 으로 할 예정.
    }
}
