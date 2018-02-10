package com.hf_sekerci.win8.api;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;


/**
 * Created by WIN8 on 1.8.2017.
 */

public class AndroidFourSquare extends ListActivity {
    ArrayList venuesList;

    //client id and secret
    final String CLIENT_ID = "IIX3OZA3QEEE5X02SY100MVVPWCTIQF0KN5S0JHM33ZGKQLZ";
    final String CLIENT_SECRET = "JKZ4RBV1MU0ZLWNG2SHYX4EFUKAU03TVJVYQGVFDU0CK3YZA";

    //lang & long
    final String latitude = "40.7463956";
    final String longtitude = "-73.9852992";

    ArrayAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // start the AsyncTask that makes the call for the venus search.
        new foursquare().execute();

    }

    private class foursquare extends AsyncTask<View, Void, String> {

        String temp;


        @Override
        protected String doInBackground(View... urls) {
            temp = makeCall("https://api.foursquare.com/v2/venues/search?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&v=20170707&ll=" + latitude + "," + longtitude + "&query=burger");
            Toast.makeText(getApplicationContext(), "çağrı yapıldı", Toast.LENGTH_SHORT).show();
            Log.e("---> ", temp);

            return "";
        }

        @Override
        protected void onPreExecute() {
            //start progress var
        }


        protected void onPostExecute(String result) {

            if (temp == null) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            } else {
                venuesList = (ArrayList) parseFoursquare(temp);
            }
        }

    }

    public static ArrayList parseFoursquare(String response) {
        ArrayList temp = new ArrayList();
        temp.add("a");
        return temp;
    }


    public static String makeCall(String url) {


        return url;
    }
}
