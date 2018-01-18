package com.algorithms.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author smallgod
 */
public class Solution_AlgorithmFLaw_2_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //answer("1211", 10);
        answer("210022", 3);
        //answer("1100110", 2);
    }

    /**
     * Determine the length of the ending cycle of commander Lambda's algorithm
     * to prove it is flawed - gets stuck in a cycle of values so that the same
     * minions end up doing the same tasks over and over again
     *
     * @param n
     * @param b
     * @return
     */
    public static int answer(String n, int b) {

        Map<String, Integer> completedTaskMap = new HashMap<>();
        int lengthK = n.length();
        int occurrenceOfTasks = 1;

        while (true) {

            char[] nArray = n.toCharArray();
            Arrays.sort(nArray);

            String y = new String(nArray);
            String x = new StringBuilder(y).reverse().toString();
            String z = Integer.toString((Integer.parseInt(x, b) - Integer.parseInt(y, b)), b);
            while (z.length() < lengthK) {
                z = "0" + z;
            }

            if (completedTaskMap.containsKey(n)) {
                return occurrenceOfTasks - completedTaskMap.get(n);
            }

            completedTaskMap.put(n, occurrenceOfTasks++);
            n = z;
        }
    }

    void baseArithmeticExamples() {

        int base = 10;
        int x = Integer.parseInt("222211", base);
        int y = Integer.parseInt("112222", base);

        System.out.println("(" + x + " - " + y + ")" + "in base: " + base + " = " + (Integer.toString(x - y, base)));

        //char[] xArray = n.toCharArray();
        //Collections.sort(Arrays.asList(nArray));
        //Collections.reverse(Arrays.asList(nArray));
        //Collections.reverse(list);
        //Arrays.sort(nArray, Collections.reverseOrder());
    }

}
