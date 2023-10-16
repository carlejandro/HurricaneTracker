import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static String selection(){
        String selection;
        selection = JOptionPane.showInputDialog("Florida Major Hurricanes 1950 - 2020 \n\n " +
                "Press 1 to Sort by Storm Name\n" +
                "Press 2 to Sort by Storm Category\n" +
                "Press 3 to Sort by Storm Year\n" +
                "Press 4 to Sort by Storm Month\n" +
                "Press 5 to Display Average Storm Category\n" +
                "Press 6 to Display the Most Active Year\n" +
                "Press 7 to Display Total by Category\n" +
                "Press 8 to Display Total by Year\n" +
                "Press 9 to Exit");
        return selection;
    }
    //readValues scans the value of the next line
    public static String readValues(Scanner hurricaneListFileScanner){
        String tempstring = hurricaneListFileScanner.nextLine();
        return tempstring;
    }
    //readToken reads the next line and tokenizes the string of the next line
    public static void readToken(String tempstring, ArrayList <String> hurricaneList){
        StringTokenizer strTokenizer = new StringTokenizer(tempstring, ",:");
        while(strTokenizer.hasMoreTokens()){
            hurricaneList.add(strTokenizer.nextToken());
        }
    }

    public static ArrayList<String> optionFive(ArrayList<String> tempList){
        ArrayList<String> hurricaneCategories = new ArrayList<>();
        int j = 1;
        while (!(tempList.isEmpty())) {
            if (j >= tempList.size()) {
                break;
            }
            //tokened list hurricane get at element 1 + 3continuing
            hurricaneCategories.add(tempList.get(j));
            j += 3;
        }
        return hurricaneCategories;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String tempString;
        //Create File from file location
        File hurricaneListFile = new File("src/NamedFloridaHurricanes.txt");
        //Attach file to scanner
        Scanner hurricaneListFileScanner = new Scanner(hurricaneListFile);
        ArrayList<String> hurricaneListTokenized = new ArrayList<>();
        //Read values from the first line of the file and store them in temp string

        while (hurricaneListFileScanner.hasNextLine()) {
            tempString = readValues(hurricaneListFileScanner);
            //Tokenize the tempstring and append to hurricane list
            readToken(tempString, hurricaneListTokenized);
        }
        //What's happening here is we're taking the list of tokenized strings and running the optionFive method
        //Making a new arraylist to store the category values into
        //The option five method takes a list in parameter iterates through
        //Adds the value at each category number to the newly created hurricanecategories list
        //Finally, the hurricane categories list is returned
        OptionFiveCategoryAverage.averageCat(optionFive(hurricaneListTokenized));
        ArrayList<String> tempList = new ArrayList<>(hurricaneListTokenized);
        //System.out.print(hurricaneListTokenized);
        //Create an arraylist of hurricane OBJECTS
        ArrayList<Hurricane> hurricaneObjects = new ArrayList<>();
        //Add a new Hurricane object into element 0 of the Hurricane ArrayList(Container of objects)
        //At Element 0 We instantiate a new hurricane object with the parameters of the tokenized sorted hurricaneListTokenized
        //as name, catnum, and date. ToString calls the method implicitly
        //iii used to iterate through original hurricaneList
        int i = 0;
        int ii = 1;
        int iii = 2;
        //While the searched through list isn't empty
        while (!(hurricaneListTokenized.isEmpty())) {
            //Check to see if the list is in bounds
            if (i >= hurricaneListTokenized.size()) {
                break;
            }


            //Add to hurricane objects by creating a new Object from hurricanelist, each token takes the place of name, category and date!
            hurricaneObjects.add(new Hurricane(hurricaneListTokenized.get(i), hurricaneListTokenized.get(ii), hurricaneListTokenized.get(iii)));
            //Increment i so we can step through the text file to get to next spot.
            i += 3;
            ii += 3;
            iii += 3;

        }
        //hurricane is a name, Hurricane is a class.
//        for (Hurricane hurricane : hurricaneObjects) {
//            //hurricaneListTokenized.get(0); //returns easy
//            String category = hurricane.getCatNum();
//            String name = hurricane.getName();
//            String date = hurricane.getDate();
//            System.out.println(name);
//            System.out.println(category);
//            System.out.println(date);
//        }
        //Make a new array list of Hurricane objects that takes the values from hurricaneObjects List
        ArrayList<Hurricane> sortedHurricaneList = new ArrayList<>(hurricaneObjects);
        String userInput = selection();
        String userInput2;
        //System.out.println(sortedHurricaneList);
        //Option 1
        while (ValidateInput.isNumber(userInput)) {
            if (Objects.equals(userInput, "1")) {
                userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                        "Sort by Hurricane Name" +
                        "Press 1 for Ascending Order\n" +
                        "Press 2 for Descending Order\n");
                while (ValidateInput.isNumber(userInput2)) {
                    if (Objects.equals(userInput2, "1")) {
                        //Post the names in a list in ascending order
                        OptionOneNameSort.ascendSort(sortedHurricaneList);
                        //reset selection
                        userInput = selection();
                        break;
                    }
                    if (Objects.equals(userInput2, "2")) {
                        //Post the names in a list in descending order
                        OptionOneNameSort.descendSort(sortedHurricaneList);
                        //reset selection
                        userInput = selection();
                        break;
                        //Stop here. Fix! Problems in the validation functions. Test Descending order in case test.
                        //Script the program separately!
                    }
                }
            } //Option 2 Cat Sort
            if (Objects.equals(userInput, "2")) {
                userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                            "Sort by Hurricane Category Number" +
                            "Press 1 for Ascending Order\n" +
                            "Press 2 for Descending Order\n");
                while (ValidateInput.isNumber(userInput2)) {
                    if (Objects.equals(userInput2, "1")) {
                        //Post the names in a list in ascending order
                        OptionTwoCatSort.ascendSort(sortedHurricaneList);
                        //reset selection
                        userInput = selection();
                        break;
                    }
                    if (Objects.equals(userInput2, "2")) {
                        //Post the names in a list in descending order
                        OptionTwoCatSort.descendSort(sortedHurricaneList);
                        //reset selection
                        userInput = selection();
                        break;
                        //Stop here. Fix! Problems in the validation functions. Test Descending order in case test.
                        //Script the program separately!
                        }
                    }
                }
            while (Objects.equals(userInput, "5")) {
                double average;
                average = OptionFiveCategoryAverage.averageCat(optionFive(hurricaneListTokenized));
                JOptionPane.showMessageDialog(null, "Major Florida Hurricanes 1950 - 2020\n" +
                        "Average Storm Category by Saffir-Simpson Scale\n" +
                        "Average Storm Category is " + average);
                userInput = selection();
                break;
                }
            }
        }
    }