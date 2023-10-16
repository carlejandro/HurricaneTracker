import java.util.*;
import java.util.ArrayList;
import java.io.*;

public class Hurricane {
    private String name;
    private String catNum;
    private String date;

    //Create constructor
    public Hurricane(String name, String catNum, String date){
        setName(name);
        setCatNum(catNum);
        setDate(date);

    }

    public Hurricane(String catNum){
        setCatNum(catNum);
    }
    //Get name
    public void setName(String name){
        this.name = name;
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

    public String getDate(){
        return date;
    }

    @Override
    public String toString(){
        return  name + "\t" + catNum + "\t" + date + "\n";
    }
}
