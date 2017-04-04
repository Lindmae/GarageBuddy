package isabel.garagesale;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SellDirectionsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_directions_screen);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new SellDirectionsScreen.MyClass() {
            public void onClick(View v) {goToSecondActivity();}
        });

    }

    private void goToSecondActivity() {
        Intent prevIntent = getIntent();
        SellData sellData1 = (SellData)prevIntent.getSerializableExtra("GlobalData");
        //code to modify the SellData goes here

        Intent intent = new Intent(this, StartTimeSelector.class);
        intent.putExtra("globalData1",sellData1);
        startActivityForResult(intent,2);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {

                SellData sellDataV1 = (SellData)data.getSerializableExtra("globalData2");
            }
        }
    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
    
}




    