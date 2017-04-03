package isabel.garagesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinalResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);

        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("GlobalData7");
        //code to modify/access the SellData goes here


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
        SellData sellData = (SellData)prevIntent.getSerializableExtra("GlobalData7");

        prevIntent.putExtra("GlobalData8", sellData);
        setResult(RESULT_OK, prevIntent);
        finish();

    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
