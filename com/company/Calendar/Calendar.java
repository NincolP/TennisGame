package com.company.Calendar;

import java.util.Scanner;

public class Calendar {

    //The 1st of January of 1800 landed on a Wednesday or day 4 of the week, but converted to 3 to serve as an index
    //Due to index starting at 0
    public static int dayOne = 3;

    //LEAP YEAR CHECKER FUNCTION
    public static boolean leapYear(int year) {
        if( year % 400 ==0 || ( (year % 4 ==0) && (year % 100 !=0) )  )
            return true;
        else
            return false;
    }

    //THIS FUNCTION RETURNS THE NUMBER OF DAYS IN A GIVEN MONTH AND YEAR
    public static int numOfDaysInMonth(int month, int year) {
        int daysInMonth = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            daysInMonth = 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            daysInMonth = 30;
        else if (month == 2 && leapYear(year))
            daysInMonth = 29;
        else
            daysInMonth = 28;
        return daysInMonth;
    }

    //Computes the number of days since 1800
    public static int getTotalNumOfDays(int month, int year) {
        int daysSinceEighteenHundred = 0;
        for(int start = 1800; start < year ; start++) {
            if(leapYear(start))
                daysSinceEighteenHundred += 366;
            else daysSinceEighteenHundred += 365;
            }
        //Add remaining full months prior to month selected
        for(int i = 1; i < month; i++) {
            daysSinceEighteenHundred += numOfDaysInMonth(i, year);
        }
        //Add dayOne to compute modulo operation that will give us index of the given month 1st day
        daysSinceEighteenHundred += dayOne;
        return daysSinceEighteenHundred;
    }

    //MAIN FUNCTION
    public static void main(String[] args) {
        int year;
        int month;
        char choice = 0;

        String[] monthsNames = {"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"};
        //---------------------------------------------------------------------------------------

        ///Create a scanner object
        Scanner input = new Scanner(System.in);

        do {        //Start of do-while loop
            //Prompt the user to enter year
            System.out.print("Please enter the year: ");
            year = input.nextInt();
            //Validating input year is greater than 1800
            while (year < 1800) {
                System.out.println("Invalid year. Please enter a year greater than 1800:");
                year = input.nextInt();
            }

            //Prompt the user to enter month
            System.out.print("Please enter the month in number between 1 and 12:");
            month = input.nextInt();
            //Validating valid month
            while (month <= 0 || month > 12) {
                System.out.println("Please enter a valid month between 1 and 12:");
                month = input.nextInt();
            }

            //Variable to hold number of days in the given month
            int daysInThisMonth = numOfDaysInMonth(month, year);

            //Creating 2D array to hold calendar
            int rows = 6;
            int columns = 7;
            int[][] calendarArray = new int[rows][columns];

            //This calculates the of the week the calendar should start on //
            int daysAfterFullWeek = (getTotalNumOfDays(month, year)) % 7;

            //Printing headers
            System.out.println();
            System.out.println("         " + monthsNames[month - 1] + ", " + year + "   ");
            System.out.println("----------------------------");
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");

            //Populating calendar arrays with days for particular month
            int j = daysAfterFullWeek;     //Starting column index dayOfMonth matches 1st DAY of month
            int dayOfMonth = 1;                    //dayOfMonth corresponding to day of the month
            int i = 0;                          //Row Index

            //While loop populates calendar array
            while (dayOfMonth <= daysInThisMonth) {
                if (j == 7) {
                    i++;
                    j = 0;
                }
                calendarArray[i][j] = dayOfMonth;
                j++;
                dayOfMonth++;
            }// End of while loop*/

            //Nested for loop use to print calendar
            for (int[] row : calendarArray) {
                for (int x : row) {
                    if (x <= 9) {
                        if (x == 0) {
                            System.out.print("    ");
                        } else
                            System.out.print("  " + x + " ");
                    }
                    else
                        System.out.print(" " + x + " ");
                }
                System.out.println();
            }//End of nested for loop*/

            System.out.println("Would you like to try again? Press any key to continue or n to stop the program: ");
            choice = input.next().charAt(0);

        }while (choice != 'n' && choice != 'N');
    }//End of main method
}//End of program
