package ua.university;

import java.util.Arrays; // Потрібен для роботи з масивами, наприклад, для Arrays.copyOf

/**
 * BasicOperators class contains a set of static methods
 * for practicing Java operators, loops, arrays, and branching.
 */
public class BasicOperators {

    /**
     * Returns the sum and average of three integers.
     *
     * @param a first integer
     * @param b second integer
     * @param c third integer
     * @return double array where [0] = sum, [1] = average
     */
    public static double[] sumAndAverage(int a, int b, int c) {
        double sum = (double) a + b + c; // Приводимо до double для точного розрахунку середнього
        double average = sum / 3.0;
        return new double[]{sum, average};
    }

    /**
     * Returns the maximum of three integers.
     *
     * @param a first integer
     * @param b second integer
     * @param c third integer
     * @return the maximum of the three integers
     */
    public static int maxOfThree(int a, int b, int c) {
        // Використовуємо Math.max для знаходження максимуму двох чисел, а потім порівнюємо з третім
        return Math.max(a, Math.max(b, c));
    }

    /**
     * Returns the corresponding grade letter for a given numeric score.
     * <p>
     * The grading scale is as follows:
     * <ul>
     *     <li>90–100: 'A'</li>
     *     <li>80–89:  'B'</li>
     *     <li>70–79:  'C'</li>
     *     <li>60–69:  'D'</li>
     *     <li>50–59:  'E'</li>
     *     <li>0–49:   'F'</li>
     * </ul>
     *
     * @param score the numeric score, expected to be between 0 and 100 inclusive
     * @return the grade letter corresponding to the given score
     * @throws IllegalArgumentException if {@code score} is less than 0 or greater than 100
     */
    public static char gradeFromScore(int score) {
        if (score < 0 || score > 100) {
            // IllegalArgumentException - це стандартний виняток у Java, який вказує на те,
            // що метод отримав аргумент, який не є допустимим.
            throw new IllegalArgumentException("Score must be between 0 and 100");
        } else if (score >= 90) {
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
     *
     * @param day the day number (1 for Monday, 7 for Sunday)
     * @return the name of the day of the week
     * @throws IllegalArgumentException if the day number is out of range (1-7)
     */
    public static String dayOfWeek(int day) {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                // IllegalArgumentException - це виняток, що сигналізує про недійсний аргумент.
                throw new IllegalArgumentException("Day must be between 1 and 7");
        }
    }

    /**
     * Returns an array counting down from n to 1.
     *
     * @param n the starting number
     * @return an array counting down from n to 1
     * @throws IllegalArgumentException if n is less than 1
     */
    public static int[] countdown(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Number must be at least 1");
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = n - i;
        }
        return result;
    }

    /**
     * Returns factorial of n.
     *
     * @param n the number to calculate factorial for
     * @return factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0) {
            return 1; // Факторіал 0 дорівнює 1
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Returns a reversed copy of the array.
     *
     * @param arr the input array
     * @return a new array with elements in reverse order
     */
    public static int[] reverseArray(int[] arr) {
        if (arr == null) {
            return null; // Або можна кинути IllegalArgumentException
        }
        int[] reversedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];
        }
        return reversedArr;
    }

    /**
     * Returns sum of all elements in a 2D array (matrix).
     *
     * @param matrix the 2D array
     * @return the sum of all elements
     */
    public static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) { // Цикл for-each для ітерації по рядках
            for (int element : row) { // Цикл for-each для ітерації по елементах у рядку
                sum += element;
            }
        }
        return sum;
    }

    /**
     * Checks if a string is a palindrome.
     *
     * @param s the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false; // Або можна кинути IllegalArgumentException
        }
        String reversedS = new StringBuilder(s).reverse().toString();
        return s.equals(reversedS);
    }

    /**
     * Returns minimum and maximum of an array.
     *
     * @param arr the input array
     * @return a 2-element array where [0] = min, [1] = max
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
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
     *
     * @param n the size of the table
     * @return an n x n multiplication table
     * @throws IllegalArgumentException if n is less than 1
     */
    public static int[][] multiplicationTable(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Table size must be at least 1");
        }
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = (i + 1) * (j + 1); // Нумерація з 1 для таблиці множення
            }
        }
        return table;
    }

    /**
     * Returns all even numbers up to n.
     *
     * @param n the upper limit (inclusive)
     * @return an array of even numbers up to n
     * @throws IllegalArgumentException if n is less than 0
     */
    public static int[] evenNumbersUpToN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        // Визначаємо розмір масиву: скільки парних чисел до n
        int count = (n / 2) + 1; // Додаємо 1, якщо n парне, щоб включити його
        if (n % 2 != 0) {
            count--; // Якщо n непарне, останнє парне число буде n-1
        }
        int[] evens = new int[count];
        int index = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                evens[index++] = i;
            }
        }
        return evens;
    }

    /**
     * Checks if a number is prime.
     *
     * @param n the number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // Числа менші або рівні 1 не є простими
        }
        // Перевіряємо дільники до квадратного кореня з n
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false; // Якщо знайшовся дільник, число не є простим
            }
        }
        return true; // Якщо дільників не знайдено, число є простим
    }

    /**
     * Counts vowels in a string.
     *
     * @param s the input string
     * @return the number of vowels in the string
     */
    public static int countVowels(String s) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        String lowerS = s.toLowerCase(); // Переводимо у нижній регістр для спрощення порівняння
        for (int i = 0; i < lowerS.length(); i++) {
            char ch = lowerS.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns first n Fibonacci numbers.
     *
     * @param n the number of Fibonacci numbers to generate
     * @return an array containing the first n Fibonacci numbers
     * @throws IllegalArgumentException if n is less than 0
     */
    public static int[] fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of Fibonacci numbers must be non-negative");
        }
        if (n == 0) {
            return new int[0]; // Повертаємо порожній масив, якщо n = 0
        }
        if (n == 1) {
            return new int[]{0}; // Перше число Фібоначчі - 0
        }
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    /**
     * Returns the transpose of a 2D array (matrix).
     *
     * @param matrix the input 2D array
     * @return the transposed matrix
     * @throws IllegalArgumentException if the matrix is null or empty, or if rows have different lengths
     */
    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Перевірка, чи всі рядки мають однакову довжину
        for (int i = 1; i < rows; i++) {
            if (matrix[i].length != cols) {
                throw new IllegalArgumentException("Matrix rows must have the same length for transposition");
            }
        }

        int[][] transposedMatrix = new int[cols][rows]; // Розмірність змінюється
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j]; // Міняємо місцями індекси
            }
        }
        return transposedMatrix;
    }

    /**
     * Returns a sorted copy of the array in ascending order.
     *
     * @param arr the input array
     * @return a new array, sorted in ascending order
     */
    public static int[] sortArray(int[] arr) {
        if (arr == null) {
            return null; // Або можна кинути IllegalArgumentException
        }
        int[] sortedArr = Arrays.copyOf(arr, arr.length); // Створюємо копію, щоб не змінювати оригінал
        Arrays.sort(sortedArr); // Використовуємо вбудований метод сортування Java
        return sortedArr;
    }
}
