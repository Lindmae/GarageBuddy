package isabel.garagesale;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FinalResult extends AppCompatActivity {
    ArrayList<String> Params;
    ArrayList<String> Categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);

        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData8");
        TextView textbox = (TextView) findViewById(R.id.textView9);

        //String p = sellData.getTheLocation();
        //String[] tokens = p.split(",");
        double lat = Double.parseDouble(sellData.getLatitude());
        double longi = Double.parseDouble(sellData.getLongitude());
        Geocoder geo = new Geocoder(this, Locale.getDefault());
        try
        {
            textbox.setText("\n");
            textbox.append("Date:\n       " + sellData.getStartDay() + " \n");
            textbox.append("Time:\n       " + sellData.getStartTime() + " - " + sellData.getEndTime() + "\n");
            List<Address> addr = geo.getFromLocation(lat,longi, 1);
            String addrr = addr.get(0).getAddressLine(0);
            String city = addr.get(0).getLocality();
            String state = addr.get(0).getAdminArea();
            String country = addr.get(0).getCountryName();
            String zipcode = addr.get(0).getPostalCode();
            textbox.append("Address: \n       " + addrr + " " + "\n");
            textbox.append("       "+city + " , " + zipcode + ",\n");
            textbox.append("       " + state + ", "+ country+"\n");
            textbox.append("Selected Categories:\n");
            //problem area
            ArrayList<String> t = sellData.getCategories();
            for(String s : t)
            {
                textbox.append("       " + t + "\n");
            }

            textbox.append("Description:\n");
            if(sellData.getDescription() == null)
            {
                textbox.append("N/A\n");
            }
            else
            {
                textbox.append(sellData.getDescription() + "\n");
            }


        }
        catch(IOException e)
        {
            e.printStackTrace();
            Log.w(" ","Cannot get Address!");
        }

        Button button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new FinalResult.MyClass() {

            @Override
            public void onClick(View v) {

                goToPreviousActivity();

            }

        });
    }

    private void goToPreviousActivity() {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData8");


        String method = "TestHTTP";
        Categories = sellData.getCategories();
        myTaskParams params = new myTaskParams(method,Params,Categories);
        params.setParams(sellData.getStartTime());
        params.setParams(sellData.getEndTime());
        params.setParams(sellData.getStartDay());

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(params);

        prevIntent.putExtra("globalData9", sellData);
        setResult(RESULT_OK, prevIntent);
        finish();

    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
