package com.hf_sekerci.win8.api;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hf_sekerci.win8.api.Model.Explore;
import com.hf_sekerci.win8.api.Model.Model;
import com.hf_sekerci.win8.api.Model.Venue;
import com.yayandroid.locationmanager.LocationManager;
import com.yayandroid.locationmanager.configuration.Configurations;
import com.yayandroid.locationmanager.configuration.LocationConfiguration;
import com.yayandroid.locationmanager.constants.FailType;
import com.yayandroid.locationmanager.constants.ProcessType;
import com.yayandroid.locationmanager.listener.LocationListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static com.hf_sekerci.win8.api.R.id.listview;

public class MainActivity extends AppCompatActivity implements LocationListener {


    private Intent googleMapIntent;
    private Intent chooser;
    private LocationListener locationListener;
    private LocationManager locationManager;

    protected com.yayandroid.locationmanager.LocationManager getLocationManager() {
        return locationManager;
    }

    public TextView etGeolocation, etQuery;
    Button btnSearch;
    ListView listView;


    String Client_ID = "IIX3OZA3QEEE5X02SY100MVVPWCTIQF0KN5S0JHM33ZGKQLZ";
    String Client_Secret = "JKZ4RBV1MU0ZLWNG2SHYX4EFUKAU03TVJVYQGVFDU0CK3YZA";
    String geoLocation;
    String apiVersion = "20170707";
    String query = " ";
    String radius = "20000";


    List<Venue> item_list = new ArrayList<Venue>();


