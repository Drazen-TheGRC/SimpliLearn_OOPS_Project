package com.lockersPvtLtd.application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

public class VirtualKeyForYourRepositories {



    // Path variables
    static String absoluteAppDirectoryPath; // It is the path provided by the user and can only be changed using setAppDirectoryPath() or updateAppDirectoryPath()
    static String currentDirectoryPath; // It is the path which changes as we navigate through fileExplorer by entering folders or by going to a parent folder

    // Path getters and setters
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




    // Other global variables
    static String appName = "Virtual Key For Your Repositories";
    static String gitHubAppLink = "https://github.com/Drazen-BBG/SimpliLearn_OOPS_Project";
    static String developerName = "Drazen Drinic";
    static String developerLinkedin = "https://www.linkedin.com/in/drazendrinic/";
    static int consoleBoxWidth = 90; //Suggested minimum is 90
    static int numberingInFileExplorer = 0;
    static int loopIterations = 0;




    // main()
    public static void main(String[] args) {
        startApp();
    }

    // startApp()
    private static void startApp(){
        //Clear the console code, having issues to make it work in IntelliJ IDEA
        System.out.print("\033[H\033[2J");
        System.out.flush();

        //Running the app
        welcomeMessage();
        waitSeconds(3);
        setAppDirectoryPath();
        mainMenu();

    }

    // exitApp()
    private static void exitApp(){
        goodbyeMessage();
        waitSeconds(3);
        System.exit(0);
    }

