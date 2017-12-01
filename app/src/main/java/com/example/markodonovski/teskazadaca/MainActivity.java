package com.example.markodonovski.teskazadaca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

   @BindView(R.id.bt1)
    Button kopce1;
   @BindView(R.id.guest)
    TextView gest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);




    }

    @OnClick(R.id.bt1)
    public void OnClick(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    @OnClick(R.id.guest)
    public void OnClick1(View view){
        User guest =new User(" ", " ", "Guest", ' ');
        Intent intent1 = new Intent(this,Main3Activity.class);
        intent1.putExtra("GUEST", guest);
        startActivity(intent1);

    }


}
