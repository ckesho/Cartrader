package com.keshogroup.cartrader.controller;

/*
 * Chris Kesho
 * 7/15/15
 * Cartrader - Autotrader mock app ver 1
 * keshoLLC-info@yahoo.com
 * 
 */

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.keshogroup.cartrader.R;
import com.keshogroup.cartrader.model.CartraderStore;


public class CartraderActivity extends Activity {

    private static final String TAG = "CartraderActivity";

    ArrayAdapter<String> mStringAdapter2;
    Button mWeatherButton, mSignUpButton, mCameraButton, mSearchButton, mDataButton, mButtonBack2, mButtonBack;
    ListView mListView1, mListView2;
    Intent mCartraderServiceIntent;
    Intent mCameraIntent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
    IntentFilter mIntentFilter;
    RelativeLayout mMain, mSearchList, mRestList;
    String mCarNames[];
    String array[] = new String[400];
    TextView mTextView2, mTextView3, mTextView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartrader);

        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView4 = (TextView) findViewById(R.id.textView4);
        mListView1 = (ListView) findViewById(R.id.listView1);
        mListView2 = (ListView) findViewById(R.id.listView2);

        mWeatherButton = (Button) findViewById(R.id.weatherButton);
        mSignUpButton = (Button) findViewById(R.id.signUpButton);
        mCameraButton = (Button) findViewById(R.id.cameraButton);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mDataButton = (Button) findViewById(R.id.dataButton);

        mButtonBack = (Button) findViewById(R.id.backButton);
        mButtonBack2 = (Button) findViewById(R.id.backButton2);
        mMain = (RelativeLayout) findViewById(R.id.main);
        mSearchList = (RelativeLayout) findViewById(R.id.searchlist);
        mRestList = (RelativeLayout) findViewById(R.id.restlist);

        mIntentFilter = new IntentFilter("actionpack");
        this.registerReceiver(mBroadcastReceiver, mIntentFilter);
        mCartraderServiceIntent = new Intent(this, CartraderService.class);

        array[0] = "temp";
        for (int c = 0; c < 400; c++) {
            array[c] = "no data";
        }

        mCarNames = CartraderStore.getCarsName();

        ArrayAdapter<String> aadapter = new ArrayAdapter<String>(this, R.layout.lists, mCarNames);
        mStringAdapter2 = new ArrayAdapter<String>(this, R.layout.list2, array);

        mListView1.setAdapter(aadapter);
        mListView2.setAdapter(mStringAdapter2);

        mWeatherButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startService(mCartraderServiceIntent);
            }
        });


        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopService(mCartraderServiceIntent);

                Notification notification;
                Builder notificationBuilder = new Builder(CartraderActivity.this);
                String contentTitle = "New Car Alert";
                String contentText = "Visit autotrader.com";

                notificationBuilder.setTicker(contentTitle);
                notificationBuilder.setSmallIcon(com.keshogroup.cartrader.R.drawable.autotraderbw);
                notificationBuilder.setContentTitle(contentTitle);
                notificationBuilder.setContentText(contentText);
                notificationBuilder.setContentIntent(null);
                notificationBuilder.setAutoCancel(true);
                notification = notificationBuilder.build();

                NotificationManager notificationManager;
                notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(28, notification);

                mSignUpButton.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP, 2);
            }
        });


        mCameraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(mCameraIntent);
            }
        });

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mSearchList.setVisibility(View.VISIBLE);
                mMain.setVisibility(View.GONE);

            }
        });

        mButtonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mSearchList.setVisibility(View.GONE);
                mMain.setVisibility(View.VISIBLE);

            }
        });

        mDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mRestList.setVisibility(View.VISIBLE);
                mMain.setVisibility(View.GONE);

            }
        });

        mButtonBack2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mRestList.setVisibility(View.GONE);
                mMain.setVisibility(View.VISIBLE);
            }
        });

    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getStringArrayExtra("com.keshogroup.cartrader.array") != null) {
                array = intent.getStringArrayExtra("com.keshogroup.cartrader.array");
                mStringAdapter2 = new ArrayAdapter<String>(CartraderActivity.this, R.layout.list2, array);
                mListView2.setAdapter(mStringAdapter2);
                Log.i("JSON", "updated array");
            }
        }
    };

}
