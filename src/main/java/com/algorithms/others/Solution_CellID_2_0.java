/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.others;

/**
 *
 * @author smallgod
 */
public class Solution_CellID_2_0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        answer(2, 3);
        answer(3, 2);
        answer(5, 10);
        answer(1, 1);
        answer(100000, 100000);
        answer(50000, 10000);
        answer(50000, 50000);

    }

    /**
     * Returns the prisoner ID of the bunny at location (x, y). Step 1: Move
     * along the x-axis a distance (int)x (where u stop is a value ->
     * bunnyPrisonerId-xvalue). Step 2: Add (int x) to the
     * bunnyPrisonerId-xvalue got, and then move along the y-axis a distance
     * (int)y incrementing (int x) by 1 and adding to the new value of
     * bunnyPrisonerId-xvalue. You will finally get the bunnyPrisonerId
     *
     * @param x
     * @param y
     * @return
     */
    public static String answer(final int x, final int y) {

        long bunnyPrisonerId = x;
        final int startPostion = 1;
        long xValue = x;
        long yValue = x;
        while (xValue >= startPostion) {
            bunnyPrisonerId += (--xValue);
        }
        for (int i = startPostion; i < y; i++) {
            bunnyPrisonerId += (yValue++);
        }
        return String.valueOf(bunnyPrisonerId);
    }
}
