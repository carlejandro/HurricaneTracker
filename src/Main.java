import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.text.DecimalFormat;

//Carlos Alexander Suarez-Martinez
//COP2552.0M1
//Project 4 Hurricane Tracker/Storm Statistics:
//Write a Java program using good programming principles
//That will read an input file and write data of major hurricanes from 1950-2020 to different output files
public class Main {

    //Selection method calls up the menu to begin the program
    public static String selection(){
        String selection;
        selection = JOptionPane.showInputDialog("Florida Major Hurricanes 1950 - 2020 \n\n" +
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
    //readValues scans the value of the next line in the given text file
    public static String readValues(Scanner hurricaneListFileScanner){
        String tempstring = hurricaneListFileScanner.nextLine();
        return tempstring;
    }
    //readToken reads the next line and tokenizes the string of the next line
    //This method is for the first constructor of hurricanes, it separates the values into Name, category, date in MM/DD/YYYY
    //Format
    public static void readToken(String tempstring, ArrayList <String> hurricaneList){
        StringTokenizer strTokenizer = new StringTokenizer(tempstring, ",:");
        while(strTokenizer.hasMoreTokens()){
            hurricaneList.add(strTokenizer.nextToken());
        }
    }

    //This method isolates the month day and year into tokens using delimiters
    public static void readTokenDateIsolation(String tempstring, ArrayList <String> hurricaneList){
        StringTokenizer strTokenizer = new StringTokenizer(tempstring, ",:/");
        while(strTokenizer.hasMoreTokens()){
            hurricaneList.add(strTokenizer.nextToken());
        }
    }


    public static ArrayList<String> getHurricaneCategoryList(ArrayList<String> tempList){
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
    //This makes the hurricane years list
    public static ArrayList<String> getHurricaneYearList(ArrayList<String> tempList) {
        ArrayList<String> hurricaneYears = new ArrayList<>();
        //Set J to the final element in the year list element 4
        int j = 4;
        while (!(tempList.isEmpty())) {
            if (j >= tempList.size()) {
                break;
            }
            //tokened list hurricane get at element 1 + continuing
            hurricaneYears.add(tempList.get(j));
            j += 5;
        }
        return hurricaneYears;


    }

    public static void main(String[] args) throws IOException {
        String tempString;
        //Create File from file location
        File hurricaneListFile = new File("src/NamedFloridaHurricanes.txt");

        //Attach file to scanner
        Scanner hurricaneListFileScanner = new Scanner(hurricaneListFile);
        Scanner hurricaneListFileScanner2 = new Scanner(hurricaneListFile);
        ArrayList<String> hurricaneListTokenized3Parameters = new ArrayList<>();
        ArrayList<String> hurricaneListTokenized5Parameters = new ArrayList<>();
        ArrayList<String> aggregateCategories =  new ArrayList<>();
        //Read values from the first line of the file and store them in temp string
        //List tokenized by 3
        while (hurricaneListFileScanner.hasNextLine()) {
            tempString = readValues(hurricaneListFileScanner);
            //Tokenize the tempstring and append to hurricane list
            readToken(tempString, hurricaneListTokenized3Parameters);
        }
        //reset the scanner to beginning by closing the first scanner
        hurricaneListFileScanner.close();

        //This is the same thing as creating the original list of 3 parameters
        //just with 5. Use the second scanner to read the values
        while (hurricaneListFileScanner2.hasNextLine()) {
            tempString = readValues(hurricaneListFileScanner2);
            //Tokenize the tempstring and append to hurricane list
            readTokenDateIsolation(tempString, hurricaneListTokenized5Parameters);
        }


        //Create an arraylist of hurricane OBJECTS using BOTH constructors--> OVERLOAD
        ArrayList<Hurricane> hurricaneObjects = new ArrayList<>();
        ArrayList<Hurricane> hurricaneObjects5Parameters = new ArrayList<>();
        //Add a new Hurricane object into element 0 of the Hurricane ArrayList(Container of objects)
        //At Element 0 We instantiate a new hurricane object with the parameters of the tokenized sorted hurricaneListTokenized3Parameters
        //as name, catnum, and date. ToString calls the method implicitly
        ///The is and zs represent the index of each ATTRIBUTE of the hurricane Constructor that will be iterated through
        //For data collection
        //iii used to iterate through original hurricaneList
        int i = 0;
        int ii = 1;
        int iii = 2;
        int z = 0;
        int zz = 1;
        int zzz = 2;
        int zzzz = 3;
        int zzzzz = 4;
        //While the searched through list isn't empty
        while (!(hurricaneListTokenized3Parameters.isEmpty())) {
            //Check to see if the list is in bounds
            if (i >= hurricaneListTokenized3Parameters.size()) {
                break;
            }


            //Add to hurricane objects by creating a new Object from hurricanelist, each token takes the place of name, category and date!
            hurricaneObjects.add(new Hurricane(hurricaneListTokenized3Parameters.get(i), hurricaneListTokenized3Parameters.get(ii), hurricaneListTokenized3Parameters.get(iii)));
            //Increment i so we can step through the text file to get to next spot.
            i += 3;
            ii += 3;
            iii += 3;

        }
        //This checks to see if the hurricane list with 5 is "In bounds" to avoid an inbounds element error
        while (!(hurricaneListTokenized5Parameters.isEmpty())){
            if (z >= hurricaneListTokenized5Parameters.size()) {
                break;
            }
            //Fill the 5 paramater list
            hurricaneObjects5Parameters.add(new Hurricane(hurricaneListTokenized5Parameters.get(z),
                    hurricaneListTokenized5Parameters.get(zz), hurricaneListTokenized5Parameters.get(zzz),
                    hurricaneListTokenized5Parameters.get(zzzz), hurricaneListTokenized5Parameters.get(zzzzz)));
            z += 5;
            zz += 5;
            zzz += 5;
            zzzz += 5;
            zzzzz += 5;
        }

        //hurricane is a name, Hurricane is a class.
        //Make a new array list of Hurricane objects that takes the values from hurricaneObjects List
        ArrayList<Hurricane> sortedHurricaneList = new ArrayList<>(hurricaneObjects);
        ArrayList<Hurricane> sortedHurricaneList5Parameters = new ArrayList<>(hurricaneObjects5Parameters);

        //Initiate the selection menu
        String userInput = selection();
        String userInput2;

        //Option 0 data validation loop
        while (!ValidateInput.isNumber(userInput) || Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 9){
            JOptionPane.showMessageDialog(null, "Please enter valid input");
            userInput = selection();
        }


        while (ValidateInput.isNumber(userInput)) {
            //Option 1 Name Sort
            if (Objects.equals(userInput, "1")) {
                userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                        "Sort by Hurricane Name\n" +
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
                    }
                    if(ValidateInput.isNumber(userInput2)
                            || !(Objects.equals(userInput2, "2")
                            || !(Objects.equals(userInput2, "1")))){
                        JOptionPane.showMessageDialog(null, "Enter Valid Number");
                        userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                                "Sort by Hurricane Name\n" +
                                "Press 1 for Ascending Order\n" +
                                "Press 2 for Descending Order\n");
                    }
                }
            } //Option 2 Cat Sort
            if (Objects.equals(userInput, "2")) {
                userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                            "Sort by Hurricane Category Number\n" +
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
                        }
                    if (ValidateInput.isNumber(userInput2)
                            || !(Objects.equals(userInput2, "2")
                            || !(Objects.equals(userInput2, "1")))){
                        JOptionPane.showMessageDialog(null, "Enter Valid Number");
                        userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                                "Sort by Hurricane Category Number\n" +
                                "Press 1 for Ascending Order\n" +
                                "Press 2 for Descending Order\n");
                        }
                    }
                }
            //Option 3 Year Sort
            if (Objects.equals(userInput, "3")){
                userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                        "Sort by Year Hurricane Landed\n" +
                        "Press 1 for Ascending Order\n" +
                        "Press 2 for Descending Order\n");
                while(ValidateInput.isNumber(userInput2)){
                    if (Objects.equals(userInput2, "1")) {
                        //Post the names in a list in ascending order
                        OptionThreeYearSort.ascendSort(sortedHurricaneList5Parameters);
                        //reset selection
                        userInput = selection();
                        break;
                    }
                    if (Objects.equals(userInput2, "2")) {
                        //Post the names in a list in descending order
                        OptionThreeYearSort.descendSort(sortedHurricaneList5Parameters);
                        //reset selection
                        userInput = selection();
                        break;
                    }
                    if (ValidateInput.isNumber(userInput2)
                            || !(Objects.equals(userInput2, "2")
                            || !(Objects.equals(userInput2, "1")))){
                        JOptionPane.showMessageDialog(null, "Enter Valid Number");
                        userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                                "Sort by Year Hurricane Landed\n" +
                                "Press 1 for Ascending Order\n" +
                                "Press 2 for Descending Order\n");
                    }
                }
            }
            //Option 4 Month Sort
            if (Objects.equals(userInput, "4")){
                userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                        "Sort by Month\n" +
                        "Press 1 for Ascending Order\n" +
                        "Press 2 for Descending Order\n");
                while(ValidateInput.isNumber(userInput2)){
                    if (Objects.equals(userInput2, "1")) {
                        //Post the names in a list in ascending order
                        OptionFourMonthSort.ascendSort(sortedHurricaneList5Parameters);
                        //reset selection
                        userInput = selection();
                        break;
                    }
                    if (Objects.equals(userInput2, "2")) {
                        //Post the names in a list in descending order
                        OptionFourMonthSort.descendSort(sortedHurricaneList5Parameters);
                        //reset selection
                        userInput = selection();
                        break;
                    }
                    if (ValidateInput.isNumber(userInput2)
                            || !(Objects.equals(userInput2, "2")
                            || !(Objects.equals(userInput2, "1")))){
                        JOptionPane.showMessageDialog(null, "Enter Valid Number");
                        userInput2 = JOptionPane.showInputDialog("Major Florida Hurricanes 1950 - 2020\n" +
                                "Sort by Month\n" +
                                "Press 1 for Ascending Order\n" +
                                "Press 2 for Descending Order\n");
                    }
                }
            }
            //Option 5 Category Average
            if (Objects.equals(userInput, "5")) {
                double average;
                //Make a new decimal format object to format the average
                DecimalFormat df = new DecimalFormat("0.00");
                average = OptionFiveCategoryAverage.averageCat(getHurricaneCategoryList(hurricaneListTokenized3Parameters));
                JOptionPane.showMessageDialog(null, "Major Florida Hurricanes 1950 - 2020\n\n " +
                        "Average Storm Category by Saffir-Simpson Scale\n\n" +
                        "Average Storm Category is " + df.format(average));
                userInput = selection();
                }
            //Option 6 Most active year
            if (Objects.equals(userInput, "6")){
                OptionSixMostActiveYear.yearAggregation(getHurricaneYearList(hurricaneListTokenized5Parameters));
                userInput = selection();
            }
            //Option 7 Aggregate Categories
            if (Objects.equals(userInput, "7")) {
                    aggregateCategories = getHurricaneCategoryList(hurricaneListTokenized3Parameters);
                    OptionSevenCategoryAggregate.aggregation(aggregateCategories);
                    userInput = selection();
                 }
            //Option 8 Aggregate Year
            if (Objects.equals(userInput, "8")){
                OptionEightAggregateYear.yearAggregation(getHurricaneYearList(hurricaneListTokenized5Parameters));
                userInput = selection();
                }
            //Option 9 Exit The Program
            if (Objects.equals(userInput, "9")){
                System.exit(0);
                }
            //Data Validation Post choice loop
            while (!ValidateInput.isNumber(userInput) || Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 9){
                JOptionPane.showMessageDialog(null, "Error Invalid Input Please Enter Valid number 1-9");
                userInput = selection();
                }
            }
        }
    }