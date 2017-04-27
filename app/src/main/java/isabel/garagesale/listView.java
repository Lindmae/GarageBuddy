package isabel.garagesale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class listView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        myTaskParams myParams = new myTaskParams("getsales");
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(myParams);
    }

}