    // waitSeconds() delays execution of the code in seconds entered as parameter.
    private static void waitSeconds(int waitSeconds){

        int milliSeconds = 1000 * waitSeconds;
        try {
            Thread.sleep( milliSeconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }


    // lineBuilder methods help us to build lines in the console, for better presentation.
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


    // welcomeMessage() is the first method to call, it greats the user.
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
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubLine + " " + gitHubAppLink, '|', ' '));
        //Below is the code in case you want to print the GitHub link in new line
        //System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubAppLink, '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
    }

    //goodbyeMessage() is called when we want to exit the program
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

    // developerInfo() displays developer info
    private static void developerInfo(){
        String firstLine = "[ Developer Info ]";
        String userInputLine = "Please enter your choice here: ";
        String lastLine = "[ Next steps are below ]";

        String developerName = "App Developer : " + VirtualKeyForYourRepositories.developerName;
        String developerLinkedin = "LinkedIn: " + VirtualKeyForYourRepositories.developerLinkedin;
        String gitHubLine = "Application GitHub: ";


        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, developerName, '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, developerLinkedin, '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubLine + " " + gitHubAppLink, '|', ' '));
        //Below is the code in case you want to print the GitHub link in new line
        //System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubAppLink, '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[1] Main Menu", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[2] Exit App", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line

        int min = 1;
        int max = 2;

        int option;

        //Getting validated option from user
        option = userInput(min, max);

        switch (option){
            case 1:
                mainMenu();
                break;
            case 2:
                exitApp();
                break;
        }
    }


    // setAppDirectoryPathMessage() is a method used to separate message from functionality in the setAppDirectoryPath()
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
    // setAppDirectoryPath() sets the path for the app folder at the beginning of the program
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
    // updateAppDirectoryPathMessage() is a method used to separate message from functionality in the updateAppDirectoryPath()
    private static void updateAppDirectoryPathMessage(){
        String firstLine = "[ Updating Absolute Working Directory Path ]";
        String userInputLine = "Please paste or enter your absolute working directory path here: ";
        String lastLine = "[ Now we need to past or enter the path down below ]";

        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, " Step 1 > Find a folder on your PC you want to make app directory", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, " Step 2 > Open the folder and click on the folder icon in the address bar ", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, " Step 3 > Copy the address link so you can past it in the next step", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line
    }
    // updateAppDirectoryPath() is a method that gives user an option to change the absoluteAppDirectoryPath, and therefore it also updates the currentDirectoryPath
    private static void updateAppDirectoryPath() {

        updateAppDirectoryPathMessage();

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
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Thanks for updating the absolute working directory path <<<", '-', '-'));
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> The path is: " + tempPath + " <<<", '-', '-'));
            }else{
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Seams your input was invalid <<<", '-', '-'));
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Check the instructions below and try again <<<", '-', '-'));
                setAppDirectoryPath();
            }
        }
    }




    // User input methods to take input from user and to validate the input
    // For this to work every other method calling those methods have to have min and max values
    // userInput() is called in every other method when we need a user input, other related methods below are helper methods to make it all work
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

                mainMenuMessage(); //Need to pass this method as a parameter, so it can dynamically change depending on who is calling the userInput()
                userInputInteger = userInput(min, max);
                return userInputInteger;
            }
        }else{
            // Message for wrong input
            System.out.println("");
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> You entered: > " + userInputString + " < which is an invalid option <<<", '-', '-'));
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Please try again <<<", '-', '-'));
            //System.out.println("");

            mainMenuMessage(); //Need to pass this method as a parameter, so it can dynamically change depending on who is calling the userInput()
            userInputInteger = userInput(min, max);
            return userInputInteger;
        }
    }
    // getUserInput() takes user input as a string and sends it for further checks
    private static String getUserInput(){
        String userInputString;
        Scanner scanner = new Scanner(System.in);
        userInputString = scanner.next();
        //scanner.close(); This was causing issues

        return userInputString;
    }
    // isInteger() checks if the user input is integer
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
    // isInRange() method checks if the user input is in range of available options
    private static boolean isInRange(int numberToTest, int min, int max){
        if (numberToTest >= min && numberToTest <= max){
            return true;
        }else{
            return false;
        }
    }




    // mainMenuMessage() is a method used to separate message from functionality in the mainMenu()
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
    // mainMenu() method is the main menu presented to the user
    private static void mainMenu(){

        mainMenuMessage();

        int min = 1;
        int max = 5;

        int option;

        //Getting validated option from user
        option = userInput(min, max);

        switch (option){
            case 1:
                fileExplorer(getFileListFromFolder(currentDirectoryPath));
                break;
            case 2:
                updateAppDirectoryPath();
                mainMenu();
                break;
            case 3:
                developerInfo();
                break;
            case 4:
                startApp();
                break;
            case 5:
                exitApp();
                break;
        }
    }



    // getFileListFromFolder lists files and folders from the currentDirectoryPath and returns an array of Files
    private static File[] getFileListFromFolder(String path){
        File directoryPath = new File(path);
        File filesList[] = directoryPath.listFiles();
        return filesList;
    }

    private static File[] sortAscending(File[] fileListToSort){
        Arrays.sort(fileListToSort);
        return fileListToSort;
    }

    private static File[] sortDescending(File[] fileListToSort){

        Arrays.sort(fileListToSort, Collections.reverseOrder());
        return fileListToSort;
    }

    private static void searchFolder(File[] fileListToSearch){

        Scanner scanner = new Scanner(System.in);
        String nameToSearch =scanner.next();

        boolean foundIt = false;
        if (fileListToSearch == null){
            // Empty directory
        }else{
            for (int i = 0; i < fileListToSearch.length; i++) {
                String fileName = fileListToSearch[i].getName();
                if (fileName.equalsIgnoreCase(nameToSearch)){
                    // code if file found and change foundIt to true
                    foundIt = true;
                }
            }
        }
        if (foundIt == false){
            // code for file not found
        }
    }


    // fileExplorerMessage() is a method used to separate message from functionality in the fileExplorer()
    private static void fileExplorerMessage(File[] inputFileListToExplore){

        File[] fileListToExplore = inputFileListToExplore;

        //creating the console look
        String firstLine = "[ File Explorer ]";
        String userInputLine = "Please enter your choice here: ";
        String lastLine = "[ Please Enter Your Choice Below ]";

        //Top of the box in the console
        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        //Main content of the box in the console
        //General File Explorer options
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "General File Explorer options:", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numberingInFileExplorer)+"]" + " Go to Main Menu", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numberingInFileExplorer)+"]" + " Go to parent directory", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numberingInFileExplorer)+"]" + " Create a file", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numberingInFileExplorer)+"]" + " Sort file ascending", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numberingInFileExplorer)+"]" + " Sort file descending", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numberingInFileExplorer)+"]" + " Search folder", '|', ' '));

        //File
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "Select a file for details and more options:", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        //Convert this below in a method if possible

        if (fileListToExplore != null && fileListToExplore.length > 0){
            for (File file : fileListToExplore){
                ++loopIterations;
                // Check if the file is a directory
                if (file.isDirectory()){
                    System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numberingInFileExplorer)+"]" + " " + file.getName() + " [Folder]", '|', ' '));
                }else {
                    System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numberingInFileExplorer)+"]" + " " + file.getName(), '|', ' '));
                }
            }
        }

        //Bottom of the box in the console
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();



        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line
    }
    // fileExplorerMessage() is a method used to separate message from functionality in the fileExplorer()
    private static void fileExplorer(File[] inputFileListToExplore){

        File[] fileListToExplore = inputFileListToExplore;
        //Restarting the numberingInFileExplorer and loopIterations on each fileExplorer() call
        numberingInFileExplorer = 0;
        loopIterations = 0;

        fileExplorerMessage(fileListToExplore);

        int min = 1;
        int max = numberingInFileExplorer;

        int option;

        option = userInput(min, max);

        //Switch General menu
        switch (option){
            case 1:
                mainMenu();
                break;
            case 2:
                goToParentDirectory();
                break;
            case 3:
                crateFile();
                waitSeconds(2);
                fileExplorer(getFileListFromFolder(currentDirectoryPath));
                break;
            case 4:

                fileExplorer(sortAscending(getFileListFromFolder(currentDirectoryPath)));
                break;
            case 5:

                fileExplorer(sortDescending(getFileListFromFolder(currentDirectoryPath)));
                break;
            case 6:
                //Search folder
                break;
        }

        //Files and Folders Menu control down below
        if (option>6 && option<=numberingInFileExplorer){
            File fileToProcess = fileListToExplore[(option-(numberingInFileExplorer-loopIterations))-1];
            if (fileToProcess.isDirectory()){
                // If option selected is a folder
                // setCurrentDirectoryPath
                setCurrentDirectoryPath(fileToProcess.getPath());
                // Go into the folder using previously set path
                goIntoDirectory();
            }else {
                // If bot a folder it must be than a file so let's see its details using the fileDetails() method
                fileDetails(fileToProcess);
            }
        }
    }


    // fileDetailsMessage() is a method used to separate message from functionality in the fileDetails()
    private static void fileDetailsMessage(File fileToProcess, double fileSizeInKiloBytes){
        //creating the console look
        String firstLine = "[ File details ]";
        String userInputLine = "Please enter your choice here: ";
        String lastLine = "[ Please Enter Your Choice Below ]";


        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "File name: " + fileToProcess.getName() +  "", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "File path: " + fileToProcess.getAbsolutePath() +  "", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "File size: " + String.format("%.5f", fileSizeInKiloBytes)  + " kilobytes" , '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[1]" + " Go to Main Menu", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[2]" + " Exit details", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[3]" + " Delete file", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line
    }
    // fileDetails() lists the details of a selected file and offers an option to delete the file
    private static void fileDetails(File fileToProcess){
        Path path = Paths.get(fileToProcess.getAbsolutePath());
        double fileSize = 0;
        try {
            fileSize = Files.size(path);
        }catch (IOException e){
            e.printStackTrace();
            //Make a code to try again
        }
        double fileSizeInKiloBytes = fileSize/2024;

        // fileDetailsMessage()
        fileDetailsMessage(fileToProcess, fileSizeInKiloBytes);

        int min = 1;
        int max = 3;

        int option;

        //Getting validated option from user
        option = userInput(min, max);

        switch (option) {
            case 1:
                mainMenu();
                break;
            case 2:
                fileExplorer(getFileListFromFolder(currentDirectoryPath));
                break;
            case 3:
                deleteFileProtocol(fileToProcess);
                waitSeconds(2);
                fileExplorer(getFileListFromFolder(currentDirectoryPath));
                break;
        }
    }


    // createFileMessage() is a method used to separate message from functionality in the createFile()
    private static void createFileMessage(){
        //Message and console box
        String firstLine = "[ Create File ]";
        String userInputLine = "Please enter file name here: ";
        String lastLine = "[ Please Enter The File Name Below ]";

        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, " Step 1 > You will need to know the name for your file and its extension", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, " Step 2 > Write your file name in this format <fileName.extension>", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, " Example > MyTextFile.txt", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line
    }
    // createFile() creates a new file in the folder we were seeing using fileExplorer()
    private static void crateFile(){

        createFileMessage();

        //User input
        Scanner scanner = new Scanner(System.in);
        String fileName =scanner.next();

        try {
            File file = new File(currentDirectoryPath, fileName);
            if(!file.exists()) {
                if(file.createNewFile()) {
                    System.out.println();
                    System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Your file: " +  file.getName() + " was created. <<<", '-', '-'));
                    System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> The file path is: " + file.getAbsolutePath() + " <<<", '-', '-'));
                    waitSeconds(2);
                    fileExplorer(getFileListFromFolder(currentDirectoryPath));
                }else {
                    //If you can't create file
                    System.out.println();
                    System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Something went wrong!!! The file was not created. <<<", '-', '-'));
                    System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Please try again <<<", '-', '-'));
                    crateFile();
                }
            }else {
                //if already exists
                System.out.println();
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> File with this name already exists. <<<", '-', '-'));
                System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Please try again with a different name <<<", '-', '-'));
                crateFile();
            }
        }
        catch (IOException e){
            e.printStackTrace();
            crateFile();
        }
    }

    // deleteFileProtocolMessage() is a method used to separate message from functionality in the deleteFileProtocol()
    private static void deleteFileProtocolMessage(File fileToProcess, double fileSizeInKiloBytes){
        String firstLine = "[ Confirm you want to delete ]";
        String userInputLine = "Please enter your choice here: ";
        String lastLine = "[ Please Enter Your Choice Below ]";


        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "File name: " + fileToProcess.getName() +  "", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "File path: " + fileToProcess.getAbsolutePath() +  "", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "File size: " + String.format("%.5f", fileSizeInKiloBytes)  + " kilobytes" , '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[1] To CONFIRM deletion", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[2] To CANCEL deletion", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line
    }
    // deleteFileProtocol() organizes the whole thing about deleting the file using deleteFileProtocolMessage() and deleteFileExecution()
    private static void deleteFileProtocol(File fileToProcess){
        Path path = Paths.get(fileToProcess.getAbsolutePath());
        double fileSize = 0;
        try {
            fileSize = Files.size(path);
        }catch (IOException e){
            e.printStackTrace();
            //Make a code to try again
        }
        double fileSizeInKiloBytes = fileSize/2024;

        // deleteFileMessage()
        deleteFileProtocolMessage(fileToProcess, fileSizeInKiloBytes);

        int min = 1;
        int max = 2;

        int option;

        //Getting validated option from user
        option = userInput(min, max);

        switch (option) {
            case 1:
                deleteFileExecution(fileToProcess);
                break;
            case 2:
                fileDetails(fileToProcess);
                break;
        }
    }

    // deleteFileExecution() deletes the actual file the
    private static void deleteFileExecution(File fileToProcess){
        File fileToDelete = new File(fileToProcess.getAbsolutePath());
        if (fileToDelete.delete()){
            System.out.println();
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Your file: " +  fileToProcess.getName() + " was deleted. <<<", '-', '-'));
        }else {
            System.out.println();
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Your file: " +  fileToProcess.getName() + " was NOT created. <<<", '-', '-'));
        }
    }


    // goToParentDirectory()
    private static void goToParentDirectory(){
        Path path = Paths.get(currentDirectoryPath);
        Path parentPath = path.getParent();
        setCurrentDirectoryPath(parentPath.toString());
        fileExplorer(getFileListFromFolder(currentDirectoryPath));
    }
    // goIntoDirectory()
    private static void goIntoDirectory(){
        //We need to change the currentDirectoryPath before calling this method, since this method is just calling the fileExplorer
        fileExplorer(getFileListFromFolder(currentDirectoryPath));
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
    private static void filesExplorerOld(){
        String firstLine = "[ File Explorer ]";
        String userInputLine = "Please enter your choice here: ";
        String lastLine = "[ Please Enter Your Choice Below ]";

        int numbering = 0;

        System.out.println();
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "General File Explorer options:", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numbering)+"]" + " Go to Main Menu", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numbering)+"]" + " Create a file", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numbering)+"]" + " Sort file ascending", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numbering)+"]" + " Sort file descending", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numbering)+"]" + " Search folder", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(++numbering)+"]" + " Exit App", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));


        File directoryPath = new File(absoluteAppDirectoryPath);
        File filesList[] = directoryPath.listFiles();

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "Select a file for details and more options:", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));


        int loopRepetitions = 0;
        for (int i = 0; i < filesList.length; i++){
            numbering++;
            //System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(i+1)+"] "+ filesList[i].getName() +  " --> " + filesList[i].getAbsolutePath(), '|', ' '));
            System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "["+(numbering)+"] "+ filesList[i].getName() +  "", '|', ' '));
            loopRepetitions++;
        }

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line
    }
    private static void fileDetailsOld(String path, int index){
        File directoryPath = new File(absoluteAppDirectoryPath);
        File filesList[] = directoryPath.listFiles();

        //need index

        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, filesList[index].getName() +  "", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, filesList[index].getAbsolutePath() +  "", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, filesList[index].getAbsolutePath() +  "", '|', ' '));

    }
    private static int calculateIndexOldStuff(int option, int numbering, int loopRepetitions){
        int indexToReturn;
        indexToReturn = (option - (numbering - loopRepetitions))-1;
        return indexToReturn;
    }

}
