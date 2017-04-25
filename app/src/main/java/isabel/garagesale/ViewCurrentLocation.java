package isabel.garagesale;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.location.LocationManager.GPS_PROVIDER;

public class ViewCurrentLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private  int LOCATION_PERMISSION_CODE = 6;
    private  SellData sellData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_current_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(weHaveFineLocationPermission())
        {
            Toast.makeText(ViewCurrentLocation.this, "We Have Fine Location Permission",Toast.LENGTH_LONG).show();
            //mMap.setMyLocationEnabled(true);
        }
        else
        {
            requestFineLocationPermission();
        }
        Button button = (Button) findViewById(R.id.finishButton);
        button.setOnClickListener(new ViewCurrentLocation.MyClass() {

            @Override
            public void onClick(View v) {
                goToPreviousActivity();

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
                Intent prevIntent = getIntent();
                SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData8v1");
                sellData.setTheLocation(lat + ", " + longi);
                //sellData.setTheLocation(lat + ", " + longi);
                prevIntent.putExtra("globalData9v1", sellData);

                LatLng current = new LatLng(lat, longi);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current,16));
            }
        }
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

    private void goToPreviousActivity() {
        //Intent prevIntent = getIntent();
        //SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData8v1");
        //Location myLocation = new Location("GarageBuddy");
        //double lat = myLocation.getLatitude();
        //double longi = myLocation.getLongitude();
        //sellData.setTheLocation(lat + ", " + longi);
        //prevIntent.putExtra("globalData9v1", sellData);
        setResult(RESULT_OK, getIntent());
        finish();

    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //mMap.setMyLocationEnabled(true);
        enableMapSettings();
        centerToMyLocation();
    }
}
