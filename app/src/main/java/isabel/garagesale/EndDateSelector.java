package isabel.garagesale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EndDateSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_date_selector);
        Button button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new EndDateSelector.MyClass() {

            @Override
            public void onClick(View v) {
                goToSecondActivity();

            }

        });
    }

    private void goToSecondActivity() {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData4");
        //code to modify the SellData goes here

        Intent intent = new Intent(this, Categories.class);

        intent.putExtra("globalData5",sellData);
        startActivityForResult(intent,6);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 6) {
            if (resultCode == RESULT_OK) {

                SellData sellData = (SellData)data.getSerializableExtra("globalData6");
            }
        }
    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
