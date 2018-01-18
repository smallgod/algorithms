/*


Find the Access Codes
=====================

In order to destroy Commander Lambda's LAMBCHOP doomsday device, you'll need access to it. But the only door leading to the LAMBCHOP chamber is secured with a unique lock system whose number of passcodes changes daily. Commander Lambda gets a report every day that includes the locks' access codes, but only she knows how to figure out which of several lists contains the access codes. You need to find a way to determine which list contains the access codes once you're ready to go in. 

Fortunately, now that you're Commander Lambda's personal assistant, she's confided to you that she made all the access codes "lucky triples" in order to help her better find them in the lists. A "lucky triple" is a tuple (x, y, z) where x divides y and y divides z, such as (1, 2, 4). With that information, you can figure out which list contains the number of access codes that matches the number of locks on the door when you're ready to go in (for example, if there's 5 passcodes, you'd need to find a list with 5 "lucky triple" access codes).

Write a function answer(l) that takes a list of positive integers l and counts the number of "lucky triples" of (lst[i], lst[j], lst[k]) where i < j < k.  The length of l is between 2 and 2000 inclusive.  The elements of l are between 1 and 999999 inclusive.  The answer fits within a signed 32-bit integer. Some of the lists are purposely generated without any access codes to throw off spies, so if no triples are found, return 0. 

For example, [1, 2, 3, 4, 5, 6] has the triples: [1, 2, 4], [1, 2, 6], [1, 3, 6], making the answer 3 total.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (int list) l = [1, 1, 1]
Output:
    (int) 1

Inputs:
    (int list) l = [1, 2, 3, 4, 5, 6]
Output:
    (int) 3

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.
 *
 *
 */
package com.algorithms.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author smallgod
 */
public class Solution_Accesscodes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        int int32BitMax = 2147483647;
        int initValue = 1;

        int max = 6;
        int[] array = new int[max];

        for (int i = 0; i < max; i++) {
            array[i] = i + 1;
        }

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;

        double seconds = (double) elapsedTime / 1000000000.0;
    }

    static int answer(int[] l) {

        int lastIndex = l.length - 1;
        int j = lastIndex - 1;
        int luckyTripples = 0;
        
        Map<String, Integer> luckyDoubleCountCache = new HashMap<>();

        do {
            int count = 0;
            for (int k = lastIndex; k > j; k--) {
                if (isAMultiple(l[j], l[k])) {
                    count++;
                }
            }
            
            luckyDoubleCountCache.put("" + l[j] + j, count);
            j--;
            
        } while (j >= 1);

        j = 1;
        do {
            for (int i = 0; i < j; i++) {
                if (isAMultiple(l[i], l[j])) {

                    luckyTripples += luckyDoubleCountCache.get("" + l[j] + j);
                }
            }
            
            j++;
            
        } while (j < lastIndex);

        return luckyTripples;
    }

    static boolean isAMultiple(int multiple, int number) {

        if ((number >= multiple) && (number % multiple) == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    static boolean isEven(int number) {
        if ((number % 2) == 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
