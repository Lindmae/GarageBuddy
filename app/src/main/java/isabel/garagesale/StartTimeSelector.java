package isabel.garagesale;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.*;
import android.widget.TimePicker;

import java.sql.Time;

import static isabel.garagesale.R.id.datePicker;
import static isabel.garagesale.R.id.timePicker;


public class StartTimeSelector extends AppCompatActivity {

    String hour;
    String minute;
    TimePicker timePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_time_selector);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new StartTimeSelector.MyClass() {

            @Override
            public void onClick(View v) {
                goToSecondActivity();

            }

        });
    }

    private void goToSecondActivity() {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData1");
        //code to modify the SellData goes here

        hour = String.valueOf(timePicker.getHour());
        minute = String.valueOf(timePicker.getMinute());

        sellData.setStartTime(hour+":"+minute);

        Intent intent = new Intent(this, EndTimeSelector.class);

        intent.putExtra("globalData2",sellData);
        startActivityForResult(intent,3);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {

                SellData sellDataV2 = (SellData)data.getSerializableExtra("globalData3");
            }
        }
    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
