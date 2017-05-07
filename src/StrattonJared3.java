/**
 * Created by jared stratton on 4/30/17.
 * parts to program ...
 *      quadrant: takes two doubles, return int--quadrant of point
 *      singleTax: takes double (taxable income) returns tax for single filing status
 *      seconds after midnight: counts seconds since
 *      seconds difference:
 */

import java.util.*;

public class StrattonJared3 {
    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        int selection;

        while (true) {
            // say howdy, give options
            greeting();
            // pick option, should return int 1,2,3,or4
            selection = selectionMaker();
            // route to task
            if (selection == 1) {
                quadrantFinder();
            } else if (selection == 2) {
                // taxFinder();
            } else if (selection == 3) {
                timeFinder(1);
            } else if (selection == 4) {
                timeFinder(2);
            } else  {
                System.out.println("Error: selection has invalid value");
            }
            // flush out the console for safety sake
            console.nextLine();
            // couple lines of whitespace between iterations
            System.out.println();
            System.out.println();
        } // end of while loop
    } // end of main method


    // just prints text
    public static void greeting()       {
        System.out.println("Program Three Online: Quadrant Finder, Tax Return Calculator, and Seconds Counter");
        System.out.println("For Quadrant Finder, enter '1'");
        System.out.println("For Tax Finder, enter '2'");
        System.out.println("For Seconds Past Midnight, enter '3'");
        System.out.println("For Seconds Difference, enter '4'");
        System.out.println("");
    }


    // takes selection, announces it, directs main where to send user
    public static int selectionMaker()      {
        String selMakerInput;
        int selTemp = 0;
        int response = 0;

        while (response == 0) {
            System.out.print("Please make your selection: ");
            selMakerInput = console.nextLine();
            try {
                selTemp = Integer.parseInt(selMakerInput);
            }
            catch (NumberFormatException e)    {
            }
            if (selTemp == 1) {
                System.out.println("You have selected Quadrant Finder");
                response = 1;
            } else if (selTemp == 2) {
                System.out.println("You have selected Tax Finder");
                response = 2;
            } else if (selTemp == 3) {
                System.out.println("You have selected Seconds Past Midnight");
                response = 3;
            } else if (selTemp == 4) {
                System.out.println("You have selected Seconds Difference");
                response = 4;
            } else {
                System.out.println("Error: Invalid Selection");
            }
        } // end of while loop
        return response;
    } // end of selectionMaker


    // method is to organize inputs and calls outside of main
    public static void quadrantFinder() {
        double x;
        double y;
        // get x
        x = doubleValueFinder('x');
        // get y
        y = doubleValueFinder('y');
        // call method
        quadrant(x,y);
    }


    // takes accepts values for x and y coordinates, validates them
    public static double doubleValueFinder(char letter)   {
        Double k = null;
        String input;

        while (k == null)   {
            System.out.println("Please enter the " + letter + "-value for the point");
            try {
                k= console.nextDouble();
            }
            catch (InputMismatchException doubleTrouble)   {
                console.nextLine();
                System.out.println("Invalid value");
            }
        }
        return k;
    }


    // takes validated doubles, prints their location
    public static void quadrant(double x, double y)    {
        if (x == 0.0 && y == 0.0) {
            System.out.println("(0.0,0.0) is the origin, it is not in any quadrant");
        }   else if (x == 0.0)  {
            System.out.println("Points on the x-axis are not in any quadrant");
        }   else if (y == 0.0)  {
            System.out.println("Points on the y-axis are not in any quadrant");
        }   else if (x > 0 && y > 0)  {
            System.out.println("Quadrant One");
        }   else if (x < 0 && y > 0)  {
            System.out.println("Quadrant Two");
        }   else if (x < 0 && y < 0)  {
            System.out.println("Quadrant Three");
        }   else if (x > 0 && y < 0)  {
            System.out.println("Quadrant Four");
        }   else    {
            System.out.println("Error: values passed to quadrant unplottable");
        }
    }


    // method is to organize inputs and calls outside of main
    public static void timeFinder(int count) {
        String tOne;
        String tTwo;
        int seconds;

        if (count == 1) {
            System.out.println("Please enter the time to be calculated past midnight");
            System.out.println("Remember to use the 'HH:MM:SSPM' format");
            tTwo = console.nextLine();
            tTwo = tTwo.toUpperCase();
            seconds = secondsPastMidnight(tTwo);
            System.out.println(seconds);
        } else if (count == 2) {
            System.out.println("Remember to use the 'HH:MM:SSPM' format");
            System.out.println("Please enter the start time to be calculated");
            tOne = console.nextLine();
            tOne = tOne.toUpperCase();
            System.out.println("Please enter the end time");
            tTwo = console.nextLine();
            tTwo = tTwo.toUpperCase();
            seconds = secondsDifference(tOne,tTwo);
            System.out.println(seconds);
        } else {
            System.out.println("Error: timeStringMaker received bad count");
        }

    } // end of timeStringMaker


    // required method accepting string and returning -1 on error
    public static int secondsPastMidnight(String secondsPast)    {
        int timeValue;

        // check the string
        if (timeVerifier(secondsPast) == false)     {
            return -1;
        }
        //System.out.println("Came back from timeVerifier");
        // perform calculation
        timeValue = (secondCounter(secondsPast)) - 43200;
        return timeValue;
    }


    // required method accepting two strings and returning -99999 on error
    public static int secondsDifference(String startTime,String stopTime)    {
        int timeInValue;
        int timeOutValue;
        int difference;

        System.out.println("secondsDifference initiated");

        if (timeVerifier(startTime) == false)   {
            return -99999;
        }
        if (timeVerifier(stopTime) == false)    {
            return -99999;
        }
        timeInValue = secondCounter(startTime);
        timeOutValue = secondCounter(stopTime);
        difference = timeOutValue - timeInValue;
        return difference;
    }


    // check strings of time for format, regex would be used here
    public static boolean timeVerifier(String time)  {
        // if string length is 9, assume they left off the zero
        if (time.length() == 9) {
            time = '0' + time;
            System.out.println(time);
        }
        // check string length
        if (time.length() != 10)    {
            return false;
        }
        // if first hour character is not a zero or a one
        if (time.charAt(0) != '0' && time.charAt(0) != '1')    {
            return false;
        }
        // if second hour character is not a digit
        if (!Character.isDigit(time.charAt(1))) {
            return false;
        }
        // if first character is a 1, second character can only be 0, 1, or 2
        if (time.charAt(0) == '1' && "012".indexOf(time.charAt(1)) == -1) {
            return false;
        }
        // if not a colon
        if (time.charAt(2) != ':')  {
            return false;
        }
        // if first minute character is not a digit or higher than five
        if ("012345".indexOf(time.charAt(3)) == -1)   {
            return false;
        }
        // if second minute character is not a digit
        if (!Character.isDigit(time.charAt(4))) {
            return false;
        }
        // if not a colon
        if (time.charAt(5) != ':')  {
            return false;
        }
        // if first second character is not a digit or higher than five
        if ("012345".indexOf(time.charAt(6)) == -1)   {
            return false;
        }
        // if second (2nd) second character is not a digit
        if (!Character.isDigit(time.charAt(7))) {
            return false;
        }
        // if not an A or P as in AM or PM
        if (time.charAt(8) != 'A' && time.charAt(8) != 'P') {
            return false;
        }
        // if not an M
        if (time.charAt(9) != 'M')  {
            return false;
        }
        return true;
    }


    // adds up total number of seconds in a time string
    public static int secondCounter(String time)    {
        String snippet;
        int halfDay;
        int hours;
        int minutes;
        int seconds;
        int totalSeconds;

        if (time.charAt(8) == 'P')  {
            System.out.println("PM noted");
            halfDay = 1;
        }   else    {
            halfDay = 0;
            System.out.println("AM noted");
        }
        snippet = time.substring(0,2);
        hours = Integer.parseInt(snippet);
        snippet = time.substring(3,5);
        minutes = Integer.parseInt(snippet);
        snippet = time.substring(6,8);
        seconds = Integer.parseInt(snippet);
        System.out.println(" hours " + hours + " minutes " + minutes + " seconds " + seconds);
        totalSeconds = (halfDay * 43200) + (hours * 3600) + (minutes * 60) + (seconds);
        return totalSeconds;
    }



} // end of StrattonJared3 class
