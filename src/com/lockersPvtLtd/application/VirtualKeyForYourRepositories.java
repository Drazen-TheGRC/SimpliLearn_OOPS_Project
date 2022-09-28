package com.lockersPvtLtd.application;


import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VirtualKeyForYourRepositories {

    // Path variables
    static String currentDirectoryPath; //It is the path which changes as we navigate through file explorer
    static String absoluteAppDirectoryPath; //It is the constant path provided by the user and can only be changed through main menu by selection of option “Change Path”.
    // Other global variables
    static String appName = "Virtual Key For Your Repositories";
    static String gitHubAppLink = "https://github.com/Drazen-BBG/Virtual_Key_for_Your_Repositories-Assessment-Project_1";
    static String developerName = "Drazen Drinic";
    static String developerLinkedin = "https://www.linkedin.com/in/drazendrinic/";
    static int consoleBoxWidth = 90; //Suggested minimum is 90

    public static String getCurrentDirectoryPath() {
        return currentDirectoryPath;
    }
    public static void setCurrentDirectoryPath(String currentDirectoryPath) {
        VirtualKeyForYourRepositories.currentDirectoryPath = currentDirectoryPath;
    }
    public static String getAbsoluteAppDirectoryPath() {
        return absoluteAppDirectoryPath;
    }
    public static void setAbsoluteAppDirectoryPath(String absoluteAppDirectoryPath) {
        VirtualKeyForYourRepositories.absoluteAppDirectoryPath = absoluteAppDirectoryPath;
    }






    // Main method
    public static void main(String[] args) {

        startApp();

    }

    private static void startApp(){

        welcomeMessage();
        waitSeconds(5);
        setAppDirectoryPath();
        mainMenu();
    }


    private static void waitSeconds(int waitSeconds){

        int milliSeconds = 1000 * waitSeconds;
        try {
            Thread.sleep( milliSeconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    // LineBuilder methods
    private static String lineBuilderCenterAligned(int lineLength, String mainString, char firstAndLastPlaceHolder, char mainPlaceHolder){
        String line = "";
        String prefix = "";
        String postfix = "";

        int prefixLength = (lineLength - mainString.length())/2;
        int postfixLength = lineLength - mainString.length() - prefixLength;

        for (int i = 0; i < prefixLength; i++){
            prefix+=mainPlaceHolder;
        }
        prefix = firstAndLastPlaceHolder + prefix;

        for (int i = 0; i < postfixLength; i++){
            postfix+=mainPlaceHolder;
        }
        postfix = postfix + firstAndLastPlaceHolder;

        line = prefix + mainString + postfix;


        return line;
    }
    private static String lineBuilderLeftAligned(int lineLength, String mainString, char firstAndLastPlaceHolder, char mainPlaceHolder){
        String line = "";
        String prefix = "";
        String postfix = "";

        int prefixLength = 1;
        int postfixLength = lineLength - mainString.length() - prefixLength;

        for (int i = 0; i < prefixLength; i++){
            prefix+=mainPlaceHolder;
        }
        prefix = firstAndLastPlaceHolder + prefix;

        for (int i = 0; i < postfixLength; i++){
            postfix+=mainPlaceHolder;
        }
        postfix = postfix + firstAndLastPlaceHolder;

        line = prefix + mainString + postfix;


        return line;
    }


    //Welcome method is the first method to call it greats the user, and after it comes the SetWorkingDirectoryPath method
    private static void welcomeMessage(){
        String firstLine = "[ Welcome ]";
        String developerLine = "Application Developer : " + developerName;
        String applicationLine = "Application Name: " + appName;
        String gitHubLine = "Application GitHub: ";
        String lastLine = "[ Next steps are below ]";

        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, developerLine, '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, applicationLine, '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubLine, '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubAppLink, '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
    }
    // Goodbye method is called when we want to exit the program
    private static void goodbyeMessage(){
        String firstLine = "[ Goodbye ]";
        String lastLine = "***";

        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "Thanks for trying my app!!!", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "See you next time!!!", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        //System.out.println();
    }

    private static void developerInfo(){
        String firstLine = "[ Developer Info ]";
        String developerName = "App Developer : " + VirtualKeyForYourRepositories.developerName;
        String developerLinkedin = "LinkedIn: " + VirtualKeyForYourRepositories.developerLinkedin;
        String gitHubLine = "Application GitHub: ";
        String lastLine = "[ Main Menu is coming in 5 seconds ]";

        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, developerName, '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, developerLinkedin, '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubLine, '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubAppLink, '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));


        waitSeconds(5);
        mainMenu();
    }

    // SetWorkingDirectoryPath method comes after the Welcome method, and it sets the path for the user app directory

    private static void setAppDirectoryPathMessage(){
        String firstLine = "[ Setting Absolute Working Directory Path ]";
        String userInputLine = "Please paste or enter your absolute working directory path here: ";
        String lastLine = "[ Now we need to past or enter the path down below ]";

        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, " Step 1 > Create a folder on your PC and give it one word name", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, " Step 2 > Open the folder and click on the folder icon in the address bar ", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, " Step 3 > Copy the address link so you can past it in the next step", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line
    }
    private static void setAppDirectoryPath() {

        setAppDirectoryPathMessage();

        Scanner scanner = new Scanner(System.in);
        String tempPath =scanner.next();
        //scanner.close(); This was causing issues

        System.out.println("");

        if(Pattern.matches("((\\/)+|(\\\\)+)", tempPath)) {
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Seams your input was invalid <<<", '+', '-'));
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Check the instructions below and try again <<<", '+', '-'));
            setAppDirectoryPath();
        }else {
            if (new File(tempPath).exists() && new File(tempPath).isDirectory()){
                setCurrentDirectoryPath(tempPath);
                setAbsoluteAppDirectoryPath(tempPath);
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Thanks for setting the absolute working directory path <<<", '-', '-'));
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> The path is: " + tempPath + " <<<", '-', '-'));
            }else{
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Seams your input was invalid <<<", '-', '-'));
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Check the instructions below and try again <<<", '-', '-'));
                setAppDirectoryPath();
            }
        }
    }




    // User input methods to take input and validate input
    // For this to work every other method calling those methods have to have min and max values

    private static String getUserInput(){
        String userInputString;
        Scanner scanner = new Scanner(System.in);
        userInputString = scanner.next();
        //scanner.close(); This was causing issues

        return userInputString;
    }

    private static boolean isInteger(String stringToCheck){
        if (stringToCheck == null){
            return false;
        }
        try {
            int integerNumber = Integer.parseInt(stringToCheck);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    private static boolean isInRange(int numberToTest, int min, int max){
        if (numberToTest >= min && numberToTest <= max){
            return true;
        }else{
            return false;
        }
    }

    private static int userInput(int min, int max){
        String userInputString = getUserInput();
        int userInputInteger;
        if (isInteger(userInputString)){
            userInputInteger = Integer.parseInt(userInputString);
            if (isInRange(userInputInteger, min, max)){
                // Message for valid input
                System.out.println("");
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> You entered: > " + userInputInteger + " < which is a valid option <<<", '-', '-'));
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Thanks For Your Input <<<", '-', '-'));
                //System.out.println("");
                return userInputInteger;
            }else{
                // Message for wrong input
                System.out.println("");
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> You entered: > " + userInputInteger + " < which is an invalid option <<<", '-', '-'));
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Please try again <<<", '-', '-'));
                //System.out.println("");

                mainMenuMessage();
                userInputInteger = userInput(min, max);
                return userInputInteger;
            }
        }else{
            // Message for wrong input
            System.out.println("");
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> You entered: > " + userInputString + " < which is an invalid option <<<", '-', '-'));
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Please try again <<<", '-', '-'));
            //System.out.println("");

            mainMenuMessage();
            userInputInteger = userInput(min, max);
            return userInputInteger;
        }
    }


    // mainMenuMessage method
    private static void mainMenuMessage(){
        // Message
        String firstLine = "[ Main Menu ]";
        String userInputLine = "Please enter your choice here: ";
        String lastLine = "[ Please Enter Your Choice Below ]";

        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[1] File Explorer", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[2] Update working directory path", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[3] Developer Info", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[4] Restart App", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[5] Exit App", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line
    }
    // mainMenuFunctionality that contains the message call too
    private static void mainMenu(){

        mainMenuMessage();

        int min = 1;
        int max = 5;

        int option;

        //Getting validated option from user
        option = userInput(min, max);

        switch (option){
            case 1:
                filesExplorer();
                break;
            case 2:
                //updateWorkingDirectoryPath();
                break;
            case 3:
                developerInfo();
                break;
            case 4:
                //restartApp();
                break;
            case 5:
                //exitApp();
                break;
        }
    }




    // FilesExplorer method
    private static void filesExplorer(){

        String firstLine = "[ File Explorer ]";
        String userInputLine = "Please enter your choice here: ";
        String lastLine = "[ Please Enter Your Choice Below ]";

        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        File directoryPath = new File(absoluteAppDirectoryPath);

        File filesList[] = directoryPath.listFiles();


        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "Select a file for details and more options:", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        int numbering = 1;
        for (int i = 0; i < filesList.length; i++){
            //System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(i+1)+"] "+ filesList[i].getName() +  " --> " + filesList[i].getAbsolutePath(), '|', ' '));
            System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(i+1)+"] "+ filesList[i].getName() +  "", '|', ' '));
            numbering++;
        }
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "General File Explorer options:", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(numbering++)+"]" + " Go to Main Menu", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(numbering++)+"]" + " Create a file", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(numbering++)+"]" + " Sort file ascending", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(numbering++)+"]" + " Sort file descending", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(numbering++)+"]" + " Search folder", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(numbering++)+"]" + " Exit App", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line


        // Down below, we need user input and functionality

    }

    //UpdateTheDirectoryPath
    private static void updateTheDirectoryPath(){
        // I will need it if I decide to have an option for going through folders
    }








    //Old methods not in use anymore
    private static void goodbyeOldMethod(){
        // Initial setup to make the Goodbye box
        String firstLine = "-------------------------[Goodbye]--------------------------";
        String thankYouLine = "Thanks for trying my app!!!";
        String seeYouLine = "See you next time!!!";
        String lastLine = "---------------------------*****----------------------------";
        int boxWidth = firstLine.length();

        // Down below is the code for center align the thankYouLine
        int indentBefore1;
        int indentAfter1;
        if ((thankYouLine.length())%2 == 0){
            indentBefore1 = (((boxWidth+thankYouLine.length())/2) - 1);
            indentAfter1 = (((boxWidth-thankYouLine.length())/2)-1);
        }else {
            indentBefore1 = (((boxWidth+thankYouLine.length())/2) - 1);
            indentAfter1 = ((boxWidth-thankYouLine.length())/2) - 2;
        }

        // Down below is the code for center align the seeYouLine
        int indentBefore2;
        int indentAfter2;
        if ((seeYouLine.length())%2 == 0){
            indentBefore2 = (((boxWidth+seeYouLine.length())/2) - 1);
            indentAfter2 = (((boxWidth-seeYouLine.length())/2)-1);
        }else {
            indentBefore2 = (((boxWidth+seeYouLine.length())/2) - 1);
            indentAfter2 = ((boxWidth-seeYouLine.length())/2) - 2;
        }

        // Those are the print statements to make the Goodbye box
        System.out.printf("\n+%"+firstLine.length()+"s+ \n", firstLine);
        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "");

        String formatString1 ="| %" + indentBefore1 + "s" + " %" + indentAfter1 + "s |";
        System.out.println(String.format(formatString1, thankYouLine, ""));

        String formatString2 ="| %" + indentBefore2 + "s" + " %" + indentAfter2 + "s |";
        System.out.println(String.format(formatString2, seeYouLine, ""));

        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "");
        System.out.printf("+%"+firstLine.length()+"s+ \n", lastLine);

        //System.out.println(String.format("| %20s %20s |", "Thanks", ""));
    }
    private static void mainMenuOldMethod(){
        String firstLine = "--------------------------------[Main Menu]--------------------------------";
        String developerLine = "Application Developer : " + developerName;
        String applicationLine = "Application Name: " + appName;
        String lastLine = "-----------------------------------*****-----------------------------------";

        System.out.printf("\n+%"+firstLine.length()+"s+ \n", firstLine);
        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "");

        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "[1] File Explorer");
        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "[2] List of Files");
        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "[3] Actions for Files");
        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "[4] Update the Folder Path");
        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "[5] Exit");
        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "");

        //System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", "");
        //System.out.printf("| %-"+(firstLine.length()-2)+"s |", "Please enter your option: ");
        //System.out.printf("\n| %-"+(firstLine.length()-2)+"s |\n", "");

        System.out.printf("+%"+firstLine.length()+"s+ \n", lastLine);
        System.out.print("Please enter your option: ");


    }



}
