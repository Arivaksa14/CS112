package SI_GitHubIssues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static final String FILE_NAME = "issues.csv";

    public static void main(String[] args){
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,year;
        String[] parts;
        String line,name="", maxName="",minName="";
        int count;

        try{

            Scanner file=new Scanner(new File(FILE_NAME));
            file.nextLine();

            while (file.hasNextLine()) {

                line = file.nextLine();
                parts = line.split(",");
                count=Integer.parseInt(parts[3]);
                name = parts[0];
                year=Integer.parseInt(parts[1]);
                if(year==2021){
                if(count>max){
                    max=count;
                    maxName=name;
                }
                if(count<min){
                    min=count;
                    minName=name;
                }
            }
            }

            file.close();
            System.out.println("The most used language of 2021 is "+maxName);
            System.out.println("The least used language of 2021 is "+minName);

            }catch(FileNotFoundException e){
            System.out.println("Error: could not locate file: ");


        }}}
