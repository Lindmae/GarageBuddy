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

        Intent intent = new Intent(this, SellDirectionsScreen.class);

        startActivity(intent);

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
