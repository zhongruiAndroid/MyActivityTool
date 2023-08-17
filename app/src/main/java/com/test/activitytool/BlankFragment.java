package com.test.activitytool;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.activitytools.ActTools;
import com.github.activitytools.ResultCallback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class BlankFragment extends Fragment implements View.OnClickListener {

    Button bt11, bt12, bt14;
    TextView tvResult;
    ImageView ivImageFragment;

    public BlankFragment() {
    }

    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvResult=view.findViewById(R.id.tvResult);
        ivImageFragment=view.findViewById(R.id.ivImageFragment);

        bt11 = view.findViewById(R.id.bt11);
        bt12 = view.findViewById(R.id.bt12);
        bt14 = view.findViewById(R.id.bt14);

        bt11.setOnClickListener(this);
        bt12.setOnClickListener(this);
        bt14.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        tvResult.setText("Fragment");
        Intent intent;
        switch (v.getId()){
            case R.id.bt11:
                //Fragment跳转不传值
                //不回传
//                ActTools.startActivity(this,SecondActivity.class);


                //回传
                ActTools.get(this).startForResult(SecondActivity.class, new ResultCallback() {
                    @Override
                    public void onActivityResult(int resultCode, Intent data) {
                        if(data!=null){
                            tvResult.setText("Fragment回传值:"+data.getStringExtra("param"));
                        }
                    }
                });
                break;
            case R.id.bt12:
                //Fragment跳转intent传值
                intent=new Intent(getActivity(),SecondActivity.class);
                intent.putExtra("set","intent传值");
                //不回传
//                ActTools.startActivity(this,SecondActivity.class,intent);


                //回传
                ActTools.get(this).startForResult(intent,new ResultCallback() {
                    @Override
                    public void onActivityResult(int resultCode, Intent data) {
                        if(data!=null){
                            tvResult.setText("Fragment回传值:"+data.getStringExtra("param"));
                        }
                    }
                });
                break;
            case R.id.bt14:
                Pair pair=new Pair(ivImageFragment,"birdImg");
                //Fragment跳转转场动画
                intent=new Intent("转场动画");
                intent.setClass(getActivity(),SecondActivity.class);
                //不回传
//                ActTools.startActivity(this,SecondActivity.class,pair);


                //回传
                ActTools.get(this).startForResult(intent, new ResultCallback() {
                    @Override
                    public void onActivityResult(int resultCode, Intent data) {
                        if(data!=null){
                            tvResult.setText("Fragment回传值:"+data.getStringExtra("param"));
                        }
                    }
                },pair);
                break;
        }
    }
}
