package IC03_Scheduler;

public class TimeInUseException extends Exception{

//Default constructor: no parameters
    public TimeInUseException(){

       super("The time slot has already been used. Please try another.");
    }
}
