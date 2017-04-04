package isabel.garagesale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.SellButton);
        button.setOnClickListener(new MyClass() {

            @Override
            public void onClick(View v) {
                goToSecondActivity();

            }

        });

        Button fbutton = (Button) findViewById(R.id.FindButton);
        fbutton.setOnClickListener(new MyClass() {

            @Override
            public void onClick(View v) {
                goToThirdActivity();

            }

        });
    }

    private void goToSecondActivity() {
        SellData sellData = new SellData();

        Intent intent = new Intent(this, SellDirectionsScreen.class);
        intent.putExtra("globalData",sellData);
        startActivityForResult(intent,1);

        //code to send data to sql database

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                SellData sellData = (SellData)data.getSerializableExtra("globalData1");
            }
        }
    }

    private void goToThirdActivity() {

        Intent intent = new Intent(this, MapsActivity.class);

        startActivity(intent);

    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

}
