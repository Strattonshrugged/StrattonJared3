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

    public static void mainMenu() {

        while (true) {
            int selection = 0;
            String input = "";

            greeting();

            // prompts selection, only allows 4 options, announces selection
            while (selection == 0) {
                selection = selectionMaker();
            }

            while (input.equals("")) {
                input = inputCleaner(selection);
            }

            methodCaller(selection,input);

        }   // end of while loop
    } // end of main method


    public static void greeting()       {
        System.out.println("Program Three Online: Quadrant Finder, Tax Return Calculator, and Seconds Counter");
        System.out.println("To use the quadrant finder, enter '1'");
        System.out.println("To use the tax finder, enter '2'");
        System.out.println("To use the seconds finder, enter '3'");
        System.out.println("To find the difference, in seconds, between two time indexes, enter '4'");
        System.out.print("Please make your selection: ");
    }

    public static int selectionMaker()      {
        Scanner selectionConsole = new Scanner(System.in);
        String selectionMakerInput;
        int selectionTemp;

        selectionMakerInput = selectionConsole.nextLine();
        selectionTemp = Integer.parseInt(selectionMakerInput);
        if (selectionTemp == 1) {
            System.out.println("You have selected Quadrant Finder");
            return 1;
        }   else if (selectionTemp == 2)    {
            System.out.println("You have selected Tax Finder");
            return 2;
        }   else if (selectionTemp == 3)    {
            System.out.println("You have selected Seconds-Past-Midnight");
            return 3;
        }   else if (selectionTemp == 4)   {
            System.out.println("You have selected Seconds Difference");
            return 4;
        }   else    {
            System.out.println("Error: Invalid Selection inside selectionMaker");
            return 0;
        }
    }


    public static String inputCleaner(int selection)    {
        Scanner inputConsole = new Scanner(System.in);
        String input;

        if (selection == 1) {

            System.out.print("Please enter coordinates in the (x,y) format");
        }   else if (selection == 2)    {
            System.out.print("Please enter adjusted gross income in the $xxxxx.xx format");

        }   else if (selection == 3)    {
            System.out.print("Please enter a time in the HH:MM:SSPM format");

        }   else if (selection == 4)    {
            System.out.print("Please enter the first time in the HH:MM:SSPM format");

        }   else    {
            System.out.print("Error: Invalid Selection received into inputCleaner");
            return "";
        }


        // what do I want to do here? inside each 'if' take an input,

    }

    public static void methodCaller(int selection, String input)    {

    }

    public static String quadrantFinder(String In)   {
        System.out.println("quadrantFinder function called");
        return "Answer";
    }

    public static Double taxFinder(String In)    {
        System.out.println("taxReturn function called");
        return 1.0;
    }

    public static Integer timeFinder(String In)  {
        System.out.println("secondsCounter function called");
        return 1;
    }





    public static void main(String[] args)  {
        greeting();
        mainMenu();
    }

// tax calculator notes
    // inputs taxable income (line 43)
    // returns proper tax for line 44

}
