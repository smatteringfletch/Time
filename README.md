# Time
 A Java-based programming assignment

## Questions

1. Define the class for time and other needed classes, with attributes, accessor/mutator methods and constructors
2. Generate a valid time value with user input (Think about what to do if the value is illegal, e.g 25 for hours)
3. Generate a random time in the form of HH:MM:SS
4. Generate two random time instances in the form of HH:MM:SS, then add them together to produce a new time value in HH:MM:SS
5. Generate multiple random times in the form of HH:MM:SS, then add them together to form a new time value in HH:MM:SS
6. Taking user input iteratively input a limited number of values for seconds. (e.g 3 iterations, 54,000 seconds, 30,080 seconds, 79,950 seconds). Convert each to HH:MM:SS. Reminder: It's optional to specify a range for the total seconds.

### Question 1

Time in the real world revolves around hours, minutes and seconds. The first task is to define the classes.

#### Time

##### Attributes

Time attributes consist of hours (00 - 23), minutes (00 - 59), and seconds (00 - 59).

##### Accessors / Mutators

The accessors and mutators for time consist of:
 * setHour(int hour)
 * setMinute(int minute)
 * setSecond(int second)
 * getHour()
 * getMinute()
 * getSecond()
 * getTime()

##### Constructors

We have two constructors within Time.

 * Time() - This is a default constructor, if called upon will set a time of 00:00:00
 * Time(int hour, int minute, int second) - This overloaded constructor allows for customising Time.

#### Time Manager

In addition to the Time class we also have a TimeManager class. This class is responsible for:

 * Ensuring all values are valid. 
 * Allowing the user to correct invalid options.
 * Calling the Time class to create only valid instances.
 * Calculating when values need to me added together.
