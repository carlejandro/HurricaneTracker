import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;


public class OptionOneNameSort {
    // The ascendSort method uses the collections class sorting method to take in a list and uses comparators to compare
    // Each Hurricane object in the sortedHurricaneList to the getName method of the Hurricane class
    // The algorithm then takes the data and arranges the objects in ascending order by name.

    //Declare global file writer to write to files in class

    public OptionOneNameSort() throws IOException {
    }

    public static void ascendSort(ArrayList<Hurricane> sortedHurricaneList) throws IOException {
          File txtFile = new File("src/SortByName.txt");
          FileWriter writeToFile = new FileWriter("src/SortByName.txt");
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
          //Write this value to string file

          //If the file has stuff from the previous iteration clear it so its new
          if(txtFile.length() > 0){
              writeToFile.write(""); //clear the contents of the file then write to it
              writeToFile.write("NameSort Text File\n" +
                      "This data is a list of hurricanes organized by name in ascending order.\n\n"
                      + sb);
          }
          else { //File is empty so write like regular
              writeToFile.write("NameSort Text File\n" +
                      "This data is a list of hurricanes organized by name in ascending order.\n\n"
                      + sb);
          }
          //close the filewrite object
          writeToFile.close();
      }
      public static void descendSort(ArrayList<Hurricane> sortedHurricaneList) throws IOException {
          File txtFile = new File("src/SortByName.txt");
          FileWriter writeToFile = new FileWriter("src/SortByName.txt");
          Collections.sort(sortedHurricaneList, Collections.reverseOrder(Comparator.comparing(Hurricane::getName)));
          StringBuilder sb = new StringBuilder();
          for (Hurricane hurricane : sortedHurricaneList){
              sb.append(hurricane);
          }
          //Create a JTextArea and set the text
          JTextArea textArea = new JTextArea("   Major Florida Hurricanes 1950-2020\n" +
                  "   Sort by name in descending order\n\n" + "Name\tCategory\tDate\n" +
                  sb.toString());
          //Create a JScrollPane to add Scroll functionality to the JtextArea
          JScrollPane scrollPane = new JScrollPane(textArea);

          //Show the JtextArea in a JOptionPane
          JOptionPane.showMessageDialog(null, scrollPane, "ArrayList Elements", JOptionPane.INFORMATION_MESSAGE);
          //If the file has stuff from the previous iteration clear it so its new
          if(txtFile.length() > 0){
              writeToFile.write(""); //clear the contents of the file then write to it
              writeToFile.write("NameSort Text File\n" +
                      "This data is a list of hurricanes organized by name in descending order.\n\n"
                      + sb);
          }
          else { //File is empty so write like regular
              writeToFile.write("NameSort Text File\n" +
                      "This data is a list of hurricanes organized by name in descending order.\n\n"
                      + sb);
          }
          //close the filewrite object
          writeToFile.close();
      }
}
