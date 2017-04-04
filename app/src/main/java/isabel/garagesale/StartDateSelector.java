package isabel.garagesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartDateSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_date_selector);
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

        Intent intent = new Intent(this, EndDateSelector.class);

        intent.putExtra("globalData4",sellData);
        startActivityForResult(intent,5);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 5) {
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
