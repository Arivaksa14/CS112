package IC06_TaskList;

import java.io.*;
import java.util.Scanner;


        public class Main {

            //For reading:
            //BufferedReader and Scanner

            //For writing:
            //PrintWriter or BufferedWriter

//.bin,.dat,.exe= binary data file

            //For binary data:
            //ObjectInputStream =reading
            //ObjectOutputStream =writing

            public static void main(String[] args) {
                String deadline,dueDate,name;
                int priority;
                Task[] taskList=new Task[10];
                int count=0;

                Scanner keyboard=new Scanner(System.in);
                File binaryFile=new File("Tasks.dat");

                //check to see if the file exists and check if it has non-zero file size
                System.out.println("Previously saved tasks from binary file: ");
                //long is a longer integer=64 byte
                if (binaryFile.exists() && binaryFile.length()>1L){
                    //TO-DO: Magic
                    try {
                        ObjectInputStream fileReader=new ObjectInputStream(new FileInputStream(binaryFile));
                        //Read the entire array into the dogPound
                        //readObject returns Object
                        taskList =(Task[])fileReader.readObject();
                        while(taskList[count]!=null){
                            System.out.println(taskList[count++]);

                        }

                        fileReader.close();
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error: "+e.getMessage());
                    }
                }else{
                    System.out.println("[None, please enter new Tasks]");
                }
                do{
                    System.out.println("Please enter task name (or \"quit\" to exit): ");
                    name=keyboard.nextLine();
                    if(name.equalsIgnoreCase("quit"))
                        break;
                    System.out.println("Please enter due date (in form MM/DD/YYY): ");
                    dueDate=keyboard.nextLine();

                    System.out.println("Please enter deadline: ");
                    deadline=keyboard.nextLine();

                    System.out.println("Please enter priority: ");
                    priority=keyboard.nextInt();

                    taskList[count++]=new Task(deadline,dueDate,name,priority);

                    keyboard.nextLine();

                } while(true);
                //After the user handles quit:
                try {
                    ObjectOutput fileWriter=new ObjectOutputStream(new FileOutputStream(binaryFile));
                    fileWriter.writeObject(taskList);
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error: "+e.getMessage());
                }


            }}




