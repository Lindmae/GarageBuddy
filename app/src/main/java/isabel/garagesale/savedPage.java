package isabel.garagesale;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class savedPage extends AppCompatActivity {

    private String[] categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CategoryTab myTab = ((myCategoryTab)getApplication()).getMyTab();

        categories = myTab.getAllCategories();




    }


}
