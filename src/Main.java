import java.util.*;

public class Main {

    public static void main(String[] args) {

        int choice = 0;
        int whichDay = 0;
        Schedule monday = new Schedule("Monday");
        Schedule tuesday = new Schedule("Tuesday");


        while (choice != 7){

            choice = displayMenu();

            switch (choice){
                case 1: // Schedule an Event
                    whichDay = whichDay();
                    if (whichDay == 1)
                        add_event(monday);
                    else
                        add_event(tuesday);
                    break;
                case 2: // Cancel an Event
                    whichDay = whichDay();
                    if (whichDay == 1)
                        cancel_event(monday);
                    else
                        cancel_event(tuesday);
                    break;
                case 3: // Move scheduled event
                    break;
                case 4: // Display current Schedule
                    break;
                case 5: // See Booked events
                    break;
                case 6: // See Free time slot
                    break;
                case 7: // Quit
                    System.out.print("Thank you for using the Scheduler!");
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }//end switch

        }


    } // end driver

    public static void cancel_event(Schedule day) {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Event's name: ");
        name = sc.next();

        if (day.cancel(name)){
            System.out.println("Event "+name+" cancelled");
        } else {
            System.out.println("ERROR: Event not found.");
        }

    } // end method cancel_event

    public static void add_event(Schedule day) {

        Scanner sc = new Scanner(System.in);
        String name;
        int start;
        int end;

        System.out.println("Event's name: ");
        name = sc.next();

        System.out.println("Event's start time: ");
        start = sc.nextInt();

        System.out.println("Event's end time: ");
        end = sc.nextInt();

        Event new_event = new Event(name, start, end);

        if (day.addEvent(new_event) != null){
            System.out.println("Event was not scheduled due to conflict");
        } else {
            System.out.println("Event scheduled.");
        }

    } // end method add_schedule


    public static int whichDay() {
        Scanner sc = new Scanner(System.in);
        int a = 0;

        System.out.println("Which day to edit?");
        System.out.println("1) Monday");
        System.out.println("2) Tuesday");
        a = sc.nextInt();

        return a;
    } // end method whichDay

    public static int displayMenu() {

        Scanner sc = new Scanner(System.in);
        int a = 0;

        System.out.println("Welcome to your Scheduler! make and edit your plans for Monday and Tuesday.");
        System.out.println("1) Schedule an Event");
        System.out.println("2) Cancel an Event");
        System.out.println("3) Move scheduled event");
        System.out.println("4) Display current Schedule");
        System.out.println("5) See Booked events");
        System.out.println("6) See Free time slot");
        System.out.println("7) Quit");
        a = sc.nextInt();

        return a;
    } // end method displayMenu

} // end class Main