package com.lockersPvtLtd.application;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VirtualKeyForYourRepositories {

    // Path variables
    static String currentDirectoryPath; //It is the path which changes as we navigate through file explorer
    static String absoluteAppDirectoryPath; //It is the constant path provided by the user and can only be changed through main menu by selection of option “Change Path”.

    // Other global variables
    static String appName = "Virtual Key For Your Repositories";
    static String gitHubAppLink = "https://github.com/Drazen-BBG/SimpliLearn_OOPS_Project";
    static String developerName = "Drazen Drinic";
    static String developerLinkedin = "https://www.linkedin.com/in/drazendrinic/";
    static int consoleBoxWidth = 90; //Suggested minimum is 90
    static int numberingInFileExplorer = 0; //

    //Path getters and setters
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

    //Start App method
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
    private static void exitApp(){
        goodbyeMessage();
        System.exit(0);
    }

    //Wait seconds method to delay execution of the code
    private static void waitSeconds(int waitSeconds){

        int milliSeconds = 1000 * waitSeconds;
        try {
            Thread.sleep( milliSeconds);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    // LineBuilder methods to build lines in the console, for better presentation
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
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubLine + " " + gitHubAppLink, '|', ' '));
        //Below is the code in case you want to print the GitHub link in new line
        //System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubAppLink, '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
    }
    //Goodbye method is called when we want to exit the program
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
    //Developer info method to display developer info
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
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubLine + " " + gitHubAppLink, '|', ' '));
        //Below is the code in case you want to print the GitHub link in new line
        //System.out.println(lineBuilderLeftAligned(consoleBoxWidth, gitHubAppLink, '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));


        waitSeconds(5);
        mainMenu();
    }


    // SetWorkingDirectoryPath method, comes after the Welcome method, and it sets the path for the user app directory
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
    // mainMenu method
    private static void mainMenu(){

        mainMenuMessage();

        int min = 1;
        int max = 5;

        int option;

        //Getting validated option from user
        option = userInput(min, max);

        switch (option){
            case 1:
                fileExplorer();
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



    //getFileListFromFolder method takes a path and lists the content of the folder in that path
    private static File[] getFileListFromFolder(String path){
        File directoryPath = new File(path);
        File filesList[] = directoryPath.listFiles();
        return filesList;
    }




    //This is actually old filesExplorer
    private static void fileExplorerMessage(){

    }

    // FilesExplorer method
    private static void fileExplorer(){

        //Restarting the numbering on each fileExplorer call
        numberingInFileExplorer = 0;

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
        int loopIterations = 0;
        if (getFileListFromFolder(currentDirectoryPath) != null && getFileListFromFolder(currentDirectoryPath).length > 0){
            for (File file : getFileListFromFolder(currentDirectoryPath)){
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

        // Down below, we need user input and functionality
        // if selection is folder than list it

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
                fileExplorer();
                break;
            case 4:
                //Sort file ascending;
                break;
            case 5:
                //Sort file descending
                break;
            case 6:
                //Search folder
                break;
        }

        //Files and Folders Menu
        //workflow fo options related to files
        if (option>6 && option<=numberingInFileExplorer){
            //Need to code the algorithm how to select the file or folder related to the option
            File fileToProcess = getFileListFromFolder(currentDirectoryPath)[(option-(numberingInFileExplorer-loopIterations))-1];

            //Code direction depending on option, if the option relates to a folder or to a file
            if (fileToProcess.isDirectory()){
                //If option selected is a folder
                //setCurrentDirectoryPath
                //Call filesExplorer for that folder
                setCurrentDirectoryPath(fileToProcess.getPath());
                goIntoDirectory();
            }else {
                fileDetails(fileToProcess);
            }
        }
    }



    //File details methods for the selection of files in the fileExplorer

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
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[2]" + " Go to parent directory", '|', ' '));
        System.out.println(lineBuilderLeftAligned(consoleBoxWidth, "[3]" + " Delete file", '|', ' '));

        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(lineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        //System.out.println(userInputLine); // Input in next line
        System.out.print(userInputLine); // Input in same line


        //Make code for file details functionality include go to parent - go back, delete
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
                goToParentDirectory();
                break;
            case 3:
                deleteFile(fileToProcess);
                waitSeconds(2);
                fileExplorer();
                break;
        }

    }
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
                    fileExplorer();
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
    private static void deleteFile(File fileToProcess){
        Path path = Paths.get(fileToProcess.getAbsolutePath());
        double fileSize = 0;
        try {
            fileSize = Files.size(path);
        }catch (IOException e){
            e.printStackTrace();
            //Make a code to try again
        }
        double fileSizeInKiloBytes = fileSize/2024;

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

        int min = 1;
        int max = 2;

        int option;

        //Getting validated option from user
        option = userInput(min, max);

        switch (option) {
            case 1:
                deleteFileProtocol(fileToProcess);
                break;
            case 2:
                fileDetails(fileToProcess);
                break;
        }
    }
    private static void deleteFileProtocol(File fileToProcess){
        File fileToDelete = new File(fileToProcess.getAbsolutePath());
        if (fileToDelete.delete()){
            System.out.println();
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Your file: " +  fileToProcess.getName() + " was deleted. <<<", '-', '-'));
        }else {
            System.out.println();
            System.out.println(lineBuilderCenterAligned(consoleBoxWidth, ">>> Your file: " +  fileToProcess.getName() + " was NOT created. <<<", '-', '-'));
        }
    }


    private static void goToParentDirectory(){
        Path path = Paths.get(currentDirectoryPath);
        Path parentPath = path.getParent();
        setCurrentDirectoryPath(parentPath.toString());
        fileExplorer();
    }

    private static void goIntoDirectory(){
        //We need to change the currentDirectoryPath before calling this method, since this method is just calling the fileExplorer
        fileExplorer();
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
