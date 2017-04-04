package isabel.garagesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UnderConstruction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_construction);
        Button button = (Button) findViewById(R.id.returnButton);
        button.setOnClickListener(new UnderConstruction.MyClass() {

            @Override
            public void onClick(View v) {

                goToPreviousActivity();

            }

        });
    }

    private void goToPreviousActivity() {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData8");

        prevIntent.putExtra("globalData9v2", sellData);
        setResult(RESULT_CANCELED, prevIntent);
        finish();

    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
