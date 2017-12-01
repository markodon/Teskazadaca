package com.example.markodonovski.teskazadaca;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main4Activity extends AppCompatActivity {

    @BindView(R.id.check2)
    Button proveri;
    @BindView(R.id.back)
    Button nazad;
    @BindView(R.id.internetcheck)
    TextView internet;
    String net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);
        MyReceiver reciever = new MyReceiver();
        registerReceiver(reciever, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


    }

    @OnClick(R.id.back)
    public void Back (View view) {
        Intent intent = new Intent();
        net = internet.getText().toString();
        intent.putExtra("NET", net);
        setResult(RESULT_OK, intent);
        finish();
    }

}

