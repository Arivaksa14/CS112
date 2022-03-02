package IC06_BinaryDog;
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
        String name,breed;
        int age;
        Dog[] dogPound=new Dog[10];
        int count=0;

        Scanner keyboard=new Scanner(System.in);
        File binaryFile=new File("Dogs.dat");

        //check to see if the file exists and check if it has non-zero file size
        System.out.println("Previously saved dogs from binary file: ");
        //long is a longer integer=64 byte
        if (binaryFile.exists() && binaryFile.length()>1L){
        //TO-DO: Magic
            try {
                ObjectInputStream fileReader=new ObjectInputStream(new FileInputStream(binaryFile));
                //Read the entire array into the dogPound
                //readObject returns Object
                dogPound =(Dog[])fileReader.readObject();
                while(dogPound[count]!=null){
                    System.out.println(dogPound[count++]);

                }

                fileReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }else{
            System.out.println("[None, please enter new dog data]");
        }
        do{
            System.out.println("Please enter dog's name (or \"quit\" to exit): ");
            name=keyboard.nextLine();
            if(name.equalsIgnoreCase("quit"))
                break;
            System.out.println("Please enter dog's breed: ");
            breed=keyboard.nextLine();
            System.out.println("Please enter dog's age: ");
            age=keyboard.nextInt();

            dogPound[count++]=new Dog(name,breed,age);
            keyboard.nextLine();

        } while(true);
    //After the user handles quit:
        try {
            ObjectOutput fileWriter=new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(dogPound);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }


    }}
