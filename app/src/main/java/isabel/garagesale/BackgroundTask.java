package isabel.garagesale;
import android.os.AsyncTask;
import android.content.Context;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

import android.util.*;

/**
 * Created by chriscalderon on 4/3/17.
 */

public class BackgroundTask extends AsyncTask<myTaskParams,Void,String> {

    Context ctx;

    BackgroundTask(Context ctx){
        this.ctx = ctx;

    }

    @Override
    protected String doInBackground(myTaskParams... params) {
        String reg_url = "http://chriscal.x10host.com/register.php";
        String method = params[0].getMethod();
        if(method.equals("TestHTTP")){
            String startTime = params[0].Params.get(0);
            String endTime = params[0].Params.get(1);
            String startDate = params[0].Params.get(2);
            String endDate = params[0].Params.get(3);
            String result = "";
            for (String s : params[0].Categories){
                result = result + " " + s;
            }
            String categories = result;

            try{
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                String error;
                if(httpURLConnection !=null){
                    error = "connection successful";
                    Log.d("error",error);
                }
                else{
                    error = "connection unsuccessful";
                    Log.d("error",error);
                }
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("startTime","UTF-8")+"="+URLEncoder.encode(startTime,"UTF-8")+"&"+
                        URLEncoder.encode("endTime","UTF-8")+"="+URLEncoder.encode(endTime,"UTF-8")+"&"+
                        URLEncoder.encode("startDate","UTF-8")+"="+URLEncoder.encode(startDate,"UTF-8")+"&"+
                        URLEncoder.encode("endDate","UTF-8")+"="+URLEncoder.encode(endDate,"UTF-8")+"&"+
                        URLEncoder.encode("categories","UTF-8")+"="+URLEncoder.encode(categories,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Garage Sale Added!";

            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }





        }

        return null;
    }

    @Override
    protected void onPostExecute(String result){
        Toast.makeText(ctx,result, Toast.LENGTH_LONG).show();
    }
}
