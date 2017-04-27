package isabel.garagesale;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Date;

public class EndTimeSelector extends AppCompatActivity {

    String hour;
    String minute;
    TimePicker timePicker;
    CharSequence message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_time_selector);
        timePicker = (TimePicker) findViewById(R.id.timePicker2);
        Button button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new EndTimeSelector.MyClass() {

            @Override
            public void onClick(View v) {

                if(checkValid() == true)
                    goToSecondActivity();
                else {
                    Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout), message, Snackbar.LENGTH_SHORT);
                    mySnackbar.show();

                }

            }

        });
    }

    private boolean checkValid(){

        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData2");
        String p = sellData.getStartTime();
        String[] tokens = p.split(":");
        int startHour = Integer.parseInt(tokens[0]);
        int startMinute = Integer.parseInt(tokens[1]);




        //String time = sellData.getStartTime();

        //wrong hours

        if (timePicker.getHour() - startHour < 0) {

            message = "Invalid hour!";
            return false;
        }
        //current hour but minutes are wrong

        if ((timePicker.getMinute() < startMinute + 30 ) && (timePicker.getHour() == startHour)  ){

            message = "Invalid minute!";
            return false;
        }

        return true;

    }

    private void goToSecondActivity() {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData2");
        //code to modify the SellData goes here

        hour = String.valueOf(timePicker.getHour());
        minute = String.valueOf(timePicker.getMinute());

        sellData.setEndTime(hour+":"+minute);

        Intent intent = new Intent(this, StartDateSelector.class);

        intent.putExtra("globalData3",sellData);
        startActivityForResult(intent,4);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 4) {
            if (resultCode == RESULT_OK) {

                SellData sellData = (SellData)data.getSerializableExtra("globalData4");
            }
        }
    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
