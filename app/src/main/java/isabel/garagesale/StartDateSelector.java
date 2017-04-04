package isabel.garagesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class StartDateSelector extends AppCompatActivity {

    DatePicker datePicker;
    String day;
    String month;
    String year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_date_selector);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        Button button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new StartDateSelector.MyClass() {

            @Override
            public void onClick(View v) {
                goToSecondActivity();

            }

        });
    }

    private void goToSecondActivity() {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData3");
        //code to modify the SellData goes here

        day = String.valueOf(datePicker.getDayOfMonth());
        month = String.valueOf(datePicker.getMonth()+1);
        year = String.valueOf(datePicker.getYear());

        sellData.setStartDay(year+"/"+month+"/"+day);


        Intent intent = new Intent(this, EndDateSelector.class);

        intent.putExtra("globalData4",sellData);
        startActivityForResult(intent,2);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                SellData sellData = (SellData)data.getSerializableExtra("globalData5");
            }
        }
    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
