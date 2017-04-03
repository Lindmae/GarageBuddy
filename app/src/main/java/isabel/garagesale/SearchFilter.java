package isabel.garagesale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchFilter extends AppCompatActivity {

    String[] DataToPassBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filter);
        Button button = (Button) findViewById(R.id.buttonSearch);
        button.setOnClickListener(new SearchFilter.MyClass() {

            @Override
            public void onClick(View v) {

                goToPreviousActivity();

            }

        });
    }

    private void goToPreviousActivity() {

        Intent intent = new Intent(this, Categories.class);
        intent.putExtra("keyName", DataToPassBack);
        setResult(RESULT_OK, intent);
        finish();

    }

    public class MyClass implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
