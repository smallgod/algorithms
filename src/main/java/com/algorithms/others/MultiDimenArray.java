/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * @author smallgod
 */
public class MultiDimenArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int ARRAY_LENGTH = 4;

        int[] ar = new int[ARRAY_LENGTH];
        Arrays.fill(ar, -1);// fill array with -1

        int[][] arr1 = new int[4][3]; // 4 X 3 // Row X Column
        Arrays.fill(arr1, ar);

        int[][] arr //array initialiser
                = {
                    {1, 2, 3},
                    {5, 6, 8, 9},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
                };
        print(arr);

    }

    /**
     * Print the given multi-dimensional array contents on the console
     *
     * @param arr
     */
    public static void print(int[][] arr) {

        int len = arr.length;
        for (int i = 0; i < len; i++) {

            int[] row = arr[i];
            for (int j = 0; j < row.length; j++) {

                System.out.print(row[j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Convert Set to List
     *
     * @param <T>
     * @param set
     * @return
     */
    public static <T> List<T> convertSetToList(Set<T> set) {

        List<T> newList = new ArrayList<>(set);
        return newList;
    }

    /**
     *
     * @param <T>
     * @param list
     * @return
     */
    public static <T> Object[] convertListToArray(List<T> list) {

        Object[] newArray = new Object[list.size()];
        newArray = list.toArray(newArray);

        return newArray;
    }

    public static <T> Object[] convertSetToArray(Set<T> set) {

        Object[] newArray = new Object[set.size()];
        newArray = set.toArray(newArray);

        return newArray;
    }

}
