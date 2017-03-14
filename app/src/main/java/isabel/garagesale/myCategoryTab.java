package isabel.garagesale;

import android.app.Application;

/**
 * Created by Chris on 3/14/2017.
 */

public class myCategoryTab extends Application{
    private CategoryTab myTab;

    public void setMyCategoryTab(CategoryTab myTab){
        this.myTab = myTab;
    }

    public CategoryTab getMyTab(){
        return myTab;
    }
}
