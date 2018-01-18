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
        
        System.out.println("Sum: " + sumArray(array, 0, 0, arrayLength));
    }

    static int sumArray(int[] array, int index, int sum, int arrayLength) {

        if (index >= arrayLength) {
            return sum;
        }
        return sumArraySG(array, index + 1, sum + array[index], arrayLength);
    }
}
