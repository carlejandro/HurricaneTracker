import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.text.DecimalFormat;

public class Main {

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
        int j = 4;
        while (!(tempList.isEmpty())) {
            if (j >= tempList.size()) {
                break;
            }
            //tokened list hurricane get at element 1 + 3continuing
            hurricaneYears.add(tempList.get(j));
            j += 5;
        }
        return hurricaneYears;


    }

    public static void main(String[] args) throws IOException {
        String tempString;
        //Create File from file location
        File hurricaneListFile = new File("src/NamedFloridaHurricanes.txt");
        File sortByNameFile = new File("src/SortByName.txt");

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

        //Stopped here, this is the same thing as creating the original list of 3 parameters
        //just with 5. Use the second scanner to read the values
        while (hurricaneListFileScanner2.hasNextLine()) {
            tempString = readValues(hurricaneListFileScanner2);
            //Tokenize the tempstring and append to hurricane list
            readTokenDateIsolation(tempString, hurricaneListTokenized5Parameters);
        }

        //What's happening here is we're taking the list of tokenized strings and running the optionFive method
        //Making a new arraylist to store the category values into
        //The option five method takes a list in parameter iterates through
        //Adds the value at each category number to the newly created hurricanecategories list
        //Finally, the hurricane categories list is returned
//        OptionFiveCategoryAverage.averageCat(optionFive(hurricaneListTokenized3Parameters));
//        ArrayList<String> tempList = new ArrayList<>(hurricaneListTokenized3Parameters);
        //System.out.print(hurricaneListTokenized3Parameters);
        //Create an arraylist of hurricane OBJECTS
        ArrayList<Hurricane> hurricaneObjects = new ArrayList<>();
        ArrayList<Hurricane> hurricaneObjects5Parameters = new ArrayList<>();
        //Add a new Hurricane object into element 0 of the Hurricane ArrayList(Container of objects)
        //At Element 0 We instantiate a new hurricane object with the parameters of the tokenized sorted hurricaneListTokenized3Parameters
        //as name, catnum, and date. ToString calls the method implicitly
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
        //This checks to see if the list 5 is in bounds

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
//        for (Hurricane hurricane : hurricaneObjects5Parameters){
//            System.out.println(hurricane.toStringDetailed());
//        }


        //Finish here, proof the isolation works. Write the method for number 3! Trust the above method! You will need it!
        //Replace with SB!

        //hurricane is a name, Hurricane is a class.
//        for (Hurricane hurricane : hurricaneObjects) {
//            //hurricaneListTokenized3Parameters.get(0); //returns easy
//            String category = hurricane.getCatNum();
//            String name = hurricane.getName();
//            String date = hurricane.getDate();
//            System.out.println(name);
//            System.out.println(category);
//            System.out.println(date);
//        }
        //Make a new array list of Hurricane objects that takes the values from hurricaneObjects List
        ArrayList<Hurricane> sortedHurricaneList = new ArrayList<>(hurricaneObjects);
        ArrayList<Hurricane> sortedHurricaneList5Parameters = new ArrayList<>(hurricaneObjects5Parameters);

        String userInput = selection();
        String userInput2;
        //System.out.println(sortedHurricaneList);
        //Option 0 data validation loop
        while (!ValidateInput.isNumber(userInput) || Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 9){
            JOptionPane.showMessageDialog(null, "Please enter valid input");
            userInput = selection();
        }
        //option 1
        while (ValidateInput.isNumber(userInput)) {
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
                        //Stop here. Fix! Problems in the validation functions. Test Descending order in case test.
                        //Script the program separately!
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
                        //Stop here. Fix! Problems in the validation functions. Test Descending order in case test.
                        //Script the program separately!
                        }
                    }
                }
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
                        //Post the names in a list in ascending order
                        OptionThreeYearSort.descendSort(sortedHurricaneList5Parameters);
                        //reset selection
                        userInput = selection();
                        break;
                    }
                }
            }
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
                        //Post the names in a list in ascending order
                        OptionFourMonthSort.descendSort(sortedHurricaneList5Parameters);
                        //reset selection
                        userInput = selection();
                        break;
                    }
                }
            }
            if (Objects.equals(userInput, "5")) {
                double average;
                //Make a new decimal format object to format the average
                DecimalFormat df = new DecimalFormat("0.00");
                average = OptionFiveCategoryAverage.averageCat(getHurricaneCategoryList(hurricaneListTokenized3Parameters));
                JOptionPane.showMessageDialog(null, "Major Florida Hurricanes 1950 - 2020\n\n " +
                        "Average Storm Category by Saffir-Simpson Scale\n\n" +
                        "Average Storm Category is " + df.format(average));
                userInput = selection();
                break;
                }
            if (Objects.equals(userInput, "6")){
                OptionSixMostActiveYear.yearAggregation(getHurricaneYearList(hurricaneListTokenized5Parameters));
                userInput = selection();
            }
            while (Objects.equals(userInput, "7")) {
                    aggregateCategories = getHurricaneCategoryList(hurricaneListTokenized3Parameters);
                    OptionSevenCategoryAggregate.aggregation(aggregateCategories);
                    userInput = selection();
                 }
            //Option 8
            if (Objects.equals(userInput, "8")){
                OptionEightAggregateYear.yearAggregation(getHurricaneYearList(hurricaneListTokenized5Parameters));
                userInput = selection();
                }
            }
        }
    }