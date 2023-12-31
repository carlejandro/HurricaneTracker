import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OptionTwoCatSort {
    // The ascendSort method uses the collections class sorting method to take in a list and uses comparators to compare
    // Each Hurricane object in the sortedHurricaneList to the getCat method of the Hurricane class
    // The algorithm then takes the data and arranges the objects in ascending order by category number.
    public static void ascendSort(ArrayList<Hurricane> sortedHurricaneList) throws IOException {
        File txtFile = new File("src/SortByCategory.txt");
        FileWriter writeToFile = new FileWriter("src/SortByCategory.txt");
        Collections.sort(sortedHurricaneList, Comparator.comparing(Hurricane::getCatNum));
        StringBuilder sb = new StringBuilder();
        //This string builder appends the value of each hurricane list element after its been sorted by collections
        //to a string builder object that will be used in building the JTextArea
        for (Hurricane hurricane : sortedHurricaneList){
            sb.append(hurricane);
        }
        //Create a JTextArea and set the text
        JTextArea textArea = new JTextArea("   Major Florida Hurricanes 1950-2020\n" +
                "   Sort by category number in ascending order\n\n" + "Name\tCategory\tDate\n" +
                sb.toString());
        //Create a JScrollPane to add Scroll functionality to the JtextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Show the JtextArea in a JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, "ArrayList Elements", JOptionPane.INFORMATION_MESSAGE);
        //If the file has stuff from the previous iteration clear it so its new
        if(txtFile.length() > 0){
            writeToFile.write(""); //clear the contents of the file then write to it
            writeToFile.write("Category Sort Text File\n" +
                    "This data is a list of hurricanes organized by category in ascending order.\n\n"
                    + sb);
        }
        else { //File is empty so write like regular
            writeToFile.write("Category Sort Text File\n" +
                    "This data is a list of hurricanes organized by category in ascending order.\n\n"
                    + sb);
        }
        //close the filewrite object
        writeToFile.close();
    }
    //Descend sort reverses the order using the Collections class Sort, reverse order method
    public static void descendSort(ArrayList<Hurricane> sortedHurricaneList) throws IOException {
        File txtFile = new File("src/SortByCategory.txt");
        FileWriter writeToFile = new FileWriter("src/SortByCategory.txt");
        Collections.sort(sortedHurricaneList, Collections.reverseOrder(Comparator.comparing(Hurricane::getCatNum)));
        StringBuilder sb = new StringBuilder();
        for (Hurricane hurricane : sortedHurricaneList){
            sb.append(hurricane);
        }
        //Create a JTextArea and set the text
        JTextArea textArea = new JTextArea("   Major Florida Hurricanes 1950-2020\n" +
                "   Sort by category number in descending order\n\n" + "Name\tCategory\tDate\n" +
                sb.toString());
        //Create a JScrollPane to add Scroll functionality to the JtextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Show the JtextArea in a JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, "ArrayList Elements", JOptionPane.INFORMATION_MESSAGE);

        if(txtFile.length() > 0){
            writeToFile.write(""); //clear the contents of the file then write to it
            writeToFile.write("Category Sort File\n" +
                    "This data is a list of hurricanes organized by category in descending order.\n\n"
                    + sb);
        }
        else { //File is empty so write like regular
            writeToFile.write("Category Sort Text File\n" +
                    "This data is a list of hurricanes organized by category in descending order.\n\n"
                    + sb);
        }
        //close the filewrite object
        writeToFile.close();
    }
}

