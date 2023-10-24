import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class OptionEightAggregateYear {
    public static void yearAggregation(ArrayList<String> getHurricaneYearList) {
        int counter = 0;
        int j = 0;
        int arrayIncrementCounter = 0;
        ArrayList<String> countofYear = new ArrayList<>();
        ArrayList<String> tempYearHolder = new ArrayList<>();

        for (int i = 0; i < getHurricaneYearList.size(); i++) {
        int count = Collections.frequency(getHurricaneYearList, getHurricaneYearList.get(i)); // check how many times
            //each year is found in the list gethurricaneyearlist, then store that number in the counter
        if (!(tempYearHolder.contains(getHurricaneYearList.get(i)))){ //
            //if the tempyear holder doesnt contain any values, add the year and the count from getHurricaneList
            //get rid of duplicate
            tempYearHolder.add(getHurricaneYearList.get(i));
            countofYear.add(String.valueOf(count));
            }
        }
        //Initialize String Builder for text area
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append("      Year     Number of Storms \n");
        for (String year : tempYearHolder){
            sb.append("      " + year);
            sb.append("\t" + "       " + countofYear.get(i) + "\n");
            i++;
        }

        //Create a JTextArea and set the text
        JTextArea textArea = new JTextArea(" Major Florida Hurricanes 1950-2020\n" +
                "       Aggregate Totals by Year\n\n" +
                sb.toString());
        //Create a JScrollPane to add Scroll functionality to the JtextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Show the JtextArea in a JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, "ArrayList Elements", JOptionPane.INFORMATION_MESSAGE);


    }
}
