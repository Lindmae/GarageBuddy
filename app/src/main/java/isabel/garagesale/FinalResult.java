package isabel.garagesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FinalResult extends AppCompatActivity {
    ArrayList<String> Params;
    ArrayList<String> Categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);

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
        SellData sellData = (SellData)prevIntent.getSerializableExtra("globalData8");


        String method = "TestHTTP";
        Categories = sellData.getCategories();
        myTaskParams params = new myTaskParams(method,Params,Categories);
        params.setParams(sellData.getStartTime());
        params.setParams(sellData.getEndTime());
        params.setParams(sellData.getStartDay());

        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(params);

        prevIntent.putExtra("globalData9", sellData);
        setResult(RESULT_OK, prevIntent);
        finish();

    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
