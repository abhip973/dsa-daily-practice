package dsadailypractice;

public class StarPattern {
    public static void main(String[] args) {
        /*
        Pattern 1: Print a square of stars (*) of size nxn.
        Example:
        ****
        ****
        ****
        ****
         */
        pattern1(4);


        /*
        Pattern 2: Write a program to print a right-angled triangle of stars with n rows.
        Example:
        *
        **
        ***
        ****
         */
        pattern2(4);

        /*
        Program 3: Write a program that prints a right angled triangle of numbers of height n.
        Example:
        1
        12
        123
        1234
         */
        pattern3(4);

        /*
        Program 4: Write a program that prints right-angled triangle where each row contains the same number repeated.
        Example:
        1
        22
        333
        4444
         */
        pattern4(4);

        /*
        Program 5: Write a program that prints a reverse right-angled triangle where each row starts from 1 and the number of elements
        decreases with each row.
        Example:
        1234
        123
        12
        1
         */
        pattern5(4);

        /*
        Program 6: Write a program that prints a right aligned triangle of stars increasing row by row, with leading spaces for alignment.
        Example:
            *
           **
          ***
         ****
         */
        pattern6(4);

        /*
        Program 7: Write a program that prints a triangle of alternating 1s and 0s starting with 1 on each row.
        Example:
        1
        10
        101
        1010
         */
        pattern7(4);

        /*
        Program 8: Write a program to print a triangle of alternating 1s and 0s, but the toggle continues globally across rows.
        Example:
        1
        01
        010
        1010
         */
        pattern8(4);

    }

    private static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            String pattern = "";
            for (int j = -0; j < n; j++) {
                pattern += "*";
            }
            System.out.println(pattern);
        }
    }

    private static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            String pattern = "";
            for (int j = 0; j < i + 1; j++) {
                pattern += "*";
            }
            System.out.println(pattern);
        }
    }

    private static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            String pattern = "";
            for (int j = 0; j < i + 1; j++) {
                pattern += j + 1;
            }
            System.out.println(pattern);
        }
    }

    private static void pattern4(int n) {
        for (int i = 0; i < n; i++) {
            String pattern = "";
            for (int j = 0; j < i + 1; j++) {
                pattern += i + 1;
            }
            System.out.println(pattern);
        }
    }

    private static void pattern5(int n) {
        for (int i = 0; i < n; i++) {
            String pattern = "";
            for (int j = 0; j < (n - i); j++) {
                pattern += j + 1;
            }
            System.out.println(pattern);
        }
    }

    private static void pattern6(int n) {
        for (int i = 0; i < n; i++) {
            String pattern = "";
            for (int j = 0; j < n - (i + 1); j++) {
                pattern += " ";
            }
            for (int k = 0; k < i + 1; k++) {
                pattern += "*";
            }
            System.out.println(pattern);
        }
    }

    private static void pattern7(int n) {
        for (int i = 0; i < n; i++) {
            String pattern = "";
            int toggle = 1;
            for (int j = 0; j < i + 1; j++) {
                pattern += toggle;
                if (toggle == 0) {
                    toggle = 1;
                } else {
                    toggle = 0;
                }
            }
            System.out.println(pattern);
        }
    }

    private static void pattern8(int n) {
        int toggle = 1;
        for (int i = 0; i < n; i++) {
            String pattern = "";
            for (int j = 0; j < i + 1; j++) {
                pattern += toggle;
                if (toggle == 0) {
                    toggle = 1;
                } else {
                    toggle = 0;
                }
            }
            System.out.println(pattern);
        }
    }
}
