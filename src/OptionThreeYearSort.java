import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OptionThreeYearSort {
    // The ascendSort method uses the collections class sorting method to take in a list and uses comparators to compare
    // Each Hurricane object in the sortedHurricaneList to the getYear method of the Hurricane class
    // The algorithm then takes the data and arranges the objects in ascending order by year.
    public static void ascendSort(ArrayList<Hurricane> sortedHurricaneList) throws IOException {
        File txtFile = new File("src/SortByYear.txt");
        FileWriter writeToFile = new FileWriter("src/SortByYear.txt");
        Collections.sort(sortedHurricaneList, Comparator.comparing(Hurricane::getYear));
        StringBuilder sb = new StringBuilder();
        for (Hurricane hurricane : sortedHurricaneList){
            sb.append(hurricane);
        }
        //Create a JTextArea and set the text
        JTextArea textArea = new JTextArea("\tMajor Florida Hurricanes 1950-2020\n" + "\t" +
                "   Sort by year in ascending order\n\n" + "Name\tCategory\tMonth\tDay\tYear\n" +
                sb.toString());
        //Create a JScrollPane to add Scroll functionality to the JtextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Show the JtextArea in a JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, "ArrayList Elements", JOptionPane.INFORMATION_MESSAGE);
        //If the file has stuff from the previous iteration clear it so its new
        if(txtFile.length() > 0){
            writeToFile.write(""); //clear the contents of the file then write to it
            writeToFile.write("Year Sort Text File\n" +
                    "This data is a list of hurricanes organized by year in ascending order.\n\n"
                    + sb);
        }
        else { //File is empty so write like regular
            writeToFile.write("Year Sort Text File\n" +
                    "This data is a list of hurricanes organized by year in ascending order.\n\n"
                    + sb);
        }
        //close the filewrite object
        writeToFile.close();
    }

    //Descend sort is identical to the ascend sort method except that it calls the collections.reverseOrder Method
    //After using comparators to compare each year within the hurricane object list
    //Place filewriter in for to append to data file
    public static void descendSort(ArrayList<Hurricane> sortedHurricaneList) throws IOException {
        File txtFile = new File("src/SortByYear.txt");
        FileWriter writeToFile = new FileWriter("src/SortByYear.txt");
        Collections.sort(sortedHurricaneList, Collections.reverseOrder(Comparator.comparing(Hurricane::getYear)));
        StringBuilder sb = new StringBuilder();
        for (Hurricane hurricane : sortedHurricaneList){
            sb.append(hurricane);
        }
        //Create a JTextArea and set the text
        JTextArea textArea = new JTextArea("\tMajor Florida Hurricanes 1950-2020\n" + "\t" +
                "   Sort by year in descending order\n\n" + "Name\tCategory\tMonth\tDay\tYear\n" +
                sb.toString());
        //Create a JScrollPane to add Scroll functionality to the JtextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Show the JtextArea in a JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, "ArrayList Elements", JOptionPane.INFORMATION_MESSAGE);
        if(txtFile.length() > 0){
            writeToFile.write(""); //clear the contents of the file then write to it
            writeToFile.write("Year Sort Text File\n" +
                    "This data is a list of hurricanes organized by year in descending order.\n\n"
                    + sb);
        }
        else { //File is empty so write like regular
            writeToFile.write("Year Sort Text File\n" +
                    "This data is a list of hurricanes organized by year in descending order.\n\n"
                    + sb);
        }
        //close the filewrite object
        writeToFile.close();
    }
}
