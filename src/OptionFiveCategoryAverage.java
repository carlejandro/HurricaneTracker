import java.util.ArrayList;

public class OptionFiveCategoryAverage {
    //This class uses only 1 method to take in an arraylist of hurricane categories and return the average
    public static Double averageCat(ArrayList<String> hurricaneCategories){
        double counter = 0;
        int total = 0;
        double average;
        for(String category: hurricaneCategories){
            total += Double.parseDouble(category);
            counter++;
        }
        average = total/counter;
        return average;
    }

}
