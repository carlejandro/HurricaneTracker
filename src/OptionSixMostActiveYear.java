import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class OptionSixMostActiveYear {
    public static void yearAggregation(ArrayList<String> getHurricaneYearList) {
        int counter = 0;
        int j = 0;
        int arrayIncrementCounter = 0;
        ArrayList<String> countofYear = new ArrayList<>();
        ArrayList<String> tempYearHolder = new ArrayList<>();
        ArrayList<String> activeYear = new ArrayList<>();

        for (int i = 0; i < getHurricaneYearList.size(); i++) { //use index to iterate over entire list
            int count = Collections.frequency(getHurricaneYearList, getHurricaneYearList.get(i)); // check how many times
            //each year is found in the list gethurricaneyearlist, then store that number in the counter
            if (!(tempYearHolder.contains(getHurricaneYearList.get(i)))){ //
                //if the tempyear holder doesnt contain any values, place the
                //get rid of duplicate
                tempYearHolder.add(getHurricaneYearList.get(i));
                countofYear.add(String.valueOf(count));
            }

        }
        //loop to search for the highest counter in temp year
        for(int k = 0; k < tempYearHolder.size(); k++){
            String max = Collections.max(countofYear); // Set string max = to highest count in countOfYear List
            if(Objects.equals(max, countofYear.get(k))) { //Take max compare it to count
                activeYear.add(tempYearHolder.get(k)); //if the index is equal to the highest counter store in active year
                activeYear.add(countofYear.get(k)); // add both the current index from the counter and the temp year
                // 2004, 4
                //[2004 4, 2005 4]
            }
        }
        JOptionPane.showMessageDialog(null, "Major Florida Hurricanes 1950 - 2020\n\n " +
                "Most Active Year\n\n" +
                "Most active storm year is tied with " + activeYear.get(0) + " and " + activeYear.get(2) + "\n" +
                        "each having " + activeYear.get(1) + " named storms");
   }
}
