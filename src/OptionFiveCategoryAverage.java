import java.util.ArrayList;

public class OptionFiveCategoryAverage {
    public static Double averageCat(ArrayList<String> hurricaneCategories){
        double counter = 0;
        int total = 0;
        double average;
        for(String category: hurricaneCategories){
            total += Double.parseDouble(category);
            counter++;
        }
        average = total/counter;
        System.out.println(hurricaneCategories);
        System.out.println(average);
        return average;
    }

}
