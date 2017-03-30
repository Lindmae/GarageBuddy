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

        Intent intent = new Intent(this, StartTimeSelector.class);

        startActivity(intent);

    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
    
}


    