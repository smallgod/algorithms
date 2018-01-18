package com.algorithms.others;

/**
 *
 * @author smallgod
 */
public class SumRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 10};
        int arrayLength = array.length;
        

        System.out.println("Sum: " + sumArraySG(array, 0, 0, arrayLength));
        System.out.println("Sum: " + sumArrayG4G(array, arrayLength));
        System.out.println("Sum: " + sumArrayG4GModified(array, 0, arrayLength));

    }

    //Sum (1,2,5,3,9) = sum(1,2,5,3) + sum(9) -> but we know that the sum (n) == n i.e. the sum(9) == 9
    //so break-down problem recursively till the problem we know to solve
    static int sumArrayG4G(int array[], int arrayLength) {

        if (arrayLength <= 0) {
            return 0;
        }
        return sumArrayG4G(array, arrayLength - 1) + array[arrayLength - 1];
    }

    static int sumArrayG4GModified(int array[], int index, int arrayLength) {

        if (index >= arrayLength) {
            return 0;
        }
        return array[index] + sumArrayG4GModified(array, index + 1, arrayLength);
    }

    static int sumArraySG(int[] array, int index, int sum, int arrayLength) {

        if (index >= arrayLength) {
            return sum;
        }
        return sumArraySG(array, index + 1, sum + array[index], arrayLength);
    }
}
