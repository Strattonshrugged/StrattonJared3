/**
 * Created by jared stratton on 4/30/17.
 * parts to program ...
 *      quadrant: takes two doubles, return int--quadrant of point
 *      singleTax: takes double (taxable income) returns tax for single filing status
 *      seconds after midnight: counts seconds since
 *      seconds difference:
 *
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
                timeStringMaker(1);
            } else if (selection == 4) {
                timeStringMaker(2);
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


    public static void greeting()       {
        System.out.println("Program Three Online: Quadrant Finder, Tax Return Calculator, and Seconds Counter");
        System.out.println("To use the quadrant finder, enter '1'");
        System.out.println("To use the tax finder, enter '2'");
        System.out.println("To use the seconds finder, enter '3'");
        System.out.println("To find the difference, in seconds, between two time indexes, enter '4'");
        System.out.println("");
    }


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
                System.out.println("You have selected Seconds-Past-Midnight");
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
    public static void timeStringMaker(int count) {
        String tOne;
        String tTwo;

        if (count == 1) {
            System.out.println("Please enter the time to be calculated past midnight");
            System.out.println("Remember to use the 'HH:MM:SSPM' format");
            tTwo = console.nextLine();
            secondsPastMidnight(tTwo);
        } else if (count == 2) {
            System.out.println("Please enter the start time to be calculated");
            System.out.println("Remember to use the 'HH:MM:SSPM' format");
            tOne = console.nextLine();
            System.out.println("Please enter the end time");
            tTwo = console.nextLine();
            secondsDifference(tOne,tTwo);
        } else {
            System.out.println("Error: timeStringMaker passed bad count");
        }
    } // end of timeStringMaker


    public static void secondsPastMidnight(String timesUp)    {
        System.out.println("secondsPastMidnight method called");
    }

    
    public static void secondsDifference(String startTime,String StopTime)    {
        System.out.println("secondsDifference method called");

    }





} // end of StrattonJared3 class
