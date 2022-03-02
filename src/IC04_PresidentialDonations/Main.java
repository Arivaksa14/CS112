package IC04_PresidentialDonations;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static final String FILE_NAME = "PresidentialDonations2020.csv";
    public static final String[] candidateList = {"Bennet Michael F.","Biden Joseph R Jr","Booker Cory A.", "Bullock Steve","Buttigieg Pete",
            "Castro Julián","Delaney John K.","Gabbard Tulsi","Gillibrand Kirsten ","Gravel Maurice Robert","Harris Kamala D.","Hickenlooper John W.","Inslee Jay R","Klobuchar Amy J.",
            "Moulton Seth","Ojeda Richard Neece II","O’Rourke Robert Beto","Ryan Timothy J.","Sanders Bernard","Swalwell Eric Michael","Trump Donald J.", "Warren Elizabeth ", "Weld William Floyd (Bill)",
            "Williamson Marianne ","Yang Andrew","de Blasio Bill"};

    public static void main(String[] args) {

        for (int i = 0; i < candidateList.length; i++) {
            try {
                double contribution, max = Double.MIN_VALUE, min = Double.MAX_VALUE, sum = 0;
                int count = 0;
                String line, name = "";
                String[] parts;

                Scanner file = new Scanner(new File(FILE_NAME));
                //Skip the header:
                file.nextLine();

                while (file.hasNextLine()) {

                    line = file.nextLine();
                    parts = line.split(",");
                    name = parts[1];

                    if (candidateList[i].equalsIgnoreCase(name)) {

                        contribution = (parts[8] == null) ? contribution = 0.00 : Double.parseDouble(parts[8]);
                        if (contribution > 0) {
                            sum += contribution;
                            count++;
                            if (contribution > max) {
                                max = contribution;
                            }
                            if (contribution < min) {
                                min = contribution;
                            }
                        }

                    }
                    name = candidateList[i];
                }
                printResults(name, min, max, count, sum);
                file.close();

            } catch (FileNotFoundException e) {
                System.out.println("Error: could not locate file " + e.getMessage());

            }}
    }
    public static void printResults (String canName,double minContribution, double maxContribution,
                                     int numContributions, double totalContributions)
    {
        double averageContribution = totalContributions / numContributions;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("*********************************************");
        System.out.println("* 2020 Presidential Campaign Donations      *");
        System.out.println("*           for Candidate:                  *");
        System.out.printf("*%11s%-32s*%n", "", canName);
        System.out.print("*");
        System.out.println("********************************************");
        System.out.println("The Minimum Contribution was: " + currency.format(minContribution));
        System.out.println("The Maximum Contribution was: " + currency.format(maxContribution));
        System.out.println("The Average Contribution was: " + currency.format(averageContribution));
        System.out.println("The Number of Contribution were: " + NumberFormat.getNumberInstance().format(numContributions));
        System.out.println("The total amount contributed was: " + currency.format(totalContributions));

    }
}