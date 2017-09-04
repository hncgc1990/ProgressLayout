package com.nguyenhoanglam.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.btn_linear)
    Button btnLinear;
    @BindView(R.id.btn_relative)
    Button btnRelative;
    @BindView(R.id.btn_frame)
    Button btnFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnLinear.setOnClickListener(this);
        btnRelative.setOnClickListener(this);
        btnFrame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.btn_linear:
                intent=new Intent(this,LinearLayoutActivity.class);
                break;
            case R.id.btn_relative:
                intent=new Intent(this,RelativeLayoutActivity.class);
                break;
            case R.id.btn_frame:
                intent=new Intent(this,FrameLayoutActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
