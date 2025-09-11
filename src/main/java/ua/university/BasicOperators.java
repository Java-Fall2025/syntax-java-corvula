package ua.university;

import java.util.Arrays; // Import for Arrays.toString() if needed

/**
 * BasicOperators class contains a set of static methods
 * for practicing Java operators, loops, arrays, and branching.
 */
public class BasicOperators {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int num3 = 15;

        double[] result = sumAndAverage(num1, num2, num3);
        System.out.println("Sum: " + result[0] + ", Average: " + result[1]);

        int max = maxOfThree(num1, num2, num3);
        System.out.println("Maximum: " + max);

        char grade = gradeFromScore(85);
        System.out.println("Grade: " + grade);

        String day = dayOfWeek(3);
        System.out.println("Day of week: " + day);

        int[] countdownArray = countdown(5);
        System.out.println("Countdown: " + Arrays.toString(countdownArray));

    }
    public static double[] sumAndAverage(int a, int b, int c) {
        double sum = (double) a + b + c; // Cast to double for accurate average
        double average = sum / 3.0;
        return new double[]{sum, average};
    }

    public static int maxOfThree(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

    }

    /**
     * Returns the corresponding grade letter for a given numeric score.
     * <p>
     * The grading scale is as follows:
     * <ul>
     * <li>90–100: 'A'</li>
     * <li>80–89:  'B'</li>
     * <li>70–79:  'C'</li>
     * <li>60–69:  'D'</li>
     * <li>50–59:  'E'</li>
     * <li>0–49:   'F'</li>
     * </ul>
     *
     * @param score the numeric score, expected to be between 0 and 100 inclusive
     * @return the grade letter corresponding to the given score
     * @throws IllegalArgumentException if {@code score} is less than 0 or greater than 100
     */
    public static char gradeFromScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else if (score >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }

    /**
     * Returns the day of the week name for a number 1-7.
     */
    public static String dayOfWeek(int day) {
        switch (day) {
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            case 7: return "Sunday";
            default: return "Invalid day";
        }
    }

    /**
     * Returns an array counting down from n to 1.
     */
    public static int[] countdown(int n) {
        if (n <= 0) {
            return new int[0]; // Return an empty array for non-positive n
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = n - i;
        }
        return result;
    }

    /**
     * Returns factorial of n.
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Returns a reversed copy of the array.
     */
    public static int[] reverseArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];
        }
        return reversedArr;
    }

    /**
     * Returns sum of all elements in a 2D array (matrix).
     */
    public static int sumMatrix(int[][] matrix) {
        int sum = 0;
        if (matrix == null) {
            return 0;
        }
        for (int[] row : matrix) {
            if (row != null) {
                for (int element : row) {
                    sum += element;
                }
            }
        }
        return sum;
    }

    /**
     * Checks if a string is a palindrome.
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedString.length() - 1;
        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Returns minimum and maximum of an array.
     */
    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0]; // Or throw an exception, depending on requirements
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[]{min, max};
    }

    /**
     * Returns multiplication table n x n.
     */
    public static int[][] multiplicationTable(int n) {
        if (n <= 0) {
            return new int[0][0]; // Return empty matrix for non-positive n
        }
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    /**
     * Returns all even numbers up to n.
     */
    public static int[] evenNumbersUpToN(int n) {
        if (n < 0) {
            return new int[0];
        }
        // Calculate the size of the resulting array
        int count = (n / 2) + (n % 2 == 0 ? 0 : 1); // If n is even, n/2. If odd, (n-1)/2 + 1 = (n+1)/2
        if (n == 0) count = 1; // Special case for n=0 to include 0 if it's considered even
        else if (n < 2) count = 0; // No even numbers up to 1 except 0
        else count = n / 2; // Number of even numbers up to n is n/2

        int[] evenNumbers = new int[count];
        int index = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                evenNumbers[index++] = i;
            }
        }
        return evenNumbers;
    }

    /**
     * Checks if a number is prime.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }
        if (n <= 3) {
            return true; // 2 and 3 are prime
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false; // Divisible by 2 or 3
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Counts vowels in a string.
     */
    public static int countVowels(String s) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int[] fibonacci(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int[] fib = new int[n];
        if (n >= 1) {
            fib[0] = 0;
        }
        if (n >= 2) {
            fib[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static int[] sortArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] sortedArr = Arrays.copyOf(arr, arr.length); // Create a copy
        Arrays.sort(sortedArr); // Sort the copy
        return sortedArr;
    }
}
