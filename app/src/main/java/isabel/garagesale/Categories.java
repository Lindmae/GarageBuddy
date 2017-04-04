package isabel.garagesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Categories extends AppCompatActivity {

    CheckBox toysCheckBox;
    CheckBox babyCheckBox;
    CheckBox kidsCheckBox;
    CheckBox youngACheckBox;
    CheckBox adultCheckBox;
    CheckBox electronicsCheckBox;
    CheckBox sportgoodsCheckBox;
    CheckBox toolsCheckBox;
    CheckBox appliancesCheckBox;
    CheckBox entCheckBox;
    CheckBox videogamesCheckBox;
    CheckBox miscCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        toysCheckBox = (CheckBox) findViewById(R.id.toysCheckBox);
        babyCheckBox = (CheckBox) findViewById(R.id.babyCheckBox);
        kidsCheckBox = (CheckBox) findViewById(R.id.kidsCheckBox);
        youngACheckBox = (CheckBox) findViewById(R.id.youngACheckBox);
        adultCheckBox = (CheckBox) findViewById(R.id.adultCheckBox);
        electronicsCheckBox = (CheckBox) findViewById(R.id.electronicsCheckBox);
        sportgoodsCheckBox = (CheckBox) findViewById(R.id.sportgoodsCheckBox);
        toolsCheckBox = (CheckBox) findViewById(R.id.toolsCheckBox);
        appliancesCheckBox = (CheckBox) findViewById(R.id.appliancesCheckBox);
        entCheckBox = (CheckBox) findViewById(R.id.entCheckBox);
        videogamesCheckBox = (CheckBox) findViewById(R.id.videogamesCheckBox);
        miscCheckBox = (CheckBox) findViewById(R.id.miscCheckBox);

        Button button = (Button) findViewById(R.id.saveBtn);
        button.setOnClickListener(new Categories.MyClass() {

            @Override
            public void onClick(View v) {
                goToSecondActivity();

            }

        });
    }


    private void goToSecondActivity() {
        Intent prevIntent = getIntent();
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData5");
        //code to modify the SellData goes here

        if(toysCheckBox.isChecked()){
            sellData.setCategories(toysCheckBox.getText().toString());
        }
        if(babyCheckBox.isChecked()){
            sellData.setCategories(babyCheckBox.getText().toString());
        }
        if(kidsCheckBox.isChecked()){
            sellData.setCategories(kidsCheckBox.getText().toString());
        }
        if(youngACheckBox.isChecked()){
            sellData.setCategories(youngACheckBox.getText().toString());
        }
        if(adultCheckBox.isChecked()){
            sellData.setCategories(adultCheckBox.getText().toString());
        }
        if(electronicsCheckBox.isChecked()){
            sellData.setCategories(electronicsCheckBox.getText().toString());
        }
        if(sportgoodsCheckBox.isChecked()){
            sellData.setCategories(sportgoodsCheckBox.getText().toString());
        }
        if(toolsCheckBox.isChecked()){
            sellData.setCategories(toolsCheckBox.getText().toString());
        }
        if(appliancesCheckBox.isChecked()){
            sellData.setCategories(appliancesCheckBox.getText().toString());
        }
        if(entCheckBox.isChecked()){
            sellData.setCategories(entCheckBox.getText().toString());
        }
        if(videogamesCheckBox.isChecked()){
            sellData.setCategories(videogamesCheckBox.getText().toString());
        }
        if(miscCheckBox.isChecked()){
            sellData.setCategories(miscCheckBox.getText().toString());
        }

        Intent intent = new Intent(this, Description.class);

        intent.putExtra("globalData6",sellData);
        startActivityForResult(intent,2);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                SellData sellData = (SellData)data.getSerializableExtra("globalData7");
            }
        }
    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
