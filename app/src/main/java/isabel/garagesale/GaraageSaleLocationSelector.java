package isabel.garagesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class GaraageSaleLocationSelector extends AppCompatActivity {
    CheckBox myLocation;
    CheckBox selectLocation;
    CheckBox typeLocation;
    SellData temp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garaage_sale_location_selector);
        Button button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(new GaraageSaleLocationSelector.MyClass() {

            @Override
            public void onClick(View v) {
                goToSecondActivity();

            }

        });

        myLocation =(CheckBox) findViewById(R.id.MyLocation);
        selectLocation =(CheckBox) findViewById(R.id.SelectLocation);
        typeLocation =(CheckBox) findViewById(R.id.TypeLocation);

        myLocation.setOnClickListener(new GaraageSaleLocationSelector.MyClass(){
            @Override
            public void onClick(View v) {
                if(myLocation.isChecked())
                {
                    selectLocation.setChecked(false);
                    typeLocation.setChecked(false);
                    goToSeeMylocation();
                }

            }
        });

        selectLocation.setOnClickListener(new GaraageSaleLocationSelector.MyClass(){
            @Override
            public void onClick(View v) {
                if(selectLocation.isChecked())
                {
                    myLocation.setChecked(false);
                    typeLocation.setChecked(false);
                    goToSelectlocation();
                }

            }
        });

        typeLocation.setOnClickListener(new GaraageSaleLocationSelector.MyClass(){
            @Override
            public void onClick(View v) {
                if(typeLocation.isChecked())
                {
                    selectLocation.setChecked(false);
                    myLocation.setChecked(false);
                    goToTypelocation();
                }

            }
        });
    }

    private void goToSecondActivity() {
        SellData sellData;


        if (temp == null)
        {
            Toast.makeText(this,"Need to select a location",Toast.LENGTH_LONG).show();
            return;
        }
        sellData = temp;

        Intent intent = new Intent(this, FinalResult.class);

        intent.putExtra("globalData8",sellData);
        startActivityForResult(intent,9);
        setResult(RESULT_OK, intent);
        finish();

    }

    private void goToSeeMylocation()
    {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData7");
        Intent intent = new Intent(this, ViewCurrentLocation.class);
        intent.putExtra("globalData8v1",sellData);
        startActivityForResult(intent,91);
        //setResult(RESULT_OK, intent);
    }

    private void goToSelectlocation()
    {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData7");
        Intent intent = new Intent(this, UnderConstruction.class);
        intent.putExtra("globalData8v2",sellData);
        startActivityForResult(intent,92);
        //setResult(RESULT_OK, intent);
    }

    private void goToTypelocation()
    {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData7");
        Intent intent = new Intent(this, UnderConstruction.class);
        intent.putExtra("globalData8v3",sellData);
        startActivityForResult(intent,93);
        //setResult(RESULT_OK, intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 9) {
            if (resultCode == RESULT_OK) {

                SellData sellData = (SellData)data.getSerializableExtra("globalData9");
            }
        }
        if (requestCode == 91) {
            if (resultCode == RESULT_OK) {

                temp = (SellData)data.getSerializableExtra("globalData9v1");
            }
        }
        if (requestCode == 92) {
            if (resultCode == RESULT_OK) {

                temp = (SellData)data.getSerializableExtra("globalData9v2");
            }
        }
        if (requestCode == 93) {
            if (resultCode == RESULT_OK) {

                temp = (SellData)data.getSerializableExtra("globalData9v2");
            }
        }
    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
