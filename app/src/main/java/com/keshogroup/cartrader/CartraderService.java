package com.keshogroup.cartrader;


import android.app.IntentService;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class CartraderService extends IntentService {

    public static final String TAG = "CartraderService";

    /**
     * A constructor is required, and must call the super IntentService(String)
     * constructor with a name for the worker thread.
     */
    public CartraderService() {
        super(TAG);
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        JSONArray jarray = null;
        JSONArray jarray2 = null;
        JSONObject jobj = null;
        JSONTokener jtoken = null;
        String array[] = new String[400];
        String gotaction;
        String gotaction2;
        String gotaction3, sresult;
        gotaction = intent.getAction();
        gotaction2 = intent.getAction();
        gotaction3 = intent.getAction();
        int code = 0;
        int length = 0;
        //check newtowrk connection
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//in case some network stuff is done
        @SuppressWarnings("deprecation")
        boolean networkready1 = cm.getBackgroundDataSetting();
        boolean networkready2 = cm.getActiveNetworkInfo() != null;
        if (networkready1 == false || networkready2 == false) {
            return;
        } else {

            HttpURLConnection f;
            String smethod = CartraderClient.METHOD_GET;
            String query = "/q/30328";
            String format = ".json";
            String web = "http://api.wunderground.com/api";
            String please = "/852ddd19c6a16593";
            String feature = "/conditions";
            String surl = web + please + feature + query + format;
            //String surl="http://api.wunderground.com/api/852ddd19c6a16593/forecast/geolookup/conditions/q/CA/San_Francisco.json";//"http://api.wunderground.com/api/852ddd19c6a16593/features/settings/q/query.format";
            OutputStream os = null;
            BufferedReader br = null;
            InputStream is;
            try {
                //client to server send
                URL url = new URL(surl);
                f = (HttpURLConnection) url.openConnection();
                f.setRequestMethod(smethod);
                //Server to client returned info

                is = f.getInputStream();
                gotaction2 = f.getResponseMessage();
                code = f.getResponseCode();

                length = is.available();

                br = new BufferedReader(new InputStreamReader(is));
			  
			  /*
			   * invalid code
			   *
			  while (!br.ready()){
				wait(100);  
			  }
			  */

                gotaction = br.readLine();//toString();
                int cnt = 0;
                while (br.read() != -1) {
                    //This pulls every potential line inside the buffer.
                    //This addresses websites that send info line by line;
                    cnt++;
                    if (cnt == 51) {//51 is the line with temperature information
                        gotaction3 = br.readLine();
                        gotaction = gotaction + gotaction3;
                        cnt++;
                    }
                    gotaction = gotaction + br.readLine();

                }
                jtoken = new JSONTokener(gotaction);

                int cnt2 = 0;
                while (jtoken.more()) {
                    array[cnt2] = (String) jtoken.nextValue();
                    jtoken.nextString('"');//fastforward to next string value by moving to \"
                    jtoken.back();//back up one char so that \" can be properly consumed with "nextValue" call
                    cnt2++;
                }

                sresult = "results";
                intent.putExtra(sresult, gotaction);
                Log.i(TAG, "http sent, intent return");

            } catch (Exception ex) {
                Log.i(TAG, "error" + ex);
            }

        }

        createNotification(array, gotaction, gotaction2, gotaction3, code, length, networkready1, networkready2);

    }//end of on Handle

    private void createNotification(String[] array, String gotaction, String gotaction2, String gotaction3, int code, int length, boolean networkready1, boolean networkready2) {
        Notification notice;
        Builder noticebuilder = new Builder(this);
        String str = " " + networkready1 + networkready2 + gotaction3;
        CharSequence tickerText = str.subSequence(0, str.length());

        noticebuilder.setTicker(tickerText);
        noticebuilder.setSmallIcon(R.drawable.autotraderbw);
        noticebuilder.setContentTitle(tickerText);
        noticebuilder.setContentText(gotaction3);
        noticebuilder.setContentIntent(null); //no intent needed for test
        noticebuilder.setAutoCancel(true);
        notice = noticebuilder.build();

        NotificationManager nm;
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);//attach to the system service
        nm.notify(29, notice); //send out notice with notification manager


        Log.i(TAG, "code" + code + ", length= " + length + ", responsecode= " + gotaction2 + ", output" + gotaction);

        Intent returnintent = new Intent();
        returnintent.putExtra("com.keshogroup.cartrader.array", array);
        returnintent.setAction("actionpack");
        LocalBroadcastManager lbm = null;
        sendBroadcast(returnintent);
        Log.i(TAG, "Broadcast sent");
    }


}