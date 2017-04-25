package isabel.garagesale;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArraySet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.location.LocationManager.GPS_PROVIDER;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap = null;
    private  int LOCATION_PERMISSION_CODE = 6;
    private ArrayList<SellData> sellTracker;
    private ArrayList<Marker> markTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        sellTracker = null;
        markTracker = null;
        if(weHaveFineLocationPermission())
        {
            Toast.makeText(MapsActivity.this, "We Have Fine Location Permission",Toast.LENGTH_LONG).show();
            //mMap.setMyLocationEnabled(true);
        }
        else
        {
            requestFineLocationPermission();
        }

        Button button = (Button) findViewById(R.id.filterButton);
        button.setOnClickListener(new MapsActivity.MyClass() {

            @Override
            public void onClick(View v) {
                goToSecondActivity();

            }

        });

        ImageButton button2 = (ImageButton) findViewById(R.id.listviewButton);
        button2.setOnClickListener(new MapsActivity.MyClass() {

            @Override
            public void onClick(View v) {
                goToListActivity();

            }

        });
    }

    private boolean weHaveFineLocationPermission()
    {
        int LocationResult = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (LocationResult == PackageManager.PERMISSION_GRANTED) {
            //mMap.setMyLocationEnabled(true);
            return true;
        }

        return false;

    }

    private void requestFineLocationPermission()
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
        {

        }
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if(requestCode == LOCATION_PERMISSION_CODE){

            //If permission is granted
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                //Displaying a toast
                Toast.makeText(this,"Permission granted now you can use the map feature",Toast.LENGTH_LONG).show();
                //mMap.setMyLocationEnabled(true);
            }
            else{
                //Displaying another toast if permission is not granted
                Toast.makeText(this,"Oops you just denied the permission",Toast.LENGTH_LONG).show();
            }
        }
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    private void goToSecondActivity() {

        Intent intent = new Intent(this, SearchFilter.class);

        startActivityForResult(intent,1);



        //clearAllMarkers();
        //addMarkers();

    }

    private void goToListActivity() {

        Intent intent = new Intent(this, listView.class);

        startActivityForResult(intent,2);

    }

    private class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                // info from search
                String[] DataToPassBack = data.getStringArrayExtra("keyName");
            }
        }
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {

                // info from search
                String[] DataToPassBack = data.getStringArrayExtra("keyName");
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        enableMapSettings();
        centerToMyLocation();
        //addMarkers();
        //hello
    }

    private void addMarkers()
    {
        for(SellData s : sellTracker)
        {
            String p = s.getTheLocation();
            String[] tokens = p.split(",");
            double lat = Double.parseDouble(tokens[0]);
            double longi = Double.parseDouble(tokens[1]);
            LatLng place = new LatLng(lat,longi);

            markTracker.add( mMap.addMarker(new MarkerOptions().position(place).title("GB")) );
            int index = markTracker.size();
            markTracker.get(index).showInfoWindow();

        }
    }

    private void clearAllMarkers()
    {
        for(Marker m : markTracker)
        {
            m.remove();
            m = null;
        }
    }

    private void enableMapSettings()
    {
        int LocationResult = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (LocationResult == PackageManager.PERMISSION_GRANTED) {

            if(mMap != null)
            {
                mMap.setMyLocationEnabled(true);

                //UiSettings mMapSettings = mMap.getUiSettings();
                //mMapSettings.setCompassEnabled(true);
                //mMapSettings.setMyLocationButtonEnabled(true);
            }
        }

    }

    private  void centerToMyLocation()
    {
        int LocationResult = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (LocationResult == PackageManager.PERMISSION_GRANTED) {

            if(mMap != null)
            {
                LocationManager myManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
                Location myLocation = new Location(myManager.getLastKnownLocation(GPS_PROVIDER));
                double lat = myLocation.getLatitude();
                double longi = myLocation.getLongitude();
                LatLng current = new LatLng(lat, longi);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current,16));
            }
        }
    }
}
