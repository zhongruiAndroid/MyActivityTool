package com.test.activitytool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.activitytools.ActTools;
import com.github.activitytools.ResultCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt1,bt2,bt4;
    TextView tvResult;
    ImageView ivImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult=findViewById(R.id.tvResult);
        ivImage=findViewById(R.id.ivImage);

        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        bt4=findViewById(R.id.bt4);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        tvResult.setText("Activity");
        Intent intent;
        switch (v.getId()){
            case R.id.bt1:
                //Activity跳转不传值
                //不回传
//                ActTools.startActivity(this,SecondActivity.class);


                //回传
                ActTools.get(this).startForResult(SecondActivity.class, new ResultCallback() {
                    @Override
                    public void onActivityResult(int resultCode, Intent data) {
                        if(resultCode==RESULT_OK){
                            tvResult.setText("Activity回传值:"+data.getStringExtra("param"));
                        }
                    }
                });
            break;
            case R.id.bt2:
                //Activity跳转intent传值
                intent=new Intent();
                intent.putExtra("set","intent传值");
                //不回传
//                ActTools.startActivity(this,SecondActivity.class,intent);


                //回传
                ActTools.get(this).startForResult(intent,SecondActivity.class, new ResultCallback() {
                    @Override
                    public void onActivityResult(int resultCode, Intent data) {
                        if(resultCode==RESULT_OK){
                            tvResult.setText("Activity回传值:"+data.getStringExtra("param"));
                        }
                    }
                });
            break;
            case R.id.bt4:
                Pair pair=new Pair(ivImage,"birdImg");
                //Activity跳转转场动画
                intent=new Intent("转场动画");
                //不回传
//                ActTools.startActivity(this,SecondActivity.class,pair);


                //回传
                ActTools.get(this).startForResult(intent,SecondActivity.class, new ResultCallback() {
                    @Override
                    public void onActivityResult(int resultCode, Intent data) {
                        if(resultCode==RESULT_OK){
                            tvResult.setText("Activity回传值:"+data.getStringExtra("param"));
                        }
                    }
                },pair);
            break;
        }
    }
}
