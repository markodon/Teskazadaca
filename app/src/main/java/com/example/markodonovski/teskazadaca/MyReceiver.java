package com.example.markodonovski.teskazadaca;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by markodonovski on 11/28/17.
 */

public class MyReceiver extends BroadcastReceiver {

    private static final String LOG_TAG = "NetworkChangeReceiver";
    private boolean isConnected = false;
    AlertDialog.Builder builder;
    String connected;
    String notconnected;

    @Override
    public void onReceive(final Context context, Intent intent) {
        Button btn = (Button) ((Main4Activity) context).findViewById(R.id.check2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("ARE YOU CONNECTED");
                builder.setMessage(isNetworkAvailable(context));
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        TextView txtView = (TextView) ((Main4Activity) context).findViewById(R.id.internetcheck);
                        txtView.setText(isNetworkAvailable(context));
                    }


                });
                builder.create().show();
            }
        });

    }

    public String isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo network = connectivity.getActiveNetworkInfo();
            if (network != null) {
                if (network.getState() == NetworkInfo.State.CONNECTED) {

                    if (!isConnected) {
                        isConnected = true;


                    }

                    return "You are connected";
                }
            }


        }

        isConnected = false;
        return "You are not connected";


    }
}
