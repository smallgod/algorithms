/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author smallgod
 */
public class TheSalesManProb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    static void methods(int[] data) {

// To boxed array
        Integer[] what = Arrays.stream(data).boxed().toArray(Integer[]::new);
        Integer[] ever = IntStream.of(data).boxed().toArray(Integer[]::new);

        List<Integer> list = new ArrayList<>(Arrays.asList(what));

// To boxed list
        List<Integer> you = Arrays.stream(data).boxed().collect(Collectors.toList());
        List<Integer> like = IntStream.of(data).boxed().collect(Collectors.toList());
    }

    static int minimumTime(int[] x) {
        
        //  Return the minimum time needed to visit all the houses.

        List<Integer> list = Arrays.stream(x)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(list);
        int count = 0;

        for (int index = 0; index < list.size() - 1; index++) {
            count += list.get(index + 1) - list.get(index);
        }
        return count;
    }

}
