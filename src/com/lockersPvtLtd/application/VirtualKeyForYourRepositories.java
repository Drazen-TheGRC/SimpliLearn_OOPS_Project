package com.lockersPvtLtd.application;


import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VirtualKeyForYourRepositories {

    static String directoryPath; //It is the path which changes as we navigate through file explorer
    static String absoluteAppDirectoryPath; //It is the constant path provided by the user and can only be changed through main menu by selection of option “Change Path”.

    public static String getDirectoryPath() {
        return directoryPath;
    }

    public static void setDirectoryPath(String directoryPath) {
        VirtualKeyForYourRepositories.directoryPath = directoryPath;
    }

    public static String getAbsoluteAppDirectoryPath() {
        return absoluteAppDirectoryPath;
    }

    public static void setAbsoluteAppDirectoryPath(String absoluteAppDirectoryPath) {
        VirtualKeyForYourRepositories.absoluteAppDirectoryPath = absoluteAppDirectoryPath;
    }

    // Other global variables
    static String appName = "Virtual Key For Your Repositories";
    static String developerName = "Drazen Drinic";
    static int consoleBoxWidth = 70; //Suggested minimum is 60
    static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {




        Welcome();
        SetWorkingDirectoryPath();
        MainMenu();



    }

    //Welcome method is the first method to call it greats the user, and after it comes the SetWorkingDirectoryPath method
    private static void Welcome(){
        String firstLine = "[ Welcome ]";
        String developerLine = "Application Developer : " + developerName;
        String applicationLine = "Application Name: " + appName;
        String lastLine = "[ Next steps are below ]";

        System.out.println();
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(LineBuilderLeftAligned(consoleBoxWidth, developerLine, '|', ' '));
        System.out.println(LineBuilderLeftAligned(consoleBoxWidth, applicationLine, '|', ' '));

        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
    }

    // SetWorkingDirectoryPath method comes after the Welcome method, and it sets the path for the user app directory
    static void SetWorkingDirectoryPath() {
        String firstLine = "[ Setting Absolute Working Directory Path ]";
        String userInputLine = ">>> Please enter your directory path here: ";
        String lastLine = "[ Now we need to past or enter the path down below ]";

        System.out.println();
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, " Create a folder anywhere on your PC ", '|', ' '));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, " Click on the folder icon in the address bar ", '|', ' '));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, " Copy the address link ", '|', ' '));

        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        System.out.print("Please enter your absolute working directory path here: ");

        String tempPath =scanner.next();

        System.out.println("");

        if(Pattern.matches("((\\/)+|(\\\\)+)", tempPath)) {
            System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "[ Seams your input was invalid ]", '+', '-'));
            System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "[ Check the instructions below and try again ]", '+', '-'));
            SetWorkingDirectoryPath();
        }else {
            if (new File(tempPath).exists() && new File(tempPath).isDirectory()){
                setDirectoryPath(tempPath);
                setAbsoluteAppDirectoryPath(tempPath);
                System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "[ Thanks for setting the absolute working directory path ]", '+', '-'));
                System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "[ The path is: " + tempPath + " ]", '+', '-'));
            }else{
                System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "[ Seams your input was invalid ]", '+', '-'));
                System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "[ Check the instructions below and try again ]", '+', '-'));
                SetWorkingDirectoryPath();
            }
        }
    }



    // Main method is the third must call method, it provides the Main Menu from where everything starts
    private static void MainMenu(){
        String firstLine = "[ Main Menu ]";
        String userInputLine = ">>> Please enter your choice here: ";
        String lastLine = "[ Please Enter Your Choice Below ]";

        System.out.println();
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(LineBuilderLeftAligned(consoleBoxWidth, "[1] File Explorer", '|', ' '));
        System.out.println(LineBuilderLeftAligned(consoleBoxWidth, "[2] List of Files", '|', ' '));
        System.out.println(LineBuilderLeftAligned(consoleBoxWidth, "[3] Actions for Files", '|', ' '));
        System.out.println(LineBuilderLeftAligned(consoleBoxWidth, "[4] Update the Folder Path", '|', ' '));
        System.out.println(LineBuilderLeftAligned(consoleBoxWidth, "[5] Exit", '|', ' '));


        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        System.out.println();

        System.out.print("Please enter your option: ");

        int x =scanner.nextInt();

        System.out.println("");

        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "[ Thanks For Your Input ]", '+', '-'));

    }

    // FilesExplorer method
    private static void FilesExplorer(){

    }

    // ListOfFiles
    private static void ListOfFiles(){

    }

    // ActionsForFiles
    private static void ActionsForFiles(){

    }

    //UpdateTheDirectoryPath
    private static void UpdateTheDirectoryPath(){

    }

    // Goodbye method is called when we want to exit the program
    private static void Goodbye(){
        String firstLine = "[ Goodbye ]";
        String lastLine = "***";

        System.out.println();
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, firstLine, '+', '-'));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));

        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "Thanks for trying my app!!!", '|', ' '));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "See you next time!!!", '|', ' '));

        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, "", '|', ' '));
        System.out.println(LineBuilderCenterAligned(consoleBoxWidth, lastLine, '+', '-'));
        //System.out.println();
    }


    // LineBuilder methods
    private static String LineBuilderCenterAligned(int lineLength, String mainString, char firstAndLastPlaceHolder, char mainPlaceHolder){
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
    private static String LineBuilderLeftAligned(int lineLength, String mainString, char firstAndLastPlaceHolder, char mainPlaceHolder){
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

    //Old methods not in use anymore
    private static void GoodbyeOldMethod(){
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
    private static void MainMenuOldMethod(){
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

        int x =scanner.nextInt();
    }



}
