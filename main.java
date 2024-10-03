import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) throws Exception {
        System.out.print("Please select a task number from the options below\n");
        ArrayList<String> tasks = taskList();
        for (String task : tasks) {
            System.out.println("\t" + task);
        }
        // Before capturing the input, we want a valid checker. This will prevent the system from crashing by rejecting invalid inputs
        boolean validTask = false;
        int task = 0;
        while (!validTask) {
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                task = input.nextInt();
                validTask = true;
            } else {
                System.out.println("You have tried to enter something other than a number, please enter a number between 1 and 6");
            }
            if (task < 0 || task > 6) {
                System.out.println("Please enter a valid task number between 1 and 6");
                validTask = false;
            }
        }
        TimeManager timeManager = new TimeManager();
        // With a valid option we can proceed
        if (task == 1){
            // As the TimeManager handles all checking we will accept any integer given at this stage.
            System.out.println("Please enter a value for hours");
            Scanner input = new Scanner(System.in);
            int hours = input.nextInt();
            System.out.println("Please enter a value for minutes");
            int minutes = input.nextInt();
            System.out.println("Please enter a value for seconds");
            int seconds = input.nextInt();
            timeManager.processTime(hours, minutes, seconds);
        }
        else if (task == 2){
            // Generate one random instance of time
            timeManager.randomTime();
        }
        else if (task == 3){
            // Generate two instances of random time.
            int instances = 2;
            timeManager.randomMultipleTime(instances);
        }
        else if (task == 4){
            // Generate a random number of instances of random time
            Random rand = new Random();
            int low = 1;
            System.out.println("Please enter the maximum number of time instances you'd like to generate: ");
            Scanner input = new Scanner(System.in);
            int max = input.nextInt();
            int instances = rand.nextInt(max-low);
            timeManager.randomMultipleTime(instances);
        }
        else if (task == 5){
            /* As this question requires the user to iteratively input a limited number of values for total seconds then convert to HH:MM:SS we give the user more control
            They are able to enter a lower bound, an upper bound and how many iterations they want
             */
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the lowest value you'd like to enter: ");
            int low = input.nextInt();
            System.out.println("Please enter the highest value you'd like to enter: ");
            int high = input.nextInt();
            System.out.println("Please enter how many iterations you'd like to complete: ");
            int iterations = input.nextInt();

            for (int i = 0; i < iterations; i++) {
                System.out.println("Please enter the total seconds for iteration " + (i + 1) + ": ");
                int seconds = input.nextInt();
                while (seconds <= low || seconds >= high) {
                    System.out.println("Invalid input, please try again: ");
                    seconds = input.nextInt();
                }
                timeManager.calculateSeconds(seconds);
            }
        }

        if (task == 6){
            throw new Exception("You have ended the program. Have a good day.");
        }
    }






    private static ArrayList<String> taskList() {
        ArrayList<String> tasks = new ArrayList<>();
        // All task that make up this assignment fall here
        tasks.add("1. Generate a valid time through user input.");
        tasks.add("2. Generate a valid randomly generated time.");
        tasks.add("3. Generate 2 valid randomly generated times.");
        tasks.add("4. Generate multiple valid randomly generated times.");
        tasks.add("5. Generate a valid time through a limited number of user generated total second values.");
        tasks.add("6. Cancel and close the program.");
        return tasks;
    }
}
