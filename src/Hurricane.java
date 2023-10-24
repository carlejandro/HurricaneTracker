import java.util.*;
import java.util.ArrayList;
import java.io.*;

public class Hurricane {
    private String name;
    private String catNum;
    private String date;

    private String month;
    private String day;
    private String year;

    //Create constructor
    public Hurricane(String name, String catNum, String date){
        setName(name);
        setCatNum(catNum);
        setDate(date);
    }

    //5 Param constructor for date isolation
    public Hurricane(String name, String catNum, String month, String day, String year){
        setName(name);
        setCatNum(catNum);
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public Hurricane(String catNum){
        setCatNum(catNum);
    }
    //Get name
    public void setName(String name){
        this.name = name;
    }

    public void setMonth(String month){
        this.month = month;
    }

    public void setDay(String day){
        this.day = day;
    }

    public void setYear(String year){
        this.year = year;
    }
    public void setCatNum(String catNum){
        this.catNum = catNum;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getName(){
        return name;
    }

    public String getCatNum(){
        return catNum;
    }

    public String getMonth(){
        return month;
    }

    public String getDay(){
        return day;
    }

    public String getYear(){
        return year;
    }
    public String getDate(){
        return date;
    }

    @Override
    public String toString(){
        if(getYear() == null) {
            return name + "\t" + catNum + "\t" + date + "\n";
        }
        else {
            return name + "\t" + catNum + "\t" + month + "\t" + day + "\t"  + year + "\n";
        }
    }

    public String toStringDetailed() {
        return name + "\t" + catNum + "\t" + getMonth() + "\t" + getDay() + "\t" + getYear() + "\n";
    }

}
