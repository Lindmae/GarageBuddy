package isabel.garagesale;

import android.location.Location;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Alex on 4/3/17.
 */

public class SellData implements Serializable
{
    private String StartTime;
    private String EndTime;
    private String StartDay;
    private String EndDay;

    private ArrayList<String> Categories;
    private String Description;
    private  String TheLocation;

    public SellData()
    {
        StartTime = null;
        EndTime = null;
        StartDay = null;
        EndDay = null;

        Categories = new ArrayList<String>();
        Description = null;
        TheLocation = null;


    }

    public String getStartTime()
    {
        return StartTime;
    }

    public String getStartDay()
    {
        return StartDay;
    }

    public String getEndTime()
    {
        return EndTime;
    }

    public String getEndDay()
    {
        return EndDay;
    }

    public ArrayList<String> getCategories()
    {
        return Categories;
    }

    public String getDescription()
    {
        return Description;
    }

    public String getTheLocation()
    {
        return TheLocation;
    }


    public void setStartTime(String ST )
    {
        StartTime = ST;
    }

    public void setStartDay(String ST )
    {
        StartDay = ST;
    }
    public void setEndTime(String ST )
    {
        EndTime = ST;
    }
    public void setEndDay(String ST )
    {
        EndDay = ST;
    }
    public void setCategories(String ST )
    {
        Categories.add(ST);
    }

    public void setDescription(String ST )
    {
        Description = ST;
    }

    public  void setTheLocation(String ST)
    {
        TheLocation = ST;
    }


}
