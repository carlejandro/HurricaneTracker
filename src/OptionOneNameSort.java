import javax.swing.*;
import java.util.ArrayList;
import java.util.*;


public class OptionOneNameSort {
    // The ascendSort method uses the collections class sorting method to take in a list and uses comparators to compare
    // Each Hurricane object in the sortedHurricaneList to the getName method of the Hurricane class
    // The algorithm then takes the data and arranges the objects in ascending order by name.
      public static void ascendSort(ArrayList<Hurricane> sortedHurricaneList){
          Collections.sort(sortedHurricaneList, Comparator.comparing(Hurricane::getName));
          for (Hurricane hurricane : sortedHurricaneList){
              System.out.print(hurricane);
          }
      }
      public static void descendSort(ArrayList<Hurricane> sortedHurricaneList){
          Collections.sort(sortedHurricaneList, Collections.reverseOrder(Comparator.comparing(Hurricane::getCatNum)));
          for (Hurricane hurricane : sortedHurricaneList){
              JOptionPane.showMessageDialog(null, hurricane);
          }
      }
}
