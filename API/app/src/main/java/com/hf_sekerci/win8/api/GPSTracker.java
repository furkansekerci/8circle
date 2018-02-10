package com.hf_sekerci.win8.api;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by WIN8 on 14.8.2017.
 */

public class GPSTracker extends Service implements LocationListener{

    static public  TextView textView;

    @Nullable
    @Override
    public IBinder onBind(Intent ıntent) {
        return null;
    }

        @Override
        public void onLocationChanged (Location location){
            textView.setText("Bulunduğunuz konum bilgileri : \n" + "Latitude = " + location.getLatitude() + "\nLongitude = " + location.getLongitude());
            Log.i("onLocationChanged", textView.getText().toString());

        }

        @Override
        public void onStatusChanged (String s,int i, Bundle bundle){

        }

        @Override
        public void onProviderEnabled (String s){

        }

        @Override
        public void onProviderDisabled (String s){
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    }

