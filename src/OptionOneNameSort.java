import javax.swing.*;
import java.util.ArrayList;
import java.util.*;


public class OptionOneNameSort {
    // The ascendSort method uses the collections class sorting method to take in a list and uses comparators to compare
    // Each Hurricane object in the sortedHurricaneList to the getName method of the Hurricane class
    // The algorithm then takes the data and arranges the objects in ascending order by name.
      public static void ascendSort(ArrayList<Hurricane> sortedHurricaneList){
          Collections.sort(sortedHurricaneList, Comparator.comparing(Hurricane::getName));
          StringBuilder sb = new StringBuilder();
          for (Hurricane hurricane : sortedHurricaneList){
                  sb.append(hurricane);
          }
          //Create a JTextArea and set the text
          JTextArea textArea = new JTextArea("   Major Florida Hurricanes 1950-2020\n" +
                  "   Sort by name in ascending order\n\n" + "Name\tCategory\tDate\n" +
                  sb.toString());
          //Create a JScrollPane to add Scroll functionality to the JtextArea
          JScrollPane scrollPane = new JScrollPane(textArea);

          //Show the JtextArea in a JOptionPane
          JOptionPane.showMessageDialog(null, scrollPane, "ArrayList Elements", JOptionPane.INFORMATION_MESSAGE);
      }
      public static void descendSort(ArrayList<Hurricane> sortedHurricaneList){
          Collections.sort(sortedHurricaneList, Collections.reverseOrder(Comparator.comparing(Hurricane::getName)));
          StringBuilder sb = new StringBuilder();
          for (Hurricane hurricane : sortedHurricaneList){
              sb.append(hurricane);
              System.out.print(hurricane);
          }
          //Create a JTextArea and set the text
          JTextArea textArea = new JTextArea("   Major Florida Hurricanes 1950-2020\n" +
                  "   Sort by name in descending order\n\n" + "Name\tCategory\tDate\n" +
                  sb.toString());
          //Create a JScrollPane to add Scroll functionality to the JtextArea
          JScrollPane scrollPane = new JScrollPane(textArea);

          //Show the JtextArea in a JOptionPane
          JOptionPane.showMessageDialog(null, scrollPane, "ArrayList Elements", JOptionPane.INFORMATION_MESSAGE);
      }
}
