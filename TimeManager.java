import java.util.Scanner;
import java.util.Random;

public class TimeManager extends Time {
    private final int minInt = 0;
    private final int maxIntHour = 23;
    private final int maxIntMinSec = 59;
    Time[] iterations;

    public Time processTime(int hour, int min, int sec) {
        // This is used as the backbone for all creations of time
        Scanner scanner = new Scanner(System.in);
        // Call the validate method for each time component
        hour = validateTimeComponent("hour", hour, minInt, maxIntHour, scanner);
        min = validateTimeComponent("minute", min, minInt, maxIntMinSec, scanner);
        sec = validateTimeComponent("second", sec, minInt, maxIntMinSec, scanner);

        Time time = new Time(hour, min, sec);
        time.getTime();
        return time;
    }

    public Time randomTime(){
        Random rand = new Random();
        // Create random, valid time instances for hour, minute, second
        int randomHour = rand.nextInt(maxIntHour - minInt);
        int randomMin = rand.nextInt(maxIntMinSec - minInt);
        int randomSec = rand.nextInt(maxIntMinSec - minInt);
        return processTime(randomHour, randomMin, randomSec);
    }

    public void randomMultipleTime(int instances){
        iterations = new Time[instances];
        for(int i = 0; i < instances; i++){
            iterations[i] = randomTime();
        }
        int calcHour = 0;
        int calcMin = 0;
        int calcSec = 0;

        for(int i = 0; i < instances; i++){
            calcHour += iterations[i].getHour();
            calcMin += iterations[i].getMinute();
            calcSec += iterations[i].getSecond();
        }
        normalizeAndDisplayTime(calcHour, calcMin, calcSec);
    }

    public void calculateSeconds(int seconds){
        int calcHour = seconds / 3600;
        int calcMin = (seconds % 3600) / 60;
        int calcSec = seconds % 60;

        normalizeAndDisplayTime(calcHour, calcMin, calcSec);
    }

    private void normalizeAndDisplayTime(int calcHour, int calcMinute, int calcSecond) {
        int tempDay = 0;

        if (calcSecond >= 60) {
            calcMinute += calcSecond / 60;
            calcSecond %= 60;
        }

        if (calcMinute >= 60) {
            calcHour += calcMinute / 60;
            calcMinute %= 60;
        }

        if (calcHour >= 24) {
            tempDay += calcHour / 24;
            calcHour %= 24;
        }

        if (tempDay >= 1) {
            System.out.println("There are more than 24 hours. To produce a valid time, " + (tempDay * 24) + " hours will be removed.");
        }

        System.out.println("Resulting time: ");
        processTime(calcHour, calcMinute, calcSecond);
    }


    private int validateTimeComponent(String component, int value, int minValue, int maxValue, Scanner scanner) {
        if (value < minValue || value > maxValue) {
            System.out.println("Invalid " + component + ": " + value + ". Would you like to try again? y/n");
            String answer = scanner.next();
            if (answer.startsWith("y") || answer.charAt(0) == 'y') {
                int remainingAttempts = 5;
                System.out.println("Please enter a valid number for " + component + ": ");
                int newValue = scanner.nextInt();
                while (newValue < minValue || newValue > maxValue) {
                    remainingAttempts--;
                    if (remainingAttempts < 1) {
                        throw new IllegalArgumentException("Exceeded attempts to enter a valid " + component + ".");
                    }
                    System.out.println("Invalid " + component + ". You have " + remainingAttempts + " attempts left. Valid range is between " + minValue + " and " + maxValue);
                    newValue = scanner.nextInt();
                }
                value = newValue;
            }
        }
        return value;
    }
}
