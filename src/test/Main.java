package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){

    try{
        String name="";

        Scanner file=new Scanner(new File("input.txt"));

        int count=0;

        while(file.hasNextLine()){
            name=file.nextLine();
            count++;

        }
        file.close();

        System.out.println("This file contains "+count +" names.");

    }catch(FileNotFoundException e) {
        System.out.println("Error opening: "+e.getMessage());

    }
    }
}
