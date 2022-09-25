package com.lockersPvtLtd.application;


public class VirtualKeyForYourRepositories {

    static String appName = "Virtual Key For Your Repositories";
    static String developerName = "Drazen Drinic";

    public static void main(String[] args) {

        Welcome();
        Goodbye();

    }

    private static void Welcome(){
        String firstAndLastLine = "-----------------------------------*****-----------------------------------";
        String developerLine = "Application Developer : " + developerName;
        String applicationLine = "Application Name: " + appName;

        System.out.printf("\n+%"+firstAndLastLine.length()+"s+ \n", firstAndLastLine);
        System.out.printf("| %-"+(firstAndLastLine.length()-2)+"s |\n", "");
        System.out.printf("| %-"+(firstAndLastLine.length()-2)+"s |\n", developerLine);
        System.out.printf("| %-"+(firstAndLastLine.length()-2)+"s |\n", applicationLine);
        System.out.printf("| %-"+(firstAndLastLine.length()-2)+"s |\n", "");
        System.out.printf("+%"+firstAndLastLine.length()+"s+ \n", firstAndLastLine);
    }

    private static void Goodbye(){
        // Initial setup to make the Goodbye box
        String firstAndLastLine = "-----------------------------------*****-----------------------------------";
        String thankYouLine = "Thanks for trying my app!!!";
        String seeYouLine = "See you next time!!!";
        int boxWidth = firstAndLastLine.length();

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
        System.out.printf("\n+%"+firstAndLastLine.length()+"s+ \n", firstAndLastLine);
        System.out.printf("| %-"+(firstAndLastLine.length()-2)+"s |\n", "");

        String formatString1 ="| %" + indentBefore1 + "s" + " %" + indentAfter1 + "s |";
        System.out.println(String.format(formatString1, thankYouLine, ""));

        String formatString2 ="| %" + indentBefore2 + "s" + " %" + indentAfter2 + "s |";
        System.out.println(String.format(formatString2, seeYouLine, ""));

        System.out.printf("| %-"+(firstAndLastLine.length()-2)+"s |\n", "");
        System.out.printf("+%"+firstAndLastLine.length()+"s+ \n", firstAndLastLine);

        //System.out.println(String.format("| %20s %20s |", "Thanks", ""));
    }

}