    protected void getLocation() {
        if (locationManager != null) {
            locationManager.get();
        } else {
            throw new IllegalStateException("locationManager is null. "
                    + "Make sure you call super.initialize before attempting to getLocation");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIds();

        btnSearch = (Button) findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//				ExploreAsyncTask exploreAsyncTask = new ExploreAsyncTask();
//				exploreAsyncTask.execute();

                FourSquareService fourSquareService = FourSquareService.retrofit.create(FourSquareService.class);
                final Call<Model> call = fourSquareService.requestExplore(Client_ID, Client_Secret, apiVersion, geoLocation);
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {

                        item_list = response.body().getResponse().getVenues();

                        geoLocation ="Buradasınız: "+ response.body().getResponse().getVenues().get(0).getName();
                        query = response.body().getResponse().getVenues().get(0).getLocation()
                                .getAddress()+"\n"+response.body().getResponse().getVenues()
                                .get(0).getLocation().getCity();

                        etQuery.setText(query);
                        etGeolocation.setText(geoLocation);
                        ExploreListAdapter exploreListAdapter = new ExploreListAdapter(getApplicationContext(), R.layout.item_list, item_list);
                        listView.setAdapter(exploreListAdapter);

                    }


                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Lütfen Mobil Veri'yi açınız.", Toast.LENGTH_SHORT).show();
                    }

                });

                //setContentView(R.layout.item_list);
                // Holding data

            }
        });



        locationManager = new LocationManager.Builder(getApplicationContext())

                .configuration(getLocationConfiguration())
                .activity(this)
                .notify((LocationListener) this)
                .build();
        getLocation();


        //6.0 and above permissions
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                requestPermissions(new String[]{
//                        Manifest.permission.ACCESS_FINE_LOCATION
//                }, 10);
//            }
//        }


        //Android location methods

        //Location
        /*
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                geoLocation = (location.getLatitude() + "," + location.getLongitude()).toString();
                Log.i("onLocationChanged", geoLocation);
                etGeolocation.setText(geoLocation);

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {
                Toast.makeText(getApplicationContext(), "Konum belirleniyor.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderDisabled(String s) {

                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 0, locationListener);

*/

        //Google Maps Intent
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                googleMapIntent = new Intent(Intent.ACTION_VIEW);
                chooser = Intent.createChooser(googleMapIntent, "Choose A Map App");
//
                Log.i("maps", "https://www.google.com/maps/search/?api=1&query=" +
                        item_list.get(position).getLocation().getLat() + "," +
                        item_list.get(position).getLocation().getLng());

                //set marker location
                googleMapIntent.setData(Uri.parse("http://maps.google.com/maps?daddr=" + item_list.get(position).getLocation().getLat() + "," + item_list.get(position).getLocation().getLng()));
                startActivity(googleMapIntent);

                //search location
                //https://www.google.com/maps/search/?api=1&query=

            }

        });


    }


    void findViewByIds() {
        etGeolocation = (TextView) findViewById(R.id.user_loc);
        etQuery = (TextView) findViewById(R.id.s_burger);
        btnSearch = (Button) findViewById(R.id.btn_search);
        listView = (ListView) findViewById(listview);

    }


    @Override
    public void onDestroy() {

        locationManager.onDestroy();
        super.onDestroy();
    }

    public LocationConfiguration getLocationConfiguration() {
        return Configurations.defaultConfiguration("Gimme the permission!", "Would you mind to turn GPS on?");
    }

    @Override
    public void onLocationChanged(Location location) {

        geoLocation = (location.getLatitude() + "," + location.getLongitude()).toString();
        Log.i("onLocationChanged", geoLocation);
        etGeolocation.setText("Konumunuz alınmıştır.Etrafınızdaki yerleri aratabilirsiniz.\nKonumunuz: "+geoLocation);
    }

    @Override
    public void onLocationFailed(@FailType int failType) {
        switch (failType) {
            case FailType.TIMEOUT: {
                etGeolocation.setText("Couldn't get location, and timeout! Please try again later.");
                System.exit(3);
                break;
            }
            case FailType.PERMISSION_DENIED: {
                etGeolocation.setText("Couldn't get location, because user didn't give permission!");
                break;
            }
            case FailType.NETWORK_NOT_AVAILABLE: {
                etGeolocation.setText("Couldn't get location, because network is not accessible!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_NOT_AVAILABLE: {
                etGeolocation.setText("Couldn't get location, because Google Play Services not available!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_CONNECTION_FAIL: {
                etGeolocation.setText("Couldn't get location, because Google Play Services connection failed!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_SETTINGS_DIALOG: {
                etGeolocation.setText("Couldn't display settingsApi dialog!");
                break;
            }
            case FailType.GOOGLE_PLAY_SERVICES_SETTINGS_DENIED: {
                etGeolocation.setText("Couldn't get location, because user didn't activate providers via settingsApi!");
                break;
            }
            case FailType.VIEW_DETACHED: {
                etGeolocation.setText("Couldn't get location, because in the process view was detached!");
                break;
            }
            case FailType.VIEW_NOT_REQUIRED_TYPE: {
                etGeolocation.setText("Couldn't get location, " + "because view wasn't sufficient enough to fulfill given configuration!");
                break;
            }
            case FailType.UNKNOWN: {
                etGeolocation.setText("Ops! Something went wrong!");
                break;
            }
        }
    }

    @Override
    public void onPermissionGranted(boolean alreadyHadPermission) {

    }

    @Override
    public void onProcessTypeChanged(@ProcessType int processType) {
        switch (processType) {
            case ProcessType.GETTING_LOCATION_FROM_GOOGLE_PLAY_SERVICES: {
                etGeolocation.setText("Getting Location from Google Play Services...");
                break;
            }
            case ProcessType.GETTING_LOCATION_FROM_GPS_PROVIDER: {
                etGeolocation.setText("Getting Location from GPS...");
                break;
            }
            case ProcessType.GETTING_LOCATION_FROM_NETWORK_PROVIDER: {
                etGeolocation.setText("Getting Location from Network...");
                break;
            }
            case ProcessType.ASKING_PERMISSIONS:
            case ProcessType.GETTING_LOCATION_FROM_CUSTOM_PROVIDER:
                // Ignored
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (getLocationManager().isWaitingForLocation() && !getLocationManager().isAnyDialogShowing()) {
        }
        locationManager.onResume();
    }

    @Override
    public void onPause() {
        locationManager.onPause();
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        locationManager.onActivityResult(requestCode, resultCode, data);
    }

  /*  @Override
    public void onPermissionGranted(boolean alreadyHadPermission) {
        // override if needed
    }*/

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // override if needed
    }

    @Override
    public void onProviderEnabled(String provider) {
        // override if needed
    }

    @Override
    public void onProviderDisabled(String provider) {
        // override if needed
    }

    //ASyncTask, get list
    public class ExploreAsyncTask extends AsyncTask<Object, Object, List<Venue>> {

        public ExploreAsyncTask() {
            super();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected List<Venue> doInBackground(Object... voids) {

            FourSquareService fourSquareService = FourSquareService.retrofit.create(FourSquareService.class);
            final Call<Model> call = fourSquareService.requestExplore(Client_ID, Client_Secret, apiVersion, geoLocation);

            try {
                Model explore = call.execute().body();
                item_list = explore.getResponse().getVenues();

            } catch (IOException e) {
                e.printStackTrace();

            }

            return item_list;
        }

        @Override
        protected void onPostExecute(List<Venue> item_s) {
            super.onPostExecute(item_s);
            ExploreListAdapter exploreListAdapter = new ExploreListAdapter(getApplicationContext(), R.layout.item_list,  item_s);
            listView.setAdapter(exploreListAdapter);

        }

    }


}
