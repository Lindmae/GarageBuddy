package isabel.garagesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Description extends AppCompatActivity {

    EditText descBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        descBox = (EditText) findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new Description.MyClass() {

            @Override
            public void onClick(View v) {
                goToSecondActivity();

            }

        });
    }

    private void goToSecondActivity() {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData6");
        //code to modify the SellData goes here

        EditText ourText = (EditText)findViewById(R.id.editText2);
        sellData.setDescription(ourText.getText().toString());

        Intent intent = new Intent(this, GaraageSaleLocationSelector.class);

        intent.putExtra("globalData7",sellData);
        startActivityForResult(intent,8);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 8) {
            if (resultCode == RESULT_OK) {

                SellData sellData = (SellData)data.getSerializableExtra("globalData8");
            }
        }
    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
