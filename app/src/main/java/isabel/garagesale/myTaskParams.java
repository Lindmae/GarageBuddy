package isabel.garagesale;

import java.util.ArrayList;

/**
 * Created by chriscalderon on 4/3/17.
 */

public class myTaskParams {
    ArrayList<String> Params;
    ArrayList<String> Categories;
    String method;

    myTaskParams(String method, ArrayList<String> Params,ArrayList<String> Categories) {
        this.method = method;
        this.Params = new ArrayList<String>();
        this.Categories = Categories;
    }

    myTaskParams(String method){
        this.method = method;
    }

    String getMethod(){
        return method;
    }

    public void setParams(String ST){
        Params.add(ST);
    }


}
