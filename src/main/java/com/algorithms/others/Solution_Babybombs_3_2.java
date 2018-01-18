/*

Bomb, Baby!
===========

You're so close to destroying the LAMBCHOP doomsday device you can taste it! But in order to do so, you need to deploy special self-replicating bombs designed for you by the brightest scientists on Bunny Planet.
There are two types: Mach bombs (M) and Facula bombs (F). The bombs, once released into the LAMBCHOP's inner workings, will automatically deploy to all the strategic points you've identified and destroy them at
the same time.

But there's a few catches. First, the bombs self-replicate via one of two distinct processes:
Every Mach bomb retrieves a sync unit from a Facula bomb; for every Mach bomb, a Facula bomb is created;
Every Facula bomb spontaneously creates a Mach bomb.

For example, if you had 3 Mach bombs and 2 Facula bombs, they could either produce 3 Mach bombs and 5 Facula bombs, or 5 Mach bombs and 2 Facula bombs. The replication process can be changed each cycle.

Second, you need to ensure that you have exactly the right number of Mach and Facula bombs to destroy the LAMBCHOP device.
Too few, and the device might survive. Too many, and you might overload the mass capacitors and create a singularity at the heart of the space station - not good!

And finally, you were only able to smuggle one of each type of bomb - one Mach, one Facula - aboard the ship when you arrived,
so that's all you have to start with. (Thus it may be impossible to deploy the bombs to destroy the LAMBCHOP, but that's not going to stop you from trying!)

You need to know how many replication cycles (generations) it will take to generate the correct amount of bombs to destroy the LAMBCHOP.

Write a function answer(M, F) where M and F are the number of Mach and Facula bombs needed.
Return the fewest number of generations (as a string) that need to pass before you'll have the exact number of bombs necessary to destroy the LAMBCHOP, or the string "impossible" if this can't be done!

M and F will be string representations of positive integers no larger than 10^50.

For example, if M = "2" and F = "1", one generation would need to pass, so the answer would be "1". However, if M = "2" and F = "4", it would not be possible.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
(string) M = "2"
(string) F = "1"
Output:
(string) "1"

Inputs:
(string) M = "4"
(string) F = "7"
Output:
(string) "4"

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.

 */
package com.algorithms.others;

import java.math.BigInteger;

/**
 *
 * @author smallgod
 */
public class Solution_Babybombs_3_2 {

    static BigInteger totalGen = BigInteger.ZERO;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        BigInteger bi = new BigIntegerMath.pow(10, 50);
        String M = "4";
        String F = "7";

        String generations = answer(M, F);
        System.out.println("Generations (" + M + ", " + F + ") == " + generations);

    }

    static String answer(String M, String F) {

        BigInteger Mbombs = new BigInteger(M);
        BigInteger Fbombs = new BigInteger(F);

        String generations = bombs(Mbombs, Fbombs, BigInteger.ZERO).toString();
        return generations.equals("0") ? "impossible" : generations;
    }

    static BigInteger bombs(BigInteger Mbombs, BigInteger Fbombs, BigInteger generations) {

        BigInteger cycles = generations;
        BigInteger bigger = Mbombs.max(Fbombs);
        BigInteger smaller = Mbombs.min(Fbombs);
        BigInteger[] values = bigger.divideAndRemainder(smaller);
        BigInteger quotient = values[0];
        BigInteger remainder = values[1];

        //we have observed that if we have 1 bomb of either, 
        //we can always trace back to 1, 1 in n-1 steps
        if (smaller.equals(BigInteger.ONE)) { //managed to smuggle in 1 of each

            cycles = cycles.add(bigger.subtract(smaller));

        } else if (remainder.equals(BigInteger.ZERO)) {

            cycles = BigInteger.ZERO;

        } //we cut down the cycles we would have made since they will be the same 
        //till the diff between bigger & smaller is the remainder
        else if (smaller.equals(Mbombs)) {
            cycles = bombs(smaller, remainder, cycles.add(quotient));
        } else {
            cycles = bombs(remainder, smaller, cycles.add(quotient));
        }
        return cycles;
    }

    static BigInteger bombsOLD1(BigInteger mach, BigInteger facula, BigInteger machNeeded, BigInteger faculaNeeded) {

        //greater
        if (mach.compareTo(machNeeded) == 1 || facula.compareTo(faculaNeeded) == 1) {

            return BigInteger.ZERO;

        } else if (mach.compareTo(machNeeded) == 1 && facula.compareTo(faculaNeeded) == 1) {

            return BigInteger.ZERO; //impossible

        } else if (mach.compareTo(machNeeded) == 0 && facula.compareTo(faculaNeeded) == 0) {
            
            return BigInteger.ONE;

        } else {

            BigInteger option1 = bombsOLD1(mach, (facula.add(mach)), 
                    machNeeded, faculaNeeded);
            BigInteger option2 = bombsOLD1((facula.add(mach)), facula, 
                    machNeeded, faculaNeeded);
            
            totalGen = totalGen.add(option1.add(option2));

            return option1.add(option2);

        }
    }
}
