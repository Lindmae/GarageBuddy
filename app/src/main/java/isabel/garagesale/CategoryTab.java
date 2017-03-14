package isabel.garagesale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;

public class CategoryTab extends AppCompatActivity {

    private String[] categories = new String[12];
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((myCategoryTab)getApplication()).setMyCategoryTab(this);

        CheckBox toysCheckBox = (CheckBox) findViewById(R.id.toysCheckBox);
        CheckBox babyCheckBox = (CheckBox) findViewById(R.id.babyCheckBox);
        CheckBox kidsCheckBox = (CheckBox) findViewById(R.id.kidsCheckBox);
        CheckBox youngACheckBox = (CheckBox) findViewById(R.id.youngACheckBox);
        CheckBox adultCheckBox = (CheckBox) findViewById(R.id.adultCheckBox);
        CheckBox elctronicsCheckBox = (CheckBox) findViewById(R.id.electronicsCheckBox);
        CheckBox sportgoodsCheckBox = (CheckBox) findViewById(R.id.sportgoodsCheckBox);
        CheckBox toolsCheckBox = (CheckBox) findViewById(R.id.toolsCheckBox);
        CheckBox appliancesCheckBox = (CheckBox) findViewById(R.id.appliancesCheckBox);
        CheckBox entCheckBox = (CheckBox) findViewById(R.id.entCheckBox);
        CheckBox videogamesCheckBox = (CheckBox) findViewById(R.id.videogamesCheckBox);
        CheckBox miscCheckBox = (CheckBox) findViewById(R.id.miscCheckBox);

        Button saveBtn = (Button) findViewById(R.id.saveBtn);

    }


    public void onSaveClick(View view){
        boolean clicked  = view.isPressed();
        Intent intent = new Intent(this, savedPage.class);

        startActivity(intent);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        String category = ((CheckBox) view).getText().toString();
        pushCategory(category);
    }


    public void pushCategory(String category){
        if(count>12){
            return;
        }
        categories[count] = category;
        count++;
    }

    public String[] getAllCategories(){
        return categories;
    }




}