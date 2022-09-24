package com.lockersPvtLtd.application;


import java.sql.SQLOutput;
import java.text.Format;

public class VirtualKeyForYourRepositories {

    public static void main(String[] args) {

        Welcome();

    }

    private static void Welcome(){
        String firstLine = "-----------------------------------***-----------------------------------"; // Length is 65 in total
        String developerLine = "Application Developer : Drazen Drinic";
        String applicationLine = "Application Name: Virtual Key For Your Repositories Application";
        String lastLine = "-----------------------------------***-----------------------------------";

        System.out.printf("\n\n+%"+firstLine.length()+"s+ \n", firstLine);
        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", developerLine);
        System.out.printf("| %-"+(firstLine.length()-2)+"s |\n", applicationLine);
        System.out.printf("+%"+firstLine.length()+"s+ \n\n", lastLine);
    }

/*    public static String CreateLine(String line, String firstLineForLength){



        return
    }*/


}
