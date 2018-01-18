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
public class Solution_MinionID_1_0 {

    private static final int MAX_INDEX = 10000;
    private static final int MINION_ID_LENGTH = 5;
    private static final int CMD_LAMBDA_ID_STRING_POOL_LENGTH = MAX_INDEX + MINION_ID_LENGTH + 1;

    private static final StringBuilder CMD_LAMBDA_ID_STRING_POOL = generateLambdasStringPool(CMD_LAMBDA_ID_STRING_POOL_LENGTH);

    public static void main(String[] args) {

        answer(10000);

    }

    /**
     * Given an index, n generate an ID for a minion
     *
     * @param n
     * @return
     */
    public static String answer(int n) {

        String minionId = CMD_LAMBDA_ID_STRING_POOL.substring(n, n + MINION_ID_LENGTH);

        System.out.println("\nLambda's string       : " + CMD_LAMBDA_ID_STRING_POOL);
        System.out.println("\nLambda's string len   : " + CMD_LAMBDA_ID_STRING_POOL.length());
        System.out.println("start-index           : " + n);
        System.out.println("end-index             : " + n + MINION_ID_LENGTH);
        System.out.println("MinionId @index       : " + n + ", is: " + minionId);

        return minionId;
    }

    /**
     * Generate a long string pool of concatenated IDs from which commander
     * Lambda will generate IDs for the minions
     *
     * @param lambdasIdPoolStringLength
     * @return string pool
     */
    public static StringBuilder generateLambdasStringPool(int lambdasIdPoolStringLength) {

        int primeCandidate = 2;//first known prime

        StringBuilder strBuilder = new StringBuilder(lambdasIdPoolStringLength);
        strBuilder.append(primeCandidate);

        int stringLength = strBuilder.length();

        do {

            primeCandidate++;
            if (isNumberPrime(primeCandidate)) {

                strBuilder.append(primeCandidate);
                int primeLength = (primeCandidate + "").length();
                stringLength += primeLength;
            }

        } while (stringLength <= lambdasIdPoolStringLength);

        return strBuilder;
    }

    // simple primality test - can be modified to be more complex and more efficient
    /**
     * Check if given number is a prime
     *
     * @param number
     * @return true if prime otherwise false
     */
    public static boolean isNumberPrime(int number) {

        if (number < 2) {

            return false;

        } else {

            for (int i = 2; i <= Math.sqrt(number); i++) {

                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
