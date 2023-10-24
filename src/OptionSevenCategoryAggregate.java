import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class OptionSevenCategoryAggregate {
    //This class utilizes one void method that simply aggregates the data and displays it in a jOptionPAne
    public static void aggregation(ArrayList<String> hurricaneCategories){
        //initialize counters for each category
        int cat1Counter = 0;
        int cat2Counter = 0;
        int cat3Counter = 0;
        int cat4Counter = 0;
        int cat5Counter = 0;
        int total = 0;
        for(String category: hurricaneCategories){
            if(Objects.equals(category, "1")){
                total++;
                cat1Counter++;
            }
            if(Objects.equals(category, "2")){
                total++;
                cat2Counter++;
            }
            if(Objects.equals(category, "3")){
                total++;
                cat3Counter++;
            }
            if(Objects.equals(category, "4")){
                total++;
                cat4Counter++;
            }
            if(Objects.equals(category, "5")){
                total++;
                cat5Counter++;
            }
        }
        JOptionPane.showMessageDialog(null, "Major Florida Hurricanes 1950 - 2020\n\n " +
                "Aggregate totals by Category (Saffir-Simpson Scale)\n\n" +
                "Total number of major hurricanes listed: " + total + "\n\n" +
                "Total category 5 hurricanes: " + cat5Counter + "\n" +
                "Total category 4 hurricanes: " + cat4Counter + "\n" +
                "Total category 3 hurricanes: " + cat3Counter + "\n" +
                "Total category 2 hurricanes: " + cat2Counter + "\n" +
                "Total category 1 hurricanes: " + cat1Counter + "\n");
    }
}
