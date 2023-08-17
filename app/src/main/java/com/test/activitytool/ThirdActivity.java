package com.test.activitytool;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    TextView tvParam;
    Button btParam;
    private String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();


        tvParam = findViewById(R.id.tvParam);
        btParam = findViewById(R.id.btParam);

        number = new Random().nextInt(100)+"";


        btParam.setText("点击finish回传值:"+number);
        btParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        if(intent.getAction()!=null){
            tvParam.setText("Fragment跳转"+intent.getAction());
        }else if(intent.getStringExtra("set")!=null){
            tvParam.setText("Fragment跳转"+intent.getStringExtra("set"));
        }else{
            tvParam.setText("Fragment跳转不传值");
        }


    }

    public void back( ) {
        Intent intent = new Intent();
        intent.putExtra("param",number);
        setResult(RESULT_OK,intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }else{
            finish();
        }
    }

}
