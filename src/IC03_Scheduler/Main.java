package IC03_Scheduler;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] appointments = new String[6];
        String name;
        Scanner keyboard = new Scanner(System.in);
        int time, count = 0;
            do {
                try {
                    System.out.print("What time (1-6pm) would you like to schedule an appointment: ");
                    time = keyboard.nextInt();

                    if (time > appointments.length || time < 1)
                        throw new InvalidTimeException();

                    //generate a new exception object:
                    if (appointments[time - 1] != null)
                        throw new TimeInUseException();

                    keyboard.nextLine();
                    System.out.print("Enter name of person reserving this appointment: ");
                    name = keyboard.nextLine();

                    appointments[time - 1] = name;
                    count++;

                    for (int i = 0; i < appointments.length; i++) {
                        System.out.print((i + 1) + ":00 pm: ");
                        if (appointments[i] == null) {
                            System.out.println("[empty]");
                        } else {
                            System.out.println(appointments[i]);
                        }
                    }

                }catch (TimeInUseException | InvalidTimeException e) {
            System.out.println(e.getMessage());
        }
    } while (count<appointments.length);


        System.out.println("All appointments have been booked!");
    }
}
